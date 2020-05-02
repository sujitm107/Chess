package com.example.android29;

import java.util.ArrayList;
import java.util.Date;

public class Match {
    private String title;
    private Date date;
    private ArrayList<String> moves = new ArrayList<String>();

    public Match(String title, ArrayList<String> moves){
        this.title = title;
        this.moves = moves;
    }

    public ArrayList<String> getMoves(){
        return moves;
    }


}
