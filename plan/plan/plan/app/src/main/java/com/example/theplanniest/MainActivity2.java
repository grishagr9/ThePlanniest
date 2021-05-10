package com.example.theplanniest;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.theplanniest.model.Note;
import com.example.theplanniest.screens.main.Description;
import com.example.theplanniest.screens.main.MainActivity;

import java.util.Calendar;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
    private Context MainActivityClass;

    private Button button;
    private LinearLayout linearLayout;
    Calendar dateAndTime=Calendar.getInstance();
    public TextView DateTime ;
    public RatingBar Rating;
    private  static final String EXTRA_NOTE = "MainActivity2.EXTRA_NOTE";
    float aboba;
    private NotificationManager nm;
    private final int NOTIFICATION_ID = 127;
//заметка, которую мы создаем
  private  Note note;

  private EditText editText;
  //private EditText MainText;
    //вызов активити, cохранение плана
    public static void start(Activity caller,Note note){
       Intent intent = new Intent(caller, MainActivity2.class);
       if(note!=null){
           intent.putExtra(EXTRA_NOTE, note);
       }
       caller.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_plan);

        DateTime=(TextView)findViewById(R.id.DateText);
        setInitialDateTime();

        setContentView(R.layout.create_plan);

        Rating = (RatingBar) findViewById(R.id.ratingBar);
        aboba = Rating.getRating();
        nm = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);



        editText = findViewById(R.id.NamePlan);
        //MainText = findViewById(R.id.about_plan);
        if (getIntent().hasExtra(EXTRA_NOTE)) {
            note = getIntent().getParcelableExtra(EXTRA_NOTE);
            editText.setText(note.text);
            //MainText.setText(note.mainText);
        } else {
            note = new Note();
        }



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //что происходит при нажатии на разные кнопки
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            //если пользователь нажал кнопку назад в панеле на
            case android.R.id.home:
                finish();
                break;
                //если нажата кнопка сохранить
            case R.id.action_save:
                if (editText.getText().length() > 0) {
                    //сохраняем заметку
                    note.text = editText.getText().toString();
                    note.done = false;
                    note.timestamp = System.currentTimeMillis();
                    //note.mainText = MainText.getText().toString();
                    //если старая
                    if (getIntent().hasExtra(EXTRA_NOTE)) {
                        App.getInstance().getNoteDao().update(note);
                    }
                    //если новая
                    else {
                        App.getInstance().getNoteDao().insert(note);
                    }
                    finish();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //ВЫБОР ДАТЫ
        public void DateClick(View v)
        {
            DateTime = (TextView)v;
            new DatePickerDialog(MainActivity2.this, d,
                    dateAndTime.get(Calendar.YEAR),
                    dateAndTime.get(Calendar.MONTH),
                    dateAndTime.get(Calendar.DAY_OF_MONTH))
                    .show();
            setInitialDateTime();
            DateTime.setTextSize(20);
        }

        // установка обработчика выбора даты
        DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateAndTime.set(Calendar.YEAR, year);
                dateAndTime.set(Calendar.MONTH, monthOfYear);
                dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                setInitialDateTime();
            }
        };
        // установка начальных даты и времени
        private void setInitialDateTime() {

            DateTime.setText(DateUtils.formatDateTime(this,
                    dateAndTime.getTimeInMillis(),
                    DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
        }

    //функция для выхода на главный экран
    public void Click_back(View view)
    {
        //onCreateDialog(); вывод предупреждения о несохранённых данных
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }

    //функция вызова оповещения
    public void  showNotification(View view)
    {
        Notification.Builder builder = new Notification.Builder((getApplicationContext()));
        Intent intent = new Intent(getApplicationContext(), Description.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(BitmapFactory.decodeResource(getApplication().getResources(), R.drawable.ic_launcher_foreground))
                .setTicker("Дедлайны близки!")
                .setWhen((System.currentTimeMillis()))
                .setAutoCancel(true)
                .setContentTitle("The Planniest")
                .setContentText("Настало время приступить к планам!");
        Notification notification = builder.build();
        nm.notify(NOTIFICATION_ID, notification);
    }
    //функция, которая будет создавать кнопку плана на главном экране
    /*public void Click_Create(View view)
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
                );
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
    public Dialog onCreateDialog(Bundle savedInstanceState) {
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