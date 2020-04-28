/**
 * @author Sujit Molleti and Rachana Kotamraju
 */
package com.example.android29.chess;

public class Bishop extends Queen{

    public Bishop(boolean isWhite){
        super(isWhite);
        this.name = isWhite ? "wB" : "bB";
    }

    /**
     * Implements the move functionality of the bishop by extending the queen class which also contains the same functionality
     * Return false if moveStraight because bishop cannot move straight even though queen can
     * @param board
     * @param oFile
     * @param oRank
     * @param nFile
     * @param nRank
     * @return
     */

    @Override
    public boolean moveStraight(Piece[][] board, int oFile, int oRank, int nFile, int nRank) {
        return false;
    }
}
