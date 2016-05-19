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
/**
 * Created by Jonathan on 5/17/16.
 */
public class TipsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        //declarations
        final TextView tipsTitle = (TextView) findViewById(R.id.tips_title);
        final TextView tipsText = (TextView) findViewById(R.id.tips_text);
        final Button lightingButton = (Button) findViewById(R.id.lighting_button);
        final Button heatingButton = (Button) findViewById(R.id.heating_button);
        final Button cookingButton = (Button) findViewById(R.id.cooking_button);

        lightingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               tipsTitle.setText(R.string.lighting_title);
               tipsText.setText(R.string.lighting_tips);
            }
        });

        heatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipsTitle.setText(R.string.heating_title);
                tipsText.setText(R.string.heating_tips);
            }
        });
        cookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipsTitle.setText(R.string.cooking_title);
                tipsText.setText(R.string.cooking_tips);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

