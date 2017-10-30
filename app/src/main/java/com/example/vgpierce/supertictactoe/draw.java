package com.example.vgpierce.supertictactoe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
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
    //Variables for touch position
    float xPos = 0;
    float yPos = 0;
    //Values for highlight Box
    float highlightXPos = 0;
    float highlightYPos = 0;
    float highlightWidth = 0;
    float highlightHeight = 0;
    //1 for X's
    //-1 for O's
    int playerTurn = 1;
    TicTacToe masterTicTacToeBoard = new TicTacToe();
    TicTacToe[] gameBoards = new TicTacToe[9];
    TicTacToe currentGameBoard = masterTicTacToeBoard;

    boolean gameOver = false;
    public draw(Context context) {
        super(context);
        for(int i = 0;i<9;i++){
            gameBoards[i] = new TicTacToe();
        }
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
        int cW = canvas.getWidth();
        int cH = canvas.getHeight();
        if(highlightWidth == 0){
            highlightWidth = cW;
            highlightHeight = cH;
        }
//        int[][]  corners  =  {{0, 0},  {x/3, y/3},
//                {x/3, 0},  {(2*x)/3, y/3},
//                {(2*x)/3,0}, {x, y / 3},
//                {0, y/3}, {x/3,(2*y)/3},
//                {x/3,y/3}, {(2*x)/3,(2*y)/3},
//                {(2*x)/3,y/3}, {x, (2*y)/3},
//                {0,(2*y)/3}, {x/3,y},
//                {x/3,(2*y)/3}, {(2*x)/3, y},
//                {(2*x)/3,(2*y)/3},{x,y},
//        };
        paint.setColor(Color.BLACK);

        int[][]  corners  =  {{0, 0},  {cW/3, 0}, {2*cW/3, 0},
                {0, cH/3}, {cW/3,cH/3}, {2*cW/3, cH/3},
                {0, 2*cH/3}, {cW/3,2*cH/3}, {2*cW/3, 2*cH/3}
        };
        masterTicTacToeBoard.setDimensions(0,0,cW,cH);
        drawTicTacToeBoard(canvas, masterTicTacToeBoard);

        for(int i = 0;i<gameBoards.length;i++){
            gameBoards[i].setDimensions(corners[i][0],corners[i][1],cW/3,cH/3);
            drawTicTacToeBoard(canvas,gameBoards[i]);
        }
        paint.setTextSize(100);
        if(gameOver){
            //Opposite player's turn on victory
            if(playerTurn == 1)
                canvas.drawText("O's WINS!",cW/2,cH/2,paint);
            else{
                canvas.drawText("X's WINS!",cW/2,cH/2,paint);
            }
        }
        paint.setStrokeWidth(10);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        Log.d("Highlight",highlightXPos + " " + highlightYPos + " " +highlightWidth + " " + highlightHeight);
        //Manually drawing the highlight rectangle because I cannot figure out the drawRect method! Why why why
        canvas.drawLine(highlightXPos,highlightYPos,highlightXPos,highlightYPos+highlightHeight,paint);
        canvas.drawLine(highlightXPos+highlightWidth,highlightYPos,highlightXPos+highlightWidth,highlightYPos+highlightHeight,paint);
        canvas.drawLine(highlightXPos,highlightYPos,highlightXPos+highlightWidth,highlightYPos,paint);
        canvas.drawLine(highlightXPos,highlightYPos+highlightHeight,highlightXPos+highlightWidth,highlightYPos+highlightHeight,paint);

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
    public void drawTicTacToeBoard(Canvas canvas,TicTacToe ttc){
        paint.setStrokeWidth(3);
        float posX = ttc.getPosX();
        float posY = ttc.getPosY();
        float width = ttc.getWidth();
        float height = ttc.getHeight();
        if(ttc.width == canvas.getWidth() && ttc.height == canvas.getHeight())
            paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        float third = (1f/3f);
        canvas.drawRect(posX,posY,width,height,paint);
        canvas.drawLine(posX,posY+(third)*height,posX+width,posY+(third)*height, paint);
        canvas.drawLine(posX,posY+(third*2)*height,posX+width,posY+(third*2)*height, paint);
        canvas.drawLine(posX+(third)*width,posY,posX+(third)*width,posY+height, paint);
        canvas.drawLine(posX+(third*2)*width,posY,posX+(third*2)*width,posY+height, paint);
        Integer[][] playsOnBoard = ttc.getGameBoard();
        float incValueX = width * third;
        float incValueY = height * third;
        for(int x = 0; x<playsOnBoard.length;x++){
            for(int y = 0;y<playsOnBoard[0].length;y++){
                if(playsOnBoard[x][y] == 1){
                    canvas.drawLine(posX +(x*incValueX),posY+(y*incValueY),posX +((x+1)*incValueX),posY+((y+1)*incValueY),paint);
                    canvas.drawLine(posX +(x*incValueX),posY+((y+1)*incValueY),posX +((x+1)*incValueX),posY+(y*incValueY),paint);
                }
                else if(playsOnBoard[x][y] == -1){
                    canvas.drawOval(posX +(x*incValueX),posY+(y*incValueY),posX +((x+1)*incValueX),posY+((y+1)*incValueY),paint);
                    canvas.drawOval(posX +(x*incValueX),posY+((y+1)*incValueY),posX +((x+1)*incValueX),posY+(y*incValueY),paint);
                }
            }
        }

    }
    @Override
    public boolean onTouchEvent (MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                xPos = event.getX();
                yPos = event.getY();
                Point gridPoint =   currentGameBoard.getGridValue(xPos,yPos);
                if(currentGameBoard == masterTicTacToeBoard){
                    Log.d("Tic Tac Toe","Master");
                    currentGameBoard = gameBoards[(gridPoint.x)+(gridPoint.y*3)];
                }
                gridPoint = currentGameBoard.getGridValue(xPos,yPos);
                if(currentGameBoard.makeMove(xPos,yPos,playerTurn)){
                    playerTurn *=-1;
                    if(currentGameBoard.checkVictory()){
                        masterTicTacToeBoard.makeMove(xPos,yPos,-playerTurn);
                    }
                    currentGameBoard = gameBoards[(gridPoint.x)+(gridPoint.y*3)];
                    if(currentGameBoard.checkVictory()){
                        currentGameBoard = masterTicTacToeBoard;
                    }
                    highlightXPos = currentGameBoard.getPosX();
                    highlightYPos = currentGameBoard.getPosY();
                    highlightWidth = currentGameBoard.getWidth();
                    highlightHeight = currentGameBoard.getHeight();
                }
                if(masterTicTacToeBoard.checkVictory()) {
                    gameOver = true;
                }
                invalidate();
                break;
        }

        return true;

    }

}
