package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton p1;
    ImageButton p2;
    ImageButton p3;
    ImageButton p4;
    ImageButton p5;
    ImageButton p6;
    ImageButton p7;
    ImageButton p8;
    ImageButton p9;
    TextView result;
    Button restart;
    boolean isGameOver = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        p5 = findViewById(R.id.p5);
        p6 = findViewById(R.id.p6);
        p7 = findViewById(R.id.p7);
        p8 = findViewById(R.id.p8);
        p9 = findViewById(R.id.p9);
        result = findViewById(R.id.result);
        restart = findViewById(R.id.restart);
        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};




        p1.setOnClickListener(v -> {
            if (isMoveValid(board, 1) && !isGameOver){
                p1.setImageResource(R.drawable.x);
                board[0][0] = 'x';
                if(!hasSideWon(board, 'x')) DrawCompMove(computerTurn(board), board);
                hasSideWon(board, 'o');
            }
        });
        p2.setOnClickListener(v -> {
            if (isMoveValid(board, 2) && !isGameOver){
                p2.setImageResource(R.drawable.x);
                board[0][1] = 'x';
                if(!hasSideWon(board, 'x')) DrawCompMove(computerTurn(board), board);
                hasSideWon(board, 'o');
            }
        });
        p3.setOnClickListener(v -> {
            if (isMoveValid(board, 3) && !isGameOver){
                p3.setImageResource(R.drawable.x);
                board[0][2] = 'x';
                if(!hasSideWon(board, 'x')) DrawCompMove(computerTurn(board), board);
                hasSideWon(board, 'o');
            }
        });
        p4.setOnClickListener(v -> {
            if (isMoveValid(board, 4) && !isGameOver){
                p4.setImageResource(R.drawable.x);
                board[1][0] = 'x';
                if(!hasSideWon(board, 'x')) DrawCompMove(computerTurn(board), board);
                hasSideWon(board, 'o');
            }
        });
        p5.setOnClickListener(v -> {
            if (isMoveValid(board, 5) && !isGameOver){
                p5.setImageResource(R.drawable.x);
                board[1][1] = 'x';
                if(!hasSideWon(board, 'x')) DrawCompMove(computerTurn(board), board);
                hasSideWon(board, 'o');
            }
        });
        p6.setOnClickListener(v -> {
            if (isMoveValid(board, 6) && !isGameOver){
                p6.setImageResource(R.drawable.x);
                board[1][2] = 'x';
                if(!hasSideWon(board, 'x')) DrawCompMove(computerTurn(board), board);
                hasSideWon(board, 'o');
            }
        });
        p7.setOnClickListener(v -> {
            if (isMoveValid(board, 7) && !isGameOver){
                p7.setImageResource(R.drawable.x);
                board[2][0] = 'x';
                if(!hasSideWon(board, 'x')) DrawCompMove(computerTurn(board), board);
                hasSideWon(board, 'o');
            }
        });
        p8.setOnClickListener(v -> {
            if (isMoveValid(board, 8) && !isGameOver){
                p8.setImageResource(R.drawable.x);
                board[2][1] = 'x';
                if(!hasSideWon(board, 'x')) DrawCompMove(computerTurn(board), board);
                hasSideWon(board, 'o');
            }
        });
        p9.setOnClickListener(v -> {
            if (isMoveValid(board, 9) && !isGameOver){
                p9.setImageResource(R.drawable.x);
                board[2][2] = 'x';
                if(!hasSideWon(board, 'x')) DrawCompMove(computerTurn(board), board);
                hasSideWon(board, 'o');
            }
        });


    }

    private boolean hasSideWon(char[][] board, char s) {
        if ((board[0][0] == s && board[0][1] == s && board[0][2] == s)||
            (board[2][0] == s && board[2][1] == s && board[2][2] == s) ||
            (board[0][0] == s && board[1][0] == s && board[2][0] == s) ||
            (board[0][1] == s && board[1][1] == s && board[2][1] == s) ||
            (board[0][2] == s && board[1][2] == s && board[2][2] == s) ||
            (board[1][0] == s && board[1][1] == s && board[1][2] == s) ||
            (board[0][0] == s && board[1][1] == s && board[2][2] == s) ||
            (board[0][2] == s && board[1][1] == s && board[2][0] == s)){
            if(s=='x'){
                result.setVisibility(View.VISIBLE);
                result.setText("You won!");
            }
            else{
                result.setVisibility(View.VISIBLE);
                result.setText("Computer won!");
            }
            restart.setVisibility(View.VISIBLE);
            restart.setOnClickListener(v -> {
                isGameOver = true;
                recreate();
            });
            isGameOver = true;
            return true;
        }
        else return false;
    }
    private int computerTurn(char[][] board) {
        Random random = new Random();
        int compMove;
        do {
            compMove = random.nextInt(9) + 1;
        } while (!isMoveValid(board, compMove));
        return compMove;
    }
    private void DrawCompMove(int pos, char[][] board){
        switch (pos){
            case 1:
                p1.setImageResource(R.drawable.o);
                board[0][0] = 'o';
                break;
            case 2:
                p2.setImageResource(R.drawable.o);
                board[0][1] = 'o';
                break;
            case 3:
                p3.setImageResource(R.drawable.o);
                board[0][2] = 'o';
                break;
            case 4:
                p4.setImageResource(R.drawable.o);
                board[1][0] = 'o';
                break;
            case 5:
                p5.setImageResource(R.drawable.o);
                board[1][1] = 'o';
                break;
            case 6:
                p6.setImageResource(R.drawable.o);
                board[1][2] = 'o';
                break;
            case 7:
                p7.setImageResource(R.drawable.o);
                board[2][0] = 'o';
                break;
            case 8:
                p8.setImageResource(R.drawable.o);
                board[2][1] = 'o';
                break;
            case 9:
                p9.setImageResource(R.drawable.o);
                board[2][2] = 'o';
                break;
        }
    }
    private boolean isMoveValid (char[][] board, int pos) {
        switch(pos) {
            case 1:
                return (board[0][0] == ' ');
            case 2:
                return (board[0][1] == ' ');
            case 3:
                return (board[0][2] == ' ');
            case 4:
                return (board[1][0] == ' ');
            case 5:
                return (board[1][1] == ' ');
            case 6:
                return (board[1][2] == ' ');
            case 7:
                return (board[2][0] == ' ');
            case 8:
                return (board[2][1] == ' ');
            case 9:
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }
}