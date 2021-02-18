package com.example.recargasweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegistrarUsuario extends AppCompatActivity {

    ImageView atras;
    Button registrarcuenta;
    EditText nombresapellidos, identificacion, email, password,confirmapassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        atras= findViewById(R.id.atras);
        registrarcuenta= findViewById(R.id.registrarcuenta);
        nombresapellidos= findViewById(R.id.nombresapellidos);
        identificacion= findViewById(R.id.identificacion);
        email= findViewById(R.id.email);
        password= findViewById(R.id.password);
        confirmapassword= findViewById(R.id.confirmapassword);

        registrarcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nombresapellidos.getText().toString().isEmpty()){
                    Toast.makeText(RegistrarUsuario.this, "Digite sus nombres y apellidos", Toast.LENGTH_SHORT).show();
                } else {
                    if(identificacion.getText().toString().isEmpty()){
                        Toast.makeText(RegistrarUsuario.this, "Digite su Identificacion", Toast.LENGTH_SHORT).show();
                    } else {
                        if(email.getText().toString().isEmpty()){
                            Toast.makeText(RegistrarUsuario.this, "Digite su Email", Toast.LENGTH_SHORT).show();

                        }else{
                            if(!Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches()){
                                email.setError("Correo invalido");
                                return;

                            }else{
                                email.setError(null);
                            }
                        }
                        if(password.getText().toString().isEmpty() || !Pattern.compile("[0-9]").matcher(password.getText()).find() ){
                            Toast.makeText(RegistrarUsuario.this, "Digite su Password", Toast.LENGTH_SHORT).show();
                            password.setError("Debe contener al menos un numero");
                            return;

                        }else{
                            password.setError(null);
                        }
                        if(!Pattern.compile("[A-Z]").matcher(password.getText()).find()){
                            password.setError("Debe contener al menos una letra mayuscula");
                            return;
                        } else{
                            password.setError(null);
                        }

                        if(!Pattern.compile("[a-z]").matcher(password.getText()).find()){
                            password.setError("Debe contener al menos una letra minuscula");
                            return;
                        } else{
                            password.setError(null);

                        }
                        if (password.length()<8) {
                            password.setError("Se necesitan más de 8 caracteres");
                            return;
                        }
                        if (!confirmapassword.getText().toString().matches(password.getText().toString())){
                            confirmapassword .setError("Las contraseñas deben coincidir");
                            return;
                        }else {
                            Modelo obj = new Modelo();
                            UsuariosDTO usr= new UsuariosDTO();
                            nombresapellidos= findViewById(R.id.nombresapellidos);
                            identificacion = findViewById(R.id.identificacion);
                            email= findViewById(R.id.email);
                            password =  findViewById(R.id.password);

                            usr.setNombresapellidos(nombresapellidos.getText().toString());
                            usr.setIdentificacion(identificacion.getText().toString());
                            usr.setEmail(email.getText().toString());
                            usr.setPassword(password.getText().toString());

                            int resInsert = obj.insertaUsuario(RegistrarUsuario.this,usr);
                            if(resInsert==1){
                                Toast.makeText(RegistrarUsuario.this, "Usuario Registrado!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegistrarUsuario.this, MainActivity.class);
                                startActivity(intent);
                                finish();

                            } else {

                                Toast.makeText(RegistrarUsuario.this, "Usuario No Registrado!", Toast.LENGTH_SHORT).show();
                            }

                        }

                    }

                }


            }


        });
        
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(RegistrarUsuario.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}