/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment8;

import javafx.scene.canvas.GraphicsContext;

/**
 * Interface for the abstract draw method
 * @author gordbond
 */
public interface Drawable {
    /**
     * Abstract draw method
     * @param gc - graphics context drawing properties
     */
    public abstract void draw(GraphicsContext gc);
}
