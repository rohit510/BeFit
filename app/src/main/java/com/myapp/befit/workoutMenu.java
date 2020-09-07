package com.myapp.befit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.myapp.befit.R;

public class workoutMenu extends AppCompatActivity {

    private ImageButton biceps;
    private ImageButton triceps;
    private ImageButton chest;
    private ImageButton back;
    private ImageButton legs;
    private ImageButton shoulder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_menu);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        biceps = (ImageButton) findViewById(R.id.bicepsButton);
        triceps = (ImageButton) findViewById(R.id.tricepsButton);
        chest = (ImageButton) findViewById(R.id.chestButton);
        back = (ImageButton) findViewById(R.id.backButton);
        legs = (ImageButton) findViewById(R.id.legsButton);
        shoulder = (ImageButton) findViewById(R.id.shoulderButton);

        biceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(workoutMenu.this, workoutList.class);

                intent.putExtra("wlist1","1.Barbell Curl");
                intent.putExtra("wlist2","2.Inclined Dumbbell Curl");
                intent.putExtra("wlist3","3.Hammer Curl");
                intent.putExtra("wlist4","4.Preacher Curl");
                intent.putExtra("wlist5","5.Concentration Curl");
                intent.putExtra("wpic1","biceps1");
                intent.putExtra("wpic2","biceps2");
                intent.putExtra("wpic3","biceps3");
                intent.putExtra("wpic4","biceps4");
                intent.putExtra("wpic5","biceps5");

                startActivity(intent);
            }
        });

        triceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(workoutMenu.this, workoutList.class);

                intent.putExtra("wlist1","1.Close grip Pushup");
                intent.putExtra("wlist2","2.Close grip Benchpress");
                intent.putExtra("wlist3","3.Skull Crusher");
                intent.putExtra("wlist4","4.Dumbbell Kickback");
                intent.putExtra("wlist5","5.Tension Pressdown");
                intent.putExtra("wpic1","triceps1");
                intent.putExtra("wpic2","triceps2");
                intent.putExtra("wpic3","triceps3");
                intent.putExtra("wpic4","triceps4");
                intent.putExtra("wpic5","triceps5");

                startActivity(intent);
            }
        });

        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(workoutMenu.this, workoutList.class);

                intent.putExtra("wlist1","1.Barbell Benchpress");
                intent.putExtra("wlist2","2.Inclined Dumbbell press");
                intent.putExtra("wlist3","3.Declined Dumbbell press");
                intent.putExtra("wlist4","4.Butterfly");
                intent.putExtra("wlist5","5.Cable fly");
                intent.putExtra("wpic1","chest1");
                intent.putExtra("wpic2","chest2");
                intent.putExtra("wpic3","chest3");
                intent.putExtra("wpic4","chest4");
                intent.putExtra("wpic5","chest5");

                startActivity(intent);
            }

        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(workoutMenu.this, workoutList.class);

                intent.putExtra("wlist1","1.Pull up");
                intent.putExtra("wlist2","2.Bent over Row");
                intent.putExtra("wlist3","3.Lat Pulldown");
                intent.putExtra("wlist4","4.Single arm Dumbbell Row");
                intent.putExtra("wlist5","5.Deadlift");
                intent.putExtra("wpic1","back1");
                intent.putExtra("wpic2","back2");
                intent.putExtra("wpic3","back3");
                intent.putExtra("wpic4","back4");
                intent.putExtra("wpic5","back5");

                startActivity(intent);
            }
        });

        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(workoutMenu.this, workoutList.class);

                intent.putExtra("wlist1","1.Barbell Squats");
                intent.putExtra("wlist2","2.Leg press");
                intent.putExtra("wlist3","3.Walking Lunges");
                intent.putExtra("wlist4","4.Leg Extension");
                intent.putExtra("wlist5","5.Calf raise");
                intent.putExtra("wpic1","legs1");
                intent.putExtra("wpic2","legs2");
                intent.putExtra("wpic3","legs3");
                intent.putExtra("wpic4","legs4");
                intent.putExtra("wpic5","legs5");

                startActivity(intent);
            }
        });

        shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(workoutMenu.this, workoutList.class);

                intent.putExtra("wlist1","1.Barbell overhead shoulder press");
                intent.putExtra("wlist2","2.Lateral raise");
                intent.putExtra("wlist3","3.Front raise");
                intent.putExtra("wlist4","4.Shoulder fly");
                intent.putExtra("wlist5","5.Dumbbell Shrugs");
                intent.putExtra("wpic1","shoulder1");
                intent.putExtra("wpic2","shoulder2");
                intent.putExtra("wpic3","shoulder3");
                intent.putExtra("wpic4","shoulder4");
                intent.putExtra("wpic5","shoulder5");

                startActivity(intent);
            }
        });

    }
}
