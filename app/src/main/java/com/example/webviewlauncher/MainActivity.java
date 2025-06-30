package com.lyc.openwebview;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent();
        intent.setComponent(new ComponentName(
                "com.google.android.webview",
                "org.chromium.android_webview.devui.MainActivity"
        ));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        try {
            startActivity(intent);
            finishAndRemoveTask();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
            Toast.makeText(this, "未找到目标Activity，你的系统可能未安装谷歌webview软件", Toast.LENGTH_LONG).show();
        }
    }
}