package cn.lucy.donghua.translationanimation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.lucy.donghua.R;


public class A1Fragment extends Fragment {

    private View mRootView;
    private Button btn_back;

    public A1Fragment() {

    }

    public static A1Fragment newInstance() {
        return new A1Fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_a_animator, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_back = (Button) mRootView.findViewById(R.id.view_button);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextfragment();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void nextfragment() {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.translate_buttom_in, R.anim.translate_top_out, R.anim.translate_top_in, R.anim.translate_buttom_out)
                .replace(R.id.root_view, B1Fragment.newInstance())
                .addToBackStack("AA")
                .commit();
    }

}
