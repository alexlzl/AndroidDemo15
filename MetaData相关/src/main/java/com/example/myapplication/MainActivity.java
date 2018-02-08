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
 * <p>
 * 3：在service应用<meta-data>元素。
 * xml代码段：
 * <service android:name="MetaDataService">
 * <meta-data android:value="hello my service" android:name="data_Name"></meta-data>
 * </service>
 * <p>
 * java代码段：
 * ComponentName cn=new ComponentName(this, MetaDataService.class);
 * ServiceInfo info=this.getPackageManager()
 * .getServiceInfo(cn, PackageManager.GET_META_DATA);
 * String msg=info.metaData.getString("data_Name");
 * Log.d(TAG, " msg == " + msg );
 * <p>
 * 4: 在receiver应用<meta-data>元素。
 * xml代码段:
 * <receiver android:name="MetaDataReceiver">
 * <meta-data android:value="hello my receiver" android:name="data_Name"></meta-data>
 * <intent-filter>
 * <action android:name="android.intent.action.PHONE_STATE"></action>
 * </intent-filter>
 * </receiver>
 * java代码段：
 * ComponentName cn=new ComponentName(context, MetaDataReceiver.class);
 * ActivityInfo info=context.getPackageManager()
 * .getReceiverInfo(cn, PackageManager.GET_META_DATA);
 * String msg=info.metaData.getString("data_Name");
 * Log.d(TAG, " msg == " + msg );
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
