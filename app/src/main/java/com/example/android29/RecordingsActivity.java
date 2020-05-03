package com.example.android29;

import android.content.Intent;
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
import java.util.List;

import static java.util.Arrays.asList;

public class RecordingsActivity extends AppCompatActivity {
//
//    public static final String title = "title";
//    public static final ArrayList<String> moves = "moves";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView matchesListView = (ListView) findViewById(R.id.matchesListView);


        final ArrayList matches = RecordedMatches.getInstance().getMatches(); //get ArrayList from RecordedMatchesList

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, matches);

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
        ListView matchesListView = (ListView) findViewById(R.id.matchesListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, matches);


    }

    public void sortDatePressed(View view){

    }

    
}
