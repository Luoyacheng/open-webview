package com.example.webviewlauncher;

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
            finish();
        } catch (Exception e) {
            Toast.makeText(this, "未找到目标Activity，请确认已安装WebView DevUI", Toast.LENGTH_LONG).show();
        }
    }
}