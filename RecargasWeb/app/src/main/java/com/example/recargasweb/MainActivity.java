package com.example.recargasweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button registrarcuenta, ingresar;
    EditText email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registrarcuenta= findViewById(R.id.registrarcuenta);
        ingresar= findViewById(R.id.ingresar);
        email= findViewById(R.id.email);
        password= findViewById(R.id.password);


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        if(email.getText().toString().isEmpty()){
                            Toast.makeText(MainActivity.this, "Digite su Email", Toast.LENGTH_SHORT).show();

                        }else {
                            if (!Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches()) {
                                email.setError("Correo invalido");
                                return;

                            } else {
                                email.setError(null);
                            }
                        }
                            if(password.getText().toString().isEmpty()){
                                Toast.makeText(MainActivity.this, "Digite su contraseña", Toast.LENGTH_SHORT).show();

                            } else{
                                Modelo obj = new Modelo();
                                int valLogin = obj.validarlogin(MainActivity.this, email.getText().toString(), password.getText().toString());
                                if(valLogin==1){
                                    Intent intent= new Intent(MainActivity.this,Menu.class);
                                    startActivity(intent);
                                    finish();
                                    Toast.makeText(MainActivity.this, "Ingreso correctamente!", Toast.LENGTH_SHORT).show();

                                }else {

                                    Toast.makeText(MainActivity.this, "Email o contraseña incorrecta!", Toast.LENGTH_SHORT).show();
                                }


                            }




                            }

        });





















        registrarcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, RegistrarUsuario.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
