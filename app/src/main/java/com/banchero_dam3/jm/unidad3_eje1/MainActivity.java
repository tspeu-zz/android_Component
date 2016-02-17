package com.banchero_dam3.jm.unidad3_eje1;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

        ControlLogin ctrlLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctrlLogin = (ControlLogin) findViewById(R.id.control);

        ctrlLogin.setOnLoginListener(new OnLoginListener() {
            @Override
            public void onLogin(String usuario, String password, String password2) {


                //Validamos el usuario y la contraseña
                // if (usuario.equals("demo") && password.equals("demo"))
                //   ctrlLogin.setMensaje("Login correcto!");
                // else
                //  ctrlLogin.setMensaje("Vuelva a intentarlo.");


                if (usuario.equals("")) {
                    textoVacio("el usuario no puede estar vacio");
                    return;
                }
                if (password.equals("")) {
                    textoVacio("debe ingresar la contraseña");
                    return;
                }
                if (password2.equals("")) {
                    textoVacio("debe repetir la contraseña");
                    return;
                }

                if (!password.equals(password2)){

                    textoVacio("las contraseñas no coinciden");
                    return;
                }

                else{


                    textoVacio("!Bienvenido \nUsuario:"+usuario +" !");
                    ctrlLogin.limpiarCampos();
                }

            }
        });


    }

    public void textoVacio(String mensaje){

        // CharSequence mensaje = getResources().getString(R.string.menssage);
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage(mensaje);
        alerta.setPositiveButton("ok", null);
        alerta.show();

    }

}
