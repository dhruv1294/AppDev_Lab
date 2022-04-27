package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private Button LoginBtn;
    private TextView ErrorMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText)findViewById(R.id.username);
        Password = (EditText)findViewById(R.id.password);
        LoginBtn = (Button)findViewById(R.id.loginBtn);
        ErrorMsg = (TextView)findViewById(R.id.errorMsg);

        LoginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(),Password.getText().toString());
            }
        });

    }

    private void validate(String username,String password){
        if((username.equals("Admin")) && (password.equals("pass1234"))){
            ErrorMsg.setText("Login Successful!");
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
        }
        else{
            ErrorMsg.setText("Invalid Credentials!");
        }
    }
}
