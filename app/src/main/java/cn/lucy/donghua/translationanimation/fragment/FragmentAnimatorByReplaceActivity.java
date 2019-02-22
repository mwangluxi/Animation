package cn.lucy.donghua.translationanimation.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import cn.lucy.donghua.R;

public class FragmentAnimatorByReplaceActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_animator);

        includeFragment();
    }

    public void includeFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_view, A1Fragment.newInstance())
                .commit();
    }


}
