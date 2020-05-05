package com.example.android29;


import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

public class RecordedMatches implements Serializable {

    //Using singleton design pattern
    public static RecordedMatches recordedMatchesList = new RecordedMatches();

    private ArrayList<MatchNode> matches = new ArrayList<MatchNode>();

//    public static final String storeDir = "/Users/rachanakotamraju/Desktop/College/Sophomore Year/Spring/Software Methodology/android29/.idea/sampledata";
//    public static final String storeFile = "matches.dat";

    static final long serialVersionUID = 1L;

    //inner class
    static class MatchNode implements  Serializable{
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

            String datestr = new SimpleDateFormat("MM/dd/yyyy").format(this.date);

            return title+" - "+datestr;
        }

        public void setTitle(String title){
            this.title = title;
        }

        public String getTitle(){
            return this.title;
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

    public static void process(RecordedMatches data){
        recordedMatchesList = data;
    }

    public ArrayList<MatchNode> getMatches(){
        return matches;
    }

    public void addMatch(MatchNode m) {

        matches.add(m);
    }

    public static RecordedMatches getInstance(){
        return recordedMatchesList;
    }


}
