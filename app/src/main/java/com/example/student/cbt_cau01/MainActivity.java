package com.example.student.cbt_cau01;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button dangnhap, thoat;
    EditText taikhoan, taikhoan2;
    CheckBox luu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taikhoan=findViewById(R.id.taikhoan);
        taikhoan2=findViewById(R.id.taikhoan2);
        dangnhap = findViewById(R.id.btndangnhap);
        thoat = findViewById(R.id.btnthoat);
        luu = findViewById(R.id.checkBox);
        dangnhap.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String tk = taikhoan.getText().toString();
                String tk2 = taikhoan2.getText().toString();
                if (!tk.isEmpty() && !tk2.isEmpty()) {
                    if (luu.isChecked()) {
                        Toast.makeText(MainActivity.this, "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn đã được lưu", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn không được lưu", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ tài khoản và mật khẩu", Toast.LENGTH_LONG).show();
                }
            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Bạn có chắc muốn thoát?");
                builder.setTitle("Thông báo");
                builder.setIcon(android.R.drawable.stat_sys_warning);

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.create().show();
            }
        });
    }
}

