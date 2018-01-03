package ChessGameEngine;

import java.awt.Color;
import static java.awt.Color.*;
import static java.lang.Math.abs;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Pawn extends Piece {

    Pawn(Color color) {

        if (color == Color.BLACK) {
            super.icon = new ImageIcon(getClass().getResource("/bPawn.png"));
        } else {
            super.icon = new ImageIcon(getClass().getResource("/wPawn.png"));
        }

        super.color = color;
    }

    public void move(Square from, Square to, Square Squares[][]) {

        if (to.piece != null) {

            if (this.CheckEat(from, to)) {
                super.move(from, to, Squares);

                return;
            } else {
                return;
            }
        }
        if (this.CheckValidity(from, to)) {
            super.move(from, to, Squares);
        }
    }

    public boolean CheckValidity(Square from, Square to) {
        int x, y;
        x = abs(to.x - from.x);
        y = to.y - from.y;
        if (from.x == to.x) {

            if (ChessGameEngine.turn == Color.BLACK) {
                if (y == 1) {
                    return true;
                } else if (y == 2 && from.y == 1) {
                    return true;
                } else {
                    return false;
                }
            } else {//For White pieces
                if (y == -1) {
                    return true;
                } else if (y == -2 && from.y == 6) {
                    return true;
                } else {
                    return false;
                }
            }

        } else {
            return false;

        }

    }

    public boolean CheckEat(Square from, Square to) {//I 
        int x = to.x - from.x;
        int y = to.y - from.y;
        if (ChessGameEngine.turn == Color.BLACK) {
            if (Math.abs(x) == 1 && y == 1) {
                return true;
            }
        } else {
            if (Math.abs(x) == 1 && y == -1) {
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
                if(board[i][j].piece != null){
                    if(board[i][j].piece.color != currentPos.piece.color){
                        if (CheckEat(currentPos, board[i][j]) ) {
                            avSquares.add(board[i][j]);
                            }
                    }
                }
                else
                if (CheckValidity(currentPos, board[i][j]) && !PathBlocked(currentPos, board[i][j],board)) {
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
