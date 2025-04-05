package com.example.gameex8;

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

    // משתנים
    TextView randomText1, randomText2, randomText3, answerText1, answerText2, answerText3;
    EditText firstInput, secondInput, thirdInput;
    Button firstCheckButton, secondCheckButton, thirdCheckButton, resetButton;
    ImageView firstImage, secondImage, thirdImage;
    int num1, num2, num3, num4, winCount = 0;
    Random randomGen = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // אתחול של אובייקטים מה-XML
        randomText1 = findViewById(R.id.randomText1);
        randomText2 = findViewById(R.id.randomText2);
        randomText3 = findViewById(R.id.randomText3);
        answerText1 = findViewById(R.id.answerText1);
        answerText2 = findViewById(R.id.answerText2);
        answerText3 = findViewById(R.id.answerText3);
        firstInput = findViewById(R.id.firstInput);
        secondInput = findViewById(R.id.secondInput);
        thirdInput = findViewById(R.id.thirdInput);
        firstCheckButton = findViewById(R.id.firstCheckButton);
        secondCheckButton = findViewById(R.id.secondCheckButton);
        thirdCheckButton = findViewById(R.id.thirdCheckButton);
        resetButton = findViewById(R.id.resetButton);
        firstImage = findViewById(R.id.firstImage);
        secondImage = findViewById(R.id.secondImage);
        thirdImage = findViewById(R.id.thirdImage);

        // הגדרת מספרים והצגתם
        num1 = randomGen.nextInt(89) + 10;
        num2 = randomGen.nextInt(89) + 10;
        randomText1.setText(String.valueOf(num1));
        randomText2.setText(String.valueOf(num2));
    }

    // פונקציה לבדוק את השלב הראשון
    public void checkFirst(View view) {
        String input = firstInput.getText().toString();
        if (!input.equals("")) {
            if (num1 + num2 == Integer.parseInt(input)) {
                firstImage.setImageResource(R.drawable.ve); // וי
                firstImage.setVisibility(View.VISIBLE);
                winCount++;
                answerText2.setText(String.valueOf(winCount));
            } else {
                firstImage.setImageResource(R.drawable.ex); // איקס
                firstImage.setVisibility(View.VISIBLE);
            }
            firstInput.setEnabled(false);
            firstCheckButton.setEnabled(false);

            // מעבר לשלב הבא
            answerText1.setText(String.valueOf(num1 + num2));
            num3 = randomGen.nextInt(89) + 10;
            randomText3.setText(String.valueOf(num3));

            // הצגת שדה הקלט של השלב הבא
            answerText1.setVisibility(View.VISIBLE);
            randomText3.setVisibility(View.VISIBLE);
            secondInput.setVisibility(View.VISIBLE);
            secondCheckButton.setVisibility(View.VISIBLE);
        }
    }

    // פונקציה לבדוק את השלב השני
    public void checkSecond(View view) {
        String input = secondInput.getText().toString();
        if (!input.equals("")) {
            if ((num1 + num2) + num3 == Integer.parseInt(input)) {
                secondImage.setImageResource(R.drawable.ve); // וי
                secondImage.setVisibility(View.VISIBLE);
                winCount++;
            } else {
                secondImage.setImageResource(R.drawable.ex); // איקס
                secondImage.setVisibility(View.VISIBLE);
            }
            secondInput.setEnabled(false);
            secondCheckButton.setEnabled(false);
            answerText3.setText(String.valueOf((num1 + num2) + num3));
            num4 = randomGen.nextInt(89) + 10;
            randomText2.setText(String.valueOf(num4));

            // הצגת שדה הקלט של השלב הבא
            thirdCheckButton.setVisibility(View.VISIBLE);
            thirdInput.setVisibility(View.VISIBLE);
            randomText2.setVisibility(View.VISIBLE);
            answerText3.setVisibility(View.VISIBLE);
        }
    }

    // פונקציה לבדוק את השלב השלישי
    public void checkThird(View view) {
        String input = thirdInput.getText().toString();
        if (!input.equals("")) {
            if ((num1 + num2 + num3) + num4 == Integer.parseInt(input)) {
                thirdImage.setImageResource(R.drawable.ve); // וי
                thirdImage.setVisibility(View.VISIBLE);
                winCount++;
            } else {
                thirdImage.setImageResource(R.drawable.ex); // איקס
                thirdImage.setVisibility(View.VISIBLE);
            }
            thirdInput.setEnabled(false);
            thirdCheckButton.setEnabled(false);

            // סיכום התוצאה
            resetButton.setText(String.format("%d/3 (%.2f%%)", winCount, (winCount / 3.0) * 100));
        }
    }

    // פונקציה לאתחול המשחק מחדש
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
