package com.example.pagoserviciospublicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button pagar;
    TextView fecha, hora, saldo,montoactualizado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fecha= findViewById(R.id.fecha);
        hora= findViewById(R.id.hora);
        pagar= findViewById(R.id.pagar);
        saldo= findViewById(R.id.saldo);
        montoactualizado= findViewById(R.id.montoactualizado);
        PagoServicios pg= new PagoServicios();
        int monto= 10000;
        Bundle recibirmonto=getIntent().getExtras();

      if(recibirmonto!=null){
          int montorecibido= recibirmonto.getInt("montoenviado");
          saldo.setText(String.valueOf(recibirmonto.getInt("montoenviado")));

        } else{
            saldo.setText(String.valueOf(monto));
        }

        fecha.setText(String.valueOf(android.text.format.DateFormat.format("dd-MM-yyyy", new java.util.Date())));
        Date date= new Date();
        SimpleDateFormat h = new SimpleDateFormat("h:mm a");
        String shora= h.format(date);
        hora.setText(shora);

        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, PagoServicios.class);
                intent.putExtra("monto",monto);
                startActivity(intent);
                finish();
            }
        });
    }
}