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

import com.myapp.befit.R;

public class workoutStart extends AppCompatActivity {

    public int count;
    private ImageView workoutDisplay;
    private TextView workoutName;
    private TextView breakText;
    private TextView endText;
    private Chronometer chronometer;
    String wpic1,wpic2,wpic3,wpic4,wpic5,wl1,wl2,wl3,wl4,wl5;

    private MediaPlayer music1,music2,music3,music4,music5;

   //@android.support.annotation.RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_start);

        chronometer = (Chronometer) findViewById(R.id.chronometer);
        workoutDisplay = (ImageView) findViewById(R.id.workoutDisplay);
        workoutName = (TextView) findViewById(R.id.workoutName);
        breakText = (TextView) findViewById(R.id.breakText);
        endText = (TextView) findViewById(R.id.endText);

        music1 = new MediaPlayer();
        music2 = new MediaPlayer();
        music3 = new MediaPlayer();
        music4 = new MediaPlayer();
        music5 = new MediaPlayer();

        music1 = MediaPlayer.create(getApplicationContext(),R.raw.music1);
        music2 = MediaPlayer.create(getApplicationContext(),R.raw.music2);
        music3 = MediaPlayer.create(getApplicationContext(),R.raw.music3);
        music4 = MediaPlayer.create(getApplicationContext(),R.raw.music4);
        music5 = MediaPlayer.create(getApplicationContext(),R.raw.music5);

        Bundle extras = getIntent().getExtras();

        wl1 = extras.getString("wl1");
        wl2 = extras.getString("wl2");
        wl3 = extras.getString("wl3");
        wl4 = extras.getString("wl4");
        wl5 = extras.getString("wl5");
        wpic1 = extras.getString("wpic1");
        wpic2 = extras.getString("wpic2");
        wpic3 = extras.getString("wpic3");
        wpic4 = extras.getString("wpic4");
        wpic5 = extras.getString("wpic5");

        endText.setVisibility(View.INVISIBLE);
        chronometer.start();
        music1.start();

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                count = (int) (SystemClock.elapsedRealtime() - chronometer.getBase())/1000;

                if(count<=120){
                    breakText.setVisibility(View.INVISIBLE);
                    workoutName.setText(wl1);
                    workoutDisplay.setImageResource(getResources().getIdentifier(wpic1,"drawable",getPackageName()));
                }
                else if(count>=121 && count<=180){
                    breakText.setVisibility(View.VISIBLE);
                    chronometer.setTextColor(Color.RED);
                    workoutName.setVisibility(View.INVISIBLE);
                    workoutDisplay.setVisibility(View.INVISIBLE);
                    music1.stop();
                }
                else if(count>=181 && count<=300){
                    breakText.setVisibility(View.INVISIBLE);
                    chronometer.setTextColor(Color.parseColor("#ff0099cc"));
                    music2.start();
                    workoutName.setVisibility(View.VISIBLE);
                    workoutDisplay.setVisibility(View.VISIBLE);
                    workoutName.setText(wl2);
                    workoutDisplay.setImageResource(getResources().getIdentifier(wpic2,"drawable",getPackageName()));
                }
                else if(count>=301 && count<=360){
                    breakText.setVisibility(View.VISIBLE);
                    chronometer.setTextColor(Color.RED);
                    workoutName.setVisibility(View.INVISIBLE);
                    workoutDisplay.setVisibility(View.INVISIBLE);
                    music2.stop();
                }
                else if(count>=361 && count<=480){
                    breakText.setVisibility(View.INVISIBLE);
                    chronometer.setTextColor(Color.parseColor("#ff0099cc"));
                    music3.start();
                    workoutName.setVisibility(View.VISIBLE);
                    workoutDisplay.setVisibility(View.VISIBLE);
                    workoutName.setText(wl3);
                    workoutDisplay.setImageResource(getResources().getIdentifier(wpic3,"drawable",getPackageName()));
                }
                else if(count>=481 && count<=540){
                    breakText.setVisibility(View.VISIBLE);
                    chronometer.setTextColor(Color.RED);
                    workoutName.setVisibility(View.INVISIBLE);
                    workoutDisplay.setVisibility(View.INVISIBLE);
                    music3.stop();
                }
                else if(count>=541 && count<=660){
                    breakText.setVisibility(View.INVISIBLE);
                    chronometer.setTextColor(Color.parseColor("#ff0099cc"));
                    music4.start();
                    workoutName.setVisibility(View.VISIBLE);
                    workoutDisplay.setVisibility(View.VISIBLE);
                    workoutName.setText(wl4);
                    workoutDisplay.setImageResource(getResources().getIdentifier(wpic4,"drawable",getPackageName()));
                }
                else if(count>=661 && count<=720){
                    breakText.setVisibility(View.VISIBLE);
                    chronometer.setTextColor(Color.RED);
                    workoutName.setVisibility(View.INVISIBLE);
                    workoutDisplay.setVisibility(View.INVISIBLE);
                    music4.stop();
                }
                else if(count>=721 && count<840){
                    breakText.setVisibility(View.INVISIBLE);
                    chronometer.setTextColor(Color.parseColor("#ff0099cc"));
                    music5.start();
                    workoutName.setVisibility(View.VISIBLE);
                    workoutDisplay.setVisibility(View.VISIBLE);
                    workoutName.setText(wl5);
                    workoutDisplay.setImageResource(getResources().getIdentifier(wpic5,"drawable",getPackageName()));
                }
                else if(count==840) {
                    endText.setVisibility(View.VISIBLE);
                    workoutName.setVisibility(View.INVISIBLE);
                    workoutDisplay.setVisibility(View.INVISIBLE);
                    chronometer.setTextColor(Color.RED);
                    chronometer.stop();
                    music5.stop();
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(workoutStart.this);
        alert.setMessage("Do you want to end the workout?");
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

   /* @Override
    protected void onPause() {
        super.onPause();
        music1.stop();
        music2.stop();
        music3.stop();
        music4.stop();
        music5.stop();
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        music1.stop();
        music2.stop();
        music3.stop();
        music4.stop();
        music5.stop();
    }
}
