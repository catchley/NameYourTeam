package com.chris.atchley.nameyourteam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button mTwoWordObjectButton;
    Button mThreeWordObjectButton;
    Button mTwoWordAnimalButton;
    Button mThreeWordAnimalButton;
    TextView mNameTextView;

    String[] adjectives =  this.getResources().getStringArray(R.array.adjectives);
    String[] animals =  this.getResources().getStringArray(R.array.adjectives);
    String[] objects =  this.getResources().getStringArray(R.array.objects);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTwoWordAnimalButton = (Button)findViewById(R.id.twoWordAnimal);
        mThreeWordAnimalButton = (Button)findViewById(R.id.threeWordAnimal);
        mTwoWordObjectButton = (Button)findViewById(R.id.twoWordObject);
        mThreeWordObjectButton = (Button)findViewById(R.id.threeWordObject);
        mNameTextView = (TextView)findViewById(R.id.nameTextView);
        mNameTextView.setText("Team Name");


        mTwoWordAnimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstWord = adjectives[new Random().nextInt(adjectives.length)];
                String secondWord = animals[new Random().nextInt(animals.length)];
                mNameTextView.setText(firstWord + " " + secondWord);
            }
        });

        mThreeWordAnimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstWord = adjectives[new Random().nextInt(adjectives.length)];
                String secondWord = adjectives[new Random().nextInt(adjectives.length)];
                String thirdWord = animals[new Random().nextInt(animals.length)];
                mNameTextView.setText(firstWord + " " + secondWord + " " + thirdWord);
            }
        });

        mTwoWordObjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstWord = adjectives[new Random().nextInt(adjectives.length)];
                String secondWord = objects[new Random().nextInt(objects.length)];
                mNameTextView.setText(firstWord + " " + secondWord);
            }
        });

        mThreeWordObjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstWord = adjectives[new Random().nextInt(adjectives.length)];
                String secondWord = adjectives[new Random().nextInt(adjectives.length)];
                String thirdWord = objects[new Random().nextInt(objects.length)];
                mNameTextView.setText(firstWord + " " + secondWord + " " + thirdWord);
            }
        });






    }
}
