package com.example.lab1brockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.MloLink;
import android.os.Bundle;
import android.view.View;
import com.example.lab1brockpaperscissors.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int playerScore = 0;
    private int compScore = 0;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.scoreText.setText(String.format(getResources().getString(R.string.scoreText), playerScore, compScore));

        binding.playerWText.setText(String.format(getResources().getString(R.string.PlayerWText), getResources().getString(R.string.noWeapontext)));
        binding.CompWText.setText(String.format(getResources().getString(R.string.CompWText), getResources().getString(R.string.noWeapontext)));
        binding.winnerText.setText(getResources().getString(R.string.noWinnertext));


        binding.rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game(0);
            }
        });
        binding.paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game(1);
            }
        });
        binding.scissorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game(2);
            }
        });
    }


    private void game(int playerW){
        int compW = Math.abs(rand.nextInt()%3);
        String pWeapon = "", cWeapon = "";

        binding.playerWText.setText(String.format(getResources().getString(R.string.PlayerWText), Weapon.values()[playerW].toString() ));
        binding.CompWText.setText(String.format(getResources().getString(R.string.CompWText), Weapon.values()[compW].toString() ));

        switch (playerW) {
            case 0:
                if (compW == 0){
                    scoreUp(0);
                }
                else if (compW == 1){
                    scoreUp(2);
                }
                else {
                    scoreUp(1);
                }
                break;
            case 1:
                if (compW == 1){
                    scoreUp(0);
                }
                else if (compW == 2){
                    scoreUp(2);
                }
                else {
                    scoreUp(1);
                }
                break;
            case 2:
                if (compW == 2){
                    scoreUp(0);
                }
                else if (compW == 0){
                    scoreUp(2);
                }
                else {
                    scoreUp(1);
                }
                break;
        }


    }

    private void scoreUp(int winner){

        if (winner == 0){
            binding.winnerText.setText(getResources().getString(R.string.tieText));
        }
        else if (winner == 1){
            binding.winnerText.setText(String.format(getResources().getString(R.string.winnerText), "Player"));
            playerScore += 1;
        }
        else if (winner == 2){
            binding.winnerText.setText(String.format(getResources().getString(R.string.winnerText), "Computer"));
            compScore += 1;
        }

        binding.scoreText.setText(String.format(getResources().getString(R.string.scoreText), playerScore, compScore));
    }
}

