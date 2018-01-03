
package ChessGameEngine;

import java.awt.Color;
import static java.awt.Color.blue;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Bishop extends Piece{

    Bishop(Color color){
    if(color==Color.BLACK)
    super.icon= new ImageIcon(getClass().getResource("/bBishop.png"));
        else
    super.icon= new ImageIcon(getClass().getResource("/wBishop.png"));
 
    super.color=color;
    }


    public void move(Square from, Square to,Square Squares[][]){
           
           if(CheckValidity(from, to)){
               if(!PathBlocked(from, to, Squares)){
        super.move(from, to,Squares);

               }
           }
    }
       public boolean CheckValidity(Square from,Square to){
          int x=to.x-from.x;
          int y=to.y-from.y;
          
          if(Math.abs(x)==Math.abs(y))
              return true;
              else 
              return false;
          
           
       }
       
       public boolean PathBlocked(Square from, Square to,Square Squares [][]){
           int x= to.x -from.x;
           int y= to.y-from.y;
           int x1= x/Math.abs(x);
           int y1= y/Math.abs(y);
         for(int i = from.x+x1, j = from.y+y1; i!=to.x && j!=to.y; i=i+x1, j=j+y1){
             if(Squares[j][i].piece!=null){
                     return true;
             }
       }
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
                if ((CheckValidity(currentPos, board[i][j])) && !(PathBlocked(currentPos,board[i][j],board))) {
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

}
