package com.asifsid88.myexpense.app.adapter;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.asifsid88.myexpense.app.R;
import com.asifsid88.myexpense.app.model.Expense;

import java.util.List;

/**
 * Created by mhussaa on 5/21/17.
 */

public class ExpenseAdapter extends ArrayAdapter<Expense> {

    private final Activity context;
    private final List<Expense> expenseList;

    private static class ExpenseViewHolder {
        TextView expenseAmount;
        TextView expenseDetail;
    }

    public ExpenseAdapter(Activity context, List<Expense> expenseList) {
        super(context, R.layout.individual_expense, expenseList);
        this.context = context;
        this.expenseList = expenseList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        ExpenseViewHolder expenseViewHolder;
        if(view == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.individual_expense, null);

            expenseViewHolder = new ExpenseViewHolder();
            expenseViewHolder.expenseAmount = (TextView) view.findViewById(R.id.expense_amount);
            expenseViewHolder.expenseDetail = (TextView) view.findViewById(R.id.expense_detail);
            view.setTag(expenseViewHolder);
        } else {
            expenseViewHolder = (ExpenseViewHolder) view.getTag();
        }

        Expense expense = expenseList.get(position);
        expenseViewHolder.expenseAmount.setText(expense.getDisplayAmount());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            expenseViewHolder.expenseDetail.setText(Html.fromHtml(expense.getExpenseDetail(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            expenseViewHolder.expenseDetail.setText(Html.fromHtml(expense.getExpenseDetail()));
        }

        return view;
    }
}
