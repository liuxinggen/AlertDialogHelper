package com.gengen.alertdialog.alertdialoghelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-09-22 10:38:14 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == btn1) {
            // Handle clicks for btn1
            alertDialog = new AlertDialog(MainActivity.this);
            alertDialog.setTitle("标题1");
            alertDialog.setMsg("你好");
        } else if (v == btn2) {
            // Handle clicks for btn2
            alertDialog = new AlertDialog(MainActivity.this);
            alertDialog.setTitle("标题2");
            alertDialog.setMsg("你好");
            alertDialog.setIcon(R.drawable.icon1);

        } else if (v == btn3) {
            // Handle clicks for btn3
            alertDialog = new AlertDialog(MainActivity.this);
            alertDialog.setTitle("标题3");
            alertDialog.setMsg("你好");
            alertDialog.setIcon(R.drawable.b01_icon1);
            alertDialog.setLeftBtnText("我是左").setLeftBtnListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "我是左", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();//添加这句话就是点击按钮之后对话框会消失
                }
            });
            alertDialog.setMiddleBtnText("我是中").setMiddleBtnListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "我是中", Toast.LENGTH_SHORT).show();
                }
            });
            alertDialog.setRightBtnText("我是右").setRightBtnListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "我是右", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                }
            });


        } else if (v == btn4) {
            // Handle clicks for btn4
            alertDialog = new AlertDialog(MainActivity.this);
            alertDialog.setCustomView(R.layout.layout_update);
            TextView tvCancel = (TextView) alertDialog.getSingleView(R.id.tv_alert_cancel);
            TextView tvSure = (TextView) alertDialog.getSingleView(R.id.tv_alert_sure);

            tvCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "点击了取消", Toast.LENGTH_SHORT).show();
                }
            });
            tvSure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "点击了确定", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }


}
