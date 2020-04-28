/**
 * @author Sujit Molleti and Rachana Kotamraju
 */
package com.example.android29.chess;

public class King extends Queen{

    public King(boolean isWhite){
        super(isWhite);

        this.rank = isWhite ? 7 : 0;
        this.file = 4;


        this.name = isWhite ? "wK" : "bK";
    }

    /**
     * Implements the functionality of the king - one move in any direction
     * Extends queen class which has same functionality as king but any number of moves
     * Also takes care of castling
     * @param board 2D array containing chess board
     * @param oFile file of the piece to be moved
     * @param oRank rank of the piece to be moved
     * @param nFile file where the piece is going to move
     * @param nRank rank where the piece is going to move
     * @return boolean, true if the move is valid, otherwise false
     */

    @Override
    public boolean move(Piece[][] board, int oFile, int oRank, int nFile, int nRank)  {
        //(oFile: 6, oRank: 0, nFile: 5, nRank: 1)
        int fdist = Math.abs(oFile - nFile);
        int rdist = Math.abs(oRank - nRank);

        //insert castling right here
        /**
         * check hasMoved, check nRank of the kings and make sure its 7 or 0, check that rank is not changing
         *  castling cannot kill
         */

        if(fdist == 2 && !this.hasMoved && rdist == 0){
            Piece rook = nFile > 4 ? board[oRank][7] : board[oRank][0];

            if(rook == null){
                return false;
            }

            if(rook.hasMoved){
                return false;
            }

            setKingPosition(nRank, nFile);
            if(Chess.check(board, this)){
                setKingPosition(oRank, oFile);
                return false;
            }

            int i = 4;
            while (i != 1 && i != 6){
                i = nFile > 4 ? ++i : --i;

               // System.out.println("Castling: "+i);

                if(board[oRank][i] != null){
                    return false;
                }

            }
            //castle approved

          //  System.out.println("Castling");

            int oldrookFile = nFile > 4 ? 7 : 0;
            int newrookFile = nFile > 4 ? 5 : 3;

            board[oRank][newrookFile] = rook;
            board[oRank][oldrookFile] = null;


            return true;
        }



        if(fdist > 1 || rdist > 1){
          //  System.out.println("King can only move one space");
            return false;
        }

        setKingPosition(nRank, nFile);

        if(super.move(board, oFile, oRank, nFile, nRank) && (Chess.check(board, this)==false)){
           // System.out.println("Updating King's position");
            this.hasMoved = true;
            return true;
        }

        setKingPosition(oRank,oFile);
        return false;

    }

    /**
     * Sets the kings position when moved
     * @param rank new rank of king
     * @param file new file of king
     *
     */

    public boolean setKingPosition(int rank, int file){
        this.file = file;
        this.rank = rank;

        return true;

    }
}
