package cn.lucy.donghua;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import cn.lucy.donghua.translationanimation.TranslationActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void FrameAnimation(View view) {
        start(FrameAnimation.class);
    }


    public void TweenAnimation(View view) {
        start(TweenAnimation.class);
    }

    private void start(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    public void interpolator(View view) {
        start(Interpolator.class);
    }

    public void Property(View view) {
        start(PropertyActivity.class);
    }

    public void Ripple(View view) {
        start(RippleActivity.class);
    }

    public void TranslationAnimation(View view) {
        start(TranslationActivity.class);
    }
}
