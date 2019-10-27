package com.example.tom.streamandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText Name;
    private  EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);  //與login.xml ui介面結合
        Name = (EditText) findViewById(R.id.email_edittext);
        Password =(EditText)findViewById(R.id.password_edittext);
        Info =(TextView)findViewById(R.id.info);
        Login =(Button)findViewById(R.id.custom_signin_button);

        Info.setText("嘗試登入次數剩下: 5"); //進入之後顯示預設五次

        initView();
    }

    private void initView() {
        mAuth = FirebaseAuth.getInstance();  //第一步得到FireBase的使用者資訊
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //按鈕會等待使用按下才會觸發
                String account = Name.getText().toString();
                String password = Password.getText().toString();
                if(TextUtils.isEmpty(account)){
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    return;
                }

                mAuth.signInWithEmailAndPassword(account, password) //第二步使用FireBase查詢是否有使用者輸入的帳號密碼
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Login.this, "登入成功!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent();
                                    intent.setClass(Login.this, MainActivity.class); //使用intent，做轉換頁面
                                    startActivity(intent); //開啟 MainActivity
                                    finish();
                                }else{
                                    counter--;//輸入輸錯就會counter --

                                    Info.setText("嘗試登入次數剩下: " + String.valueOf(counter));

                                    if(counter == 0){ //超過五次則，登入嘗試失敗，登入按鈕關閉
                                        Login.setEnabled(false);
                                    }
                                }
                            }
                        });
            }
        });
    }

}
