package com.example.yi17zhang.vipkeyboardtest;

import android.content.Context;
import android.graphics.Canvas;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

/**
 * Created by yi17.zhang on 2017/5/19. 用于以后扩展功能
 */
public class MyKeyboardView extends KeyboardView {

    private Context context;

    public MyKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       /* List<Keyboard.Key> keys = getKeyboard().getKeys();
        for(Keyboard.Key key: keys) {
            if(key.label.equals("delete"))
                resetOKBtn(key, canvas);
        }*/
    }

    /**
     * 绘制OK键的点9图
     * @author Song
     * @param key
     * @param canvas
     */
    private void resetOKBtn(Keyboard.Key key, Canvas canvas) {
        //将OK键重新绘制
       /* Drawable npd = (Drawable) context.getResources().getDrawable(R.mipmap.icon_number_del);
        npd.setBounds(key.x, key.y + 1, key.x + key.width, key.y + key.height + 1);
        npd.draw(canvas);*/
    }
}
