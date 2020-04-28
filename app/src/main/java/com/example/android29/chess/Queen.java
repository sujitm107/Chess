/**
 * @author Sujit Molleti and Rachana Kotamraju
 */
package com.example.android29.chess;

public class Queen extends Piece{

    public Queen(boolean isWhite){
        this.isWhite = isWhite;
        this.name = isWhite ? "wQ" : "bQ";
    }

    /**
     * Implements the move functionality of the Queen - any number of spaces in any direction
     * @param board 2D array containing chess board
     * @param oFile file of piece to be moved
     * @param oRank rank of piece to be moved
     * @param nFile file the piece is moving to
     * @param nRank rank the piece is moving to
     * @return true if valid move, false otherwise
     */

    @Override
    public boolean move(Piece[][] board, int oFile, int oRank, int nFile, int nRank)  {
       // System.out.println("Player is moving a "+name);

        if(moveStraight(board, oFile, oRank, nFile, nRank)){
            return true;
        }else{
            return moveDiagonally(board, oFile, oRank, nFile, nRank);
        }

    }

    /**
     * Implements moving straight functionality of the queen which is also used for the rook
     * @param board
     * @param oFile
     * @param oRank
     * @param nFile
     * @param nRank
     * @return
     */

    public boolean moveStraight(Piece[][] board, int oFile, int oRank, int nFile, int nRank){
        if((oFile == nFile) ^ (oRank == nRank)){ //Logical XOR, Either Files have to be the same or Ranks have to be the but not both
            int minRank = Math.min(oRank, nRank);
            int maxRank = Math.max(oRank, nRank);

            int minFile = Math.min(oFile, nFile);
            int maxFile = Math.max(oFile, nFile);

            if(oRank != nRank){ //vertical move
                for(int i = minRank+1; i< maxRank; i++){ //plus one bc we do not want to check the spot of the rook
                    if (board[i][oFile] != null) {
                     //   System.out.println("Something in the way: "+oFile+","+i);
                       // System.out.println(board[i][oFile]);
                        return false;
                    }
                }
            } else { //horizontal move
                for(int i = minFile+1; i< maxFile; i++){
                    if (board[oRank][i] != null) {

                        // System.out.println("Something in the way: "+oFile+","+i);
                        return false;
                    }
                }
            }

            if(board[nRank][nFile] != null){
                if(board[oRank][oFile].isWhite == board[nRank][nFile].isWhite){
                //    System.out.println("Don't kill ur friend");
                    return false;
                } else {
                  //  System.out.println("Slayed");
                    //isKing(nRank, nFile);
                    return true;
                }
            }
            //isKing(nRank, nFile);
            return true;
        }

        return false;
    }

    /**
     * Implements moving diagonal functionality of the queen which is also used for the bishop
     * @param board
     * @param oFile
     * @param oRank
     * @param nFile
     * @param nRank
     * @return
     */

    public boolean moveDiagonally(Piece[][] board, int oFile, int oRank, int nFile, int nRank){
        if((nFile != oFile) && (nRank != oRank)) {
            double slope = ((double)(nRank - oRank)) / ((double)(nFile - oFile));
            //System.out.println("Slope: "+slope);

            if (Math.abs(slope) != 1) {
            //    System.out.println("Slope is not one");
                return false;
            }

            int r = oRank;
            int c = oFile;

            while( Math.abs(r - nRank) != 1){

                r = (oRank < nRank) ? ++r : --r; // south : north
                c = (oFile < nFile) ? ++c : --c;

                if (board[r][c] != null){
              //      System.out.println("Something in the way: "+c+","+r);
                    return false;
                }
            }

            if(board[nRank][nFile] != null){
                if(board[oRank][oFile].isWhite == board[nRank][nFile].isWhite){
               //     System.out.println("Don't kill ur friend");
                    return false;
                } else {
                //    System.out.println("Slayed");
                    //isKing(nRank, nFile);
                    return true;
                }
            }
            //isKing(nRank, nFile);
            return true;
        }
        return false;
    }



}