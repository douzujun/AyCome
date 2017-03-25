package com.example.aycomev322.Me;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aycomev322.R;

/**
 * Created by quan on 2017/3/22.
 */

public class FragmentMe extends Fragment implements View.OnClickListener{

    TextView icon_my_name;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me,null);
        //数据初始化
        icon_my_name = (TextView)view.findViewById(R.id.my_name);
        icon_my_name.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.my_name:
                Intent intent = new Intent(getContext(),Activity_register.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
