package com.example.liuzhouliang.demo8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.liuzhouliang.demo3.BuildConfig;
import com.example.liuzhouliang.demo3.R;

/**
 * Android Studio中默认会使用 Gradle Wrapper 而不是直接使用Gradle。命令也是使用gradlew而不是gradle。这是因为gradle针对特定的开发环境的构建脚本，新的gradle可能不能兼容旧版的构建环境。为了解决这个问题，使用Gradle Wrapper 来间接使用 gradle。相当于在外边包裹了一个中间层。对开发者来说，直接使用Gradlew 即可，不需要关心 gradle的版本变化。Gradle Wrapper 会负责下载合适的的gradle版本来构建项目。
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String name=getResources().getString(R.string.app_name);
        if(BuildConfig.LEO_DEBUG){
            Log.e("BuildConfig","============");
        }
        Toast.makeText(this,BuildConfig.NAME,Toast.LENGTH_LONG).show();
    }
}
