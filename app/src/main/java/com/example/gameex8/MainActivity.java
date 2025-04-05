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
    TextView textRandom1, textRandom2, textViewAnswer1, textViewAnswer2, textViewAnswer3, textViewAnswer4;
    EditText editText1, editText2, editText3;
    int number1, number2, number3, number4, numberOfWins;
    ImageView imageView1, imageView2, imageView3;
    Random ra = new Random();
    Button buttonCheck1, buttonCheck2, buttonCheck3, buttonNewGame;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textRandom1 = findViewById(R.id.textRandom1);
        textRandom2 = findViewById(R.id.textRandom2);
        editText1 = findViewById(R.id.editText1);
        imageView1 = findViewById(R.id.imageView1);
        textViewAnswer1 = findViewById(R.id.textViewAnswer1);
        textViewAnswer2 = findViewById(R.id.textViewAnswer2);
        imageView2 = findViewById(R.id.imageView2);
        editText2 = findViewById(R.id.editText2);
        buttonCheck1 = findViewById(R.id.buttonCheck1);
        buttonCheck2 = findViewById(R.id.buttonCheck2);
        buttonNewGame = findViewById(R.id.buttonNewGame);
        textViewAnswer3 = findViewById(R.id.textViewAnswer3);
        textViewAnswer4 = findViewById(R.id.textViewAnswer4);
        buttonCheck3 = findViewById(R.id.buttonCheck3);
        editText3 = findViewById(R.id.editText3);
        imageView3 = findViewById(R.id.imageView3);

        number1 = ra.nextInt(89) + 10;
        textRandom1.setText(String.valueOf(number1));

        number2 = ra.nextInt(89) + 10;
        textRandom2.setText(String.valueOf(number2));

        numberOfWins = 0;
    }

    public void check1(View view) {
        String text1 = editText1.getText().toString();
        if (!text1.equals("")) {
            if (number1 + number2 == Integer.valueOf(text1)) {
                imageView1.setVisibility(View.VISIBLE);
                numberOfWins++;
                textViewAnswer2.setText(String.valueOf(numberOfWins));
            } else {
                imageView1.setImageResource(R.drawable.ex);
                imageView1.setVisibility(View.VISIBLE);
            }
            editText1.setEnabled(false);
            buttonCheck1.setEnabled(false);
            textViewAnswer1.setText(String.valueOf(number1 + number2));
            number3 = ra.nextInt(89) + 10;
            textViewAnswer2.setText(String.valueOf(number3));

            textViewAnswer1.setVisibility(View.VISIBLE);
            textViewAnswer2.setVisibility(View.VISIBLE);
            editText2.setVisibility(View.VISIBLE);
            buttonCheck2.setVisibility(View.VISIBLE);
        }
    }

    public void check2(View view) {
        String text1 = editText2.getText().toString();
        if (!text1.equals("")) {
            if ((number1 + number2) + number3 == Integer.valueOf(text1)) {
                imageView2.setVisibility(View.VISIBLE);
                numberOfWins++;
            } else {
                imageView2.setImageResource(R.drawable.ex);
                imageView2.setVisibility(View.VISIBLE);
            }
            editText2.setEnabled(false);
            buttonCheck2.setEnabled(false);
            textViewAnswer3.setText(String.valueOf((number1 + number2) + number3));
            number4 = ra.nextInt(89) + 10;
            textViewAnswer4.setText(String.valueOf(number4));

            buttonCheck3.setVisibility(View.VISIBLE);
            editText3.setVisibility(View.VISIBLE);
            textViewAnswer4.setVisibility(View.VISIBLE);
            textViewAnswer3.setVisibility(View.VISIBLE);
        }
    }

    public void check3(View view) {
        String text1 = editText3.getText().toString();
        if (!text1.equals("")) {
            if ((number1 + number2 + number3) + number4 == Integer.valueOf(text1)) {
                imageView3.setVisibility(View.VISIBLE);
                numberOfWins++;
            } else {
                imageView3.setImageResource(R.drawable.ex);
                imageView3.setVisibility(View.VISIBLE);
            }
            editText3.setEnabled(false);
            buttonCheck3.setEnabled(false);
            buttonNewGame.setText(String.format("%d/3 (%.2f%%)", numberOfWins, (numberOfWins / 3.0) * 100));
        }
    }

    public void restartGame(View view) {
        number1 = ra.nextInt(89) + 10;
        number2 = ra.nextInt(89) + 10;
        number3 = ra.nextInt(89) + 10;
        number4 = ra.nextInt(89) + 10;

        numberOfWins = 0;

        textRandom1.setText(String.valueOf(number1));
        textRandom2.setText(String.valueOf(number2));
        textViewAnswer2.setText("");
        textViewAnswer4.setText("");
        textViewAnswer1.setText("");
        textViewAnswer3.setText("");
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");

        imageView1.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.INVISIBLE);

        editText1.setEnabled(true);
        buttonCheck1.setEnabled(true);
        buttonCheck2.setVisibility(View.INVISIBLE);
        buttonCheck3.setVisibility(View.INVISIBLE);
        buttonNewGame.setVisibility(View.INVISIBLE);
    }
}
