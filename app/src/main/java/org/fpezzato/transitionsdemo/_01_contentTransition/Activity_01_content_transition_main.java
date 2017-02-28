package org.fpezzato.transitionsdemo._01_contentTransition;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import org.fpezzato.transitionsdemo.R;

public class Activity_01_content_transition_main extends AppCompatActivity {


    private View view01;
    private View view02;
    private View view03;
    private ViewGroup root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01_content_transition_main);

        root = (ViewGroup) findViewById(R.id.root);
        view01 = findViewById(R.id.view01);
        view02 = findViewById(R.id.view02);
        view03 = findViewById(R.id.view03);

        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    execute(new Fade());
                }
            }
        });
        findViewById(R.id.go2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    execute(new Slide());
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) //KITKAT is supported.
    private void execute(Transition transition) {

        TransitionManager.beginDelayedTransition(root, new Fade());
        view01.setVisibility(View.GONE);
        view02.setVisibility(View.GONE);
        view03.setVisibility(View.GONE);
    }
}
