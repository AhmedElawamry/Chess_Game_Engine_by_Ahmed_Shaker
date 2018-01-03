package ChessGameEngine;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public abstract class Piece {

    //return valid square
    public ArrayList getValidSqaures() {
        return ValidSqaures;
    }

    //set valid squares
    public void setValidSqaures(ArrayList ValidSqaures) {
        this.ValidSqaures = ValidSqaures;
    }

    private ArrayList ValidSqaures;
    Color color;
    public ImageIcon icon;
    

    public abstract ArrayList checkValidMoves(Square[][] board, Square currentPos);
    public  ArrayList getValidMoves(Square[][] board, Square currentPos){
        this.setValidSqaures(checkValidMoves(board,currentPos));
        //Revert Colors Block -------------------------------------------------------
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((j + i) % 2 == 0) {
                    board[i][j].setBackground(Color.white);
                } else {
                    board[i][j].setBackground(Color.black);
                }

            }
        }
        //-----------------------------------------
        return getValidSqaures();
    }

     public void move(Square from, Square to, Square[][] Squares) {
        if (to.piece != null) {
            if (to.piece instanceof King) {
                if (ChessGameEngine.turn == Color.WHITE) {
                    JOptionPane.showMessageDialog(null, "White Player Wins", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(3);
                } else {
                    JOptionPane.showMessageDialog(null, "Black Player Wins", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(3);
                }
            }
        }
        to.piece = from.piece;
        to.setIcon(to.piece.icon);
        from.piece = null;
        from.setIcon(null);
        ChessGameEngine.ChangeTurn();
    }

    public void clone( Piece a){
        this.color = a.color;
        this.icon = a.icon;
       
    }
    public abstract boolean CheckValidity(Square from,Square to);
    public abstract boolean PathBlocked(Square from,Square to,Square Squares[][]);

}

