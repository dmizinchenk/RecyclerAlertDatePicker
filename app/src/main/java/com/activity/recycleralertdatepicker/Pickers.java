package com.activity.recycleralertdatepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Pickers extends AppCompatActivity {

    TextView date, time;
    Button setDate, setTime;
    Calendar calendar = Calendar.getInstance();

//    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
//        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//            calendar.set(Calendar.YEAR, year);
//            calendar.set(Calendar.MONTH, monthOfYear);
//            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//            setInitialDateTime();
//        }
//    };
//
//    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
//        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
//            calendar.set(Calendar.MINUTE, minute);
//            setInitialDateTime();
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pickers);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        date.setText(String.format("%02d.%02d.%04d", calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)));
        time.setText(String.format("%02d:%02d", calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE)));


        setDate = findViewById(R.id.set_date);
        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dateDialog = new DatePickerDialog(Pickers.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        date.setText(String.format("%02d.%02d.%04d", i2, i1, i));
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                dateDialog.show();
            }
        });

        setTime = findViewById(R.id.set_time);
        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timeDialog = new TimePickerDialog(Pickers.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        time.setText(String.format("%02d:%02d", i, i1));
                    }
                }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), true);
                timeDialog.show();
            }
        });
    }
}