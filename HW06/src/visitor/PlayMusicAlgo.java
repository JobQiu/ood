package visitor;

import provided.music.APhraseVisitor;
import provided.music.Chord;
import provided.music.Header;
import provided.music.IPhrase;
import provided.music.IPhraseVisitorCmd;
import provided.music.MTSeqList;
import provided.music.NESeqList;
import provided.music.Note;
import provided.music.Triplet;
import provided.player.SequencePlayer2;
import provided.util.ABCUtil;
import provided.util.KeySignature;

/**
 * Play Music Visitor
 * @author ls53@rice.edu
 */
public class PlayMusicAlgo extends APhraseVisitor {
    
    /**
     * The key signature to adjust notes
     */
    private KeySignature keySignature;
    
    /**
     * The constructor for Play Music Visitor
     */
    public PlayMusicAlgo() {
        String headerString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < headerString.length(); i++) {
             addCmd("" + headerString.charAt(i), new IPhraseVisitorCmd() {
                
                @Override
                public Object apply(String id, IPhrase host, Object... params) {
                    return params[1];
                }
            });
        }
        
        addCmd("L", new IPhraseVisitorCmd() {
            
            @Override
            public Object apply(String id, IPhrase host, Object... params) {
                Header header = (Header)host;
                double defaultNoteLen = ABCUtil.Singleton.parseFraction(header.getValue());
                SequencePlayer2 player = (SequencePlayer2)params[0];
                defaultNoteLen *=  player.getTicksPerDefaultNote() / 0.25;
                player.setTicksPerDefaultNote((int)defaultNoteLen);
                
                return params[1];
            }
        });
        
        addCmd("Q", new IPhraseVisitorCmd() {
            
            @Override
            public Object apply(String id, IPhrase host, Object... params) {
                SequencePlayer2 player = (SequencePlayer2)params[0];
                double defaultNotesPerQuarterNote = (double)player.getTicksPerDefaultNote() / player.getTicksPerQuarterNote();
                Header header = (Header)host;
                double bpm = ABCUtil.Singleton.parseTempo(header.getValue(), defaultNotesPerQuarterNote);
                player.setTempo((int)bpm);
                
                return params[1];
            }
        });
        
        addCmd("K", new IPhraseVisitorCmd() {
            
            @Override
            public Object apply(String id, IPhrase host, Object... params) {
                Header header = (Header)host;
                keySignature = new KeySignature(header.getValue());
                return params[1];
            }
        });
        
        addCmd(Note.ID, new IPhraseVisitorCmd() {
            
            @Override
            public Object apply(String id, IPhrase host, Object... params) {
                SequencePlayer2 player = (SequencePlayer2)params[0];
                Note note = keySignature.adjust((Note)host);
                
                return player.addNote(note, (int)params[1]);
            }
        });
        
        addCmd(MTSeqList.ID, new IPhraseVisitorCmd() {
            
            @Override
            public Object apply(String id, IPhrase host, Object... params) {
                return params[1];
            }
        });
        
        addCmd(NESeqList.ID, new IPhraseVisitorCmd() {
            
            @Override
            public Object apply(String id, IPhrase host, Object... params) {
                NESeqList list = (NESeqList)host;
                Object tick = list.getFirst().execute(PlayMusicAlgo.this, params);
                return list.getRest().execute(PlayMusicAlgo.this, params[0], tick);
            }
        });
        
        addCmd(Chord.ID, new IPhraseVisitorCmd() {
            
            @Override
            public Object apply(String id, IPhrase host, Object... params) {
                Chord chord = (Chord)host;
                Note[] notes = chord.getNotes();
                Object stopTick = params[1];
                for (Note note : notes) {
                    stopTick = note.execute(PlayMusicAlgo.this, params);
                }
                
                return stopTick;
            }
        });
        
        addCmd(Triplet.ID, new IPhraseVisitorCmd() {
            
            @Override
            public Object apply(String id, IPhrase host, Object... params) {
                Triplet triplet = (Triplet)host;
                Note[] notes = triplet.getNotes();
                
                Object tick = params[1];
                for (Note note : notes) {
                    note.setDuration(note.getDuration() * 2.0 / 3);
                    tick = note.execute(PlayMusicAlgo.this, params[0], tick);
                }
                
                return tick;
            }
        });
    }
}