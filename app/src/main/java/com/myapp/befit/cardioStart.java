package com.myapp.befit;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.myapp.befit.R;

public class cardioStart extends AppCompatActivity {

    public int count;
    private Chronometer chronometer;
    private ImageView cardioDisplay;
    private TextView cardioName;
    private TextView breakText;
    private TextView endText;

    private MediaPlayer music1,music2,music3,music4,music5,music6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_start);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        chronometer = (Chronometer) findViewById(R.id.chronometer);
        cardioDisplay = (ImageView) findViewById(R.id.cardioDisplay);
        cardioName = (TextView) findViewById(R.id.cardioName);
        breakText = (TextView) findViewById(R.id.breakText);
        endText = (TextView) findViewById(R.id.endText);

        music1 = new MediaPlayer();
        music2 = new MediaPlayer();
        music3 = new MediaPlayer();
        music4 = new MediaPlayer();
        music5 = new MediaPlayer();
        music6 = new MediaPlayer();

        music1 = MediaPlayer.create(getApplicationContext(),R.raw.music1);
        music2 = MediaPlayer.create(getApplicationContext(),R.raw.music2);
        music3 = MediaPlayer.create(getApplicationContext(),R.raw.music3);
        music4 = MediaPlayer.create(getApplicationContext(),R.raw.music4);
        music5 = MediaPlayer.create(getApplicationContext(),R.raw.music5);
        music6 = MediaPlayer.create(getApplicationContext(),R.raw.music3);

        endText.setVisibility(View.INVISIBLE);
        chronometer.start();
        music1.start();

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                count = (int) (SystemClock.elapsedRealtime() - chronometer.getBase())/1000;

                if(count<=150){
                    breakText.setVisibility(View.INVISIBLE);
                    cardioName.setText(R.string.cardio1);
                    cardioDisplay.setImageResource(getResources().getIdentifier("cardio1","drawable",getPackageName()));
                }
                else if(count>=151 && count<=240){
                    breakText.setVisibility(View.VISIBLE);
                    chronometer.setTextColor(Color.RED);
                    cardioName.setVisibility(View.INVISIBLE);
                    cardioDisplay.setVisibility(View.INVISIBLE);
                    music1.stop();
                }
                else if(count>=241 && count<=390){
                    breakText.setVisibility(View.INVISIBLE);
                    chronometer.setTextColor(Color.parseColor("#ff0099cc"));
                    music2.start();
                    cardioName.setVisibility(View.VISIBLE);
                    cardioDisplay.setVisibility(View.VISIBLE);
                    cardioName.setText(R.string.cardio2);
                    cardioDisplay.setImageResource(getResources().getIdentifier("cardio2","drawable",getPackageName()));
                }
                else if(count>=391 && count<=480){
                    breakText.setVisibility(View.VISIBLE);
                    chronometer.setTextColor(Color.RED);
                    cardioName.setVisibility(View.INVISIBLE);
                    cardioDisplay.setVisibility(View.INVISIBLE);
                    music2.stop();
                }
                else if(count>=481 && count<=630){
                    breakText.setVisibility(View.INVISIBLE);
                    chronometer.setTextColor(Color.parseColor("#ff0099cc"));
                    music3.start();
                    cardioName.setVisibility(View.VISIBLE);
                    cardioDisplay.setVisibility(View.VISIBLE);
                    cardioName.setText(R.string.cardio3);
                    cardioDisplay.setImageResource(getResources().getIdentifier("cardio3","drawable",getPackageName()));
                }
                else if(count>=631 && count<=720){
                    breakText.setVisibility(View.VISIBLE);
                    chronometer.setTextColor(Color.RED);
                    cardioName.setVisibility(View.INVISIBLE);
                    cardioDisplay.setVisibility(View.INVISIBLE);
                    music3.stop();
                }
                else if(count>=721 && count<=870){
                    breakText.setVisibility(View.INVISIBLE);
                    chronometer.setTextColor(Color.parseColor("#ff0099cc"));
                    music4.start();
                    cardioName.setVisibility(View.VISIBLE);
                    cardioDisplay.setVisibility(View.VISIBLE);
                    cardioName.setText(R.string.cardio4);
                    cardioDisplay.setImageResource(getResources().getIdentifier("cardio4","drawable",getPackageName()));
                }
                else if(count>=871 && count<=960){
                    breakText.setVisibility(View.VISIBLE);
                    chronometer.setTextColor(Color.RED);
                    cardioName.setVisibility(View.INVISIBLE);
                    cardioDisplay.setVisibility(View.INVISIBLE);
                    music4.stop();
                }
                else if(count>=961 && count<=1110){
                    breakText.setVisibility(View.INVISIBLE);
                    chronometer.setTextColor(Color.parseColor("#ff0099cc"));
                    music5.start();
                    cardioName.setVisibility(View.VISIBLE);
                    cardioDisplay.setVisibility(View.VISIBLE);
                    cardioName.setText(R.string.cardio5);
                    cardioDisplay.setImageResource(getResources().getIdentifier("cardio5","drawable",getPackageName()));
                }
                else if(count>=1111 && count<=1200){
                    breakText.setVisibility(View.VISIBLE);
                    chronometer.setTextColor(Color.RED);
                    cardioName.setVisibility(View.INVISIBLE);
                    cardioDisplay.setVisibility(View.INVISIBLE);
                    music5.stop();
                }
                else if(count>=1201 && count<=1349){
                    breakText.setVisibility(View.INVISIBLE);
                    chronometer.setTextColor(Color.parseColor("#ff0099cc"));
                    music6.start();
                    cardioName.setVisibility(View.VISIBLE);
                    cardioDisplay.setVisibility(View.VISIBLE);
                    cardioName.setText(R.string.cardio5);
                    cardioDisplay.setImageResource(getResources().getIdentifier("cardio6","drawable",getPackageName()));
                }
                else {
                    endText.setVisibility(View.VISIBLE);
                    cardioName.setVisibility(View.INVISIBLE);
                    cardioDisplay.setVisibility(View.INVISIBLE);
                    chronometer.setTextColor(Color.RED);
                    chronometer.stop();
                    music6.stop();
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(cardioStart.this);
        alert.setMessage("Do you want to end the Cardio?");
        alert.setCancelable(false);

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertbox = alert.create();
        alertbox.show();


    }

    /*@Override
    protected void onPause() {
        super.onPause();
        music1.stop();
        music2.stop();
        music3.stop();
        music4.stop();
        music5.stop();
        music6.stop();
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        music1.stop();
        music2.stop();
        music3.stop();
        music4.stop();
        music5.stop();
        music6.stop();
    }
}
