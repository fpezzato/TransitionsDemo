package org.fpezzato.transitionsdemo._04_custom_shared_enter_transition;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.fpezzato.transitionsdemo.R;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class Activity_04_custom_shared_enter_main extends AppCompatActivity {
    public static final String CUSTOM_BACKGROUND_COLOR = "CUSTOM_BACKGROUND_COLOR";

    private View sharedTransView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_04_custom_shared_enter_main);

        sharedTransView = findViewById(R.id._04_shared_element_01);
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

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressWarnings("unchecked")
    private void goToDetails() {
        Intent intent = new Intent(this, Activity_04_custom_shared_enter_dest.class);

        Pair<View, String> orangePair = new Pair<View, String>(sharedTransView, sharedTransView.getTransitionName());

        intent.putExtra(CUSTOM_BACKGROUND_COLOR, ((ColorDrawable) sharedTransView.getBackground()).getColor());

        ActivityCompat.startActivity(this, intent,
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        orangePair).toBundle());

    }


}
