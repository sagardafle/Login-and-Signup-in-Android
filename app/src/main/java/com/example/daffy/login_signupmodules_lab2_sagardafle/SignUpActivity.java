package com.example.daffy.login_signupmodules_lab2_sagardafle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by daffy on 7/1/16.
 */
public class SignUpActivity extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupmodulefragment);

    }
}
