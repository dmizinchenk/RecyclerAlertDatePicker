package com.activity.recycleralertdatepicker;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Car> cars = new ArrayList<Car>();
    private Button btnAlert;
    private Button toPickers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        cars.add(new Car("Audi", "A4", R.drawable.audi_a4));
        cars.add(new Car("BMW", "M3", R.drawable.bmw_m3));
        cars.add(new Car("Skoda", "Rapid", R.drawable.skoda_rapid));
        cars.add(new Car("Volkswagen", "Passat", R.drawable.vw_passat));
        cars.add(new Car("Opel", "Mokka", R.drawable.opel_mokka));
        cars.add(new Car("Hyundai", "Sonata", R.drawable.hyunday_sonata));

        CarAdapter.OnCarClickListener listener = new CarAdapter.OnCarClickListener() {
            @Override
            public void onCarClick(Car car, int position) {
                Toast.makeText(getApplicationContext(), String.format("Вы выбрали автомобиль: %s %s",  car.getBrand(), car.getModel()), Toast.LENGTH_SHORT).show();
            }
        };
        CarAdapter adapter = new CarAdapter(this, cars, listener);
        recyclerView.setAdapter(adapter);

        btnAlert = findViewById(R.id.alert);
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Выход");
                builder.setMessage("Вы уверены, что хотите выйти?");
                builder.setPositiveButton("Продолжить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Приложение продолжается", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                });
                builder.setNegativeButton("Выход", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        toPickers = findViewById(R.id.toPicker);
        toPickers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Pickers.class);
                startActivity(intent);
            }
        });
    }
}