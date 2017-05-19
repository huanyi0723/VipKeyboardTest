package com.example.yi17zhang.vipkeyboardtest;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    EditText writebankcard_mobileedit;
    CustomKeyboard mCustomKeyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writebankcard_mobileedit = (EditText) findViewById(R.id.writebankcard_mobileedit);

        //1 屏蔽掉系统默认输入法
        if (Build.VERSION.SDK_INT <= 10) {
            writebankcard_mobileedit.setInputType(InputType.TYPE_NULL);
        } else {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            try {
                Class<EditText> cls = EditText.class;
                Method setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(writebankcard_mobileedit, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //2 初试化键盘
        MyKeyboardView keyboardView = (MyKeyboardView) findViewById(R.id.customKeyboard);
        mCustomKeyboard = new CustomKeyboard(MainActivity.this, keyboardView, writebankcard_mobileedit);
        mCustomKeyboard.showKeyboard();

        writebankcard_mobileedit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mCustomKeyboard.showKeyboard();
                return false;
            }
        });
    }

    //物理返回键
    @Override
    public void onBackPressed() {
        if (mCustomKeyboard.isShowKeyboard()){
            mCustomKeyboard.hideKeyboard();
        }else {
            finish();
        }
    }
}
