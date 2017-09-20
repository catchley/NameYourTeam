package com.chris.atchley.nameyourteam;

import android.content.res.Resources;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources res = getResources();

        final String[] adjectives = res.getStringArray(R.array.adjectives);
        final String[] animals = res.getStringArray(R.array.animals);
        final String[] objects = res.getStringArray(R.array.objects);

        mTwoWordAnimalButton = (Button) findViewById(R.id.twoWordAnimal);
        mThreeWordAnimalButton = (Button) findViewById(R.id.threeWordAnimal);
        mTwoWordObjectButton = (Button) findViewById(R.id.twoWordObject);
        mThreeWordObjectButton = (Button) findViewById(R.id.threeWordObject);
        mNameTextView = (TextView) findViewById(R.id.nameTextView);
        mNameTextView.setText("Team Name");


        mTwoWordAnimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstWord = adjectives[new Random().nextInt(adjectives.length)];
                String secondWord = animals[new Random().nextInt(animals.length)];
                mNameTextView.setText(firstWord + " " + secondWord + "s");
                mNameTextView.setAllCaps(true);
            }
        });

        mThreeWordAnimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstWord = adjectives[new Random().nextInt(adjectives.length)];
                String secondWord = adjectives[new Random().nextInt(adjectives.length)];
                String thirdWord = animals[new Random().nextInt(animals.length)];
                mNameTextView.setText(firstWord + " " + secondWord + " " + thirdWord + "s");
                mNameTextView.setAllCaps(true);
            }
        });

        mTwoWordObjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstWord = adjectives[new Random().nextInt(adjectives.length)];
                String secondWord = objects[new Random().nextInt(objects.length)];
                mNameTextView.setText(firstWord + " " + secondWord + "s");
                mNameTextView.setAllCaps(true);
            }
        });

        mThreeWordObjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstWord = adjectives[new Random().nextInt(adjectives.length)];
                String secondWord = adjectives[new Random().nextInt(adjectives.length)];
                String thirdWord = objects[new Random().nextInt(objects.length)];
                mNameTextView.setText(firstWord + " " + secondWord + " " + thirdWord + "s");
                mNameTextView.setAllCaps(true);
            }
        });


    }
}
