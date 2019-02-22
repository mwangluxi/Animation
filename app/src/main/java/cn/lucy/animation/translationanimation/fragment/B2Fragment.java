package cn.lucy.animation.translationanimation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.lucy.animation.R;


public class B2Fragment extends Fragment {

    private View mRootView;
    private Button btn_back;

    public B2Fragment() {

    }

    public static B2Fragment newInstance() {
        return new B2Fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Slide slide = new Slide(Gravity.LEFT);
        Explode explode = new Explode();

        setEnterTransition(slide);
        setExitTransition(slide);
//        setReenterTransition( explode );
//        setReturnTransition( explode );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_b_animator, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_back = (Button) mRootView.findViewById(R.id.view_button);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void goBack() {
        IFragmentShowControl control = (IFragmentShowControl) getActivity();
        control.showFragmentByTag(IFragmentShowControl.A);
    }

}
