package edu.qc.seclass.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    EditText checkAmountValue;
    EditText partySizeValue;
    Button buttonCompute;
    EditText fifteenPercentTipValue, twentyPercentTipValue, twentyfivePercentTipValue,
            fifteenPercentTotalValue,twentyPercentTotalValue,twentyfivePercentTotalValue;
    int checkAmount, partySize, fifteenPercentTip,twentyPercentTip,
        twentyfivepercentTip,afterSplit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(edu.example.a10ngawang.tipcalculator.R.layout.activity_tip_calculator);
        checkAmountValue = findViewById(edu.example.a10ngawang.tipcalculator.R.id.checkAmountValue);
        partySizeValue = findViewById(edu.example.a10ngawang.tipcalculator.R.id.partySizeValue);
        buttonCompute = findViewById(edu.example.a10ngawang.tipcalculator.R.id.buttonCompute);
        fifteenPercentTipValue = findViewById(edu.example.a10ngawang.tipcalculator.R.id.fifteenPercentTipValue);
        twentyPercentTipValue =findViewById(edu.example.a10ngawang.tipcalculator.R.id.twentyPercentTipValue);
        twentyfivePercentTipValue =findViewById(edu.example.a10ngawang.tipcalculator.R.id.twentyfivePercentTipValue);
        fifteenPercentTotalValue =findViewById(edu.example.a10ngawang.tipcalculator.R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue =findViewById(edu.example.a10ngawang.tipcalculator.R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue =findViewById(edu.example.a10ngawang.tipcalculator.R.id.twentyfivePercentTotalValue);



        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = checkAmountValue.getText().toString();
                String party = partySizeValue.getText().toString();

                if(amount.length()==0 || party.length()==0){
                    display();
                }else {
                    checkAmount = Integer.parseInt(amount);
                    partySize = Integer.parseInt(party);

                    if (partySize == 0) {
                        afterSplit = checkAmount;
                    } else {
                        afterSplit = (checkAmount / partySize);
                    }

                    fifteenPercentTipValue.setText(String.valueOf((int) (Math.ceil(afterSplit * 0.15))));
                    fifteenPercentTip = Integer.parseInt(fifteenPercentTipValue.getText().toString());

                    twentyPercentTipValue.setText(String.valueOf((int) (Math.ceil(afterSplit * 0.20))));
                    twentyPercentTip = Integer.parseInt(twentyPercentTipValue.getText().toString());

                    twentyfivePercentTipValue.setText(String.valueOf((int) (Math.ceil(afterSplit * 0.25))));
                    twentyfivepercentTip = Integer.parseInt(twentyfivePercentTipValue.getText().toString());

                    fifteenPercentTotalValue.setText(String.valueOf(afterSplit + fifteenPercentTip));
                    twentyPercentTotalValue.setText(String.valueOf(afterSplit + twentyPercentTip));
                    twentyfivePercentTotalValue.setText(String.valueOf(afterSplit + twentyfivepercentTip));
                }
            }
        });

        checkAmountValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAmountValue.setText("");
            }
        });

        partySizeValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                partySizeValue.setText("");
            }
        });
    }

    public void display(){
        Toast.makeText(this,"Empty or incorrect value(s)!",Toast.LENGTH_LONG).show();
    }

   /* public boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            //You can send the message which you want to show to your users here.
            return false;
        }
    }*/
}
