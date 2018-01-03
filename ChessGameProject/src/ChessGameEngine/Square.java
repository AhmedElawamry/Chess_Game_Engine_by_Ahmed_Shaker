
package ChessGameEngine;

import java.awt.Color;

import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;

/**
 *
 * @author ahmed
 */
public class Square extends JButton{
  public  Piece piece;
  int x,y;
    Square(int x ,int y){
        this.x=x;
        this.y=y;
        this.setSize(75, 75);
        piece = null;
    }

    

    @Override
    public void addActionListener(ActionListener al) {
        super.addActionListener(al); //To change body of generated methods, choose Tools | Templates.
    }


    public void clone (Square b){
        this.x = b.x;
        this.y = b.y;
        if(b.piece == null){
           this.piece = null;
           this.setIcon(null);
        }
        else{

            try{
            this.piece = b.piece
                    .getClass()
                    .getDeclaredConstructor(Color.class)
                    .newInstance(b.piece.color);
            this.setIcon(b.piece.icon);
            }
            catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e){
                    System.out.println("Exception");
                    }
      
        this.piece.clone(b.piece);
        
        }
    }
 

}
