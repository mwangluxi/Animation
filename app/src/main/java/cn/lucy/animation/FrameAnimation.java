package cn.lucy.donghua;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

//帧动画
public class FrameAnimation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        ImageView  image = (ImageView) this.findViewById(R.id.image);

        // 逐帧动画
        Drawable dr = image.getDrawable();
        AnimationDrawable ad = (AnimationDrawable) dr;
        ad.start();
    }
}
