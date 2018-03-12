package com.example.mylibrary;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.myapplication.R;

import java.util.List;

public class MainActivityLib extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lib);
    }

    public void testlib(View view){
        /**
         * 判断一个scheme是否有效
         */
        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("main://com.gome"));
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        boolean isValid = !activities.isEmpty();
        if (isValid) {
            startActivity(intent);
        }
//        Uri uri=Uri.parse("main://com.gome");
//        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
//        startActivity(intent);
    }


}
