package cn.lucy.donghua;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;

public class QietuActivity extends Activity {
	AdapterViewFlipper avf;
	SeekBar sba;
	ImageView image4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qietu);
		avf = (AdapterViewFlipper) this.findViewById(R.id.avf);
		sba = (SeekBar) this.findViewById(R.id.sba);
		image4 = (ImageView) this.findViewById(R.id.image4);
		// 图片自动播放
		Adapter adapter = new ArrayAdapter<Integer>(this, 0, new Integer[] {
				R.drawable.girl_1, R.drawable.girl_2, R.drawable.girl_3,
				R.drawable.girl_4, }) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ImageView iv = new ImageView(QietuActivity.this);
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

				BitmapDrawable bms = (BitmapDrawable) QietuActivity.this
						.getResources().getDrawable(R.drawable.girl_1);
				Bitmap bm = bms.getBitmap();

				// Bitmap bm = BitmapFactory.decodeResource(
				// QietuActivity.this.getResources(), R.drawable.girl_1);
				
				
//				Bitmap source, int x, int y, int width, int height, Matrix m, boolean filter
				Matrix m = new Matrix();
				// 得到1个从0到2之间的数
				float kx = 1.0f * progress / seekBar.getMax()* 2;
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
		Animator a = AnimatorInflater.loadAnimator(this, R.animator.left_out);
		// 这个改变的是点击的那个ImageView
		a.setTarget(v);
		a.start();
	}

	public void shuxing2(View v) {
		// 属性动画
		Animator a = AnimatorInflater.loadAnimator(this, R.animator.fuza);
		// 这个改变的是点击的那个ImageView
		a.setTarget(v);
		a.start();
	}

}
