package com.example.calculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    ImageButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn_clear,btn_back,btn_modulo,btn_divide,btn_multiply,btn_subtract,btn_addition,btn_equal,btn_dot;
    TextView textView1, textView2;
    String val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.inputTxt);
        textView2 = findViewById(R.id.outputTxt);

        btn0 = findViewById(R.id.zero);
        btn1 = findViewById(R.id.one);
        btn2 = findViewById(R.id.two);
        btn3 = findViewById(R.id.three);
        btn4 = findViewById(R.id.four);
        btn5 = findViewById(R.id.five);
        btn6 = findViewById(R.id.six);
        btn7 = findViewById(R.id.seven);
        btn8 = findViewById(R.id.eight);
        btn9 = findViewById(R.id.nine);

        btn_clear = findViewById(R.id.clear);
        btn_back = findViewById(R.id.back);
        btn_modulo = findViewById(R.id.modulo);
        btn_divide = findViewById(R.id.division);
        btn_multiply = findViewById(R.id.multiply);
        btn_subtract = findViewById(R.id.subtract);
        btn_addition = findViewById(R.id.add);
        btn_equal = findViewById(R.id.equalsto);
        btn_dot = findViewById(R.id.dot);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                textView1.setText(val + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                textView1.setText(val + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                textView1.setText(val + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                textView1.setText(val + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                textView1.setText(val + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                textView1.setText(val + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                textView1.setText(val + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                textView1.setText(val + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                textView1.setText(val + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                textView1.setText(val + "9");
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("");
                textView2.setText("");
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                if(val.isEmpty()){
                    textView1.setText("");
                    textView2.setText("");
                }
                else {
                    textView1.setText(val.substring(0, val.length() - 1));
                }
            }
        });
        btn_modulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                textView1.setText(val + "%");
            }
        });
        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                textView1.setText(val + "÷");
            }
        });
        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                textView1.setText(val + "×");
            }
        });
        btn_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                textView1.setText(val + "-");
            }
        });
        btn_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                textView1.setText(val + "+");
            }
        });
        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();

                val = val.replaceAll("÷", "/");
                val = val.replaceAll("×", "*");
                val = val.replaceAll("%", "/100");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                Scriptable scriptable = rhino.initStandardObjects();
                String total = rhino.evaluateString(scriptable,val,"Javascript",1,null).toString();

                textView2.setText(total);
            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = textView1.getText().toString();
                if(val.length() > 0){
                    textView1.setText(val + ".");
                }
                else{
                    textView1.setText(val + "0.");
                }
            }
        });


    }
}