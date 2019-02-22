package cn.lucy.animation.translationanimation.transition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;

import cn.lucy.animation.R;


public class ExplodeTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Explode explode = new Explode();

//        explode.setMode(MODE_IN);

        explode.setDuration(5000);
        getWindow().setEnterTransition(explode);
        getWindow().setExitTransition(explode);

        setContentView(R.layout.activity_mdtarge);
    }

}
