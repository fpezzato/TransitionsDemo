package org.fpezzato.transitionsdemo._01_contentTransition;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import org.fpezzato.transitionsdemo.R;

public class Activity_01_content_transition_main extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01_content_transition_main);

        final ViewGroup root = (ViewGroup) findViewById(R.id.root);
        final View view01 = findViewById(R.id.view01);
        final View view02 = findViewById(R.id.view02);
        final View view03 = findViewById(R.id.view03);

        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    execute(root, view01, view02, view03);
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) //KITKAT is supported.
    private void execute(ViewGroup root, View view01, View view02, View view03) {

        TransitionManager.beginDelayedTransition(root, new Fade()); //Fade, Explode..
        view01.setVisibility(View.GONE);
        view02.setVisibility(View.GONE);
        view03.setVisibility(View.GONE);
    }
}
