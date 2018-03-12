package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mylibrary.MainActivityLib;

/**
 * http://blog.csdn.net/guiying712/article/details/55213884#1为什么要项目组件化
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=findViewById(R.id.tv);
        textView.setText(getText(R.string.lib_str1));
    }

    public void test(View view){
        Intent intent=new Intent(this, MainActivityLib.class);
        startActivity(intent);
    }
}
