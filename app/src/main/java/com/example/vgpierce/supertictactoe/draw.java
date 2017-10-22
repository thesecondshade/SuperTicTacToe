package com.example.vgpierce.supertictactoe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.util.*;
import android.content.Context;

/**
 * Created by vgpierce on 10/21/17.
 */

public class draw extends View {
    Paint paint = new Paint();

    private void init() {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
    }

    public draw(Context context) {
        super(context);
        init();
    }

    public draw(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public draw(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x1 = 0;
        int y1 = 0;
        int x2 = canvas.getWidth();
        int y2 = canvas.getHeight();
        canvas.drawLine(x2/3,y1,x2/3,y2, paint);
        canvas.drawLine((2*x2)/3, y1, (2*x2)/3, y2, paint);
        canvas.drawLine(x1, y2/3, x2, y2/3, paint);
        canvas.drawLine(x1, (2*y2)/3, x2, (2*y2)/3, paint);
    }

}
