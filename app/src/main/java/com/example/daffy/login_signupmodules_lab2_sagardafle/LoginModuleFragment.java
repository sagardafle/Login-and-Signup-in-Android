package com.example.daffy.login_signupmodules_lab2_sagardafle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by daffy on 6/30/16.
 */



public class LoginModuleFragment extends Fragment {
    private static View loginview;
    private static Button loginbtn, registerbtn;
    private static FragmentManager loginfragmentManager;


    public LoginModuleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loginview = inflater.inflate(R.layout.loginfragment, container, false);
        loginfragmentManager = getActivity().getSupportFragmentManager();
        registerbtn = (Button) loginview.findViewById(R.id.signupBtn);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("myTag" , "/ pressed");
                loginfragmentManager
                        .beginTransaction()
                        //.setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                        .replace(R.id.frameContainer, new SignUpModuleFragment(),
                                "SignUpModuleFragment").commit();



            }
        });




        return loginview;
    }


}
