package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity{
    private TextView tvMath;
    private int[] idNumber={
            R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,
            R.id.btn7,R.id.btn8,R.id.btn9
    };
    private int[] idOp={
            R.id.btnDiv,R.id.btnPlus,R.id.btnSub,R.id.btnMul
    };
    private int[] idOther={
            R.id.btnCE,R.id.btnC,R.id.btnBS,R.id.btnResult,R.id.btnDot,R.id.btnneg
    };
    Double var1;
    Double var2;
    Double ans;
    Boolean addition = false, subtract = false, multiply = false, divide = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectView();
    }

    public void connectView(){
        tvMath=(TextView) findViewById(R.id.tvMath);
        for (int i = 0; i < idNumber.length; i++){
            findViewById(idNumber[i]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId();
                    for (int i = 0; i < idNumber.length ; i++) {
                        if (id == idNumber[i]) {
                            String text = ((Button) findViewById(id)).getText().toString();


                            if (tvMath.getText().toString().trim().equals("")||tvMath.getText().toString().trim().equals("0")) {
                                tvMath.setText("");
                            }

                            String s=tvMath.getText().toString()+text;
                            Double d=Double.parseDouble(s);
                            tvMath.setText(DecimalFormat.getInstance().format(d).toString());

                            return;
                        }
                    }
                }
            });
        }
        findViewById(R.id.btnCE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMath.setText("0");
                allReset();
            }
        });
        findViewById(R.id.btnC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMath.setText("");
                allReset();
            }
        });
        findViewById(R.id.btnDot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Double.parseDouble(tvMath.getText().toString())!=0)
                {
                    tvMath.append(".");
                }else {
                    tvMath.setText("0.");
                }
            }
        });
        findViewById(R.id.btnBS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=tvMath.getText().toString();
                if(s.length()<=1)
                    tvMath.setText("");
                else{
                    s=s.substring(0,s.length()-1);
                    tvMath.setText(s);
                }

            }
        });
        findViewById(R.id.btnneg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double d=Double.parseDouble(tvMath.getText().toString());
                if(d!=0)
                {
                    Double i = -d;
                    tvMath.setText(DecimalFormat.getInstance().format(i).toString());
                }else {
                    tvMath.setText("-");
                }
            }
        });
        findViewById(R.id.btnPlus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVar1();
                buttonFalse();
                addition = true;
            }
        });
        findViewById(R.id.btnSub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVar1();
                buttonFalse();
                subtract = true;
            }
        });
        findViewById(R.id.btnMul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVar1();
                buttonFalse();
                multiply = true;
            }
        });
        findViewById(R.id.btnDiv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVar1();
                buttonFalse();
                divide = true;
            }
        });
        findViewById(R.id.btnResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var2 = Double.parseDouble(tvMath.getText().toString());
                if(addition){
                    ans = var1 + var2;
                } else if (subtract){
                    ans = var1 - var2;
                } else if (multiply){
                    ans = var1 * var2;
                } else if (divide){
                    ans = var1 / var2;
                } else {
                    ans = ans + 0;
                }
                tvMath.setText(DecimalFormat.getInstance().format(ans).toString());
                addition = false;
                subtract = false;
                multiply = false;
                divide = false;
                allReset();
            }
        });


    }
    public void setVar1(){
        var1 = Double.parseDouble(tvMath.getText().toString());
    }
    public void buttonFalse(){
        findViewById(R.id.btnDiv).setEnabled(false);
        findViewById(R.id.btnMul).setEnabled(false);
        findViewById(R.id.btnPlus).setEnabled(false);
        findViewById(R.id.btnSub).setEnabled(false);
        tvMath.setText("");
    }
    public void allReset(){

        findViewById(R.id.btnDiv).setEnabled(true);
        findViewById(R.id.btnMul).setEnabled(true);
        findViewById(R.id.btnPlus).setEnabled(true);
        findViewById(R.id.btnSub).setEnabled(true);
    }





}