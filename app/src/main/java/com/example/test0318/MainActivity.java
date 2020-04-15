package com.example.test0318;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText height;
    private EditText weight;
    private TextView b;
    private ImageView view1;
    private SeekBar sb_weight;
    private SeekBar sb_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.ed_name);
        height = (EditText) findViewById(R.id.ed_height);
        weight = (EditText) findViewById(R.id.ed_weight);
        b = (TextView) findViewById(R.id.tv_showbmi);
        view1 = (ImageView)findViewById(R.id.imageView);
        sb_weight = (SeekBar) findViewById(R.id.sb_weight);

        sb_weight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                weight.setText(String.valueOf(sb_weight.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_height = (SeekBar) findViewById(R.id.sb_height);
        sb_height.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                height.setText(String.valueOf(sb_height.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void show(View view) {
        weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        String h = height.getText().toString();
        String w = weight.getText().toString();
        double bmi = Double.parseDouble(w)  / (Double.parseDouble(h) /100.0 * Double.parseDouble(h)/100.0);

        DecimalFormat df=new DecimalFormat("#.##");


        String msg="";
        if(bmi<18.5) {
            msg=getString(R.string.w_low);
            view1.setImageResource(R.drawable.s1);
        } else if(bmi>25) {
            msg=getString(R.string.w_high);
            view1.setImageResource(R.drawable.f1);
        } else {
            msg=getString(R.string.w_std);
            view1.setImageResource(R.drawable.m1);
        }
        Toast.makeText(this, msg , Toast.LENGTH_SHORT).show();
        b.setText(name.getText().toString()+getString(R.string.msg1) +df.format(bmi));
    }

    public void nextpage(View view) {
        String h = height.getText().toString();
        String w = weight.getText().toString();
        String name1= name.getText().toString();

        Bundle bundle=new Bundle();
        bundle.putString("height",h);
        bundle.putString("weight",w);
        bundle.putString("name",name1);

        Intent intent =new Intent(this,ShowBMIActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
