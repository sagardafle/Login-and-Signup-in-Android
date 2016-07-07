package com.example.daffy.login_signupmodules_lab2_sagardafle;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.Fragment;
import android.widget.EditText;

/**
 * Created by daffy on 7/1/16.
 */
public class LoginActivity extends FragmentActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    private static EditText emailid,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.myfragmentcontainer);

        LoginModuleFragment loginmodulefragment = new LoginModuleFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, loginmodulefragment).commit();

}

    @Override
    public void onSaveInstanceState(Bundle outState)
    {

        emailid = (EditText) LoginModuleFragment.loginview.findViewById(R.id.login_emailid);
        outState.putString("emailid", emailid.getText().toString());
        pass = (EditText) LoginModuleFragment.loginview.findViewById(R.id.login_password);
        outState.putString("password", pass.getText().toString());
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore last state for checked position.

            Log.d("HEREEEEEEEEE","+++++++++");
            Log.d("emailid+++++++++",emailid.getText().toString());
            Log.d("password+++++++++",pass.getText().toString());
            emailid.setText(savedInstanceState.getString("emailid"));
            pass.setText(savedInstanceState.getString("password"));
            Log.d("Received emailid+++++++",savedInstanceState.getString("emailid"));

        }
    }



}
