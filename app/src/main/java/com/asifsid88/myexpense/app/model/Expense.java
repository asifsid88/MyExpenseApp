package com.asifsid88.myexpense.app.model;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by mhussaa on 5/21/17.
 */
@Data
public class Expense implements Serializable {
    private String expenseId;
    private String expenseType;
    private String amount;
    private String description;
    private String comment;
    private String date;

    public String getDisplayAmount() {
        return "Rs. " + this.amount;
    }

    public String getExpenseDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction done on <strong>" + getDate() + "</strong> ");
        sb.append("using <strong>" + getExpenseType() + "</strong><br/>");
        sb.append("Description: " + getDescription());

        return sb.toString();
    }
}
