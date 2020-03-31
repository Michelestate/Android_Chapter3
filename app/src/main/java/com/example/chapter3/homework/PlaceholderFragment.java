package com.example.chapter3.homework;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PlaceholderFragment extends Fragment {

    private static String TAG = "placeholder";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件

//        Log.d(TAG,"已进入onCreateView函数");
//        getActivity().findViewById(R.id.animation_view1).setAlpha(1f);
//        getActivity().findViewById(R.id.list_view1).setAlpha(0f);
//        Log.d(TAG,"即将退出onCreateView函数");
        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Objects.requireNonNull(getView()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                String[] friendsArray = { "  Item 1","  Item 2","  Item 3","  Item 4","  Item 5","  Item 6","  Item 7"};
                List<String> friendsList = new ArrayList<String>(Arrays.asList(friendsArray));
                ArrayAdapter<String> friendsAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        R.layout.list_item_friends,
                        R.id.list_item_friends_tv,
                        friendsList);
                ListView list_friends = getActivity().findViewById(R.id.list_view1);
                list_friends.setAdapter(friendsAdapter);
                Objects.requireNonNull(getActivity()).findViewById(R.id.animation_view1).setAlpha(0f);
//                getActivity().findViewById(R.id.list_view1).setAlpha(1f);
//                list_friends.setAlpha(1f);
            }
        }, 5000);
    }
}
