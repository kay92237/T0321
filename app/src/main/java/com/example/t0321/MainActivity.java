package com.example.t0321;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText h;
    private EditText w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        name = (EditText) findViewById(R.id.ed_name);
        h = (EditText) findViewById(R.id.ed_high);
        w = (EditText) findViewById(R.id.ed_We);
    }

    public void show(View view) {

        TextView b = findViewById(R.id.tv_show);
        double w_value =Double.parseDouble(w.getText().toString());
        double h_value =Double.parseDouble(h.getText().toString());
        double bmi = w_value / (h_value/100.0*h_value/100.0);
       // DecimalFormat mDecimalFormat = new DecimalFormat("#,#");
       
    }


    public void nextPage(View view) {
        Bundle bundle = new Bundle();

        bundle.putString("heihgt",h.getText().toString());
        bundle.putString("weight",w.getText().toString());
        bundle.putString("name",name.getText().toString());
        Intent intent = new Intent(this,ShowBmiActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
