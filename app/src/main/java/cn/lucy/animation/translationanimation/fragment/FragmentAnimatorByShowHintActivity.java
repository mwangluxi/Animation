package cn.lucy.animation.translationanimation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import cn.lucy.animation.R;

public class FragmentAnimatorByShowHintActivity extends AppCompatActivity implements IFragmentShowControl {

    private Fragment a;
    private Fragment b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_animator);

        includeFragment();
    }

    public void includeFragment() {
        a = A2Fragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.root_view, a, IFragmentShowControl.A)
                .commit();
    }

    @Override
    public void showFragmentByTag(String tag) {

        if (IFragmentShowControl.A.equals(tag)) {
            if (isAdd(tag)) {
                hintFragmentByTag(IFragmentShowControl.B)
                        .show(a)
                        .setTransition(android.R.transition.explode)
                        .commit();
                Log.d( "AAA","show_a" );
            } else {
                a = A2Fragment.newInstance();
                hintFragmentByTag(IFragmentShowControl.B)
                        .add(R.id.root_view, a, IFragmentShowControl.A)
                        .commit();
                Log.d( "AAA","add_a" );
            }
            return;
        }

        if (IFragmentShowControl.B.equals(tag)) {
            if (isAdd(tag)) {
                hintFragmentByTag(IFragmentShowControl.A)
                        .show(b)
                        .setTransition(android.R.transition.explode)
                        .commit();
                Log.d( "AAA","show_b" );
            } else {
                b = B2Fragment.newInstance();
                hintFragmentByTag(IFragmentShowControl.A)
                        .add(R.id.root_view, b, IFragmentShowControl.B)
                        .commit();
                Log.d( "AAA","add_b" );
            }
            return;
        }
    }

    private boolean isAdd(String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag) == null ? false : true;
    }

    private FragmentTransaction hintFragmentByTag(String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (IFragmentShowControl.A.equals(tag)) {
            fragmentTransaction.hide(a);
            return fragmentTransaction;
        }

        if (IFragmentShowControl.B.equals(tag)) {
            fragmentTransaction.hide(b);
            return fragmentTransaction;
        }

        return null;
    }
}
