package cn.lucy.animation.translationanimation.transition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.lucy.animation.R;

public class MDAnimationActivity extends AppCompatActivity {

    private ImageView view_image;
    private TextView tx_text;
    private View view_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdanimation);
        view_image = (ImageView) findViewById(R.id.view_shade_image);
        tx_text = (TextView) findViewById(R.id.view_text_111);
        view_name = findViewById(R.id.view_name);
    }

    public void startExplode(View view) {
        Intent intent = new Intent(this, ExplodeTransitionActivity.class);
        Bundle options = ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle();
        startActivity(intent, options);
    }

    public void startSlide(View view) {
        Intent intent = new Intent(this, SlideTransitionActivity.class);
        Bundle options = ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle();
        startActivity(intent, options);
    }

    public void startFade(View view) {
        Intent intent = new Intent(this, FadeTransitionActivity.class);
        Bundle options = ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle();
        startActivity(intent, options);
    }

    public void startShare(View view) {
        Intent intent = new Intent(this, ShadeTransitionActivity.class);
        Pair<View, String> pair1 = new Pair<View, String>(view_image, ViewCompat.getTransitionName(view_image));
        Pair<View, String> pair2 = new Pair<View, String>(tx_text, ViewCompat.getTransitionName(tx_text));
        Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pair1, pair2).toBundle();
        startActivity(intent, bundle);
    }


}
