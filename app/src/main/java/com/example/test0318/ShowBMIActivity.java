package com.example.test0318;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ShowBMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bmi);
        TextView name=(TextView) findViewById(R.id.tv_name);
        ImageView view1=(ImageView)findViewById(R.id.iv_pic);
        TextView info=(TextView)findViewById(R.id.tv_info);

        Bundle bundle =this.getIntent().getExtras();
        String h=bundle.getString("height");
        String w=bundle.getString("weight");
        String n=bundle.getString("name");

        Toast.makeText(this,h+w+n,Toast.LENGTH_SHORT).show();

        double bmi = Double.parseDouble(w)  / (Double.parseDouble(h) /100.0 * Double.parseDouble(h)/100.0);

        DecimalFormat df=new DecimalFormat("#.##");

        name.setText(n);
        String msg="";
        if(bmi<18.5) {
            msg=getString(R.string.w_low);
            view1.setImageResource(R.drawable.s1);
        } else if(bmi>25) {
            msg=getString(R.string.w_high);;
            view1.setImageResource(R.drawable.f1);
        } else {
            msg=getString(R.string.w_std);;
            view1.setImageResource(R.drawable.m1);
        }
        Toast.makeText(this, msg , Toast.LENGTH_SHORT).show();
        info.setText(name.getText().toString()+getString(R.string.msg1) +df.format(bmi));
    }
}
