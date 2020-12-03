package com.example.theplanniest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity2 extends Activity {
    private Context MainActivityClass;

    private Button button;
    private LinearLayout linearLayout;
    private int countID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_plan);


    }
    //функция для выхода на главный экран
    public void Click_back(View view)
    {
        //onCreateDialog(); вывод предупреждения о несохранённых данных
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }
    //функция, которая будет создавать кнопку плана на главном экране
    public void Click_Create(View view)
    {
        button = (Button) findViewById(R.id.Create_plan_click);
        linearLayout = (LinearLayout) findViewById(R.id.LinearLayout228);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Button b = new Button(getApplicationContext());
                b.setText("button");
                /*b.setLayoutParams(
                        new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT)
                );*/
                b.setId(2000+countID);
                linearLayout.addView(b);
                countID++;
                System.out.println(11111111);
            }
        });
        //onClick(button);
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
       // System.out.println(11111111);
        // TODO: 27.11.2020
    }

     //функция для всплывающего окна в случае выхода из создателя плана, не сохранив изменения
    /*public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = "Предупреждение";
        String message = "Если вы покинете страницу, введенные данные не сохранятся";
        String button1String = "Отмена";
        String button2String = "Покинуть страницу";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);  // заголовок
        builder.setMessage(message); // сообщение
        builder.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        builder.setCancelable(true);

        return builder.create();
    }*/
}