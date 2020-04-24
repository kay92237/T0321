package com.example.t0321;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Key;
import java.text.DecimalFormat;

public class ShowBmiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bmi);
        TextView show_name = (TextView) findViewById(R.id.tv_name);
       ImageView view1  = (ImageView) findViewById(R.id.tv_pic);
       TextView show_bmi = (TextView) findViewById(R.id.tv_show);

        Bundle bundle =  getIntent().getExtras();
        String name = bundle.getString("name");
        String h = bundle.getString("heihgt");
        String w = bundle.getString("weight");
        TextView b = findViewById(R.id.tv_show);
        double bmi = Double.parseDouble(w) / (Double.parseDouble(h)/100.0*Double.parseDouble(h)/100.0);
        String nsg = "";
        if (bmi<18.5){
            nsg = getString(R.string.strTooLow);
            view1.setImageResource(R.drawable.a1);
        }else if (bmi>25){
            nsg = getString(R.string.strToohigh);
            view1.setImageResource(R.drawable.a3);
        }else {
            nsg = getString(R.string.strstd);
            view1.setImageResource(R.drawable.a2);
        }
      // Toast.makeText(this,nsg,Toast.LENGTH_LONG).show();
        DecimalFormat df = new DecimalFormat("#.#");
        show_name.setText(name);
        show_bmi.setText(getString(R.string.strHowbmi)+ df.format(bmi)+nsg);

    }
}
