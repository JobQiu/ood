package visitor;

import provided.music.APhraseVisitor;
import provided.music.IPhrase;
import provided.music.IPhraseVisitorCmd;
import provided.music.MTSeqList;
import provided.music.NESeqList;

/**
 * A visitor that can print phrase
 * @author ls53@rice.edu
 */
public class ToStringAlgo extends APhraseVisitor {
    
    /**
     * Constructor for ToStringAlgo
     */
    public ToStringAlgo() {
        addCmd(MTSeqList.ID, new IPhraseVisitorCmd() {
            
            @Override
            public Object apply(String id, IPhrase host, Object... params) {
                return params[0] + "}";
            }
        });
        
        addCmd(NESeqList.ID, new IPhraseVisitorCmd() {
            
            @Override
            public Object apply(String id, IPhrase host, Object... params) {
                NESeqList list = (NESeqList)host;
                return list.getRest().execute(ToStringAlgo.this, params[0] + ", " + list.getFirst());
            }
        });
    }
}
