package com.example.liuzhouliang.demo8;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by liuzhouliang on 2018/2/8.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationInfo appInfo = null;
        try {
            appInfo = this.getPackageManager()
                    .getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Bundle bundle = appInfo.metaData;
        Log.e("MyApplication", "bundle.getString(jerey) : " + bundle.getString("test_array")+bundle.getString("testmeta"));// bundle.getString(jerey) : sdf123456
        int id = bundle.getInt("test_array");
        String[] aString = getResources().getStringArray(id);
        for (int i = 0; i < aString.length; i++) {
            Log.e("MyApplication", "onCreate: " + aString[i]);
        }

    }
}
