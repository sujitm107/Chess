package com.example.android29;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView matchesListView = (ListView) findViewById(R.id.matchesListView);

        RecordedMatches.getInstance().addMatch(new RecordedMatches.MatchNode("Match 1", new ArrayList<String>()));
        RecordedMatches.getInstance().addMatch(new RecordedMatches.MatchNode("Match 2", new ArrayList<String>()));
        RecordedMatches.getInstance().addMatch(new RecordedMatches.MatchNode("Match 3", new ArrayList<String>()));


        final ArrayList matches = RecordedMatches.getInstance().getMatches(); //get ArrayList from RecordedMatchesList

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, matches);

        matchesListView.setAdapter(arrayAdapter);

        matchesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String match = matches.get(i).toString();

                Toast.makeText(RecordingsActivity.this, match, Toast.LENGTH_SHORT).show();
            }
        });

    }

    
}
