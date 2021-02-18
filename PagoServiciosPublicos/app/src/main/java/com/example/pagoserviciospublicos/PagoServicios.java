package com.example.pagoserviciospublicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class PagoServicios extends AppCompatActivity {
    Spinner spinner;
    Button pagarfactura;
    EditText numerofactura,valorapagar,confivalorapagar;
    ImageView atras;
    int montonuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago_servicios);
        spinner =findViewById(R.id.spinner);
        pagarfactura= findViewById(R.id.pagarfactura);
        numerofactura= findViewById(R.id.numerofactura);
        valorapagar= findViewById(R.id.valorapagar);
        atras= findViewById(R.id.atras);
        confivalorapagar= findViewById(R.id.confivalorapagar);
        MainActivity ma= new MainActivity();
        Bundle recibirmonto =getIntent().getExtras();
        int montorecibido= recibirmonto.getInt("monto");
        Toast.makeText(this, String.valueOf(recibirmonto), Toast.LENGTH_SHORT).show();




        String []opciones={"CENS","TV NORTE","TV SANJORGE","ESPO"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagoServicios.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        pagarfactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numerofactura.getText().toString().isEmpty()) {
                    Toast.makeText(PagoServicios.this, "Digite el numero de la factura", Toast.LENGTH_SHORT).show();
                } else {
                    if (valorapagar.getText().toString().isEmpty()) {
                        Toast.makeText(PagoServicios.this, "Digite el valor a pagar", Toast.LENGTH_SHORT).show();
                    } else {
                        if (confivalorapagar.getText().toString().isEmpty()) {
                            Toast.makeText(PagoServicios.this, "Confirme el valor a pagar", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            if(!(numerofactura.length()==10)){
                                numerofactura.setError("El numero de factura debe contener 10 digitos");
                                return;
                                
                            } else {
                                numerofactura.setError(null);
                                }
                            if(!valorapagar.getText().toString().matches(confivalorapagar.getText().toString())){
                                Toast.makeText(PagoServicios.this, "El valor a pagar no coinciden", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            else{

                                if(montorecibido<Integer.parseInt(valorapagar.getText().toString())){

                                    Toast.makeText(PagoServicios.this, "Saldo insuficiente", Toast.LENGTH_SHORT).show();
                                } else{
                                    Toast.makeText(PagoServicios.this, "Pago realizado correctamente", Toast.LENGTH_SHORT).show();
                                    montonuevo=montorecibido-Integer.parseInt(valorapagar.getText().toString());
                                    Intent intent = new Intent(PagoServicios.this,MainActivity.class);
                                    intent.putExtra("montoenviado",montonuevo);
                                    startActivity(intent);
                                    finish();

                                }

                            }
                        }


                    }
                }
            }
        });

    }

    public void recibirdatos() {


    }
}