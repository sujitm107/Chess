package com.example.android29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.AlphabeticIndex;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();

    }

    public void playButtonPressed(View view){

        Toast.makeText(this, "Play Button Pressed", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ChessMatchActivity.class);
        ChessMatchActivity.isPlayback = false;
        startActivity(intent);

    }

    public void matchesButtonPressed(View view){

        Toast.makeText(this, "Previous Matches Button Pressed", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, RecordingsActivity.class);
        startActivity(intent);

    }

    public void load(){
        RecordedMatches data = null;
        ObjectInputStream ois = null;
        FileInputStream fis = null;

        try {
            fis = this.openFileInput("Pizza.dat");
            Log.i("Success", "Read in file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(fis == null){
            return;
        }

        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            data = (RecordedMatches) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RecordedMatches.process(data);

        //label.setText(data.toString());
    }



}
