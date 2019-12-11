package com.example.tp1;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Debug;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker ;
    Button btnSetAlarm ;
    Button btnGoToList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        btnSetAlarm =(Button) findViewById(R.id.btnSetAlarm);
        btnGoToList = (Button)findViewById(R.id.btnGoToList);


        // setting the alarm button
        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH),
                        timePicker.getCurrentHour(),
                        timePicker.getCurrentMinute(),
                        0
                );

                setAlarm(calendar.getTimeInMillis());
            }


        });
        //link to the List activity
        btnGoToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });


    }
    private void setAlarm(long timeInMillis) {
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this,MyAlarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);
        alarmManager.setRepeating(AlarmManager.RTC ,timeInMillis, AlarmManager.INTERVAL_DAY,pendingIntent);
        Toast.makeText(this ,"Alarm set !", Toast.LENGTH_SHORT).show();

    }

    public void runy()
    {
        int i = 1;
    }
}
