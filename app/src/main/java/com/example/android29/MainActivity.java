package com.example.android29;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This is Rachana's Comment
        //This is Sujit's Comment
    }

    public void playButtonPressed(View view){
        Log.i("Message: ", "Play Button Pressed");



    }

}
