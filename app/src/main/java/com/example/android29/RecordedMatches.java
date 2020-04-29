package com.example.android29;

import java.util.ArrayList;
import java.util.Date;

public class RecordedMatches {

    //Using singleton design pattern
    private static RecordedMatches recordedMatchesList = new RecordedMatches();
    private ArrayList<MatchNode> matches = new ArrayList<MatchNode>();

    //inner class
    class MatchNode {
        private String title;
        private Date date;
        private ArrayList<String> moves = new ArrayList<String>();

        public MatchNode(String title, ArrayList<String> moves){
            this.title = title;
            this.moves = moves;
        }

        public ArrayList<String> getMoves(){
            return moves;
        }

    }

    private RecordedMatches(){

    }

    public void addMatch(MatchNode m){
        matches.add(m);
    }

}
