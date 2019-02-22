package cn.lucy.animation.translationanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.lucy.animation.R;
import cn.lucy.animation.translationanimation.fragment.FragmentAnimatorByReplaceActivity;
import cn.lucy.animation.translationanimation.fragment.FragmentAnimatorByShowHintActivity;
import cn.lucy.animation.translationanimation.transition.MDAnimationActivity;


public class TranslationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);
    }

    public void startTweenTransitionAnimationAtivity(View view) {
        Intent intent = new Intent(this, TweenAnimationActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.translate_top_in, R.anim.translate_buttom_out);
    }

    public void startMDTransitionAnimationAtivity(View view) {
        Intent intent = new Intent(this, MDAnimationActivity.class);
        startActivity(intent);
    }

    public void startFragmentByReplaceAnimationAtivity(View view) {
        Intent intent = new Intent(this, FragmentAnimatorByReplaceActivity.class);
        startActivity(intent);
    }

    public void startFragmentByShowHintAnimationAtivity(View view) {
        Intent intent = new Intent(this, FragmentAnimatorByShowHintActivity.class);
        startActivity(intent);
    }

}
