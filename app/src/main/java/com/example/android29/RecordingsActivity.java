package com.example.android29;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class RecordingsActivity extends AppCompatActivity {

    ListView matchesListView;
    ArrayList matches;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        matchesListView = (ListView) findViewById(R.id.matchesListView);

        matches = RecordedMatches.getInstance().getMatches(); //get ArrayList from RecordedMatchesList

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, matches);

        matchesListView.setAdapter(arrayAdapter);
        matchesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String matchName = matches.get(i).toString();
                RecordedMatches.MatchNode match = (RecordedMatches.MatchNode) adapterView.getItemAtPosition(i);

                Bundle b = new Bundle();
                b.putString("title", match.toString());
                b.putStringArrayList("moves", match.getMoves());
                b.putString("winner", match.getWinner());
                b.putLong("Date", match.getDate().getTime());

                Intent intent = new Intent(view.getContext(), ChessMatchActivity.class);
                intent.putExtras(b);

                ChessMatchActivity.isPlayback = true;

                startActivity(intent);
            }
        });


    }

    public void sortTitlePressed(View view){
        ArrayList matches = RecordedMatches.getInstance().getMatches(); //get ArrayList from RecordedMatchesList

        if(matches.size() == 0){
            noMatchestoSort();
            return;
        }

        Collections.sort(RecordedMatches.getInstance().getMatches(), new SortByTitle());
        Log.i("Sorting", "By Title");
        Log.i("First:", RecordedMatches.getInstance().getMatches().get(0).toString());

        matchesListView.setAdapter(arrayAdapter);



    }

    public void sortDatePressed(View view){

        ArrayList matches = RecordedMatches.getInstance().getMatches(); //get ArrayList from RecordedMatchesList

        if(matches.size() == 0){
            noMatchestoSort();
            return;
        }

        Collections.sort(RecordedMatches.getInstance().getMatches(), new SortByDate());
        Log.i("Sorting", "By Date");
        Log.i("First:", RecordedMatches.getInstance().getMatches().get(0).toString());

        matchesListView.setAdapter(arrayAdapter);

    }

    public void noMatchestoSort(){
        Toast.makeText(this, "Nothing to Sort", Toast.LENGTH_SHORT).show();
    }

}
