/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment8;

import static java.lang.System.gc;
import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author gordbond
 */
public class Model2 {
    public ArrayList<GeometricObject> o;
    //GeometricObjectA circle = new CircleA();
    //GeometricObjectA rect = new RectangleA();
    //GeometricObjectA line = new LineA();
    
   
    
    public Model2 (){
        
        o = new ArrayList<>();
    }
    
    
    public void draw(GraphicsContext gc){
        int i = o.size() - 1;
        
        //GeometricObjectA g = o.get(i);
        for ( GeometricObject g : o) {
            if (g instanceof Circle) {
                ((Circle) g).draw(gc);
                System.out.println(((Circle) g));
                
            }else if (g instanceof Rectangle) {
                ((Rectangle) g).draw(gc);
                System.out.println(((Rectangle) g));
            }
        }
    }
    
    public void clear(){
        o = new ArrayList<>();
    }
    
    public void undo(){
        int last = o.size()-1;
        o.remove(last);
    }
    
    public void setShape(GeometricObject shape){
        if (shape instanceof Circle) {
                o.add((Circle)shape);
            }else if (shape instanceof Rectangle) {
                
            }
    }
    
    public GeometricObject getShape(){
        GeometricObject shape;
        int i = o.size() - 1;
        shape = o.get(i); 
        return shape;
    }
    
    
    public void createCircle(){
        o.add(new Circle());
    }
    
    
    
    public void createRectangle(){
        o.add(new Rectangle());
    }
    
    public void createLine(){
        o.add(new LineA());
    }
    
    public void printList(){
        for( GeometricObject i : o){
            System.out.println(i);
        }
    }
    
    
    @Override
    public String toString(){
        String result = "";
        for (GeometricObject g : o){
            result += g.toString() + " ";
        }
        return result;
    }
}

