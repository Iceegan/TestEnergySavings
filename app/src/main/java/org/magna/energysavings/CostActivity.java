package org.magna.energysavings;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CostActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        //declarations
        final EditText timeEdit = (EditText) findViewById(R.id.time_edit);
        final Spinner timeSpinner = (Spinner) findViewById(R.id.time_spinner);
        final EditText powerEdit = (EditText) findViewById(R.id.power_edit);
        final Spinner powerSpinner = (Spinner)findViewById(R.id.power_spinner);
        final EditText billEdit = (EditText) findViewById(R.id.bill_edit);
        final Spinner billSpinner = (Spinner) findViewById(R.id.bill_spinner);
        final Button calcButton = (Button) findViewById(R.id.calc_button);
        final TextView cOuptut = (TextView) findViewById(R.id.c_output);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                double time = 0;
                if(timeEdit.length() > 0){
                    time = Double.parseDouble(timeEdit.getText().toString());
                }
                String timeUnit = timeSpinner.getSelectedItem().toString();

                double power = 0;
                if(powerEdit.length() > 0){
                    power = Double.parseDouble(powerEdit.getText().toString());
                }
                String powerUnit = powerSpinner.getSelectedItem().toString();

                double bill = 0;
                if(billEdit.length() > 0){
                    bill = Double.parseDouble(billEdit.getText().toString());
                }
                String billUnit = billSpinner.getSelectedItem().toString();


                cOuptut.setText(calculate(time, power, bill, timeUnit, powerUnit, billUnit));
            }
        });
    }

    public String calculate(double time, double power, double bill, String timeUnit, String powerUnit, String billUnit){
        double powerPerDay = time*power;
        if(timeUnit.equals("Minutes")){
            powerPerDay /= 60;
        }
        else if(timeUnit.equals("Seconds")){
            powerPerDay /= 3600;
        }
        if(powerUnit.equals("Watts")){
            powerPerDay/=1000;
        }
        double powerPerMonth = powerPerDay*30;
        double cost = powerPerMonth*bill;

        DecimalFormat df = new DecimalFormat("#.00");

        String result = "Please Use Every Field";

        if(billUnit.equals("Dollars/kWh")){
            return "$ " + df.format(cost);
        }
        if(billUnit.equals("Euros/kWh")){
            return "\u20AC" + df.format(cost);
        }

        return "Fill out all fields";
    }
}
