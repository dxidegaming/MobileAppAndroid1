package com.example.student.termproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class coldPlayInfo extends AppCompatActivity {
    ImageButton button1 , button2;
    MediaPlayer playSample;
    final double tax=0.0875;
    double ticketCost = 45.99;
    double VIPticket = 95.99;
    double ordersInput;
    boolean VIPYorN;
    double totalCost;
    double partialCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cold_play_info);
        button1 = (ImageButton) findViewById(R.id.btnPlay);
        button2 = (ImageButton) findViewById(R.id.btnPause);
        final CheckBox cbAutoPlay = (CheckBox) findViewById(R.id.cbAutoReplay);
        button1.setOnClickListener(bPlay);
        button2.setOnClickListener(bPause);
        button2.setVisibility(View.INVISIBLE);
        playSample = new MediaPlayer();
        playSample = MediaPlayer.create(this, R.raw.coldplay);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText order = (EditText) findViewById(R.id.txtNumTickets);
        final CheckBox cbVIP = (CheckBox) findViewById(R.id.cbVIPorN);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button calculation = (Button) findViewById(R.id.btnCalculate);

        calculation.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v){
                if (cbVIP.isChecked()) {
                    VIPYorN = true;
                } else {
                    VIPYorN = false;}
                String txtNumP= order.getText().toString();
                if(txtNumP.isEmpty()){
                    Toast.makeText(coldPlayInfo.this,"Must enter number of tickets.", Toast.LENGTH_LONG).show( );}
                else {
                    ordersInput=Double.parseDouble(order.getText( ).toString( ));
                    if(VIPYorN){
                        partialCost = VIPticket * ordersInput;
                        totalCost = (partialCost * tax) + partialCost;}
                    else{
                        partialCost = ticketCost * ordersInput;
                        totalCost = (partialCost * tax) + partialCost;}
                }
                String tCost = String.valueOf(totalCost);
                result.setText("The total is $" + tCost.format("%.2f",totalCost));
            }});
        playSample.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (cbAutoPlay.isChecked()) {
                    playSample.start();
                } else {
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.INVISIBLE);
                }
            }

        });
    }
    Button.OnClickListener bPlay = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            playSample.start();
            button1.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.VISIBLE);
        }
    };

    Button.OnClickListener bPause = new Button.OnClickListener() {
        @Override
        public void onClick(View v){
            playSample.pause();
            button2.setVisibility(View.INVISIBLE);
            button1.setVisibility(View.VISIBLE);
        }
    };
    public void seePersonInfo1(View v){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Chris_Martin")));
    }
    public void seePersonInfo2(View v){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Jonny_Buckland")));
    }
    public void seePersonInfo3(View v){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Guy_Berryman")));
    }
    public void seePersonInfo4(View v){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Will_Champion")));
    }
    public void backHome(View v){
        startActivity(new Intent(coldPlayInfo.this, MainActivity.class));
        playSample.stop();
        button2.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.VISIBLE);
    }

}
