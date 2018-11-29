package com.example.dailyrium.androidstarterapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddIncome extends AppCompatActivity {

    private TextView mLabelResult;
    private Spinner mCategorySelection;
    private Button buttonAddIncome, buttonReset;
    private EditText mIncomeDate;
    private EditText mNote;

    private View.OnClickListener mOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            showAlertDialogButtonClicked("something clicked!");
            // Code here executes on main thread after user presses button
            switch(v.getId()) {
                case R.id.buttonReset: {
                    AddIncome.this.showAlertDialogButtonClicked("RESET");
                    mLabelResult.setText("RESET");
                    mCategorySelection.setSelection(0);
                    mNote.setText("");
                    mIncomeDate.setText("");
                }
                break;
                case R.id.buttonAddIncome: {
                    mLabelResult.setText("SAVED");
                    AddIncome.this.showAlertDialogButtonClicked("SAVED");
                }
                break;
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

        mLabelResult = findViewById(R.id.labelResult);
        mCategorySelection = findViewById(R.id.categorySelection);
        mIncomeDate = findViewById(R.id.editIncomeDate);
        mNote = findViewById(R.id.editNote);
        buttonAddIncome = findViewById(R.id.buttonAddIncome);
        buttonAddIncome.setOnClickListener(mOnClickListener);
        buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(mOnClickListener);
        this.showAlertDialogButtonClicked("I set all the listeners!");
    }

    @Override
    protected void onResume() {
        Log.d("AddIncome","ENtered onResume");
        super.onResume();
    }
}

