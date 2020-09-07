package com.myapp.befit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class workoutList extends AppCompatActivity {

    private TextView wlist1;
    private TextView wlist2;
    private TextView wlist3;
    private TextView wlist4;
    private TextView wlist5;
    private TextView workoutEx;
    private Button startWorkout;
    String wpic1,wpic2,wpic3,wpic4,wpic5,wl1,wl2,wl3,wl4,wl5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        wlist1 = (TextView) findViewById(R.id.wlist1);
        wlist2 = (TextView) findViewById(R.id.wlist2);
        wlist3 = (TextView) findViewById(R.id.wlist3);
        wlist4 = (TextView) findViewById(R.id.wlist4);
        wlist5 = (TextView) findViewById(R.id.wlist5);
        startWorkout = (Button) findViewById(R.id.startCardio);
        workoutEx = (TextView) findViewById(R.id.workoutExercises);

        Bundle extras = getIntent().getExtras();

        wl1 = extras.getString("wlist1");
        wl2 = extras.getString("wlist2");
        wl3 = extras.getString("wlist3");
        wl4 = extras.getString("wlist4");
        wl5 = extras.getString("wlist5");
        wpic1 = extras.getString("wpic1");
        wpic2 = extras.getString("wpic2");
        wpic3 = extras.getString("wpic3");
        wpic4 = extras.getString("wpic4");
        wpic5 = extras.getString("wpic5");

        wlist1.setText(wl1);
        wlist2.setText(wl2);
        wlist3.setText(wl3);
        wlist4.setText(wl4);
        wlist5.setText(wl5);


        startWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(workoutList.this, workoutStart.class);

                intent.putExtra("wl1",wl1);
                intent.putExtra("wl2",wl2);
                intent.putExtra("wl3",wl3);
                intent.putExtra("wl4",wl4);
                intent.putExtra("wl5",wl5);

                intent.putExtra("wpic1",wpic1);
                intent.putExtra("wpic2",wpic2);
                intent.putExtra("wpic3",wpic3);
                intent.putExtra("wpic4",wpic4);
                intent.putExtra("wpic5",wpic5);

                startActivity(intent);
            }
        });


    }
}
