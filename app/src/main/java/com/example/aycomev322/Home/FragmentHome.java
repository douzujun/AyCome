package com.example.aycomev322.Home;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aycomev322.R;

import java.util.ArrayList;

/**
 * Created by quan on 2017/3/22.
 */

public class FragmentHome extends Fragment implements ViewPager.OnPageChangeListener{

    private LinearLayout linearLayout;//存放小白点
    private ViewPager viewPager;//获取viewPager
    private TextView textView;//获取文本描述的TextView
    private int[] imageResIds;//保存图片资源ID数组
    private String[] imageText;//图片描述数组
    ViewPagerAdapter viewpagerAdapter = new ViewPagerAdapter();
    private boolean isRunning = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,null);

        //初始化视图
        viewPager = (ViewPager)view.findViewById(R.id.viewpager);
        textView = (TextView)view.findViewById(R.id.home_image_desc);
        viewPager.setOnPageChangeListener((ViewPager.OnPageChangeListener) this);
        linearLayout = (LinearLayout) view.findViewById(R.id.home_point_container);
        //初始化数据
        initData();
        //初始化适配器
        initAdapter();
        // 开启轮询
        new Thread(){
            public void run() {
                isRunning = true;
                while(isRunning){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 往下跳一位
                    Activity activity = (Activity)getContext();
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                        }
                    });
                }
            };
        }.start();
        return view;
    }

    @Override
    public void onDestroyView() {
        isRunning = false;
        super.onDestroyView();
    }

    private void initData() {

        // 图片资源id数组
        imageResIds = new int[]{R.drawable.home_viewpager_image1, R.drawable.home_viewpager_image2,
                R.drawable.home_viewpager_image3, R.drawable.home_viewpager_image4, R.drawable.home_viewpager_image5};
        // 文本描述
        imageText = new String[]{
                "专业级厨房卫生打扫",
                "打造完美家居",
                "创造温馨室内环境",
                "给您一个舒适安逸的家",
                "热爱生活"
        };

        // 初始化要展示的5个ImageView
        viewpagerAdapter.imageViewList = new ArrayList<ImageView>();

        ImageView imageView;
        View pointView;
        LinearLayout.LayoutParams layoutParams;
        for (int i = 0; i < imageResIds.length; i++) {
            // 初始化要显示的图片对象
            imageView = new ImageView(getContext());
            imageView.setBackgroundResource(imageResIds[i]);
            viewpagerAdapter.imageViewList.add(imageView);

            // 加小白点, 指示器
            pointView = new View(getContext());
            pointView.setBackgroundResource(R.drawable.pointer_selector);
            layoutParams = new LinearLayout.LayoutParams(15, 15);
            if(i != 0)
                layoutParams.leftMargin = 20;
            // 设置默认所有都不可用
            pointView.setEnabled(false);
            linearLayout.addView(pointView,layoutParams);
        }

    }

    private void initAdapter() {
        //将第一张图片的状态设置为true
        linearLayout.getChildAt(0).setEnabled(true);
        textView.setText(imageText[0]);
        // 设置适配器
        viewPager.setAdapter(viewpagerAdapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //滚动时调用
    }

    @Override
    public void onPageSelected(int position) {
        //新条目被选中时调用
        int newPosition = position % viewpagerAdapter.imageViewList.size();
        textView.setText(imageText[newPosition]);
        for(int i=0;i<5;i++){
            if(i==newPosition){
                linearLayout.getChildAt(i).setEnabled(true);
            }else{
                linearLayout.getChildAt(i).setEnabled(false);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //滚动状态变化时调用
    }
}
