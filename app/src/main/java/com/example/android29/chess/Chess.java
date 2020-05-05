/**
 * @author Sujit Molleti and Rachana Kotamraju
 */
package com.example.android29.chess;

import android.app.AlertDialog;
import android.media.Image;
import android.util.Log;

import com.example.android29.ChessMatchActivity;
import com.example.android29.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Chess {

    /**
     * @lastMove Keeps track of the last piece that was moved - useful for enpassant
     * @whiteKing Global variable storing position of white king
     * @blackKing Global variable storing position of black king
     */
    static Piece lastMove;
    private static Piece whiteKing;
    private static Piece blackKing;
    private Piece[][] board;

    static Piece lastKilled;
    private boolean ifCheck = false;

    public Chess(){
        board = new Piece[8][8];
        setBoard(this.board);
        whiteKing = board[7][4];
        blackKing = board[0][4];
    }

    public Piece[][] getBoard(){
        return board;
    }

    public static void main(String[] args) {

//        boolean gameOn = true;
//        boolean isWhiteTurn = true;
//
//        Scanner in = new Scanner(System.in);
//        String move;
//
//        Piece[][] board = new Piece[8][8];
//
//        setBoard(board);
//        printBoard(board);
//
//        whiteKing = board[7][4];
//        blackKing = board[0][4];
//
//
//        boolean check = false;
//        boolean prevDraw = false;
//        int oFile;
//        int oRank;
//        int nFile;
//        int nRank;
//
//
//        while(gameOn){ //can change to true actually
//            if(check){
//                System.out.println("\nCheck");
//            }
//            if(isWhiteTurn){
//                System.out.print("\nWhite's Move: ");
//                move = in.nextLine();
//            } else{
//                System.out.print("\nBlack's Move: ");
//                move = in.nextLine();
//            }
//
//            if(move.equals("resign")){
//                if(isWhiteTurn){
//                    System.out.println("\nBlack Wins");
//                } else {
//                    System.out.println("\nWhite Wins");
//                }
//                gameOn = false;
//                break; //-- gameOver;
//            }
//            else {
//
//
//                if(prevDraw == true){
//                    if(move.equals("draw")){
//                        gameOn = false;
//                        System.out.println("\ndraw");
//                        break; //game over
//                    }
//
//                    prevDraw = false;
//                }
//
//                //we are using 7 instead of 8 because if getValue returned a 0, we would go out of bounds
//                String[] moves = move.split(" ");
//                oFile = getValue(moves[0].charAt(0));
//                oRank = 7-getValue(moves[0].charAt(1));
//                nFile = getValue(moves[1].charAt(0));
//                nRank = 7-getValue(moves[1].charAt(1));
//
//                Piece newPosition = board[nRank][nFile];
//
//                if(move.substring(move.lastIndexOf(" ")+1).equals("draw?")){
//                    prevDraw = true;
//                }
//
//                if(oFile == -1 || oRank == 8 || nFile == -1 || nRank == 8){ //we set Ranks to 8 bc lines 45 and 47
//                    //System.out.println("MOVE IS OUT OF BOUNDS");
//                    System.out.println("Illegal move, try again");
//                    continue;
//                }
//
//
//                if(board[oRank][oFile] != null && (isWhiteTurn == board[oRank][oFile].isWhite)) {
//                    // System.out.println("Moving from " + oFile + " " + oRank + " to " + nFile + " " + nRank);
//                    if(board[oRank][oFile].move(board, oFile, oRank, nFile, nRank) == true){
//
//
//
//                        //checking for pawn promotion
//                        if(checkPawnPromotion(board, oRank, oFile, nRank, nFile) == true){
//                            //System.out.println("CHECK PAWN PROMOTION IS TRUE");
//                           // promotePawn(board, move.charAt(move.length()-1), oRank, oFile, nRank, nFile);
//
//                        }
//
//                      // System.out.println(board[oRank][oFile]);
//
//                        //if You are killing something
//
//                        board[nRank][nFile] = board[oRank][oFile];
//                        board[oRank][oFile] = null;
//
//                        if(board[nRank][nFile] instanceof King){
//                            if(isWhiteTurn){
//                                whiteKing = board[nRank][nFile];
//                            } else{
//                                blackKing = board[nRank][nFile];
//                            }
//                        }
//
////                        System.out.println("Updating last moved piece");
//                        lastMove = board[nRank][nFile];
//
//                    }else{
//                        System.out.println("\nIllegal move, try again.");
//                        continue; // this should act as a redo
//                    }
//                } else {
//                    //System.out.println("WE ARE ON LINE 104");
//                    System.out.println("\nIllegal move, try again.");
//                    continue;
//                }
//
//                //invalid
//                if(check(board, isWhiteTurn ? whiteKing : blackKing)){
//                    //printBoard(board);
//                    System.out.println("\nIllegal move, try again.");
//                    reverseMove(board, oFile, oRank, nFile, nRank, newPosition);
//                    lastMove = board[oRank][oFile];
//                    //we don't have to update the king's position here because we don't allow the king to put itself in check
//                    continue;
//                }
//
//                //opposite
//                check = check(board, isWhiteTurn ? blackKing : whiteKing);
//
//                if(check){
//                   // System.out.println("running");
//                    if(checkmate(board, isWhiteTurn ? blackKing : whiteKing)){
//                        System.out.println("\nCheckmate");
//                        System.out.println(isWhiteTurn ? "\nWhite Wins" : "\nBlack Wins");
//                        break;
//                    }
//
//                }
//
//            }
//
//           // System.out.println("BlackKing Position File "+blackKing.file+" Rank: "+blackKing.rank);
//          //  System.out.println("WhiteKing Position File "+whiteKing.file+" Rank: "+whiteKing.rank);
//
//            //end turn code
//           // System.out.println("Updating last moved piece");
//            lastMove = board[nRank][nFile];
//            System.out.println();
//            printBoard(board);
//
//            isWhiteTurn = !(isWhiteTurn);
//        }

    } //end of the main

    /**
     * Reverses a move previously made by using a temporary position
     * @param board 2D array containing the chess board
     * @param oFile file you are moving the piece back to
     * @param oRank rank you are moving the piece back to
     * @param nFile file of piece you are moving
     * @param nRank rank of piece you are moving
     * @param newPosition old piece you killed and brought back
     *
     */
    public static void reverseMove(Piece[][] board, int oFile, int oRank, int nFile, int nRank, Piece newPosition){
       // System.out.println("Reversing move "+board[nRank][nFile]);
        board[oRank][oFile] = board[nRank][nFile];
        board[nRank][nFile] = newPosition;

    }

    /**
     * Creates a hashmap of values that map the ranks and files of the board to the 2D array which contains the board
     * @param c char to get value of
     *
     */
    public static int getValue(char c){
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

        hashmap.put('a', 0); hashmap.put('1', 0);
        hashmap.put('b', 1); hashmap.put('2', 1);
        hashmap.put('c', 2); hashmap.put('3', 2);
        hashmap.put('d', 3); hashmap.put('4', 3);
        hashmap.put('e', 4); hashmap.put('5', 4);
        hashmap.put('f', 5); hashmap.put('6', 5);
        hashmap.put('g', 6); hashmap.put('7', 6);
        hashmap.put('h', 7); hashmap.put('8', 7);

        try {
            return hashmap.get(c);
        } catch (NullPointerException e){
            return -1;
        }
    }

    /**
     * Sets up the starting board for chess by specifying the location of each piece in the beginning
     * @param board 2D array containing the chess board
     */
    public static void setBoard(Piece[][] board){

        //["Rook", "Knight", "Bishop", "Queen", "King", "Bishop", "Knight", "Rook"]
        //Write this more efficiently

        board[0][0] = new Rook(false);
        board[0][7] = new Rook(false);
        board[0][1] = new Knight(false);
        board[0][6] = new Knight(false);
        board[0][2] = new Bishop(false);
        board[0][5] = new Bishop(false);
        board[0][3] = new Queen(false);
        board[0][4] = new King(false);

        board[7][0] = new Rook(true);
        board[7][7] = new Rook(true);
        board[7][1] = new Knight(true);
        board[7][6] = new Knight(true);
        board[7][2] = new Bishop(true);
        board[7][5] = new Bishop(true);
        board[7][3] = new Queen(true);
        board[7][4] = new King(true);


        for(int c = 0; c<(board[0].length); c++){
            board[1][c] = new Pawn(false);
            board[6][c] = new Pawn(true);
        }


    }

    /**
     * Prints the chess board using ascii values, puts '##' on black squares and leaves white squares empty
     * @param board 2D array containing the chess board
     */

    public static void printBoard(Piece[][] board){
        for(int r = 0; r<board.length; r++){
            for(int c = 0; c<board[r].length; c++){
                if(board[r][c] == null){
                    if ((r % 2 == 0 && c % 2 == 0) || (r % 2 != 0 && c % 2 != 0)) { //even even, or odd odd
                        System.out.print("   ");
                    }else{
                        System.out.print("## ");
                    }
                }else{
                    System.out.print(board[r][c]+" ");
                }
            }
            System.out.println(8-r);
        }

        //using ascii values to print files, 97 = a, 104=h
        for(int i = 0; i<8; i++){
            System.out.print(" "+(char)(97+i)+" ");
        }
        System.out.println();

    }

    /**
     * Checks if specified king is in check by any other opposite color piece
     * @param board 2D array of chess board
     * @param king king you are checking is or is not in check (black or white)
     * @return boolean, true if king is in check, false otherwise
     */

    public static boolean check(Piece[][] board, Piece king){
        //alt. make it a int method 1 white is on check, -1 black is on check, 0 neither are on check
        /*
            1. Before -- prevention bc otherwise invalid move
            2. After -- warning to the other player
         */

        Piece temp = board[king.rank][king.file];
        board[king.rank][king.file] = null;

      //  System.out.println(board[3][4]);

       // System.out.println("Starting check");
        for(int r = 0; r<board.length; r++){
            for(int f = 0; f<board[r].length; f++){
                if((board[r][f] != null)  && (board[r][f].isWhite != king.isWhite)){
                    if((board[r][f].move(board, f, r, king.file, king.rank) == true) ){
                        if(board[r][f] instanceof Pawn){
                            if(king.file == f){
                                board[king.rank][king.file] = temp;
                                return false;
                            }
                        }
                      //  System.out.println(board[r][f]+" this piece can kill the king");
                      //  System.out.println("King's File: "+king.file);
                       // System.out.println("King's Rank: "+king.rank);
                        board[king.rank][king.file] = temp;
                        return true; //this is being callled but from where?
                    }
                }
            }
        }

        board[king.rank][king.file] = temp;
        return false;
    }

    /**
     * Checks whether the specified King is in checkmate
     * @param board 2D array of the chess board
     * @param king king you are checking is or is not in checkmate (black or white)
     * @return boolean, true if the king is in checkmate, false otherwise
     */

    public static boolean checkmate(Piece[][] board, Piece king){
        //System.out.println("Call for checkmate");
        //every move for the king is false

        int ogRank = king.rank;
        int ogFile = king.file;

        for(int r = king.rank-1; r<=king.rank+1; r++){
            if(r < 0 || r > 7 ){ //skip checking if out of bounds
                continue;
            }
            for(int f = king.file-1; f<=king.file+1; f++){

                if(f < 0 || f > 7){ //skip checking if out of bounds
                    continue;
                }
                if(r == king.rank && f == king.file){ //do not check the king's spot
                    continue;
                }

              //  System.out.println("TRYING TO MOVE KING");
             //   System.out.println("File: "+f+" Rank:"+r +" THIS IS THE POSITION BEING CHECKED DURING CHECKMATE");
             //   System.out.println("File: "+king.file+" Rank: "+king.rank+" POSITION OF KING BEFORE RESETTING IN CHECKMATE METHOD");
                if(king.move(board, king.file, king.rank, f, r)){
                    //System.out.println("File: "+king.file+" Rank: "+king.rank+" POSITION OF KING WHEN RETURNING FROM CHECKMATE METHOD");
                    king.file = ogFile;
                    king.rank = ogRank;
                    //king.move(board, r, f, king.file, king.rank);
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Determines whether it is permissible for the pawn to be promoted
     * Checks whether it has reached the opposite end and whether it is a pawn
     * @param board 2D array of the chess board
     * @param oRank old rank of the piece to be moved
     * @param oFile old file of the piece to be moved
     * @param nRank new rank that you are moving the piece to
     * @param nFile new file that you are moving the piece to
     * @return boolean, true if pawn promotion is valid, false otherwise
     */
    public static boolean checkPawnPromotion(Piece[][] board, int oRank, int oFile, int nRank, int nFile){
        if(!(board[oRank][oFile] instanceof Pawn)){ //has to be a pawn
            return false;
        }

        if((board[oRank][oFile].isWhite) && (nRank != 0)){
            return false;
        }
        else if(!(board[oRank][oFile].isWhite) && (nRank != 7)){
            return false;
        }
        return true;
    }

    public boolean isPawn(String move){
        String[] moves = move.split(" ");
        int oFile = getValue(moves[0].charAt(0));
        int oRank = 7-getValue(moves[0].charAt(1));
        int nFile = getValue(moves[1].charAt(0));
        int nRank = 7-getValue(moves[1].charAt(1));
        return checkPawnPromotion(board, oRank,oFile,nRank,nFile);

    }

    /**
     * Determines what piece a pawn should be promoted to based on the player input
     *
     * @param board 2D array of the chess board
     * @param promotion char indicating the piece the player wants to promote the pawn to
     * @param oRank old rank of the piece you are promoting
     * @param oFile old file of the piece you are promoting
     * @param nRank new rank that you are moving the piece to
     * @param nFile new file that you are moving the piece to
     *
     * @return void
     */

    public static void promotePawn(Piece[][] board, char promotion, int oRank, int oFile, int nRank, int nFile){
        boolean white = board[oRank][oFile].isWhite;
        if(promotion == 'Q'){
            board[oRank][oFile] = new Queen(white);
        }
        else if(promotion == 'N'){
            board[oRank][oFile] = new Knight(white);
        }
        else if(promotion == 'B'){
            board[oRank][oFile] = new Bishop(white);

        }
        else if(promotion == 'R'){
            board[oRank][oFile] = new Rook(white);
        }
        else{ //not specified
            board[oRank][oFile] = new Queen(white);
        }

    }

    /**
     * Used for the enpassant method to check that a enpassant move is not leaving the same color king in check
     * @param isWhite boolean which tells if a piece is white or black
     * @return a white or black king
     */

    public static Piece returnKing(boolean isWhite){

        return isWhite ? whiteKing : blackKing;
    }

    public String start(String move, boolean isWhiteTurn){
        Log.i("Message", move);


        boolean check = false;
        boolean prevDraw = false;
        int oFile;
        int oRank;
        int nFile;
        int nRank;



            if(isWhiteTurn){
                System.out.print("\nWhite's Move: ");
                //move = in.nextLine();
            } else{
                System.out.print("\nBlack's Move: ");
                //move = in.nextLine();
            }

                if(prevDraw == true){
                    if(move.equals("draw")){
                        //gameOn = false;
                        System.out.println("\ndraw");
                        return "Draw"; //game over
                    }

                    prevDraw = false;
                }

                //we are using 7 instead of 8 because if getValue returned a 0, we would go out of bounds
                String[] moves = move.split(" ");
                oFile = getValue(moves[0].charAt(0));
                oRank = 7-getValue(moves[0].charAt(1));
                nFile = getValue(moves[1].charAt(0));
                nRank = 7-getValue(moves[1].charAt(1));

                Piece newPosition = board[nRank][nFile];

                if(move.substring(move.lastIndexOf(" ")+1).equals("draw?")){
                    prevDraw = true;
                }

                if(oFile == -1 || oRank == 8 || nFile == -1 || nRank == 8){ //we set Ranks to 8 bc lines 45 and 47
                    //System.out.println("MOVE IS OUT OF BOUNDS");
                    System.out.println("Illegal move, try again");
                    return "invalid";
                }


                if(board[oRank][oFile] != null && (isWhiteTurn == board[oRank][oFile].isWhite)) {
                    // System.out.println("Moving from " + oFile + " " + oRank + " to " + nFile + " " + nRank);
                    if(board[oRank][oFile].move(board, oFile, oRank, nFile, nRank) == true){



                        //checking for pawn promotion
                        if(checkPawnPromotion(board, oRank, oFile, nRank, nFile) == true){
                            System.out.println("CHECK PAWN PROMOTION IS TRUE");
                            //PAWN PROMOTION HERE

                        }
                        //if you are killing something
                        if(board[nRank][nFile]!=null){
                            lastKilled = board[nRank][nFile];
                        }
                        else{
                            lastKilled = null;
                        }

                        Log.i("StartMethod:", board[oRank][oFile].toString());
                        board[nRank][nFile] = board[oRank][oFile];
                        board[oRank][oFile] = null;

                        if(board[nRank][nFile] instanceof King){
                            if(isWhiteTurn){
                                whiteKing = board[nRank][nFile];
                            } else{
                                blackKing = board[nRank][nFile];
                            }
                        }

//                        System.out.println("Updating last moved piece");
                        lastMove = board[nRank][nFile];

                    }else{
                        System.out.println("\nIllegal move, try again.");
                        return "invalid"; // this should act as a redo
                    }
                } else {
                    //System.out.println("WE ARE ON LINE 104");
                    System.out.println("\nIllegal move, try again.");
                    return "invalid";
                }

                //invalid
                if(check(board, isWhiteTurn ? whiteKing : blackKing)){
                    //printBoard(board);
                    System.out.println("\nIllegal move, try again.");
                    reverseMove(board, oFile, oRank, nFile, nRank, newPosition);
                    lastMove = board[oRank][oFile];
                    //we don't have to update the king's position here because we don't allow the king to put itself in check
                    return "invalid";
                }

                //opposite
                check = check(board, isWhiteTurn ? blackKing : whiteKing);

                if(check){
                    // System.out.println("running");
                    if(checkmate(board, isWhiteTurn ? blackKing : whiteKing)){
                        System.out.println("\nCheckmate" + (isWhiteTurn ? "\nWhite Wins" : "\nBlack Wins"));
                        return "Checkmate";
                    }
                    return "check";
                }



            //}

            // System.out.println("BlackKing Position File "+blackKing.file+" Rank: "+blackKing.rank);
            //  System.out.println("WhiteKing Position File "+whiteKing.file+" Rank: "+whiteKing.rank);

            //end turn code
            // System.out.println("Updating last moved piece");
            lastMove = board[nRank][nFile];
            System.out.println();
            printBoard(board);

            //isWhiteTurn = !(isWhiteTurn);
        //}

        return "valid";
    }

    static class Move{
        int rank;
        int file;

        public Move(int file, int rank){
            this.rank = rank;
            this.file = file;
        }
    }

    public String makeAImove(boolean isWhiteTurn) {
        int nFile = 0;
        int nRank = 0;
        int oFile = 0;
        int oRank = 0;

        ArrayList<Piece> piecesSet = new ArrayList<Piece>();
        ArrayList<Move> validDestSet = new ArrayList<Move>();

        //generate set of White Pieces or BlackPieces
        for (int r = 0; r < 8; r++) {
            for (int f = 0; f < 8; f++) {
                if (board[r][f] == null) {
                    continue;
                }
                if (board[r][f].isWhite == isWhiteTurn) {
                    piecesSet.add(board[r][f]);
                }
            }
        }


        Piece randomPiece = null;
        int randomPieceIndex = -1;


        //4 --->
        String AImove = null;
        String moveResult = null;
        Move dest = null;

        do {

            if(dest != null){
                validDestSet.remove(dest);
            }

            while(validDestSet.size() == 0){
                if(randomPiece != null){
                    piecesSet.remove(randomPiece);
                }


                randomPieceIndex = (int) (Math.random() * piecesSet.size());
                randomPiece = piecesSet.get(randomPieceIndex);

                //finding Rank and File of random piece
                for (int r = 0; r < 8; r++) {
                    for (int f = 0; f < 8; f++) {
                        if (board[r][f] == randomPiece) {
                            oFile = f;
                            oRank = r;
                        }
                    }
                }


                if(board[oRank][oFile] == null){
                    System.out.println("Error");
                }
                Log.i("Start:", board[oRank][oFile].toString());

                for (int r = 0; r < 8; r++) {
                    for (int f = 0; f < 8; f++) {
                        if (randomPiece.move(board, oFile, oRank, f, r)) {
                            validDestSet.add(new Move(f, r));
                        }
                    }
                }
            }

            validDestSet.remove(new Move(whiteKing.file, whiteKing.rank));
            validDestSet.remove(new Move(blackKing.file, blackKing.rank));

            int randomDestIndex = (int) (Math.random() * validDestSet.size());
            dest = validDestSet.get(randomDestIndex);

            //construct our string

            AImove = (char) (oFile + 97) + String.valueOf(8 - oRank) + " ";
            AImove += (char) (dest.file + 97) + String.valueOf(8 - dest.rank);

            Log.i("AIMOVE", AImove);

            if (board[oRank][oFile] instanceof Pawn) {
                board[oRank][oFile].hasMoved = false;
            }
            System.out.println("End: " + board[oRank][oFile]);
            printBoard(board);

            if(board[nRank][nFile] instanceof King){
                System.out.println("Error");
            }

            moveResult = start(AImove, isWhiteTurn);


            if(moveResult.equals("Checkmate")){
                AImove = moveResult;
            }

            if(moveResult.equals("check")){
                ifCheck = true;
                AImove += "check";
            }


        } while(moveResult.equals("invalid"));

        return AImove;

    }



    public void movePlayBack(String move){
        String[] moves = move.split(" ");
        int oFile = getValue(moves[0].charAt(0));
        int oRank = 7-getValue(moves[0].charAt(1));
        int nFile = getValue(moves[1].charAt(0));
        int nRank = 7-getValue(moves[1].charAt(1));

        board[nRank][nFile] = board[oRank][oFile];
        board[oRank][oFile] = null;

        System.out.println("IN MOVEPLAYBACK");
    }

    public void undoMove(String move){
        String[] moves = move.split(" ");
        int oFile = getValue(moves[0].charAt(0));
        int oRank = 7-getValue(moves[0].charAt(1));
        int nFile = getValue(moves[1].charAt(0));
        int nRank = 7-getValue(moves[1].charAt(1));

        if(board[nRank][nFile] instanceof Pawn && ((Math.abs(nRank-oRank)==2) || (Math.abs(nRank-oRank)==1 && (oRank == 1 || oRank == 6)))){
            System.out.println("UNDO IS AN INSTANCE OF PAWN");
            board[nRank][nFile].hasMoved = false;
        }

        board[oRank][oFile] = board[nRank][nFile];
        board[nRank][nFile] = lastKilled;
        if(lastKilled != null){
            System.out.println("PIECE LAST KILLED: " + lastKilled.name);
        }else{
            System.out.println("LAST KILLED IS NULL");
        }
        printBoard(board);

    }

    public int getLastKilled(){
        if(lastKilled == null){
            return android.R.color.transparent;
        }
        else if(lastKilled.name.equals("bK")){
            return R.drawable.bk;
        }
        else if(lastKilled.name.equals("bQ")){
            return R.drawable.bq;
        }
        else if(lastKilled.name.equals("bN")){
            return R.drawable.bn;
        }
        else if(lastKilled.name.equals("bB")){
            return R.drawable.bb;
        }
        else if(lastKilled.name.equals("bR")){
            return R.drawable.br;
        }
        else if(lastKilled.name.equals("bp")){
            return R.drawable.bp;
        }
        else if(lastKilled.name.equals("wK")){
            return R.drawable.wk;
        }
        else if(lastKilled.name.equals("wQ")){
            return R.drawable.wq;
        }
        else if(lastKilled.name.equals("wN")){
            return R.drawable.wn;
        }
        else if(lastKilled.name.equals("wB")){
            return R.drawable.wb;
        }
        else if(lastKilled.name.equals("wR")){
            return R.drawable.wr;
        }
        else if(lastKilled.name.equals("wp")){
            return R.drawable.wp;
        }
        return android.R.color.transparent;
    }
}
