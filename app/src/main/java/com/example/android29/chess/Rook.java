/**
 * @author Sujit Molleti and Rachana Kotamraju
 */
package com.example.android29.chess;

public class Rook extends Queen{

    public Rook(boolean isWhite){

        super(isWhite);
        //this.isWhite = isWhite;
        this.name = isWhite ? "wR" : "bR";
    }

    /**
     * Implements the functionality of the rook by extending the Queen class, which contains the same functionality
     * Queen class also contains moving diagonally but the rook cannot do that, so return false
     * @param board 2D array containing chess board
     * @param oFile file of piece to be moved
     * @param oRank rank of piece to be moved
     * @param nFile file piece is moving to
     * @param nRank rank piece is moving to
     * @return true if valid move, false otherwise
     */

    @Override
    public boolean moveDiagonally(Piece[][] board, int oFile, int oRank, int nFile, int nRank) {
        return false;
    }
}