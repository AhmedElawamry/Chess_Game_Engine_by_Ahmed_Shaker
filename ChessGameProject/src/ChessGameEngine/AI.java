/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessGameEngine;
import java.awt.Color;
import java.util.ArrayList;
/**
 *
 * @author Ahmed
 */
class Move{
    double evaluation;
    Square from;
    Square To;
    Move(double ev, Square from, Square To){
        evaluation = ev;
        this.from = from;
        this.To = To;
    }
    Move(){
        
    }
}
public  class AI {

    //return evaluator
    public evaluateBoard getEvaluator() {
        return evaluator;
    }

    
    //evaluator to set
    
    public void setEvaluator(evaluateBoard evaluator) {
        this.evaluator = evaluator;
    }
    private evaluateBoard evaluator;
    AI(evaluateBoard evaluator){
        this.evaluator = evaluator;
    }
    private ArrayList getAllPieces(Square [][] board, Color color){
        ArrayList squaresContainingPieces = new ArrayList();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if(board[y][x].piece != null && board[y][x].piece.color == color)
                    squaresContainingPieces.add(board[y][x]);
            }
        }
        return squaresContainingPieces;
    }
    
    private Move getMaxMove(int depth, Square[][] board, Color color){
        
        Square[][] tempBoard = new Square[8][8];
        Panel1.initSquares(tempBoard);
        Panel1.clone(board, tempBoard);
        
        ArrayList currentPieces = getAllPieces(tempBoard, color), possibleMoves = new ArrayList();

        
        Move maxMove = new Move();
        // Build the tree level

        for (int i = 0; i < currentPieces.size(); i++) {
            Square temp = ((Square)currentPieces.get(i));
            possibleMoves.add(temp.piece.getValidMoves(tempBoard,temp));

        }
        
           // initialize maxMove
            for (int i = 0; i < currentPieces.size(); i++) {
              if( ((ArrayList)possibleMoves.get(i)).size()>0){
                maxMove = new Move(Double.NEGATIVE_INFINITY ,
                 (Square)currentPieces.get(i),
                 (Square)((ArrayList)possibleMoves.get(i)).get(0) );
              }  
            }
            
            
        for (int i = 0; i < currentPieces.size(); i++) {
            
            Square squareContPieceToBeMoved = ((Square)currentPieces.get(i));
            ArrayList highlightedSquarePossibleMoves = ((ArrayList)possibleMoves.get(i));
            
            for (int j = 0; j <highlightedSquarePossibleMoves.size(); j++) {
            
            Square savedFrom = new Square(0,0), savedTo = new Square(0,0);
            
            // Save current state
            Color savedTurn = ChessGameEngine.turn;
            savedFrom.clone(squareContPieceToBeMoved);
            savedTo.clone((Square)highlightedSquarePossibleMoves.get(j));
            
            // Do the move
            squareContPieceToBeMoved.piece.move(squareContPieceToBeMoved,((Square)highlightedSquarePossibleMoves.get(j)), tempBoard);
            
                if(depth != 0){
                    Move returnedMove = getMinMove(depth-1, tempBoard, color);
                    if( returnedMove.evaluation>maxMove.evaluation){
                    maxMove = returnedMove;
                }
              }
                else{    
            // Evaluate the move that was done
            double evaluation=getEvaluator().evaluate(tempBoard);
            
             if (evaluation>maxMove.evaluation){
                 maxMove.evaluation=evaluation;
                 maxMove.from = squareContPieceToBeMoved;
                 maxMove.To = ((Square)highlightedSquarePossibleMoves.get(j));
             }
            }
            //Return the State
            ChessGameEngine.turn = savedTurn; 
            tempBoard[savedFrom.y][savedFrom.x].clone(savedFrom);
            tempBoard[savedTo.y][savedTo.x].clone(savedTo);
            squareContPieceToBeMoved.clone(savedFrom);
            
            }
        }

         return maxMove;
        }
        
    
    
    private Move getMinMove(int depth,Square[][] board, Color turn){
        return new Move();
    }
    
    private Move minMax(Square [][] board, Color turn, int depth){
        return getMaxMove(depth-1, board, turn);
    }
    public Move doAMove(Square [][] board, Color turn){
        int min_max_depth = 1;
        return minMax(board, turn, min_max_depth);
 
        
    }
}
