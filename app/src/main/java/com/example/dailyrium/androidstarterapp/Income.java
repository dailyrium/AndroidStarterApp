package com.example.dailyrium.androidstarterapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;

public class Income extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.transactions:
                    mTextMessage.setText(item.getTitle());
                    return true;
                case R.id.add_income:
                    setContentView(R.layout.add_income);
                    Log.d("Main","Entering add_income");
                    return true;
                case R.id.add_expense:
                    mTextMessage.setText(item.getTitle());
                    return true;
            }
            return false;
        }
    };

    public void showAlertDialogButtonClicked(Income view) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("My title");
        builder.setMessage("This is my message.");

        // add a button
        builder.setPositiveButton("OK", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Main","ENtered onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        this.showAlertDialogButtonClicked(this);
    }

}
