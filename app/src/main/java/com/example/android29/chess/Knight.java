/**
 * @author Sujit Molleti and Rachana Kotamraju
 */
package com.example.android29.chess;

public class Knight extends Piece{

    public Knight(boolean isWhite){
        this.isWhite = isWhite;
        this.name = isWhite ? "wN" : "bN";
    }

    /**
     * Implements functionality of the knight - makes sure does not kill same color
     * @param board 2D array of chess board
     * @param oFile file of the piece to be moved
     * @param oRank rank of the piece to be moved
     * @param nFile file the piece is going to move to
     * @param nRank rank the piece is going to move to
     * @return true if valid move, false otherwise
     */

    @Override
    public boolean move(Piece[][] board, int oFile, int oRank, int nFile, int nRank) {
        //System.out.println("Player is moving a"+name);


        if((Math.abs(oFile-nFile)+Math.abs(oRank-nRank) == 3) && (oFile != nFile && oRank != nRank)){
            if (board[nRank][nFile] != null) {
                if (board[oRank][oFile].isWhite == board[nRank][nFile].isWhite) {
                  //  System.out.println("Don't kill ur friend");
                    return false;
                } else {
                 //   System.out.println("Slayed");
                    return true;
                }
            }
            return true;
        }

        return false;
    }
}