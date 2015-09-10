package model;

import java.awt.Component;

/**
 * The model to view adapter interface
 * @author ls53@rice.edu
 */
public interface IViewAdapter {
    
    /**
     * Get the canvas from view
     * @return
     */
    public Component getCanvas();
    
    /**
     * Repaint view
     */
    public void repaint();
    
    /**
     * The null object as a placeholder
     */
    public static final IViewAdapter NULL_OBJECT = new IViewAdapter() {
        
        @Override
        public Component getCanvas() {
            return null;
        }
        
        @Override
        public void repaint() {}
    };
}