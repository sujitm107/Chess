package com.example.android29;



import com.example.android29.RecordedMatches;

import java.util.Comparator;

public class SortByTitle implements Comparator<RecordedMatches.MatchNode> {


    @Override
    public int compare(RecordedMatches.MatchNode o1, RecordedMatches.MatchNode o2) {

        return o1.getTitle().compareTo(o2.getTitle());
    }
}
