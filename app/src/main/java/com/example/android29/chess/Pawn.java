/**
 * @author Sujit Molleti and Rachana Kotamraju
 */
package com.example.android29.chess;

public class Pawn extends Piece{

    boolean twoStep = false;

    public Pawn(boolean isWhite){
        this.isWhite = isWhite;
        this.name = isWhite ? "wp" : "bp";
    }

    /**
     * Implements the move functionality of the Pawn Piece
     * Takes care of killing diagonally - makes sure there is something to kill and that it is the opposite color
     * Takes care of moving forward one or two spots by called checkMove method
     * Takes care of enpassant by storing a piece which tracks which piece was moved last
     * @param board 2D array containing the chess board
     * @param oFile old file of the piece to be moved
     * @param oRank old rank of the piece to be moved
     * @param nFile new file of where the piece is going to move
     * @param nRank new rank of where the piece is going to move
     * @return boolean, true if move is valid, false otherwise
     */
    @Override
    public boolean move(Piece[][] board, int oFile, int oRank, int nFile, int nRank) {


        if(oFile == nFile){ //normal move, not killing anyone
                if(board[nRank][nFile]!=null){
                   // System.out.println("Cant move to a taken spot!");
                    return false; //trying to move to an occupied space
                }

                if(checkMove(board, oFile, oRank, nFile, nRank)){
                    return true;
                }else{
                    return false;
                }
        }

        else{ //killing, moving diagonal
            if(board[nRank][nFile] == null){

                int necessaryRank =  isWhite ? 2 : 5;

                if(nRank != necessaryRank){
                    return false;
                }

                Piece pawn = this.isWhite ? board[nRank+1][nFile] : board[nRank-1][nFile];

                //enpassant
                if(pawn  == Chess.lastMove){
                    if(pawn instanceof Pawn){
                        Pawn x = (Pawn) pawn;
                        if(x.twoStep == false){
                            return false;
                        }
                    }
                    else{
                        return false;
                    }


                    if(!checkMove(board, oFile, oRank, nFile, nRank)){
                        return false;
                    }

                    //simulating enpassant to get ready to see if it will result in a check
                    Piece king = Chess.returnKing(this.isWhite);
                    board[nRank][nFile] = this;
                    board[oRank][oFile] = null;
                    int tempRank = this.isWhite ? necessaryRank+1 : necessaryRank-1;
                    board[tempRank][nFile] = null;
                    //System.out.println("Right before king enpassant");

                    if(Chess.check(board, king)){ //this is returning false when it should be returning true
                       // System.out.println(king+"This is the king enpassant");
                        Chess.reverseMove(board, oFile, oRank, nFile, nRank, null);
                        board[tempRank][nFile] = pawn;
                        return false;
                    }

                    board[oRank][oFile] = this;
                    board[nRank][nFile] = null;
                    int enpassantRank = this.isWhite ? nRank+1 : nRank-1;
                    board[enpassantRank][nFile] = null;
                    return true;
                }
                else{
                   // System.out.println("Cannot kill nothing!");
                    return false;
               }

            }
            //check that you are killing opposite color
            if((isWhite && board[nRank][nFile].isWhite) || ((!isWhite) && !(board[nRank][nFile].isWhite))){
                //System.out.println("Dont kill your friend!");
                return false;
            }
            if(isWhite && (nRank-oRank == -1) && (Math.abs(nFile-oFile) == 1)){
                hasMoved = true;
                return true;
            }
            else if(!isWhite && (nRank-oRank == 1) && (Math.abs(nFile-oFile)==1)){
                hasMoved=true;
                return true;
            }
            else{
                return false;
            }
        }
    }

    /**
     * Method which checks if the pawn is moving one or two spaces forward
     * If the pawn if moving 2 spaces forward, checks that the pawn is not jumping over anything
     * Also checks that it is the first move of the pawn since that is the only time you can move two spaces
     * @param board 2D array containing the chess board
     * @param oFile old file of the piece you want to move
     * @param oRank old rank of the piece you want to move
     * @param nFile new file you want to move the piece to
     * @param nRank new rank you want to move the piece to
     * @return boolean, true if move is valid
     */
    public boolean checkMove (Piece[][] board, int oFile, int oRank, int nFile, int nRank){
        if(isWhite){
            //check if one space

            if((nRank - oRank) == -1){
                hasMoved = true;
                return true;
            }
            //check if two space
            else if((nRank-oRank) == -2){

                if(hasMoved == true){
                  //  System.out.println("Not first move! Cannot go two spaces");
                    return false;
                }
                //check middle space

                if(board[nRank+1][oFile]==null){
                    hasMoved = true;
                    this.twoStep = true;
                    return true;
                }
                else{
                  //  System.out.println("Cannot jump over");
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{ //Black
            //check if 1 space
            if((nRank - oRank) == 1){
                hasMoved = true;
                return true;
            }
            //check if 2 spaces
            if((nRank - oRank) == 2){

                if(hasMoved == true){
                 //   System.out.println("Cannot move two spaces if not first turn");
                    return false;
                }
                if(board[nRank-1][oFile] == null){
                    hasMoved = true;
                    this.twoStep = true;
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }

        }
    }

}