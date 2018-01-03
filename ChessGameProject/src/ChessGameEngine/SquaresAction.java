package ChessGameEngine;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class SquaresAction implements ActionListener {


    Square start, dest;
    Square Squares[][];
    evaluateBoard evaluate;

    public SquaresAction(Square Squares[][]) {
        start = null;
        dest = null;
        this.Squares = Squares;
    }

    public void actionPerformed(ActionEvent e) {
        ArrayList dummy;
            if (start == null && ((Square) e.getSource()).piece == null) {
                System.out.println("No Piece Selected--1st press");
                return;
            }

            if (start == null && ((Square) e.getSource()).piece != null) {


                if (ChessGameEngine.turn == ((Square) e.getSource()).piece.color) {
                    dummy=((Square) e.getSource()).piece.checkValidMoves(Squares, (Square) e.getSource());
                    System.out.println("Piece Selected,choose destination 2nd");
                    start = ((Square) e.getSource());

                    return;
                } else {
                    System.out.println("Not this Players turn --2nd else");
                    //Revert Colors Block -------------------------------------------------------
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if ((j + i) % 2 == 0) {
                                Squares[i][j].setBackground(Color.white);
                            } else {
                                Squares[i][j].setBackground(Color.yellow);
                            }

                        }
                    }
                    //-----------------------------------------
                    return;

                }
            }

            if (start != null) {
                //Revert Colors Block -------------------------------------------------------
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if ((j + i) % 2 == 0) {
                            Squares[i][j].setBackground(Color.white);
                        } else {
                            Squares[i][j].setBackground(Color.yellow);
                        }

                    }
                }
                //-----------------------------------------
                System.out.println("3rd");
                if (((Square) e.getSource()).piece != null) {

                    if (((Square) e.getSource()).piece.color == start.piece.color) {
                        start = null;
                        return;
                    }
                }

                dest = ((Square) e.getSource());

                start.piece.move(start, dest, Squares);
                start = null;
                dest = null;
              
            }

        }

    }


