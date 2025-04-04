package com.example.gameex8;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView randomText1;
    TextView randomText2;
    TextView answerText1;
    TextView answerText2;
    TextView answerText3;
    TextView randomText3;
    EditText firstInput;
    EditText secondInput;
    EditText thirdInput;
    int num1;
    int num2;
    int num3;
    int num4;
    int num5;
    ImageView firstImage;
    ImageView secondImage;
    ImageView thirdImage;
    Random randomGen = new Random();
    int winCount;
    Button firstCheckButton;
    Button secondCheckButton;
    Button thirdCheckButton;
    Button resetButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomText1 = findViewById(R.id.randomText1);
        randomText2 = findViewById(R.id.randomText2);
        firstInput = findViewById(R.id.firstInput);
        firstImage = findViewById(R.id.firstImage);
        answerText1 = findViewById(R.id.answerText1);
        answerText2 = findViewById(R.id.answerText2);
        secondImage = findViewById(R.id.secondImage);
        secondInput = findViewById(R.id.secondInput);
        firstCheckButton = findViewById(R.id.firstCheckButton);
        secondCheckButton = findViewById(R.id.secondCheckButton);
        resetButton = findViewById(R.id.resetButton);
        answerText3 = findViewById(R.id.answerText3);
        randomText3 = findViewById(R.id.randomText3);
        thirdCheckButton = findViewById(R.id.thirdCheckButton);
        thirdInput = findViewById(R.id.thirdInput);
        thirdImage = findViewById(R.id.thirdImage);

        num1 = randomGen.nextInt(89) + 10;
        randomText1.setText(String.valueOf(num1));

        num2 = randomGen.nextInt(89) + 10;
        randomText2.setText(String.valueOf(num2));

        winCount = 0;
    }

    public void checkFirst(View view) {
        String input = firstInput.getText().toString();
        if (!(input.equals(""))) {
            if (num1 + num2 == Integer.valueOf(input)) {
                firstImage.setVisibility(View.VISIBLE);
                winCount++;
                answerText2.setText(String.valueOf(winCount));
            } else {
                firstImage.setImageResource(R.drawable.ex);
                firstImage.setVisibility(View.VISIBLE);
            }
            firstInput.setEnabled(false);
            firstCheckButton.setEnabled(false);
            answerText1.setText(String.valueOf(num1 + num2));
            num3 = randomGen.nextInt(89) + 10;
            randomText2.setText(String.valueOf(num3));

            answerText1.setVisibility(View.VISIBLE);
            randomText2.setVisibility(View.VISIBLE);
            secondInput.setVisibility(View.VISIBLE);
            secondCheckButton.setVisibility(View.VISIBLE);
        }
    }

    public void checkSecond(View view) {
        String input = secondInput.getText().toString();
        if (!(input.equals(""))) {
            if ((num1 + num2) + num3 == Integer.valueOf(input)) {
                secondImage.setVisibility(View.VISIBLE);
                winCount++;
            } else {
                secondImage.setImageResource(R.drawable.ex);
                secondImage.setVisibility(View.VISIBLE);
            }
            secondInput.setEnabled(false);
            secondCheckButton.setEnabled(false);
            answerText3.setText(String.valueOf((num1 + num2) + num3));
            num4 = randomGen.nextInt(89) + 10;
            randomText3.setText(String.valueOf(num4));

            thirdCheckButton.setVisibility(View.VISIBLE);
            thirdInput.setVisibility(View.VISIBLE);
            randomText3.setVisibility(View.VISIBLE);
            answerText3.setVisibility(View.VISIBLE);
        }
    }

    public void checkThird(View view) {
        String input = thirdInput.getText().toString();
        if (!(input.equals(""))) {
            if ((num1 + num2 + num3) + num4 == Integer.valueOf(input)) {
                thirdImage.setVisibility(View.VISIBLE);
                winCount++;
            } else {
                thirdImage.setImageResource(R.drawable.ex);
                thirdImage.setVisibility(View.VISIBLE);
            }
            thirdInput.setEnabled(false);
            thirdCheckButton.setEnabled(false);
            resetButton.setText(String.format("%d/3 (%.2f%%)", winCount, (winCount / 3.0) * 100));
        }
    }

    public void restart(View view) {
        num1 = randomGen.nextInt(89) + 10;
        num2 = randomGen.nextInt(89) + 10;
        num3 = randomGen.nextInt(89) + 10;
        num4 = randomGen.nextInt(89) + 10;

        winCount = 0;

        randomText1.setText(String.valueOf(num1));
        randomText2.setText(String.valueOf(num2));
        randomText2.setText("");
        randomText3.setText("");
        answerText1.setText("");
        answerText3.setText("");

        firstInput.setText("");
        secondInput.setText("");
        thirdInput.setText("");

        firstInput.setEnabled(true);
        secondInput.setEnabled(true);
        thirdInput.setEnabled(true);

        firstCheckButton.setEnabled(true);
        secondCheckButton.setEnabled(true);
        thirdCheckButton.setEnabled(true);
        resetButton.setText("new");

        firstImage.setVisibility(View.INVISIBLE);
        secondImage.setVisibility(View.INVISIBLE);
        thirdImage.setVisibility(View.INVISIBLE);

        secondCheckButton.setVisibility(View.INVISIBLE);
        thirdCheckButton.setVisibility(View.INVISIBLE);

        secondInput.setVisibility(View.INVISIBLE);
        thirdInput.setVisibility(View.INVISIBLE);
    }
}
