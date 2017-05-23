package com.asifsid88.myexpense.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

    static class ViewHolder {
        public TextView text;
    }

    public ExpenseAdapter(Activity context, List<Expense> expenseList) {
        super(context, R.layout.activity_main, expenseList);
        this.context = context;
        this.expenseList = expenseList;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.activity_main, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) view.findViewById(R.id.label);
            view.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.text.setText("this is the position:== " + expenseList.get(position));

        return view;
    }

    /*
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null) {
            LayoutInflater inflater = context
        }

    }*/
}
