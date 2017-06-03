package com.asifsid88.myexpense.app.model;

import lombok.Data;

/**
 * Created by mhussaa on 6/3/17.
 */
@Data
public class Error implements IModel {
    private String statusCode;
    private String statusMessage;
}
