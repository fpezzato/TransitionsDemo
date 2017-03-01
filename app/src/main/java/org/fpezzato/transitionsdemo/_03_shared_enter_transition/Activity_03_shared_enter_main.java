package org.fpezzato.transitionsdemo._03_shared_enter_transition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.fpezzato.transitionsdemo.R;

public class Activity_03_shared_enter_main extends AppCompatActivity {

    private TextView orangeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_03_shared_enter_main);

        printhash();

        setuponClick();
    }

    private void setuponClick() {
        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetails();
            }
        });
    }

    private void printhash() {
        orangeView = (TextView) findViewById(R.id._03_shared_element_01);
        orangeView.setText("#" + orangeView.hashCode());
    }

    @SuppressWarnings("unchecked")
    private void goToDetails() {
        Intent intent = new Intent(this, Activity_03_shared_enter_dest.class);

        Pair<View, String> orangePair = new Pair<View, String>(orangeView, getResources().getString(R.string._03_target_name_ORANGE));

        ActivityCompat.startActivity(this, intent,
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        orangePair).toBundle());


    }
}
