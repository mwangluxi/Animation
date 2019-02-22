package cn.lucy.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Adapter;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class PropertyActivity extends AppCompatActivity {
    AdapterViewFlipper avf;
    SeekBar sba;
    ImageView image, image4;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qietu);
        avf = (AdapterViewFlipper) this.findViewById(R.id.avf);
        sba = (SeekBar) this.findViewById(R.id.sba);
        image4 = (ImageView) this.findViewById(R.id.image4);
        image = (ImageView) this.findViewById(R.id.image);
        tv = (TextView) this.findViewById(R.id.tv);
        // 图片自动播放
        Adapter adapter = new ArrayAdapter<Integer>(this, 0, new Integer[]{
                R.drawable.girl_1, R.drawable.girl_2, R.drawable.girl_3,
                R.drawable.girl_4,}) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView iv = new ImageView(PropertyActivity.this);
                iv.setImageResource(this.getItem(position));
                return iv;
            }
        };
        avf.setAdapter(adapter);
        // avf.setTranslationX(translationX);
        // avf.setAlpha(alpha);
        // avf.setScaleX(scaleX);/
        // avf.setRotation(rotation);

        sba.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

                BitmapDrawable bms = (BitmapDrawable) PropertyActivity.this
                        .getResources().getDrawable(R.drawable.girl_1);
                Bitmap bm = bms.getBitmap();

                // Bitmap bm = BitmapFactory.decodeResource(
                // PropertyActivity.this.getResources(), R.drawable.girl_1);


//				Bitmap source, int x, int y, int width, int height, Matrix m, boolean filter
                Matrix m = new Matrix();
                // 得到1个从0到2之间的数
                float kx = 1.0f * progress / seekBar.getMax() * 2;
                // 倾斜
                m.setSkew(kx, 0);
//				true  false 无区别
                boolean filter = true;
                Bitmap nbm = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(),
                        bm.getHeight(), m, filter);
                // 显示
                image4.setImageBitmap(nbm);

            }
        });
    }

    public void shuxing(View v) {
        // 属性动画
        Animator a = AnimatorInflater.loadAnimator(this, R.animator.left_out); //fuza   right_in
        // 这个改变的是点击的那个ImageView
        a.setTarget(image);
        a.start();

    }


    public void translationX(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(image, "translationX", 0, 300, 200, 600);
        animator.setDuration(2000);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.setRepeatCount(1);
        animator.start();
    }

    public void rotation(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(image, "rotation", 0, 3600);
        animator.setDuration(2000);
        animator.start();
    }

    public void backgroundColor(View view) {
        int[] values = {Color.parseColor("#FF4081"), Color.parseColor("#3F51B5")};
        ObjectAnimator animator = ObjectAnimator.ofInt(view, "backgroundColor", values);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setDuration(500);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.setRepeatCount(1);
        animator.start();
    }

    int count = 0;

    public void ValueAnimator(View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 10);
        valueAnimator.setDuration(10000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                count++;
                // 当前的数值
                int animatedValue = (int) valueAnimator.getAnimatedValue();
                // 当前动画的进度
                float animatedFraction = valueAnimator.getAnimatedFraction();
                tv.setText(String.valueOf(animatedValue));

                Log.d("test", "属性动画第:" + count + "次执行," + "线程：" + Thread.currentThread().getName() + "，currentAnimatedValue:" + animatedValue + ",animatedFraction:" + animatedFraction);
            }
        });
        valueAnimator.start();
    }

    public void togetherRun(View view) {
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(image, "scaleX", 1.0f, 2f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(image, "scaleY", 1.0f, 2f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(2000);
        animSet.setInterpolator(new LinearInterpolator());
        //两个动画同时执行
        animSet.playTogether(anim1, anim2);
        animSet.start();
    }

    public void playWithAfter(View view) {
        float cx = image.getX();

        ObjectAnimator anim1 = ObjectAnimator.ofFloat(image, "scaleX", 1.0f, 2f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(image, "scaleY", 1.0f, 2f);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(image, "x", cx, 0f);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(image, "x", cx);

        /**
         * anim1，anim2,anim3同时执行
         * anim4接着执行
         */
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim1).with(anim2);
        animSet.play(anim2).with(anim3);
        animSet.play(anim4).after(anim3);
        animSet.setDuration(1000);
        animSet.start();
    }

    float temX, temY;

    public void path(View view) {

        image.post(new Runnable() {
            @Override
            public void run() {
                // 获取view 的初始位置
                temX = image.getX();
                temY = image.getY();
            }
        });

        Path path = new Path();
        path.moveTo(temX, temY);
        path.lineTo(temX + 300, temY + 300);

        ObjectAnimator animator = ObjectAnimator.ofFloat(image, View.X, View.Y, path);
        animator.setDuration(500);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.setRepeatCount(1);


        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                toast("动画开始");
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                toast("动画结束");
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                toast("动画取消");
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                toast("动画重建");
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
        animator.start();

    }

    private void toast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
