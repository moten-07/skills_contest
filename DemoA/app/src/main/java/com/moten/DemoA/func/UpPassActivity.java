package com.moten.DemoA.func;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.moten.DemoA.R;
import com.moten.DemoA.aboutIntent.UserOkhttp;

public class UpPassActivity extends AppCompatActivity {
    EditText up_pass_ordpwd,up_pass_newpwd,up_pass_newpwd2;
    boolean canUpPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_pass);
        UserOkhttp userOkhttp = new UserOkhttp();
        up_pass_ordpwd = findViewById(R.id.up_pass_ordpwd);
        up_pass_newpwd = findViewById(R.id.up_pass_newpwd);
        up_pass_newpwd2 = findViewById(R.id.up_pass_newpwd2);

        canUpPwd = false;

        SharedPreferences sp = this.getSharedPreferences("location", Context.MODE_PRIVATE);
        int a = sp.getInt("UserId",-1);
        ((TextView)findViewById(R.id.up_pass_id)).setText("账号："+a);
        up_pass_newpwd2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    if (up_pass_newpwd.getText().toString().equals(up_pass_newpwd2.getText().toString())){
                        findViewById(R.id.error).setVisibility(View.GONE);
                        canUpPwd = true;
                    }else {
                        findViewById(R.id.error).setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        (findViewById(R.id.save)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canUpPwd){
                    userOkhttp.PutUpPass(up_pass_ordpwd.getText().toString(),
                            up_pass_newpwd.getText().toString(),
                            UpPassActivity.this);
                }
            }
        });
    }
}