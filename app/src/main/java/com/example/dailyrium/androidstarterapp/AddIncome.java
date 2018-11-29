package com.example.dailyrium.androidstarterapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;
import android.util.Log;

public class AddIncome extends AppCompatActivity implements View.OnClickListener {

    TextView mLabelResult = (TextView) findViewById(R.id.labelResult);
    Spinner mCategorySelection = (Spinner) findViewById(R.id.categorySelection);
    Button buttonAddIncome, buttonReset;
    EditText mIncomeDate = (EditText) findViewById(R.id.editIncomeDate);
    EditText mNote = (EditText) findViewById(R.id.editNote);

    public void onClick(View v) {
        showAlertDialogButtonClicked("something clicked!");
        // Code here executes on main thread after user presses button
        switch(v.getId()) {
            case R.id.buttonReset: {
                this.showAlertDialogButtonClicked("RESET");
                mLabelResult.setText("RESET");
                mCategorySelection.setSelection(0);
                mNote.setText("");
                mIncomeDate.setText("");
            }
            case R.id.buttonAddIncome: {
                mLabelResult.setText("SAVED");
                this.showAlertDialogButtonClicked("RESET");
            }
        }

    };

    public void showAlertDialogButtonClicked(String textToShow) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("My title");
        builder.setMessage(textToShow);

        // add a button
        builder.setPositiveButton("OK", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("AddIncome","ENtered onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_income);
        this.showAlertDialogButtonClicked("I am about to set all the listeners!");

        buttonAddIncome = (Button) findViewById(R.id.buttonAddIncome);
        buttonAddIncome.setOnClickListener(this);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(this);
        this.showAlertDialogButtonClicked("I set all the listeners!");
    }

    @Override
    protected void onResume() {
        Log.d("AddIncome","ENtered onResume");
        super.onResume();
       // setContentView(R.layout.add_income);
        this.showAlertDialogButtonClicked("I am about to set all the listeners!");

        buttonAddIncome = (Button) findViewById(R.id.buttonAddIncome);
        buttonAddIncome.setOnClickListener(this);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(this);
        this.showAlertDialogButtonClicked("I set all the listeners!");
    }
}

