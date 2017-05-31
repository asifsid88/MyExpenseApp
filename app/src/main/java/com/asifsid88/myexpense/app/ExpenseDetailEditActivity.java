package com.asifsid88.myexpense.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.asifsid88.myexpense.app.component.DatePicker;

public class ExpenseDetailEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_detail_edit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DatePicker datePicker = new DatePicker(this, R.id.expense_detail_expense_date);
    }

    public void close(View view) {
        this.onBackPressed();
    }

    public void update(View view) {

    }
}
