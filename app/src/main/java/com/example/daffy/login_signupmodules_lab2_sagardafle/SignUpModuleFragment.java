package com.example.daffy.login_signupmodules_lab2_sagardafle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by daffy on 7/1/16.
 */
public class SignUpModuleFragment extends Fragment {

    private static View signupview;
    private static FragmentManager registerfragmentManager;


    /**
     * Sign-up form fields
     */

    private static EditText fullName, emailId, mobileNumber, age, password, confirmPassword;

    private static Button registerbutton;

    public SignUpModuleFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        signupview = inflater.inflate(R.layout.signupmodulefragment, container, false);
        registerfragmentManager = getActivity().getSupportFragmentManager();
        getUserEnteredDetails();
        Log.d("fullName",fullName.getText().toString());
        registerbutton = (Button) signupview.findViewById(R.id.signUpBtn);
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        UserData userdata = new UserData();
                userdata.setFullname(fullName.getText().toString());
                userdata.setEmailid(emailId.getText().toString());
                userdata.setAge(Integer.parseInt(age.getText().toString()));
                userdata.setMobile(mobileNumber.getText().toString());
                userdata.setPassword(password.getText().toString());


               // helper.insertData(userdata);

//                registerfragmentManager
//                        .beginTransaction()
//                        .replace(R.id.frameContainer, new InitialSetupModuleFragment(),
//                                "InitialSetup").commit();

            }
        });
        return signupview;
    }

    public void getUserEnteredDetails(){

        fullName = (EditText) signupview.findViewById(R.id.fullName);
        emailId = (EditText) signupview.findViewById(R.id.userEmailId);
        mobileNumber = (EditText) signupview.findViewById(R.id.mobileNumber);
        age = (EditText) signupview.findViewById(R.id.age);
        password = (EditText) signupview.findViewById(R.id.password);
        confirmPassword = (EditText) signupview.findViewById(R.id.confirmPassword);

    }
}
