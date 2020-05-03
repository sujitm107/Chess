package com.example.android29;


import java.util.ArrayList;
import java.util.Date;

public class RecordedMatches  {

    //Using singleton design pattern
    public static RecordedMatches recordedMatchesList = new RecordedMatches();

    private ArrayList<MatchNode> matches = new ArrayList<MatchNode>();

    public static final String storeDir = "sampledata";
    public static final String storeFile = "matches.dat";
    static final long serialVersionUID = 1L;

    //inner class
    static class MatchNode {
        private String title;
        private Date date;
        private String winner;
        //Calendar.getInstance.getTime();
        private ArrayList<String> moves = new ArrayList<String>();
        static final long serialVersionUID = 1L;

        public MatchNode(String title, ArrayList<String> moves){
            this.title = title;
            this.moves = moves;
           // moves.add("e2 e4");
        }

        public MatchNode(){

            this.moves = new ArrayList<>();
        }

        public ArrayList<String> getMoves(){
            return moves;
        }

        public String getWinner(){
            return winner;
        }

        public void setDate(Date date){
            this.date = date;
        }

        public Date getDate(){
            return date;
        }

        public void setWinner(String winner){
            this.winner = winner;
        }

        public String toString(){
            return title;
        }

        public void setTitle(String title){
            this.title = title;
        }

        public void setMoves(ArrayList<String> moves){
            this.moves = moves;
        }

        public void addMove(String move){
            this.moves.add(move);
        }

        public void undoMove(){
            this.moves.remove(moves.size()-1);
        }

        public void printMoves(){
            for(int i = 0; i < moves.size();i++){
                System.out.println("Move: " + moves.get(i));
            }
        }

    }

    //constructor
    private RecordedMatches(){

    }

    public void writeApp() {


    }

    public void readApp() {

    }

    public ArrayList<MatchNode> getMatches(){
        return matches;
    }

    public void addMatch(MatchNode m){
        matches.add(m);
    }

    public static RecordedMatches getInstance(){
        return recordedMatchesList;
    }

}
