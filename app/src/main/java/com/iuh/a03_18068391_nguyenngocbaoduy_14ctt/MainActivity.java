package com.iuh.a03_18068391_nguyenngocbaoduy_14ctt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editSo1,editSo2,editKetqua;
    Button btnAdd,btnSub,btnMul,btnDiv;
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
                getNumber();
                int num1 =Integer.parseInt(editSo1.getText()+"");
                int num2 =Integer.parseInt(editSo2.getText()+"");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumber();
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumber();
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumber();
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