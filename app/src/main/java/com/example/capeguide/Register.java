//Deep Programming (2021) Near Me | Firebase, Google Map, Place & Direction API's | Intro & Setup Project Android Java source code (Version 1.0) [Source code]. https://www.youtube.com/watch?v=dfTzz5AhBNQ&list=PLpQFhyCcxiCqDFYQabluYIYsNSsCFMNFk&index=1
package com.example.capeguide;

/* CodeWithMazn (2020) Auth App source code (Version 1.0) [Source code]. https://www.youtube.com/watch?v=KB2BIm_m1Os*/
/*Coding With Tea (2020 Modern Login Screen design android with Shared Animations in Android Studio 2021) (Version 1.0) [Source code]. https://www.youtube.com/watch?v=C_TEugAIMHA*/

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener
{
    //variables
    private TextView txt_personalDetails;
    private MaterialButton mb_signUp;
    /*private EditText et_Name, et_Age, et_emailAddress, et_confirmPassword, et_Password */;

    /*Register*/
    private TextInputEditText et_Name, et_Age, et_emailAddress, et_Password, et_confirmPassword;

    private ProgressBar pb_registerLoading;
    private CheckBox cbx_AgreeToTerms;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //initialize firebase instance
        mAuth = FirebaseAuth.getInstance();

        //initializing components
        mb_signUp = (MaterialButton) findViewById(R.id.mb_signUp);
        mb_signUp.setOnClickListener(this);

        et_Name = (TextInputEditText) findViewById(R.id.et_Name);
        et_Age = (TextInputEditText) findViewById(R.id.et_Age);
        et_emailAddress = (TextInputEditText) findViewById(R.id.et_emailAddress);
        et_Password = (TextInputEditText) findViewById(R.id.et_Password);
        et_confirmPassword = (TextInputEditText) findViewById(R.id.et_confirmPassword);

        pb_registerLoading = (ProgressBar) findViewById(R.id.pb_registerLoading);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mb_signUp:
                registerUser();
                break;
        }
    }
    // registers user, error handling and data validation
    private void registerUser() {
        String name = et_Name.getText().toString().trim();
        String age = et_Age.getText().toString().trim();
        String email = et_emailAddress.getText().toString().trim();
        String password = et_Password.getText().toString().trim();
        String confirmPass = et_confirmPassword.getText().toString().trim();

        if(name.isEmpty()) {
            et_Name.setError("Full Name is required!");
            et_Name.requestFocus();
            return;
        }
        if(age.isEmpty()) {
            et_Age.setError("Age is required!");
            et_Age.requestFocus();
            return;
        }
        if(email.isEmpty()) {
            et_emailAddress.setError("Email is required!");
            et_emailAddress.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_emailAddress.setError("Please provide a valid email!(including @ character and domain name)");
            et_emailAddress.requestFocus();
            return;
        }
        if(password.isEmpty()) {
            et_Password.setError("Password is required!");
            et_Password.requestFocus();
            return;
        }
        if(password.length() < 6){
            et_Password.setError("Minimum password length should be 6 characters!");
            et_Password.requestFocus();
            return;
        }
        if(confirmPass.isEmpty()) {
            et_confirmPassword.setError("Please confirm your password!");
            et_confirmPassword.requestFocus();
            return;
        }
        if(!password.equals(confirmPass)){
            et_confirmPassword.setError("Please ensure your passwords are matching!");
            et_confirmPassword.requestFocus();
            return;
        }


        // creates a new account with email and password
        pb_registerLoading.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    User user = new User(name, age, email);

                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(Register.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
                                        pb_registerLoading.setVisibility(View.GONE);

                                        //redirect to login layout
                                        startActivity(new Intent( Register.this, Login.class));
                                    }else{
                                        Toast.makeText(Register.this, "Failed to register user. Try again!", Toast.LENGTH_LONG).show();
                                        pb_registerLoading.setVisibility(View.GONE);
                                    }
                                }
                            });
                }
                else
                {
                    Toast.makeText(Register.this, "Failed to register user. Try again!", Toast.LENGTH_LONG).show();
                    pb_registerLoading.setVisibility(View.GONE);
                }
            }
        });
    }
}

      /*
      if(cbx_AgreeToTerms.isChecked()) {
            return;
        }
        else{
            Toast.makeText(this,"Please agree to the Terms of Service",Toast.LENGTH_SHORT).show();
            return;
        }
        */
