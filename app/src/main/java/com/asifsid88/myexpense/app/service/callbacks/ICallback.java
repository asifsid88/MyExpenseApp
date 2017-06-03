package com.asifsid88.myexpense.app.service.callbacks;

import com.asifsid88.myexpense.app.model.IModel;

/**
 * Created by mhussaa on 6/3/17.
 */

public interface ICallback {
    void execute(boolean success, IModel result);
}
