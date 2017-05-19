package com.example.yi17zhang.vipkeyboardtest;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

/**
 * Created by yi17.zhang on 2017/5/19.
 */
public class CustomKeyboard {

    private EditText mEdittext;
    private MyKeyboardView mKeyboardView;
    private Keyboard mKeyboard;

    public CustomKeyboard(Context context, MyKeyboardView keyboardView, EditText editText) {
        this.mEdittext = editText;
        mKeyboard = new Keyboard(context, R.xml.keyboard);//从xml中加载自定义的键盘
        mKeyboardView = keyboardView;
        mKeyboardView.setContext(context);
        mKeyboardView.setKeyboard(mKeyboard);
        mKeyboardView.setPreviewEnabled(false);
        mKeyboardView.setOnKeyboardActionListener(actionListener);
    }

    private KeyboardView.OnKeyboardActionListener actionListener = new KeyboardView.OnKeyboardActionListener() {
        @Override
        public void onPress(int primaryCode) {
        }

        @Override
        public void onRelease(int primaryCode) {

        }

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {
            Editable editable = mEdittext.getText();
            int index = mEdittext.getSelectionStart();//光标位置
            switch (primaryCode) {

                case Keyboard.KEYCODE_DELETE://回退
                    if (editable != null && editable.length() > 0) {
                        if (index > 0) {
                            editable.delete(index - 1, index);
                        }
                    }
                    break;
                case 9995://重输
                    mEdittext.setText("");
                    break;
                case 9994://左移
                    if (index > 0) {
                        mEdittext.setSelection(index - 1);
                    }
                    break;
                case 9996://右移
                    if (index < mEdittext.length()) {
                        mEdittext.setSelection(index + 1);
                    }
                    break;
                default:
                    editable.insert(index, Character.toString((char) primaryCode));
                    break;
            }
        }

        @Override
        public void onText(CharSequence text) {

        }

        @Override
        public void swipeLeft() {

        }

        @Override
        public void swipeRight() {

        }

        @Override
        public void swipeDown() {

        }

        @Override
        public void swipeUp() {

        }
    };

    public void showKeyboard() {
        if (mKeyboardView.getVisibility() != View.VISIBLE) {
            mKeyboardView.setVisibility(View.VISIBLE);
        }
    }

    public void hideKeyboard() {
        if (mKeyboardView.getVisibility() == View.VISIBLE) {
            mKeyboardView.setVisibility(View.GONE);
        }
    }

    public boolean isShowKeyboard() {
        return mKeyboardView.getVisibility() == View.VISIBLE;
    }

}

