package cn.lucy.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class TweenAnimation extends AppCompatActivity {
    private ImageView mTw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);


        mTw = (ImageView) findViewById(R.id.tw);
    }

    public void bujian(View v) {
        // 补间动画
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.bujian);
        v.startAnimation(animation);

//		Animation animati = AnimationUtils.loadAnimation(this,
//				R.anim.bujian_jia_jian);
//		iv2.startAnimation(animati);
    }


    public void Back(View view) {
        ////////////////////////////////平移//////////////////////////////////
//        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.tran1); // R.anim.tran1是我们定义号的动画 xml
//        mTw.startAnimation(animation1); // imageTest是要显示动画的 view

//        TranslateAnimation translateAnimation = new TranslateAnimation(0, 100, 0, 100);
//        translateAnimation.setDuration(1000);
//        translateAnimation.setRepeatMode(TranslateAnimation.REVERSE);
//        translateAnimation.setRepeatCount(1);
//        mTw.startAnimation(translateAnimation);

        ////////////////////////////////缩放动画//////////////////////////////////

//        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.scale1);
//        mTw.startAnimation(animation1); // imageTest是要显示动画的 view


        ////////////////////////////////旋转动画//////////////////////////////////

//        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.rotate1);
//        mTw.startAnimation(animation1); // imageTest是要显示动画的 view

        ////////////////////////////////透明度动画//////////////////////////////////
//        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.alpha1);
//        mTw.startAnimation(animation1); // imageTest是要显示动画的 view


        ////////////////////////////////set动画//////////////////////////////////
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.bujian);
        mTw.startAnimation(animation1); // imageTest是要显示动画的 view


        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
