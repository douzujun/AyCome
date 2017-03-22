package com.example.aycomev322;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        android.view.View.OnClickListener{

    private Fragment[] fragments;//Fragment数组
    private ImageView[] imagebuttons;//tag图标
    private TextView[] textviews;//tag文字
    private int index;//tag编号
    private int currentTabIndex;// 当前fragment的index

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    //初始化函数
    private void initView() {

        imagebuttons = new ImageView[4];
        imagebuttons[0] = (ImageView) findViewById(R.id.im_home);
        imagebuttons[1] = (ImageView) findViewById(R.id.im_order);
        imagebuttons[2] = (ImageView) findViewById(R.id.im_life);
        imagebuttons[3] = (ImageView) findViewById(R.id.im_me);

        imagebuttons[0].setSelected(true);
        textviews = new TextView[4];
        textviews[0] = (TextView) findViewById(R.id.te_home);
        textviews[1] = (TextView) findViewById(R.id.te_order);
        textviews[2] = (TextView) findViewById(R.id.te_life);
        textviews[3] = (TextView) findViewById(R.id.te_me);
        textviews[0].setTextColor(0xFF45C01A);
        // 添加显示第一个fragment
    }



    //底部tag单击事件
    public void onTabClicked(View view) {
        switch (view.getId()) {
            case R.id.re_home:
                index = 0;
                break;
            case R.id.re_order:
                index = 1;
                break;
            case R.id.re_life:
                index = 2;
                break;
            case R.id.re_me:
                index = 3;
                break;

        }

//        if (currentTabIndex != index) {
//            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
//            trx.hide(fragments[currentTabIndex]);
//            if (!fragments[index].isAdded()) {
//                trx.add(R.id.fragment_container, fragments[index]);
//            }
//            trx.show(fragments[index]).commit();
//        }
        imagebuttons[currentTabIndex].setSelected(false);
        // 把当前tab设为选中状态
        imagebuttons[index].setSelected(true);
        textviews[currentTabIndex].setTextColor(0xFF999999);
        textviews[index].setTextColor(0xFF45C01A);
        currentTabIndex = index;
    }

    @Override
    public void onClick(View view) {
        onTabClicked(view);
    }
}
