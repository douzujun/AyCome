package com.example.aycomev322.Me;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aycomev322.R;

public class Activity_register extends AppCompatActivity implements View.OnClickListener{

    ImageButton imageButton_return;
    TextView textView_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        imageButton_return = (ImageButton)findViewById(R.id.img_btn_arrow_left);
        textView_register = (TextView)findViewById(R.id.icon_register);
        imageButton_return.setOnClickListener(this);
        textView_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.img_btn_arrow_left:
                finish();
                break;
            case R.id.icon_register:
                Toast.makeText(this,"You clicked register",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
