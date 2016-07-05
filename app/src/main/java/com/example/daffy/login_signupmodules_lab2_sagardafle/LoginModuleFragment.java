package com.example.daffy.login_signupmodules_lab2_sagardafle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by daffy on 6/30/16.
 */



public class LoginModuleFragment extends Fragment {
    public static View loginview;
    private static Button loginbtn, registerbtn;
    private static FragmentManager loginfragmentManager;
    private static EditText emailid,pass,fullname;


    public LoginModuleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loginview = inflater.inflate(R.layout.loginfragment, container, false);
        loginfragmentManager = getActivity().getSupportFragmentManager();

        loginbtn = (Button) loginview.findViewById (R.id.loginBtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Login ", " clicked");

                emailid = (EditText) loginview.findViewById(R.id.login_emailid);
                pass = (EditText) loginview.findViewById(R.id.login_password);
                Log.d("emailid ", emailid.getText().toString());
                Log.d("pass ", pass.getText().toString());

                LoginActivity loginctivity = new LoginActivity();

                if(loginctivity.helper.userExists(emailid.getText().toString(),pass.getText().toString())){

                    String userfullname = loginctivity.helper.getUserName(emailid.getText().toString());
                    Log.d("Retrieved userfullname", userfullname);
                    Intent i = new Intent(getActivity(),InitialSetupActivity.class);
                    i.putExtra("username", userfullname);
                    startActivity(i);
                    /*
                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_container, new InitialSetupModuleFragment(), "InitialModuleFragment");
                    ft.commit();
                    */
                } else{
                    Toast.makeText(getActivity(), "Email and/or password don't match.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });



        registerbtn = (Button) loginview.findViewById (R.id.signupBtn);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new SignUpModuleFragment(), "SignUpFragmentTag");
                ft.commit();
            }
        });

        return loginview;
    }






}
