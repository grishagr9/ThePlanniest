package com.example.theplanniest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends Activity {
    private Context MainActivityClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_plan);
    }
    public void Click_back(View view)
    {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
        // TODO: 19.11.2020
        //предупредить пользователя о том, что план не сохранится
    }
    public void Click_crate(View view)
    {
        // TODO: 19.11.2020
        //после нажатия кнопки создается кнопка этого плана на главном экране с надписью названия плана
    }


}
