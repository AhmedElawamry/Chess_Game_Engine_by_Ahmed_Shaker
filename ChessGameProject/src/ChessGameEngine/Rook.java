
package ChessGameEngine;
 
import java.awt.Color;
import static java.awt.Color.blue;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Rook extends Piece {

    Rook(Color color) {
        if (color == Color.BLACK) {
            super.icon = new ImageIcon(getClass().getResource("/bRook.png"));
        } else {
            super.icon = new ImageIcon(getClass().getResource("/wRook.png"));
        }
 
        super.color = color;
 
    }
 
    public void move(Square from, Square to, Square Squares[][]) {
        if (CheckValidity(from, to)) {
            if (!PathBlocked(from, to, Squares)) {
                super.move(from, to, Squares);
                
 
            }
        }
    }
 
    public boolean CheckValidity(Square from, Square to) {
        int x, y;
        x = to.x - from.x;
        y = to.y - from.y;
        if (to.x == from.x && Math.abs(y) > 0) {
            return true;
 
        }
        if (to.y == from.y & Math.abs(x) > 0) {
            return true;
 
        } else {
            return false;
 
        }
    }
 
    public boolean PathBlocked(Square from, Square to, Square[][] Squares) {
        int x = to.x - from.x;
        int y = to.y - from.y;
        if(x==0){
           int y1 = y / Math.abs(y);
           for (int i = from.x , j = from.y + y1;j != to.y;j = j + y1){
               if (Squares[j][i].piece != null) {
                return true;
            }
           }
               }
           else if(y==0){
                   int x1 = x/Math.abs(x);
           for (int i = from.x + x1 , j =  from.y ; i != to.x ; i = i + x1){
               if (Squares[j][i].piece != null) {
                return true;
            }
           }
               
               }
           
       
        return false;
    }



    @Override
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