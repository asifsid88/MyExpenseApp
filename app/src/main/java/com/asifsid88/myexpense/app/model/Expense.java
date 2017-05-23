package com.asifsid88.myexpense.app.model;

import lombok.Data;

/**
 * Created by mhussaa on 5/21/17.
 */
@Data
public class Expense {
    private String expenseType;
    private String amount;
    private String description;
    private String comment;
}
