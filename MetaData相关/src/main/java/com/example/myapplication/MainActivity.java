package com.example.myapplication;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * //在service应用<meta-data>元素。
 * ComponentName cn = new ComponentName(this, ×××Service.class);
 * ServiceInfo info = this.getPackageManager().getServiceInfo(cn, PackageManager.GET_META_DATA);
 * info.metaData.getString("meta_name");
 * <p>
 * //在receiver应用<meta-data>元素。
 * ComponentName cn = new ComponentName(context, ×××Receiver.class);
 * ActivityInfo info = context.getPackageManager().getReceiverInfo(cn, PackageManager.GET_META_DATA);
 * info.metaData.getString("meta_name");
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tv);
        //在Activity应用<meta-data>元素。
        ActivityInfo info = null;
        try {
            info = getPackageManager()
                    .getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        textView.setText(info.metaData.getString("activity_meta"));


    }
}
