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
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Log.d("HEREEEE", " ++++");
              boolean areFieldsValid = validatefields();
                if(areFieldsValid) {
                    Toast.makeText(getActivity(), "Successfully registered!!!",
                            Toast.LENGTH_LONG).show();

                    UserData userdata = new UserData();
                    userdata.setFullname(fullName.getText().toString());
                    userdata.setEmailid(emailId.getText().toString());
                    userdata.setAge(Integer.parseInt(age.getText().toString()));
                    userdata.setMobile(mobileNumber.getText().toString());
                    userdata.setPassword(password.getText().toString());

                    Log.d("userdata.getFullname", userdata.getFullname());
                    Log.d("userdata.getEmailid", userdata.getEmailid());
                    Log.d("userdata.getAge", String.valueOf(userdata.getAge()));
                    Log.d("userdata.getMobile", userdata.getMobile());
                    Log.d("userdata.getPassword", userdata.getPassword());

                    SignUpActivity signupactivity = new SignUpActivity();
                    signupactivity.helper.insertData(userdata);

                registerfragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, new LoginModuleFragment(),
                                "LoginModuleFragment").commit();
                }

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

    // Check Validation Method
    private boolean validatefields() {

        // Get all edittext texts
        String getFullName = fullName.getText().toString();
        String getEmailId = emailId.getText().toString();
        String getMobileNumber = mobileNumber.getText().toString();
        String getAge = age.getText().toString();
        String getPassword = password.getText().toString();
        String getConfirmPassword = confirmPassword.getText().toString();

        // Pattern match for email id
//        Pattern p = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b\"");
//        Matcher m = p.matcher(getEmailId);

        // Check if all strings are null or not
        if (getFullName.equals("") || getFullName.length() == 0
                || getEmailId.equals("") || getEmailId.length() == 0
                || getMobileNumber.equals("") || getMobileNumber.length() == 0
                || getAge.equals("") || getAge.length() == 0
                || getPassword.equals("") || getPassword.length() == 0
                || getConfirmPassword.equals("")
                || getConfirmPassword.length() == 0)


        {
            Toast.makeText(getActivity(), "All fields are required.",
                    Toast.LENGTH_LONG).show();
            return false;
        }

            // Check if email id valid or not
//        else if (!m.find()) {
//            Toast.makeText(getActivity(), "Email ID is invalid.",
//                    Toast.LENGTH_LONG).show();
//            return false;
//        }
            // Check if both password should be equal
        else if (!getConfirmPassword.equals(getPassword)) {
            Toast.makeText(getActivity(), "Passwords don't match!",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
            // Else do signup or do your stuff
        else
            return true;

    }
}
