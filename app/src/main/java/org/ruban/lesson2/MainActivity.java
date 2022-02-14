package org.ruban.lesson2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView indicator;
    private Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0,btnPlus,
            btnRav,btnMinus,btnDel,btnDot,btnUmn;
    boolean clear_flag;
    private String str;
    public static String INDICATOR = "INDICATOR";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null)
        {
            str = savedInstanceState.getString(INDICATOR, null);
        }

        btn_0 = findViewById(R.id.button_0);
        btn_1 = findViewById(R.id.button_1);
        btn_2 = findViewById(R.id.button_2);
        btn_3 = findViewById(R.id.button_3);
        btn_4 = findViewById(R.id.button_4);
        btn_5 = findViewById(R.id.button_5);
        btn_6 = findViewById(R.id.button_6);
        btn_7 = findViewById(R.id.button_7);
        btn_8 = findViewById(R.id.button_8);
        btn_9 = findViewById(R.id.button_9);
        btnPlus = findViewById(R.id.button_plus);
        btnRav = findViewById(R.id.button_rav);
        btnMinus = findViewById(R.id.button_minus);
        btnDel = findViewById(R.id.button_del);
        btnDot = findViewById(R.id.button_dot);
        btnUmn = findViewById(R.id.button_umn);

        indicator = findViewById(R.id.indicator);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener (this);
        btn_2.setOnClickListener (this);
        btn_3.setOnClickListener (this);
        btn_4.setOnClickListener (this);
        btn_5.setOnClickListener (this);
        btn_6.setOnClickListener (this);
        btn_7.setOnClickListener (this);
        btn_8.setOnClickListener (this);
        btn_9.setOnClickListener (this);
        btnPlus.setOnClickListener (this);
        btnRav.setOnClickListener (this);
        btnMinus.setOnClickListener (this);
        btnDel.setOnClickListener (this);
        btnDot.setOnClickListener (this);
        btnUmn.setOnClickListener (this);



    }

    @Override
    public void onClick(View view) {
        str = indicator.getText().toString();
        switch (view.getId()) {
            case R.id.button_0:
            case R.id.button_1:
            case R.id.button_2:
            case R.id.button_3:
            case R.id.button_4:
            case R.id.button_5:
            case R.id.button_6:
            case R.id.button_7:
            case R.id.button_8:
            case R.id.button_9:
            case R.id.button_dot:
            case R.id.button_plus:
            case R.id.button_rav:
            case R.id.button_minus:
            case R.id.button_del:
            case R.id.button_umn:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    indicator.setText("");
                }
                indicator.setText(str + ((Button) view).getText());
                break;



        }
    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INDICATOR, str);
    }

}