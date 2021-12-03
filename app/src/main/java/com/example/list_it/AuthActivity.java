package com.example.list_it;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AuthActivity extends AppCompatActivity {

    private Button mButtonLogin;
    private FirebaseAuth mAuth;
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;

    private String email ="";
    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mAuth = FirebaseAuth.getInstance();

        mEditTextEmail = (EditText) findViewById(R.id.emailEditText);
        mEditTextPassword = (EditText) findViewById(R.id.passEditText);
        mButtonLogin = (Button) findViewById(R.id.loginButton);

        mButtonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                email = mEditTextEmail.getText().toString();
                password = mEditTextPassword.getText().toString();

                if(!email.isEmpty() && !password.isEmpty()){
                    loginUser();
                }else{
                    Toast.makeText(AuthActivity.this, "Complete todo los campos", Toast.LENGTH_SHORT).show();
                }

            }


        });


    }

    private void loginUser(){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(AuthActivity.this, BottomActivity.class));
                    finish();
                }else{
                    Toast.makeText(AuthActivity.this, "No se pudo iniciar sesión, compruebe los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();

        if(mAuth.getCurrentUser()!=null){
            startActivity(new Intent(AuthActivity.this, BottomActivity.class));
            finish();
        }

    }



    public void launchBottomActivity(View view) {
        Intent intent=new Intent(this, BottomActivity.class);
        startActivity(intent);
    }

    public void launchRegisterActivity(View view) {
        Intent intent=new Intent(this, AccountActivity.class);
        startActivity(intent);
    }
}