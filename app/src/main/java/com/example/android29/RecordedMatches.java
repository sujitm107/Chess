package com.example.android29;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class RecordedMatches implements Serializable {

    //Using singleton design pattern
    private static RecordedMatches recordedMatchesList = new RecordedMatches();

    private ArrayList<MatchNode> matches = new ArrayList<MatchNode>();

    public static final String storeDir = "R.raw";
    public static final String storeFile = "matches.dat";
    static final long serialVersionUID = 1L;

    //inner class
    static class MatchNode implements Serializable{
        private String title;
        //private Date date;
        private ArrayList<String> moves = new ArrayList<String>();
        static final long serialVersionUID = 1L;

        public MatchNode(String title, ArrayList<String> moves){
            this.title = title;
            this.moves = moves;
            moves.add("e2 e4");
        }

        public ArrayList<String> getMoves(){
            return moves;
        }

        public String toString(){
            return title;
        }

    }

    //constructor
    private RecordedMatches(){

    }

    public void writeApp() throws IOException {



    }

    public void readApp() throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new
                ObjectInputStream( new FileInputStream(storeDir + File.separator + storeFile));

        recordedMatchesList = (RecordedMatches) ois.readObject();
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
