package com.example.theplanniest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_plan);
    }

    public void On_click_text(View view, char[] def)
    {
        // TODO: 13.11.2020
        //если текст равен дефолтному - удалить
    }
}
