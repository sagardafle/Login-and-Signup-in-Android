package com.example.daffy.login_signupmodules_lab2_sagardafle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by daffy on 6/30/16.
 */



public class LoginModuleFragment extends Fragment {
    private static View loginview;

    public LoginModuleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loginview = inflater.inflate(R.layout.loginfragment, container, false);

        return loginview;
    }
}
