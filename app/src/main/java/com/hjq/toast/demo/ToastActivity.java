package com.hjq.toast.demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationManagerCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import com.hjq.toast.ToastUtils;
import com.hjq.toast.style.ToastAliPayStyle;
import com.hjq.toast.style.ToastBlackStyle;
import com.hjq.toast.style.ToastQQStyle;
import com.hjq.toast.style.ToastWhiteStyle;
import com.hjq.xtoast.XToast;

/**
 *    author : Android 杞瓙鍝? *    github : https://github.com/getActivity/ToastUtils
 *    time   : 2018/09/01
 *    desc   : ToastUtils 浣跨敤妗堜緥
 */
public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    public void show1(View v) {
        for (int i = 0; i < 3; i++) {
            ToastUtils.show("鎴戞槸绗? + (i + 1) + "涓悙鍙?);
        }
    }

    public void show2(View v) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                ToastUtils.show("鎴戞槸瀛愮嚎绋嬩腑寮瑰嚭鐨勫悙鍙?);
            }
        }).start();
    }

    public void show3(View v) {
        ToastUtils.initStyle(new ToastWhiteStyle(getApplication()));
        ToastUtils.show("鍔ㄦ€佸垏鎹㈢櫧鑹插悙鍙告牱寮忔垚鍔?);
    }

    public void show4(View v) {
        ToastUtils.initStyle(new ToastBlackStyle(getApplication()));
        ToastUtils.show("鍔ㄦ€佸垏鎹㈤粦鑹插悙鍙告牱寮忔垚鍔?);
    }

    public void show5(View v) {
        ToastUtils.initStyle(new ToastQQStyle(getApplication()));
        ToastUtils.show("QQ閭ｇ杩樹笉绠€鍗曪紝鍒嗗垎閽熺殑浜?);
    }

    public void show6(View v) {
        ToastUtils.initStyle(new ToastAliPayStyle(getApplication()));
        ToastUtils.show("鏀粯瀹濋偅绉嶈繕涓嶇畝鍗曪紝鍒嗗垎閽熺殑浜?);
    }

    public void show7(View v) {
        // ToastUtils.setView(View.inflate(getApplication(), R.layout.toast_custom_view, null));
        ToastUtils.setView(R.layout.toast_custom_view);
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
        ToastUtils.show("鎴戞槸鑷畾涔塗oast");
    }

    public void show8(View v) {
        new XToast(ToastActivity.this)
                .setDuration(1000)
                .setView(ToastUtils.getToast().getView())
                .setAnimStyle(android.R.style.Animation_Translucent)
                .setText(android.R.id.message, "灏遍棶浣犳簻涓嶆簻")
                .show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // 璇锋敞鎰忚繖娈典唬鐮佸己鐑堝缓璁笉瑕佹斁鍒板疄闄呭紑鍙戜腑锛屽洜涓虹敤鎴峰睆钄介€氱煡鏍忓拰寮€鍚簲鐢ㄧ姸鎬佷笅鐨勬儏鍐垫瀬灏戯紝鍙互蹇界暐涓嶈

        // 濡傛灉閫氱煡鏍忕殑鏉冮檺琚墜鍔ㄥ叧闂簡
        if (!NotificationManagerCompat.from(this).areNotificationsEnabled() &&
                !"SupportToast".equals(ToastUtils.getToast().getClass().getSimpleName())) {
            try {
                // 鍥犱负鍚愬徃鍙湁鍒濆鍖栫殑鏃跺€欐墠浼氬垽鏂€氱煡鏉冮檺鏈夋病鏈夊紑鍚紝鏍规嵁杩欎釜閫氱煡寮€鍏虫潵鏄剧ず鍘熺敓鐨勫悙鍙歌繕鏄吋瀹圭殑鍚愬徃
                ToastUtils.init(getApplication());
                recreate();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ToastUtils.show("妫€鏌ュ埌浣犳墜鍔ㄥ叧闂簡閫氱煡鏉冮檺锛屾鍦ㄩ噸鏂板垵濮嬪寲ToastUtils妗嗘灦");
                        } catch (Exception ignored) {}
                    }
                }, 2000);
            }catch (Exception ignored) {}
        }
    }
}
