package com.android.jamalludin.pamfun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Awal extends AppCompatActivity implements View.OnClickListener {

    Button Bmasuk, Blangsung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awal);

        Bmasuk = (Button) findViewById(R.id.Bmasuk);
        Blangsung = (Button) findViewById(R.id.Blangsung);

        Bmasuk.setOnClickListener(this);
        Blangsung.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Bmasuk:
                startActivity(new Intent(this, Login1.class));
                break;

            case R.id.Blangsung:
                startActivity(new Intent(this, MainActivity2.class));
                break;
        }
    }
}
