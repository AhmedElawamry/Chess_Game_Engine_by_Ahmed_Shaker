
package ChessGameEngine;
 
import java.awt.Color;
import static java.awt.Color.blue;
import java.util.ArrayList;
import javax.swing.ImageIcon;
 
 
public class Knight extends Piece {

    Knight(Color color){
    if(color==Color.BLACK)
    super.icon= new ImageIcon(getClass().getResource("/bKnight.png"));
        else
    super.icon= new ImageIcon(getClass().getResource("/wKnight.png"));
   
            super.color=color;
    }
       public void move(Square from, Square to,Square Squares[][]){
        if(this.CheckValidity(from,to)){
        super.move(from, to,Squares);

       }
    }
       
       public boolean CheckValidity(Square from, Square to)
       {
        int x,y;
           x=to.x-from.x;
           y=to.y-from.y;
           
           if(Math.abs(x)==2 && Math.abs(y)==1)
               return true;
           else if(Math.abs(x)==1 && Math.abs(y)==2)
               return true;
           else
               return false;
                     
       }

    public ArrayList checkValidMoves(Square[][] board, Square currentPos) {

        ArrayList avSquares = new ArrayList();
        Square temp = currentPos;
        int x = currentPos.x;
        int y = currentPos.y;

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {
                if (i == y && j == x) {
                    continue;//Don't count current position;
                }
                if (CheckValidity(currentPos, board[i][j]) ) {
                  if(board[i][j].piece==null)
                    avSquares.add(board[i][j]);
                   else
                       if(board[i][j].piece.color != currentPos.piece.color)
                           avSquares.add(board[i][j]);
                }
                

            }
        }

        for (int i = 0; i < avSquares.size(); i++) {
            temp = (Square) avSquares.get(i);
            board[temp.y][temp.x].setBackground(blue);
            System.out.println("X:" + temp.x + " Y:" + temp.y);

        }

return avSquares;
}

       public boolean PathBlocked(Square from, Square to, Square Squares[][]){
           return false;
       }

}