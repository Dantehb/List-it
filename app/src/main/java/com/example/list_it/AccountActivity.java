package com.example.list_it;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AccountActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button mRegisterButton;

    private String name = "";
    private String email = "";
    private String password = "";

    FirebaseAuth mAuth;
    DatabaseReference mDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        mAuth = FirebaseAuth.getInstance();
        mDataBase = FirebaseDatabase.getInstance().getReference();

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        mRegisterButton = (Button) findViewById(R.id.registerButton);

        mRegisterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                name = nameEditText.getText().toString();
                email = emailEditText.getText().toString();
                password = passwordEditText.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                    registerUser();
                    if(password.length() >=6){

                    }else{
                        Toast.makeText(AccountActivity.this, "El password debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(AccountActivity.this, "Debe completar los campos", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task){
                if(task.isSuccessful()){

                    Map<String, Object> map = new HashMap<>();
                    map.put("name",name);
                    map.put("email",email);
                    map.put("password",password);

                    String id = mAuth.getCurrentUser().getUid();
                    mDataBase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>(){
                        @Override
                        public void onComplete(@NonNull Task<Void> task2){
                            if(task2.isSuccessful()){
                                startActivity(new Intent(AccountActivity.this,BottomActivity.class));
                                finish();
                            }else{
                                Toast.makeText(AccountActivity.this, "No se pudo crear los datos correctamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(AccountActivity.this, "No se pudo registrar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}