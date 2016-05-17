package org.magna.energysavings;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment{

    private AlertDialog mDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        //Handle Buttons here...
        View settingsButton = rootView.findViewById(R.id.settings_button);
        View costsButton = rootView.findViewById(R.id.costs_button);
        View tipsButton = rootView.findViewById(R.id.tips_button);

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                getActivity().startActivity(intent);
            }
        });
        tipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TipsActivity.class);
                getActivity().startActivity(intent);
            }
        });
        costsButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               Intent intent = new Intent(getActivity(), CostActivity.class);
               getActivity().startActivity(intent);
           }
        });
        return rootView;
    }
    public void onPause(){
        super.onPause();
        //get rid of about dialog if it's still up
        if(mDialog != null) mDialog.dismiss();
    }
}
