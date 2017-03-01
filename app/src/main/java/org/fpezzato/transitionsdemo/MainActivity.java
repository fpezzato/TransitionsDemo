package org.fpezzato.transitionsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.fpezzato.transitionsdemo._01_contentTransition.Activity_01_content_transition_main;
import org.fpezzato.transitionsdemo._02_enter_transition.Activity_02_activity_transition;
import org.fpezzato.transitionsdemo._03_shared_enter_transition.Activity_03_shared_enter_main;
import org.fpezzato.transitionsdemo._04_custom_shared_enter_transition.Activity_04_custom_shared_enter_main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.try_content_transition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(Activity_01_content_transition_main.class);
            }
        });

        findViewById(R.id.try_enter_transition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_02_activity_transition.class);

                //noinspection unchecked
                ActivityCompat.startActivity(MainActivity.this, intent,
                        ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });

        findViewById(R.id.try_shared_element_enter_transition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(Activity_03_shared_enter_main.class);
            }
        });

        findViewById(R.id.try_custom_shared_element_enter_transition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(Activity_04_custom_shared_enter_main.class);
            }
        });
    }

    private void open(Class<? extends AppCompatActivity> dest) {
        Intent intent = new Intent(this, dest);
        startActivity(intent);
    }
}