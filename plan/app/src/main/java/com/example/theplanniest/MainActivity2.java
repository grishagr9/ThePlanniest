package com.example.theplanniest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_plan);
    }
    public void Click_back(View view)
    {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }
    public void Click_crate(View view)
    {

    }
}
