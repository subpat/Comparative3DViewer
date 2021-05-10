package com.subhadeep.AndroidApp.view.activity2_extra;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import androidx.annotation.ArrayRes;

public class ConfigureSpinner {

    public static void perform(Context context, Spinner spinner, @ArrayRes int arrayRes, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (spinner != null) {
            setAdapterToSpinner(context, spinner, arrayRes);
            spinner.setOnItemSelectedListener(onItemSelectedListener);
        }
    }

    private static void setAdapterToSpinner(Context context, Spinner spinner, @ArrayRes int arrayRes) {
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(context, arrayRes, android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }



    public static void perform(Context context, Spinner spinner, List<String> stringList, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (spinner != null) {
            setAdapterToSpinner(context, spinner, stringList);
            spinner.setOnItemSelectedListener(onItemSelectedListener);
        }
    }

    private static void setAdapterToSpinner(Context context, Spinner spinner, List<String> stringList) {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item,  stringList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

}
