package model.paint.strategy;

import model.paint.UprightImagePaintStratergy;

/**
 * An example of an ImagePaintStrategy that randomly picks one of two 
 * animated image files to display when it is instantiated.
 * @author ls53@rice.edu
 *
 */
public class BirdSheepImagePaintStrategy extends UprightImagePaintStratergy {
    
    /**
     * No-parameter constructor that instantiates the AffineTransform
     */
    public BirdSheepImagePaintStrategy() {
        super(Math.random() < 0.5 ? "images/sheep_animate.gif" : "images/humbird_animate.gif", 0.5);
    }
}
