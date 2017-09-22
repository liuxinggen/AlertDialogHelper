package com.gengen.alertdialog.alertdialoghelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void click(View v) {
        AlertDialog alertDialog = new AlertDialog(MainActivity.this);
        alertDialog.setTitle("标题");
        alertDialog.setMsg("你好");

    }

}
