package cn.lucy.animation.translationanimation.transition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.lucy.animation.R;


public class ShadeTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

//        TransitionSet set = new TransitionSet();
//        set.addTransition(new ChangeImageTransform());
//        set.addTransition(new ChangeBounds());
//        getWindow().setSharedElementEnterTransition(set);
        setContentView(R.layout.activity_mdtarge_bak);
    }
}
