package cn.lucy.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Interpolator extends AppCompatActivity {
    private ImageView mTw;//修改完了

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);


        mTw = (ImageView) findViewById(R.id.tw);
    }


    public void Back(View view) {
        ////////////////////////////////平移//////////////////////////////////
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.rotate1); // R.anim.tran1是我们定义号的动画 xml
        mTw.startAnimation(animation1); // imageTest是要显示动画的 view

//        TranslateAnimation translateAnimation = new TranslateAnimation(0, 100, 0, 100);
//        translateAnimation.setDuration(1000);
//        translateAnimation.setRepeatMode(TranslateAnimation.REVERSE);
//        translateAnimation.setRepeatCount(1);
//        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
//        mTw.startAnimation(translateAnimation);
//

    }
}
