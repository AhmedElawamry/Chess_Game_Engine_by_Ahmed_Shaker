/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessGameEngine;

import java.awt.Color;

public class evaluateBoard {

    //set score
    public void setScore(double Score) {
        this.Score = Score;
    }
    private double Score;
    public evaluateBoard(){
    }
    double getScore(){
        return this.Score;
    }
    double evaluate(Square Squares[][]){
        setScore(0.0);
        double wKing=0,bKing=0,wQueen=0,bQueen=0,wRook=0,bRook=0,wBishop=0,bBishop=0,wKnight=0,bKnight=0,wPawn=0,bPawn=0,wBlocked=0,bBlocked=0,wDoubled=0,bDoubled=0,wIsolated=0,bIsolated=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(Squares[i][j].piece instanceof Pawn){
                    if(Squares[i][j].piece.color == Color.WHITE){
                      wPawn++;
                      if(Squares[i-1][j].piece instanceof Piece){
                          bBlocked++;
                      }
                      for(int z=0;z<8;z++){
                          if(i==z)
                              continue;
                          if(Squares[z][j].piece instanceof Pawn){
                              if(Squares[z][j].piece.color == Color.WHITE){
                                  bDoubled = bDoubled + 0.5;
                              }
                          }                                    
                      }
                      if(checkIsolation(Squares,Squares[i][j],i,j)){
                          bIsolated++;
                      }
                      continue;
                    }
                    else{ 
                        bPawn++;
                        if(Squares[i+1][j].piece instanceof Piece){
                           wBlocked++;
                        }
                        for(int z=0;z<8;z++){
                          if(i==z)
                              continue;
                          if(Squares[z][j].piece instanceof Pawn){
                              if(Squares[z][j].piece.color == Color.BLACK){
                                  wDoubled = wDoubled + 0.5;
                              }
                          }          
                      }
                       if(checkIsolation(Squares,Squares[i][j],i,j)){
                          wIsolated++;
                      }
                        continue;
                }
                }
                if(Squares[i][j].piece instanceof King){
                    if(Squares[i][j].piece.color == Color.WHITE){
                      wKing++;
                      continue;
                    }
                    else bKing++;
                    continue;
                }
                if(Squares[i][j].piece instanceof Queen){
                    if(Squares[i][j].piece.color == Color.WHITE){
                      wQueen++;
                      continue;
                    }
                    else bQueen++;
                    continue;
                }
                if(Squares[i][j].piece instanceof Rook){
                    if(Squares[i][j].piece.color == Color.WHITE){
                      wRook++;
                      continue;
                    }
                    else bRook++;
                    continue;
                }
                if(Squares[i][j].piece instanceof Bishop){
                    if(Squares[i][j].piece.color == Color.WHITE){
                      wBishop++;
                      continue;
                    }
                    else bBishop++;
                    continue;
                }
                if(Squares[i][j].piece instanceof Knight){
                    if(Squares[i][j].piece.color == Color.WHITE){
                      wKnight++;
                    }
                    else bKnight++;
                }
            }
        }
        setScore((200*(wKing-bKing))
                +(9*(wQueen-bQueen))
                +(5*(wRook-bRook))
                +(3*((wBishop-bBishop)
                        +(wKnight-bKnight)))
                +(1.5*(wPawn-bPawn))
                +(0.5*((wBlocked-bBlocked)
                        +(wDoubled-bDoubled)
                        +(wIsolated-bIsolated))));
        setScore(getScore() * -1);
        return getScore();
    }
    public boolean checkIsolation(Square Squares[][],Square Sqre, int a, int b){
        Color get = Sqre.piece.color;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(i==a && j==b)
                continue;
                    if(Squares[i][j].piece instanceof Piece){
                        if(Squares[i][j].piece.color == get){
                            if((Squares[i][j].piece.CheckValidity(Squares[i][j], Sqre))){
                                if(!(Squares[i][j].piece.PathBlocked(Squares[i][j], Sqre, Squares))){
                             return false;
                                }
                            }
                        }
                    }
            }   
        }
        return true;
    }        
}
        
