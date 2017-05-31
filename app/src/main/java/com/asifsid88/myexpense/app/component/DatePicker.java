package com.asifsid88.myexpense.app.component;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
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

    private Context context;
    private EditText editText;
    private int day;
    private int month;
    private int year;

    public DatePicker(Context context, int editTextViewID) {
        Activity act = (Activity)context;
        this.editText = (EditText)act.findViewById(editTextViewID);
        this.editText.setOnClickListener(this);
        this.context = context;
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
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        DatePickerDialog dialog = new DatePickerDialog(context, this,
                                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                                        calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    private void updateDisplay() {
        editText.setText(new StringBuilder()
                // Month is 0 based so add 1
                .append(day).append("/").append(month + 1).append("/").append(year).append(" "));
    }
}
