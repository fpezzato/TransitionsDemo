package org.fpezzato.transitionsdemo._03_shared_enter_transition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.fpezzato.transitionsdemo.R;

public class Activity_03_shared_enter_dest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_03_shared_enter_dest);

        printHash();
    }

    private void printHash() {
        TextView orangeView = (TextView) findViewById(R.id._03_shared_element_01);
        orangeView.setText("#"+orangeView.hashCode());
    }
}
