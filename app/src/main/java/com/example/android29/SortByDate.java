package com.example.android29;



import com.example.android29.RecordedMatches;

import java.util.Comparator;

public class SortByDate implements Comparator<RecordedMatches.MatchNode> {


    @Override
    public int compare(RecordedMatches.MatchNode o1, RecordedMatches.MatchNode o2) {
        if(o1.getDate().before(o2.getDate())){
            return -1;
        } else {
            return 1;
        }


        //return o1.getTitle().compareTo(o2.getTitle());
    }
}