package com.wjjzst.livedatatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewModelWithLiveData viewModelWithLiveData;
    private TextView textView;
    private ImageButton imageButtonLike, imageButtonDislike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        imageButtonLike = findViewById(R.id.imageButton1);
        imageButtonDislike = findViewById(R.id.imageButton2);
        viewModelWithLiveData = ViewModelProviders.of(this).get(ViewModelWithLiveData.class);
        // 给值添加一个观察方法
        // 第一个参数this
        viewModelWithLiveData.getLikedNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(integer));
            }
        });
        imageButtonLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelWithLiveData.addLikedNumber(1);
            }
        });
        imageButtonDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelWithLiveData.addLikedNumber(-1);
            }
        });
    }
}
