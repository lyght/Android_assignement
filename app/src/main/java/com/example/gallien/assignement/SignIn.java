package com.example.gallien.assignement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText emailInput, passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        emailInput = findViewById(R.id.email_Field);
        passwordInput = findViewById(R.id.password_Field);

        mAuth = FirebaseAuth.getInstance();
        Button login = findViewById(R.id.signIn_Buton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser(emailInput,passwordInput);
            }
        });
    }

    public void registerUser(EditText email_input, EditText password_input) {
        String email = email_input.getText().toString();
        String password = password_input.getText().toString();

        if (email.isEmpty()) {

            Toast.makeText(SignIn.this,"email is empty", Toast.LENGTH_SHORT).show();

        } else if (password.isEmpty()) {
            Toast.makeText(SignIn.this,"password is empty", Toast.LENGTH_SHORT).show();

        } else {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(SignIn.this, "User registered", Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(SignIn.this, "User registered failed", Toast.LENGTH_SHORT).show();
                            }


                        }
                    });
        }
    }
}
