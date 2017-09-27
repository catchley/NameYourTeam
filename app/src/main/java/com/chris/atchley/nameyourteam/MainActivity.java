package com.chris.atchley.nameyourteam;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button mTwoWordObjectButton;
    Button mThreeWordObjectButton;
    TextView mNameTextView;
    CheckBox mColorCheckBox;
    CheckBox mAnimalCheckBox;
    String firstWord;
    String secondWord;
    String thirdWord;
    String color;

    int adCounter = 0;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });


        Resources res = getResources();

        final String[] adjectives = res.getStringArray(R.array.adjectives);
        final String[] animals = res.getStringArray(R.array.animals);
        final String[] objects = res.getStringArray(R.array.objects);
        final String[] colors = res.getStringArray(R.array.colors);


        mTwoWordObjectButton = (Button) findViewById(R.id.twoWordObject);
        mThreeWordObjectButton = (Button) findViewById(R.id.threeWordObject);
        mNameTextView = (TextView) findViewById(R.id.nameTextView);
        mColorCheckBox= (CheckBox)findViewById(R.id.colerCheckBox);
        mAnimalCheckBox= (CheckBox)findViewById(R.id.animalCheckBox);

        mNameTextView.setText("Team Name");




        mTwoWordObjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (adCounter >= 15) {
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                        adCounter = 0;
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
                }

                if(mAnimalCheckBox.isChecked()) {
                    firstWord = adjectives[new Random().nextInt(adjectives.length)];
                    secondWord = animals[new Random().nextInt(animals.length)];
                }
                else{
                    firstWord = adjectives[new Random().nextInt(adjectives.length)];
                    secondWord = objects[new Random().nextInt(objects.length)];
                }
                color = colors[new Random().nextInt(colors.length)];
                if(mColorCheckBox.isChecked()) {
                    mNameTextView.setText(color + " " + firstWord + " " + secondWord + "s");
                }
                else{
                    mNameTextView.setText(firstWord + " " + secondWord + "s");
                }

                mNameTextView.setAllCaps(true);
                adCounter++;

            }
        });

        mThreeWordObjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAnimalCheckBox.isChecked()) {
                    firstWord = adjectives[new Random().nextInt(adjectives.length)];
                    secondWord = adjectives[new Random().nextInt(adjectives.length)];
                    thirdWord = animals[new Random().nextInt(animals.length)];
                }
                else{
                    firstWord = adjectives[new Random().nextInt(adjectives.length)];
                    secondWord = adjectives[new Random().nextInt(adjectives.length)];
                    thirdWord = objects[new Random().nextInt(objects.length)];
                }
                color = colors[new Random().nextInt(colors.length)];
                if(mColorCheckBox.isChecked()) {
                    mNameTextView.setText(color + " " + firstWord + " " + secondWord + " " + thirdWord + "s");
                }
                else{
                    mNameTextView.setText(firstWord + " " + secondWord + " " + thirdWord + "s");
                }
                mNameTextView.setAllCaps(true);
                adCounter++;

            }
        });


    }
}
