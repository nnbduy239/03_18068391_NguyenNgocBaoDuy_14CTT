package com.iuh.a03_18068391_nguyenngocbaoduy_14ctt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editSo1,editSo2,editKetqua;
    Button btnAdd,btnSub,btnMul,btnDiv;
    private MyService myService;
    private boolean isConnection;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder binder = (MyService.MyBinder) service;
            myService = binder.getService();
            isConnection = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isConnection = false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editSo1 = findViewById(R.id.editSo1);
        editSo2 = findViewById(R.id.editSo2);
        editKetqua = findViewById(R.id.editKetQua);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnAdd);
        btnMul = findViewById(R.id.btnAdd);
        btnDiv = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int A = Integer.parseInt(editSo1.getText().toString());
                int B =  Integer.parseInt(editSo2.getText().toString());
                int Result = myService.Add(A,B);
                editKetqua.setText(String.valueOf(Result));
                getNumber();
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumber();
                int A = Integer.parseInt(editSo1.getText().toString());
                int B =  Integer.parseInt(editSo2.getText().toString());
                int Result = myService.Sub(A,B);
                editKetqua.setText(String.valueOf(Result));
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumber();
                int A = Integer.parseInt(editSo1.getText().toString());
                int B =  Integer.parseInt(editSo2.getText().toString());
                int Result = myService.Mul(A,B);
                editKetqua.setText(String.valueOf(Result));
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumber();
                int A = Integer.parseInt(editSo1.getText().toString());
                int B =  Integer.parseInt(editSo2.getText().toString());
                double Result = myService.Div(A,B);
                editKetqua.setText(String.valueOf(Result));
            }
        });
    }

    private void getNumber() {
        Intent intent = new Intent(this,MyService.class);
        intent.putExtra("number1",editSo1.getText());
        intent.putExtra("number2",editSo2.getText());
        startService(intent);

    }
}