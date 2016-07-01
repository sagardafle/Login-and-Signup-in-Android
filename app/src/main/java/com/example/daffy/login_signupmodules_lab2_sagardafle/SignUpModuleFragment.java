package com.example.daffy.login_signupmodules_lab2_sagardafle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by daffy on 7/1/16.
 */
public class SignUpModuleFragment extends Fragment {
    private static View signupview;

    public SignUpModuleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        signupview = inflater.inflate(R.layout.signupmodulefragment, container, false);
        return signupview;
    }
}
