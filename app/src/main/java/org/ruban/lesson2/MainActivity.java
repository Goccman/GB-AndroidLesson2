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
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btnPlus,
            btnRav, btnMinus, btnDel, btnDot, btnUmn;
    boolean clear_flag;
    private String str;
    public static String INDICATOR = "INDICATOR";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
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
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnRav.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnUmn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String str = indicator.getText().toString();
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
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    indicator.setText("");
                }
                indicator.setText(str + ((Button) view).getText());
                break;
            case R.id.button_plus:
            case R.id.button_minus:
            case R.id.button_del:
            case R.id.button_umn:
                if (clear_flag) {
                    clear_flag = false;
                    indicator.setText("");
                }
                indicator.setText(str + " " + ((Button) view).getText() + " ");
                break;

            case R.id.button_rav:
                getResult();
                break;

        }
    }

    private void getResult() {
        String s = indicator.getText().toString();
        if (s == null || s.equals("")) {
            return;
        }
        if (!s.contains("")) {
            return;
        }
        if (clear_flag) {
            clear_flag = false;
            return;
        }
        clear_flag = true;

        String str1 = s.substring(0, s.indexOf("")); // Получить символ перед оператором
        String str_y = s.substring(s.indexOf("") + 1, s.indexOf("") + 2); // Получаем оператор
        String str2 = s.substring(s.indexOf("") + 3); // Получить символ после оператора

        double result = 0;
        if (!str1.equals("") && !str2.equals("")) {
            double num1 = Double.parseDouble(str1);
            double num2 = Double.parseDouble(str2);

            if (str_y.equals("+")) {
                result = num1 + num2;
            } else if (str_y.equals("-")) {
                result = num1 - num2;
            } else if (str_y.equals("/")) {
                if (num2 == 0) {
                    result = 0;
                } else {
                    result = num1 / num2;
                }
            } else if (str_y.equals("*")) {
                result = num1 * num2;
            }
            if (!str1.contains(".") && !str2.contains(".") && !s.equals("/")) {
                int k = (int) result;
                indicator.setText(k);
            } else {
                indicator.setText(result + "");
            }
        } else if (!str1.equals("") && str2.equals("")) {
            indicator.setText(s);
        } else if (str1.equals("") && !str2.equals("")) {
            double num2 = Double.parseDouble(str2);
            if (s.equals("+")) {
                result = 0 + num2;
            } else if (s.equals("-")) {
                result = 0 - num2;
            } else if (s.equals("*")) {
                result = 0;
            } else if (s.equals("/")) {
                result = 0;
            }
            if (!str2.contains(".")) {
                int r = (int) result;
                indicator.setText(r + "");
            } else {
                indicator.setText(result + "");
            }
        } else {
            indicator.setText("");
        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INDICATOR, str);
    }

}