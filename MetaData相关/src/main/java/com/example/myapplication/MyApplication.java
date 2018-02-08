package com.example.myapplication;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by liuzhouliang on 2018/2/8.
 * <p>
 * 简介-meta是什么
 * <p>
 * meta-data是应用的清单文件AndroidManifest.xml中application,activity,activity-alias,provider,receiver,service下的子标签,比intent-filter多些父标签.像友盟这些统计服务一般只需要一个AppID等,只需要定义在Application中,如果你想给某个组件添加meta-data，那么meta-data必须定义在其组件申明内。
 * <p>
 * 事实上，meta-data我们拿到的时候是一个Bundle
 */

public class MyApplication extends Application {
    private static final String TAG = "application";

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 测试Application节点的metadata数据
         */
        //获取meta中字符串====================1
        ApplicationInfo appInfo = null;
        try {
            appInfo = this.getPackageManager()
                    .getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Bundle bundle = appInfo.metaData;
        Log.e(TAG, "bundle.getString(jerey) : " + bundle.getString("application_meta"));
        //获取meta中的数组======================2
        int id = bundle.getInt("application_meta_res");
        String[] metaString = getResources().getStringArray(id);
        for (int i = 0; i < metaString.length; i++) {
            Log.e(TAG, "获取meta中数组: " + metaString[i]);
        }


    }
}
