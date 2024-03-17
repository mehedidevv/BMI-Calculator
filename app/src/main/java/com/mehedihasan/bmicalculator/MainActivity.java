package com.mehedihasan.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weightET,heightET;
    Button resultBTN, resetBTN;
    TextView detailTXT,resultTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connection With XML ID
        connection();
      //OnClick Listner  to Result Button
        resultBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strweight=weightET.getText().toString();
                String strheight=heightET.getText().toString();

                if(strweight.equals("")){
                    weightET.setError("Please Enter Your Weight ");
                    weightET.requestFocus();
                    return;
                }
                if(strheight.equals("")){
                    heightET.setError("Please Enter Your Height");
                    heightET.requestFocus();
                    return;
                }

                float weight = Float.parseFloat(strweight);
                float height = Float.parseFloat(strheight)/100;

                // BMICalculate Is A Method
                float bmiVlaue = BMICalculate(weight,height);

                //interpreteBMI is a Method
                detailTXT.setText(interpreteBMI(bmiVlaue));
                resultTXT.setText("BMI= "+bmiVlaue);

            }
        });
     //ON Click Listner to Reset Button
        resetBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heightET.setText("");
                weightET.setText("");
                detailTXT.setText("");
                resultTXT.setText("");

            }
        });

    }

    private void connection() {
        weightET=findViewById(R.id.weightET);
        heightET=findViewById(R.id.heightET);
        resultBTN=findViewById(R.id.resultBTN);
        resetBTN=findViewById(R.id.resetBtn);
        detailTXT=findViewById(R.id.detailTXT);
        resultTXT=findViewById(R.id.resultTXT);
    }
    public float BMICalculate(float weight,float height){
        return weight / (height * height);
    }
    public String interpreteBMI(float bmiValue){
        if( bmiValue <16){
            return "Servely Underweight";
        }
        else if(bmiValue <18.5){
            return "Underweight";
        }
        else if(bmiValue < 25){
            return "Normal";
        }
        else if(bmiValue <30){
            return "OverWeight";
        }
        else
            return "Obese";
    }
}