package com.asifsid88.myexpense.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class ExpenseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getApplicationContext(), "hellossss", LENGTH_SHORT).show();
    }

}
