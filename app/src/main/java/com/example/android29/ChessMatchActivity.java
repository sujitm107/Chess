package com.example.android29;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class ChessMatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess_match);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //activates the up arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void resignButtonPressed(View view){

        Toast.makeText(this, "Resign Button Pressed", Toast.LENGTH_SHORT).show();

    }

    public void undoButtonPressed(View view){

        Toast.makeText(this, "Undo Button Pressed", Toast.LENGTH_SHORT).show();

    }

    public void drawButtonPressed(View view){

        Toast.makeText(this, "Draw Button Pressed", Toast.LENGTH_SHORT).show();

    }
    public void aiButtonPressed(View view){

        Toast.makeText(this, "AI Button Pressed", Toast.LENGTH_SHORT).show();

    }



}
