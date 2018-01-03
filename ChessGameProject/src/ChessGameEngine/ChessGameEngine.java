package ChessGameEngine;

import java.awt.Color;



public class ChessGameEngine {
 static Color turn = Color.WHITE;
 static evaluateBoard evaluator = new evaluateBoard();
 static AI ChessAI = new AI(evaluator);
 static Frame frame= null;
public static void ChangeTurn(){
    if (turn==Color.BLACK)
        turn=Color.WHITE;
    else{

        turn=Color.BLACK;
        
        Move AIMove= new Move();
        AIMove = ChessAI.doAMove(frame.getBoard().getSquares(), Color.BLACK);
        Square from = frame.getBoard().getSquares()[AIMove.from.y][AIMove.from.x];
        Square to = frame.getBoard().getSquares()[AIMove.To.y][AIMove.To.x];
        from.piece.move(from, to, frame.getBoard().getSquares());
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

   Frame MainFrame = new Frame();
   frame = MainFrame;

}

}
