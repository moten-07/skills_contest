package com.moten.DemoA.func;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.moten.DemoA.R;
import com.moten.DemoA.aboutIntent.UserOkhttp;

public class UpPassActivity extends AppCompatActivity {
    EditText up_pass_ordpwd,up_pass_newpwd,up_pass_newpwd2;
    boolean canUpPwd;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_pass);
        toolbar = findViewById(R.id.toolbar_uppass);
        setSupportActionBar(toolbar);
        setTitle("修改密码");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return false;
    }
}