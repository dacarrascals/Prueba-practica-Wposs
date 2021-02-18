package com.example.recargasweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Menu extends AppCompatActivity {
    Spinner spinner;
    Button recargar;
    EditText numrecargar, confinumrecargar, valorrecarga, confivalorrecarga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recargar = findViewById(R.id.recargar);
        spinner= findViewById(R.id.spinner);
        numrecargar = findViewById(R.id.numrecargar);
        confinumrecargar = findViewById(R.id.confinumrecargar);
        valorrecarga = findViewById(R.id.valorrecarga);
        confivalorrecarga = findViewById(R.id.confivalorrecarga);

        String []opciones={"CLARO","MOVISTAR","TIGO"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);

        recargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numrecargar.getText().toString().isEmpty()) {
                    Toast.makeText(Menu.this, "Digite el numero a recargar", Toast.LENGTH_SHORT).show();
                } else {
                    if (confinumrecargar.getText().toString().isEmpty()) {
                        Toast.makeText(Menu.this, "Confirme el numero a recargar", Toast.LENGTH_SHORT).show();
                    } else {
                        if (valorrecarga.getText().toString().isEmpty()) {
                            Toast.makeText(Menu.this, "Digite el valor a recargar", Toast.LENGTH_SHORT).show();
                        } else {
                            if (confivalorrecarga.getText().toString().isEmpty()) {
                                Toast.makeText(Menu.this, "Confirme el valor a recargar", Toast.LENGTH_SHORT).show();
                            } else {
                                    if (!confinumrecargar.getText().toString().matches(numrecargar.getText().toString())) {
                                        confinumrecargar.setError("Debe coincidir el numero de celular");
                                        return;
                                    } else {
                                        if (!confivalorrecarga.getText().toString().matches(valorrecarga.getText().toString())) {
                                            confivalorrecarga.setError("Debe coincidir el valor de la recarga");
                                            return;
                                        }else{

                                            if(!(Integer.parseInt(valorrecarga.getText().toString())>0)){
                                                valorrecarga.setError("El monto debe ser mayor a 0");
                                                return;
                                            }
                                            else {
                                                if(!(numrecargar.getText().length()==10)){
                                                    numrecargar.setError("El numero debe contener 10 digitos");
                                                    return;

                                                }else {
                                                    Toast.makeText(Menu.this, "Recarga exitosa!!!", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }

                                    }



                            }
                        }
                    }
                }
            }
        });


    }
}
