package com.asifsid88.myexpense.app.component;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by mhussaa on 5/31/17.
 */

/**
 * Usage:
 * DatePicker datePicker = new DatePicker(context, editTextResId);
 *
 * Example:
 * DatePicker datePicker = new DatePicker(this, R.id.expense_detail_expense_date);
 *
 * Make sure, editText XML has android:focusable="false" attribute present
 */
public class DatePicker implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private Activity activity;
    private EditText editText;
    private String currentExpenseDate;
    private int day;
    private int month;
    private int year;

    private DatePickerDialog datePickerDialog;

    public DatePicker(Activity activity, int editTextViewId, String currentExpenseDate) {
        this.activity = activity;
        this.editText = (EditText) activity.findViewById(editTextViewId);
        this.editText.setOnClickListener(this);
        this.currentExpenseDate = currentExpenseDate;

        populateDateFields();
        this.datePickerDialog = new DatePickerDialog(activity, this, this.year, this.month, this.day);
    }

    private void populateDateFields() {
        try {
            if(this.currentExpenseDate != null && this.currentExpenseDate.length() > 0) {
                String[] dateFields = this.currentExpenseDate.split("/");
                if(dateFields.length > 2) {
                    this.day = Integer.parseInt(dateFields[0]);
                    this.month = Integer.parseInt(dateFields[1]) - 1;
                    this.year = Integer.parseInt(dateFields[2]);
                } else {
                    setCurrentDateAsDefaultFields();
                }
            } else {
                setCurrentDateAsDefaultFields();
            }
        } catch(Exception e) {
            Log.e("DatePicker.java", "Exception while fetching date from ExpenseDate EditTextField - Setting today's date as default", e);
            setCurrentDateAsDefaultFields();
        }
    }

    private void setCurrentDateAsDefaultFields() {
        Calendar today = Calendar.getInstance(TimeZone.getDefault());
        this.day = today.get(Calendar.DAY_OF_MONTH);
        this.month = today.get(Calendar.MONTH) + 1;
        this.year = today.get(Calendar.YEAR);
    }

    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        updateDisplay();
    }

    @Override
    public void onClick(View v) {
        this.datePickerDialog.show();
    }

    private void updateDisplay() {
        this.editText.setText(new StringBuilder()
                .append(day).append("/")
                .append(month + 1).append("/")
                .append(year).append(" "));
    }
}
