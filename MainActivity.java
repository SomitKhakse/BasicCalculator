package com.example.democalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button add;
    private Button mul;
    private Button div;
    private Button sub;
    private Button sign;
    private Button point;
    private Button clear;
    private Button del;
    private Button percent;
    private Button equal;
    private TextView data;
    private TextView result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = 'X';
    private final char DIVIDE = '/';
    private final char PERCENTAGE = '%';
    private final char EQUALS = '0';
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText(data.getText().toString()+ "1" );
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText(data.getText().toString()+ "2" );
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText(data.getText().toString()+ "3" );
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText(data.getText().toString()+ "4" );
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText(data.getText().toString()+ "5" );
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText(data.getText().toString()+ "6" );
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText(data.getText().toString()+ "7" );
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText(data.getText().toString()+ "8" );
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText(data.getText().toString()+ "9" );
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText(data.getText().toString()+ "0" );
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                result.setText(String.valueOf(val1)+ "+");
                data.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(val1)+ "-");
                data.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(val1)+ "X");
                data.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVIDE;
                result.setText(String.valueOf(val1)+ "/");
                data.setText(null);
            }
        });


        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText(data.getText().toString()+ "." );
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = PERCENTAGE;
                result.setText(String.valueOf(val1)+ "%");
                data.setText(null);
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText("-" +data.getText().toString());
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                data.setText(null);
                result.setText(null);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.getText().length() > 0) {
                    CharSequence name = data.getText().toString();
                    data.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    data.setText(null);
                    result.setText(null);
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQUALS;
                result.setText(result.getText().toString()+ String.valueOf(val2)+ "="+ String.valueOf(val1));
                data.setText(null);
            }
        });



    }

    private void setupUIViews() {

        one = (Button)findViewById(R.id.button1);
        two = (Button)findViewById(R.id.button2);
        three = (Button)findViewById(R.id.button3);
        four = (Button)findViewById(R.id.button4);
        five = (Button)findViewById(R.id.button5);
        six = (Button)findViewById(R.id.button6);
        seven = (Button)findViewById(R.id.button7);
        eight = (Button)findViewById(R.id.button8);
        nine = (Button)findViewById(R.id.button9);
        zero = (Button)findViewById(R.id.button0);
        add = (Button)findViewById(R.id.buttonPlus);
        mul = (Button)findViewById(R.id.buttonMultiply);
        div = (Button)findViewById(R.id.buttonDivide);
        sub = (Button)findViewById(R.id.buttonSubtract);
        sign = (Button)findViewById(R.id.buttonSign);
        point = (Button)findViewById(R.id.buttonPoint);
        clear = (Button)findViewById(R.id.buttonC);
        del = (Button)findViewById(R.id.buttonDel);
        percent = (Button)findViewById(R.id.buttonPercent);
        equal = (Button)findViewById(R.id.buttonEqual);
        data = (TextView) findViewById(R.id.data);
        result = (TextView) findViewById(R.id.result);









    }

    private void compute() {
        if(!Double.isNaN(val1)) {
            val2 = Double.parseDouble(data.getText().toString());

            switch(ACTION) {
                case ADDITION: val1 = val1+val2;
                               break;
                case SUBTRACTION: val1 = val1-val2;
                                   break;
                case MULTIPLICATION: val1 = val1*val2;
                                     break;
                case DIVIDE: val1 = val1/val2;
                             break;
                case PERCENTAGE: val1= (val1/val2)*100;
                                 break;
                case EQUALS:
                            break;
            }
        }

        else {
            val1 = Double.parseDouble(data.getText().toString());
        }
    }
}
