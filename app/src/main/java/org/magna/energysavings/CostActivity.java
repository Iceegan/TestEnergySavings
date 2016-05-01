package org.magna.energysavings;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

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
        EditText powerEdit = (EditText) findViewById(R.id.power_edit);
        Spinner powerSpinner = (Spinner)findViewById(R.id.power_spinner);
        EditText billEdit = (EditText) findViewById(R.id.bill_edit);
        Spinner billSpinner = (Spinner) findViewById(R.id.bill_spinner);
        Button calcButton = (Button) findViewById(R.id.calc_button);
        final TextView cOuptut = (TextView) findViewById(R.id.c_output);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double time = 0;
                if(timeEdit.length() > 0){
                    time = Double.parseDouble(timeEdit.getText().toString());
                }



                String timeUnit = timeSpinner.getSelectedItem().toString();
                cOuptut.setText(timeUnit);
            }
        });
    }
}
