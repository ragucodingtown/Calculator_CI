package com.example.codingtown.calculator_ci;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import java.text.DecimalFormat;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button calcul,clearbt,half,quater,onemonth,interest_bt;
    EditText at, interst, yer;
    TextView total,chgtext;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        at = (EditText) findViewById(R.id.tv1);
        interst = (EditText) findViewById(R.id.tv2);
        yer = (EditText) findViewById(R.id.tv3);
        total = (TextView) findViewById(R.id.view1);

        //calbt = (Button) findViewById(R.id.b1);
        clearbt = (Button) findViewById(R.id.clr);
        onemonth=(Button)findViewById(R.id.one);
        half=(Button)findViewById(R.id.six);
        quater=(Button)findViewById(R.id.three);
        calcul=(Button)findViewById(R.id.cal);
        interest_bt=(Button)findViewById(R.id.intr_bt);
        chgtext=(TextView)findViewById(R.id.chgview);


        img=(ImageView)findViewById(R.id.imageView);



        onemonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yer.setText("0.083");
            }
        });


        half.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yer.setText("0.5");
            }
        });

        quater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yer.setText("0.25");
            }
        });


        clearbt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                at.setText("");
                yer.setText("");
              chgtext.setText("");
                interst.setText("");
                total.setText("");
            }
        });


/*
        calcul.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                double amt = Double.parseDouble(at.getText().toString());
                double rate = (Double.parseDouble(interst.getText().toString()));
                //double amra=(amt*rate)/100;
                double yr = Double.parseDouble(yer.getText().toString());
                //double ans=yr*amra;


                double ans = (double) (amt* Math.pow((1 + rate/100),yr));
                total.setText(new DecimalFormat("##.##").format(ans));



            }
        });*/


        calcul.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onClick(View v)
            {
                chgtext.setText("AMOUNT + INTEREST IS...");
                double amt=Double.parseDouble(at.getText().toString());
                double rate=Double.parseDouble(interst.getText().toString());
                double yr=Double.parseDouble(yer.getText().toString());
                double ans=amt*Math.pow((1+rate/100),yr);


                total.setText(new DecimalFormat("##.##").format(ans));


            }
        });

        interest_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chgtext.setText("INTEREST AMOUNT IS...");
                double amt1=Double.parseDouble(at.getText().toString());
                double rate1=Double.parseDouble(interst.getText().toString());
                double yr1=Double.parseDouble(yer.getText().toString());
                double ans=amt1*Math.pow((1+rate1/100),yr1);
                double interest_ans=ans-amt1;
                total.setText(new DecimalFormat("##.##").format(interest_ans));

            }
        });

   /*yer.setOnEditorActionListener(new TextView.OnEditorActionListener() {
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        double amt = Double.parseDouble(at.getText().toString());
        double rate = (Double.parseDouble(interst.getText().toString()));
        //double amra=(amt*rate)/100;
        double yr = Double.parseDouble(yer.getText().toString());
        //double ans=yr*amra;


        double ans = (double) (amt* Math.pow((1 + rate/100),yr));
        total.setText(new DecimalFormat("##.##").format(ans));
        return false;
    }
});*/







    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?").setCancelable(false).setPositiveButton
                ("Yes", new DialogInterface.OnClickListener()


                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        MainActivity.this.finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
    }

