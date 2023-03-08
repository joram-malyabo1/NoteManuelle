package com.example.notemanuelle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class loginActivity extends Activity {

    Button BtnLogin;

    EditText TextNomUser,PassWord;
    ImageView showPassword;
//    CheckBox showPassword;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        BtnLogin=findViewById(R.id.BtnLogin);

        showPassword = findViewById(R.id.showPassword);
        TextNomUser = findViewById(R.id.TextNomUser);
        PassWord = findViewById(R.id.PassWord);

        showPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId()==R.id.showPassword){

                    if (PassWord.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                        ((ImageView)(view)).setImageResource(R.drawable.ic_visibility_off_black_24dp);
                        PassWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }else{

                        ((ImageView)(view)).setImageResource(R.drawable.ic_visibility_black_24dp);
                        PassWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                }

            }
        });

//        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b){
//                    PassWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                }else {
//
//                    PassWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                }
//            }
//        });


        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity.this,MenuPrinciale.class);
                startActivity(intent);
            }
        });

    }

}
