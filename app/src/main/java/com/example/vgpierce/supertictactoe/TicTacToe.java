package com.example.vgpierce.supertictactoe;

import android.util.Log;

/**
 * Created by Alex on 10/21/2017.
 * Tracks and crates information relating to tictactoe game boards
 */

public class TicTacToe {
    Integer[][] gameSlots = new Integer[3][3];
    public TicTacToe(){
        for(int x = 0; x<gameSlots.length;x++){
            for(int y = 0;y< gameSlots[0].length;y++){
                gameSlots[x][y] = 0;
            }
        }
    }
    public boolean setValue(int x, int y, int value){
        if(gameSlots[x][y] == 0){
            gameSlots[x][y] = value;
            return true;
        }
        return false;
    }
    public boolean checkVictory(){
        if(gameSlots[1][1] !=0){
            if(gameSlots[1][1] == gameSlots[0][1] && gameSlots[1][1] == gameSlots[2][1]){
                return true;
            }
            if(gameSlots[1][1] == gameSlots[1][0] && gameSlots[1][1] == gameSlots[1][2]){
                return true;
            }
            if(gameSlots[1][1] == gameSlots[0][0] && gameSlots[1][1] == gameSlots[2][2]){
                return true;
            }
            if(gameSlots[2][0] == gameSlots[0][1] && gameSlots[1][1] == gameSlots[0][2]){
                return true;
            }
        }
        if(gameSlots[0][1] !=0){
            if(gameSlots[0][1] == gameSlots[0][0] && gameSlots[0][1] == gameSlots[0][2]){
                return true;
            }
        }
        if(gameSlots[2][1] !=0){
            if(gameSlots[2][1] == gameSlots[2][0] && gameSlots[2][1] == gameSlots[2][2]){
                return true;
            }
        }
        if(gameSlots[1][0] !=0){
            if(gameSlots[1][0] == gameSlots[0][0] && gameSlots[1][0] == gameSlots[2][0]){
                return true;
            }
        }
        if(gameSlots[1][2] !=0){
            if(gameSlots[1][2] == gameSlots[0][2] && gameSlots[1][2] == gameSlots[2][2]){
                return true;
            }
        }
        return false;
    }
    public Integer[][] getGameBoard(){
            Log.d("Test",toString());
        return gameSlots;
    }
    public String toString(){
        String a = "";
        for(Integer[] x : gameSlots){
            for(Integer y : x){
                a+= y + " ";
            }
            a+="\n";
        }
        if(checkVictory())
            a+=" VICTORY";
        return a;
    }
}
