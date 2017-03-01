package org.fpezzato.transitionsdemo._04_custom_shared_enter_transition;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;

import org.fpezzato.transitionsdemo.R;

import java.util.List;

import static org.fpezzato.transitionsdemo._04_custom_shared_enter_transition.Activity_04_custom_shared_enter_main.CUSTOM_BACKGROUND_COLOR;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class Activity_04_custom_shared_enter_dest extends AppCompatActivity {

    private View sharedTransView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_04_custom_shared_enter_dest);
        sharedTransView = findViewById(R.id.blueView);

        getWindow().setSharedElementEnterTransition(myTransition());
        setEnterSharedElementCallback(new SharedElementCallback() {

            @Override
            public void onSharedElementStart(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
                View view = sharedElements.get(0);
                int intExtra = getIntent().getIntExtra(CUSTOM_BACKGROUND_COLOR, 0);
                view.setBackground(new ColorDrawable(intExtra));
            }

            @Override
            public void onSharedElementEnd(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
                View view = sharedElements.get(0);
                //using setBackgroundColor returns the same instance of backgound in the transition createAnimator
                //So need to set it manually.
                int endColor = ContextCompat.getColor(Activity_04_custom_shared_enter_dest.this, R.color.colorAccent);
                ColorDrawable color2 = new ColorDrawable(endColor);

                view.setBackground(color2);
            }
        });
    }


    private Transition myTransition() {
        TransitionSet set = new TransitionSet();
        set.setOrdering(TransitionSet.ORDERING_TOGETHER);
        set.setDuration(2000);

        Transition changeBounds = new ChangeBounds();
        //changeBounds.addTarget(R.id.qwerty);
        changeBounds.addTarget(sharedTransView.getTransitionName());
        set.addTransition(changeBounds);

        //1 - Recolor is in the platform.
        Transition recolor = new Recolor();
        recolor.addTarget(sharedTransView.getTransitionName());
        set.addTransition(recolor);


        return set;
    }
}
