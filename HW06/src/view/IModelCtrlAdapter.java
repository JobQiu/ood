package view;

public interface IModelCtrlAdapter<TInstrument> {
    public String loadFile(String fileName);
    
    public String parseFile();
    
    public void playMusic(TInstrument instrument);
    
    public void stopMusic();
    
    @SuppressWarnings("rawtypes")
    public static final IModelCtrlAdapter NULL_OBJECT = new IModelCtrlAdapter() {

        @Override
        public String loadFile(String fileName) {
            return null;
        }

        @Override
        public String parseFile() {
            return null;
        }

        @Override
        public void playMusic(Object instrument) {}

        @Override
        public void stopMusic() {}
    };
}
