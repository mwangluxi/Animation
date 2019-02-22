package cn.lucy.donghua.translationanimation.transition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;

import cn.lucy.donghua.R;


public class FadeTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fade fade = new Fade();
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        setContentView(R.layout.activity_mdtarge_bak);
    }
}
