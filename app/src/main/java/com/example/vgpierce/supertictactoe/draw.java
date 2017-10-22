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
        int x = canvas.getWidth();
        int y = canvas.getHeight();
        int[][]  corners  =  {{0, 0},  {x/3, y/3},
                {x/3, 0},  {(2*x)/3, y/3},
                {(2*x)/3,0}, {x, y / 3},
                {0, y/3}, {x/3,(2*y)/3},
                {x/3,y/3}, {(2*x)/3,(2*y)/3},
                {(2*x)/3,y/3}, {x, (2*y)/3},
                {0,(2*y)/3}, {x/3,y},
                {x/3,(2*y)/3}, {(2*x)/3, y},
                {(2*x)/3,(2*y)/3},{x,y},
                {0,  0}, {x, y}

        };

        for(int i =0; i< corners.length;i+=2) {
            game(canvas,corners[i][0],corners[i][1],corners[i+1][0],corners[i+1][1]);

        }


    }
    public void game(Canvas canvas, int x1, int y1, int x2, int y2) {
        int xone = canvas.getWidth()/9;
        int xtwo = 2*(canvas.getWidth()/9);
        int yone = canvas.getHeight()/9;
        int ytwo = 2*(canvas.getHeight()/9);
        if(x1==0&& y1==0&&x2==canvas.getWidth() && y2==canvas.getHeight())
        {
            paint.setStrokeWidth(10);
            canvas.drawLine(x2/3,y1,x2/3,y2, paint);
            canvas.drawLine((2*x2)/3, y1, (2*x2)/3, y2, paint);
            canvas.drawLine(x1, y2/3, x2, y2/3, paint);
            canvas.drawLine(x1, (2*y2)/3, x2, (2*y2)/3, paint);
        }
        else {
            paint.setStrokeWidth(3);
            canvas.drawLine(x1+xone,y1,x1+xone,y2, paint);
            canvas.drawLine(x1+xtwo, y1, x1+xtwo, y2, paint);
            canvas.drawLine(x1, y1+yone, x2, y1+yone, paint);
            canvas.drawLine(x1, y1+ytwo, x2, y1+ytwo, paint);
        }


    }

}
