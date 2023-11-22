package com.example.hw_6v;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private MaterialButton loginButton;
    private TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.button);
        welcomeText = findViewById(R.id.text2);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredEmail = emailEditText.getText().toString();
                String enteredPassword = passwordEditText.getText().toString();

                if (enteredEmail.equals("admin") && enteredPassword.equals("admin")) {
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                    welcomeText.setVisibility(View.VISIBLE);
                    emailEditText.setVisibility(View.GONE);
                    passwordEditText.setVisibility(View.GONE);
                    loginButton.setVisibility(View.GONE);
                } else {
                    Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredEmail = emailEditText.getText().toString();
                String enteredPassword = passwordEditText.getText().toString();

                if (enteredEmail.equals("admin") && enteredPassword.equals("admin")) {
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();

                    // Скрыть все элементы кроме welcomeText
                    emailEditText.setVisibility(View.GONE);
                    passwordEditText.setVisibility(View.GONE);
                    loginButton.setVisibility(View.GONE);

                    // Показать welcomeText
                    welcomeText.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });


        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    loginButton.setBackgroundTintList(getResources().getColorStateList(R.color.orange));
                } else {
                    loginButton.setBackgroundTintList(getResources().getColorStateList(R.color.gray));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}
