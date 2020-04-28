/**
 * @author Sujit Molleti and Rachana Kotamraju
 */
package com.example.android29.chess;

public abstract class Piece {
    int file; /** current file of the piece*/
    int rank; /** current rank of the piece*/
    boolean isWhite; /** whether the piece is black or white*/
    String name; /** name of piece on chess board - color + actual piece (ex: wp - white pawn)*/
    boolean hasMoved; /** whether the piece has moved yet*/

    /**
     * Abstract method - each piece's move functionality is different but they all move
     * Implement the move method differently in each piece
     * @param board 2D array containing chess board
     * @param oFile file of piece to be moved
     * @param oRank rank of piece to be moved
     * @param nFile file the piece is moving to
     * @param nRank rank the piece is moving to
     * @return
     */

    public abstract boolean move(Piece[][] board, int oFile, int oRank, int nFile, int nRank);
    //had to add board, nFile, and nRank so you can check if the places you are moving to are null or not. Can't put in main
    // because different for each piece, easier and less headache to pass it in

    public String toString(){
        return name;
    }

}
