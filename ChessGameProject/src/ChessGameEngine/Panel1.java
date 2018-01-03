
package ChessGameEngine;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;


public class Panel1 extends JPanel {

   //return squares
    public Square[][] getSquares() {
        return Squares;
    }

    //set Squares
    public void setSquares(Square[][] Squares) {
        this.Squares = Squares;
    }

    //get Action
    public SquaresAction getAction() {
        return Action;
    }

    //Set action
    public void setAction(SquaresAction Action) {
        this.Action = Action;
    }
    public static void clone(Square[][] cloneFrom, Square[][] cloneTo){
        for (int y = 0; y < cloneFrom.length; y++) {
            for (int x = 0; x < cloneFrom[y].length; x++) {
                cloneTo[y][x].clone(cloneFrom[y][x]);
            }
        }
    }
    public static void initSquares(Square[][] board){
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                board[y][x] = new Square(x,y);
            }
        }
    }

    private Square[][] Squares;
    private SquaresAction Action;
    Panel1() {
        this.setLayout(null);
        this.setSize(new Dimension(1000, 1000));
        this.setLocation(0, 0);
        this.setBackground(Color.BLACK);

        Squares = new Square[8][8];
        Action = new SquaresAction(getSquares());
        this.InitSquares();
        this.AssignPiecesToSquares();
    
}
    void InitSquares(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                getSquares()[i][j] = new Square(j,i);
                getSquares()[i][j].setLocation(j * 75, i * 75);
                
                
                if ((j + i) % 2 == 0) {
                    getSquares()[i][j].setBackground(Color.white);
                } else {
                    getSquares()[i][j].setBackground(Color.yellow);
                }
                getSquares()[i][j].addActionListener(getAction());
                this.add(getSquares()[i][j]);
            }
        }
    }
    
    void AssignPiecesToSquares(){
        // --------------Rooks---------------------------
         Squares[0][0].piece= new Rook(Color.BLACK);
         getSquares()[0][0].setIcon(getSquares()[0][0].piece.icon);
         
         Squares[0][7].piece= new Rook(Color.BLACK);
         getSquares()[0][7].setIcon(getSquares()[0][7].piece.icon);
         
         Squares[7][0].piece= new Rook(Color.WHITE);
         getSquares()[7][0].setIcon(getSquares()[7][0].piece.icon);
         
         Squares[7][7].piece= new Rook(Color.WHITE);
         getSquares()[7][7].setIcon(getSquares()[7][7].piece.icon);
         
         //--------------Knight---------------------------
         Squares[0][1].piece= new Knight(Color.BLACK);
         getSquares()[0][1].setIcon(getSquares()[0][1].piece.icon);
         
         Squares[0][6].piece= new Knight(Color.BLACK);
         getSquares()[0][6].setIcon(getSquares()[0][6].piece.icon);
         
         Squares[7][1].piece= new Knight(Color.WHITE);
         getSquares()[7][1].setIcon(getSquares()[7][1].piece.icon);
         
         Squares[7][6].piece= new Knight(Color.WHITE);
         getSquares()[7][6].setIcon(getSquares()[7][6].piece.icon);
         //-------------BiShop----------------------------
         Squares[0][2].piece= new Bishop(Color.BLACK);
         getSquares()[0][2].setIcon(getSquares()[0][2].piece.icon);
         
         Squares[0][5].piece= new Bishop(Color.BLACK);
         getSquares()[0][5].setIcon(getSquares()[0][5].piece.icon);
         
         Squares[7][2].piece= new Bishop(Color.WHITE);
         getSquares()[7][2].setIcon(getSquares()[7][2].piece.icon);
         
         Squares[7][5].piece= new Bishop(Color.WHITE);
         getSquares()[7][5].setIcon(getSquares()[7][5].piece.icon);
         //-------------Queen----------------------------
         Squares[0][3].piece= new Queen(Color.BLACK);
         getSquares()[0][3].setIcon(getSquares()[0][3].piece.icon);
        
         Squares[7][3].piece= new Queen(Color.WHITE);
         getSquares()[7][3].setIcon(getSquares()[7][3].piece.icon);
         //-------------King------------------------------
         Squares[0][4].piece= new King(Color.BLACK);
         getSquares()[0][4].setIcon(getSquares()[0][4].piece.icon);
         
         Squares[7][4].piece= new King(Color.WHITE);
         getSquares()[7][4].setIcon(getSquares()[7][4].piece.icon);
         //------------Pawn--------------------------------
         for(int i=0;i<8;i++){
             Squares[1][i].piece=new Pawn(Color.BLACK);
             getSquares()[1][i].setIcon(getSquares()[1][i].piece.icon);
             
             Squares[6][i].piece=new Pawn(Color.WHITE);
             getSquares()[6][i].setIcon(getSquares()[6][i].piece.icon);
         }
    }
    
}   

