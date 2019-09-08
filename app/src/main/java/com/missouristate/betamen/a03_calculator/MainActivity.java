package com.missouristate.betamen.a03_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public boolean buttonPressed = false;
    public  double firstNumber = 0;
    public double secondNumber = 0;
    public int secondNumIndex = 0;
    public String operatCommand;



//    public Button n_0 = findViewById(R.id.button_0);//assigning bottunts
//    public Button n_1 = findViewById(R.id.button_1);
//    public Button n_2 = findViewById(R.id.button_2);
//    public Button n_3 = findViewById(R.id.button_3);
//    public Button n_4 = findViewById(R.id.button_4);
//    public Button n_5 = findViewById(R.id.button_5);
//    public Button n_6 = findViewById(R.id.button_6);
//    public Button n_7 = findViewById(R.id.button_7);
//    public Button n_8 = findViewById(R.id.button_8);
//    public Button n_9 = findViewById(R.id.button_9);
//    public Button dot = findViewById(R.id.button_dot);
//    public Button equals = findViewById(R.id.button_Equals);
//    public Button plus = findViewById(R.id.button_Plus);
//    public Button minus = findViewById(R.id.button_Minus);
//    public Button muntiply = findViewById(R.id.button_Muliply);
//    public Button devide = findViewById(R.id.button_Divide);
//  public Button percent = findViewById(R.id.percent);
//    public Button ac = findViewById(R.id.button_AC);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView calcScreen = findViewById(R.id.textView_calculatorScreen); //connect screen on calc to a TextView



        final Button n_0 = findViewById(R.id.button_0);//assigning bottunts
        final Button n_1 = findViewById(R.id.button_1);
        final Button n_2 = findViewById(R.id.button_2);
        final Button n_3 = findViewById(R.id.button_3);
        final Button n_4 = findViewById(R.id.button_4);
        final Button n_5 = findViewById(R.id.button_5);
        final Button n_6 = findViewById(R.id.button_6);
        final Button n_7 = findViewById(R.id.button_7);
        final Button n_8 = findViewById(R.id.button_8);
        final Button n_9 = findViewById(R.id.button_9);
        final Button dot = findViewById(R.id.button_dot);
        final Button equals = findViewById(R.id.button_Equals);
        final Button plus = findViewById(R.id.button_Plus);
        final Button minus = findViewById(R.id.button_Minus);
        final Button muntiply = findViewById(R.id.button_Muliply);
        final Button devide = findViewById(R.id.button_Divide);
        final Button percent = findViewById(R.id.percent);
        final Button ac = findViewById(R.id.button_AC);

        final View.OnClickListener calcListener = new View.OnClickListener() { //listens when buttons are pressed

            @Override
            public void onClick(View view) {
                int id = view.getId();                                      //will compare values pressed on the key
                if (id == R.id.button_0){
                    calcScreen.append("0");                                 //.appends will add to text on the screen Zero or other numbers
                }else if (id == R.id.button_1){
                    calcScreen.append("1");
                }else if (id == R.id.button_2){
                    calcScreen.append("2");
                }else if (id == R.id.button_3){
                    calcScreen.append("3");
                }else if (id == R.id.button_4){
                    calcScreen.append("4");
                }else if (id == R.id.button_5){
                    calcScreen.append("5");
                }else if (id == R.id.button_6){
                    calcScreen.append("6");
                }else if (id == R.id.button_7){
                    calcScreen.append("7");
                }else if (id == R.id.button_8){
                    calcScreen.append("8");
                }else if (id == R.id.button_9){
                    calcScreen.append("9");
                }else if (id == R.id.button_Plus){                              //plus command will do some math.

                    getFirstNumber();                                          //runs subroutine to get first number before sign like +
                    calcScreen.append("+");
                }else if (id == R.id.button_Minus){
                    getFirstNumber();
                    calcScreen.append("-");
                }else if (id == R.id.button_Muliply){
                    getFirstNumber();
                    calcScreen.append("*");
                }else if (id == R.id.button_Divide){
                    calcScreen.append("/");
                }else if (id == R.id.percent){
                    calcScreen.append("%");
                }else if (id == R.id.button_dot){
                    calcScreen.append(".");
                }else if (id == R.id.button_AC){                               //just eraces the screen
                    calcScreen.setText("");

                }else if (id == R.id.button_Equals){                            //will do a calculation after "=" was pressed

                    String screenContent = calcScreen.getText().toString();       //reads the values on the screen an String

                        if(screenContent.contains("+")){                          //will finish math if "+" was press
                            getSecondNumber();                                                      //runs subroutine to get second number
                            calcScreen.setText(String.valueOf(firstNumber + secondNumber));         //prints on the display sum
                        }else if (screenContent.contains("-")){
                            getSecondNumber();
                            calcScreen.setText(String.valueOf(firstNumber - secondNumber));
                        }else if (screenContent.contains("*")){
                            getSecondNumber();
                            calcScreen.setText(String.valueOf(firstNumber * secondNumber));
                        }else if (screenContent.contains("/")){
                            getSecondNumber();
                            if(secondNumber != 0){
                                calcScreen.setText(String.valueOf(firstNumber / secondNumber));
                            }
                         else if (screenContent.contains("%")){
                                getSecondNumber();
                                calcScreen.setText(String.valueOf(firstNumber /100));
                         }
                         else if (screenContent.contains("*")){
                                getSecondNumber();
                                calcScreen.setText(String.valueOf(firstNumber * secondNumber));
                         }
                        }
                }

            }

            private void getFirstNumber() {
                String screenContent = calcScreen.getText().toString();                              //reads the value on the screen
                secondNumIndex = screenContent.length() +1;                                          //secondNumIndex shows the place of the sign like "+" inside the String
                firstNumber = Double.parseDouble(screenContent);                                     //parses the string to get double
            }
            private void getSecondNumber(){
                String screenContent = calcScreen.getText().toString();
                secondNumber = Double.parseDouble(screenContent.substring(secondNumIndex, screenContent.length())); //gets the String screenContent snd cuts it using
            }
        };

        n_0.setOnClickListener(calcListener);                                                          //listeners to act on the click
        n_1.setOnClickListener(calcListener);
        n_2.setOnClickListener(calcListener);
        n_3.setOnClickListener(calcListener);
        n_4.setOnClickListener(calcListener);
        n_5.setOnClickListener(calcListener);
        n_6.setOnClickListener(calcListener);
        n_7.setOnClickListener(calcListener);
        n_8.setOnClickListener(calcListener);
        n_9.setOnClickListener(calcListener);
        plus.setOnClickListener(calcListener);
        minus.setOnClickListener(calcListener);
        muntiply.setOnClickListener(calcListener);
        devide.setOnClickListener(calcListener);
 //       percent.setOnClickListener(calcListener);
        dot.setOnClickListener(calcListener);
        ac.setOnClickListener(calcListener);
        equals.setOnClickListener(calcListener);
    }


}
