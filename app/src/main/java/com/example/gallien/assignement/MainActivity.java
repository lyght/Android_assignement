package com.example.gallien.assignement;



import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    EditText email_loginInput;
    EditText password_loginInput;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // retrieve button en textView
        email_loginInput = findViewById(R.id.email_login);
        password_loginInput = findViewById(R.id.password_login);
        Button login = findViewById(R.id.login_button);
        TextView sign_in = findViewById(R.id.sign_In);

        mAuth = FirebaseAuth.getInstance();

        //On Click go to signIn View
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_signIn = new Intent(MainActivity.this, SignIn.class);
                startActivity(intent_signIn);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            loginIn(email_loginInput,password_loginInput);
            }
        });

    }

    public void loginIn(EditText email, EditText password) {

        String email_login = email.getText().toString();
        String password_login = password.getText().toString();

        mAuth.signInWithEmailAndPassword(email_login, password_login).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {


                    FirebaseUser user = mAuth.getCurrentUser();

                    Intent intent_user_view = new Intent(MainActivity.this, View_Data.class);
                    intent_user_view.putExtra("uid", user.getUid());

                    startActivity(intent_user_view);

                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(MainActivity.this, "Login failed.",
                            Toast.LENGTH_SHORT).show();

                }


            }
        });

    }

    }

