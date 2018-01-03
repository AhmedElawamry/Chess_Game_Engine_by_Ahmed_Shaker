
package ChessGameEngine;
 
import java.awt.Color;
import static java.awt.Color.blue;
import java.util.ArrayList;
import javax.swing.ImageIcon;
 
public class King extends Piece{

    King(Color color){
    if(color==Color.BLACK)
 
    super.icon= new ImageIcon(getClass().getResource("/bKing.png"));
        else
    super.icon= new ImageIcon(getClass().getResource("/wKing.png"));
 
            super.color=color;
    }
       public void move(Square from, Square to,Square Squares[][]){
       //condition for the knight
        if (CheckValidity(from, to)){
        super.move(from, to,Squares);

        }
    }
       public boolean CheckValidity(Square from,Square to){
           
           int x = to.x-from.x;
           int y = to.y-from.y;
           
           if (Math.abs(y)<=1 && Math.abs(x)<=1){
               return true;
           
               }
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
                if ((CheckValidity(currentPos, board[i][j])) ) {//howa leeeh mafeesh path Bloced fe king 
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