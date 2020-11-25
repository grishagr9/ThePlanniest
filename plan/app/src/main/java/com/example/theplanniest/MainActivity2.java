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
import android.widget.Toast;
import android.app.Dialog;
import android.content.DialogInterface;

public class MainActivity2 extends Activity {
    private Context MainActivityClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_plan);
    }
    public void Click_back(View view)
    {
        //onCreateDialog(); вывод предупреждения о несохранённых данных
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }

    public void Click_crate(View view)
    {
        // TODO: 19.11.2020
        //после нажатия кнопки создается кнопка этого плана на главном экране с надписью названия плана
    }
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