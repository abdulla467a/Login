package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText Name;
    public EditText Password;
    public TextView Info;
    public Button Login;
    public int counter = 5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name= (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login=(Button)findViewById(R.id.btnLogin);

        Info.setText("No of attempts remaining:5 ");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());


            }
        });

        }

    public void validate(String userName, String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("1234"))){
            Intent intent =new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);}
            else{
                counter--;
                Info.setText("NO of attempts remaining:"+String.valueOf  (counter));
                if(counter==0){
                    Login.setEnabled(false);
            }

        }

    }


}