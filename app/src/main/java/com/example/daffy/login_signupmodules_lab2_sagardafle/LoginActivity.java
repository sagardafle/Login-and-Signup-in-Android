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

/**
 * Created by daffy on 7/1/16.
 */
public class LoginActivity extends FragmentActivity {
    private static View loginview;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myfragmentcontainer);  //+++++++++++++++WORKING+++++++++++++++++++=

        LoginModuleFragment loginmodulefragment = new LoginModuleFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, loginmodulefragment).commit();


}


}
