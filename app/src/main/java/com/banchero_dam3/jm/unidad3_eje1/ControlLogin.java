package com.banchero_dam3.jm.unidad3_eje1;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by JM_B on 21-Oct-15.
 */
public class ControlLogin extends LinearLayout {

    private TextView lblMensaje, lblUsuario, lblInfo;
    private EditText txtUsuario,txtPasswordRepite;
    private Button btnLogin;
    //variable de la clase componente
    ExtendedEditText txtPassAlerta;
    //variable de la interfaz
    private OnLoginListener listener;
    private String [] listaNombres = {"pepe","lolo","juan","ana","pepa","lola","eva","adan","pedro","juana","pepe1"};
   // private Boolean bTextU,bPassU,bPassR = false;
    private ImageView imgAlerta;


    public ControlLogin(Context context) {
        super(context);
        inicializar();
    }

    public ControlLogin(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializar();
    }



    private  void inicializar(){
        //Utilizamos el layout 'control' como interfaz del control
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.control, this, true);

        // referencias a los distintos componentes
        txtUsuario = (EditText)findViewById(R.id.TxtUsuario);
        txtPassAlerta = (ExtendedEditText) findViewById(R.id.TxtPassSeguridad);
        txtPasswordRepite = (EditText)findViewById(R.id.TxtPassRepite);
        btnLogin = (Button)findViewById(R.id.BtnAceptar);
        lblMensaje = (TextView)findViewById(R.id.LblMensaje);
        lblUsuario = (TextView)findViewById(R.id.lblUsuario);
        lblInfo= (TextView)findViewById(R.id.lblInfo);
        imgAlerta = (ImageView) findViewById(R.id.imageViewAlerta) ;

       // btnLogin.setVisibility(INVISIBLE);
        btnLogin.setEnabled(false);

//controlar los mombres en el edittext
        txtUsuario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String nombre = s.toString();
                String nombreArray =null;

                if(nombre.equals("")){
                    setMensajeUsuario("");
                    btnLogin.setEnabled(false);
                   // btnLogin.setVisibility(INVISIBLE);
                }

                    for (int i = 0; i < listaNombres.length; i++) {
                        nombreArray = listaNombres[i];

                        if (nombre.equals(nombreArray))  {

                            setMensajeUsuario("usuario repetido");
                            setInfo(getResources().getString(R.string.infoUsuario));
                           // imgAlerta.setBackgroundColor(getResources().getColor(R.color.colorAlerta));
                            imgAlerta.setColorFilter(new LightingColorFilter(Color.RED, Color.TRANSPARENT));
                            lblUsuario.setTextColor(Color.RED);
                    //test
                    Log.d("MainActivity", "TextArray " + nombreArray+"nombre:"+nombre +i);
                            //btnLogin.setVisibility(INVISIBLE);
                            // btnLogin.setEnabled(false);
                        }
                        else{
                            setMensajeUsuario("");
                            setInfo("");
                            imgAlerta.setColorFilter(new LightingColorFilter(Color.WHITE, Color.TRANSPARENT));
                            //imgAlerta.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                            Log.d("MainActivity", "else " + nombre);
                           // btnLogin.setVisibility(VISIBLE);
                           btnLogin.setEnabled(true);
                        }
                    }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String nombre = s.toString().toUpperCase();
                String nombreArray =null;

                if(nombre.equals("")){
                    setMensajeUsuario("");
                    setInfo("");
                    btnLogin.setEnabled(false);
                    // btnLogin.setVisibility(INVISIBLE);

                }
                // else {

                for (int i = 0; i < listaNombres.length; i++) {
                    nombreArray = listaNombres[i].toUpperCase();

                    if (nombre.equals(nombreArray))  { //
                        setMensajeUsuario("usuario no disponible");
                        setInfo(getResources().getString(R.string.infoUsuario));
                       // imgAlerta.setBackgroundColor(getResources().getColor(R.color.colorAlerta));
                        imgAlerta.setColorFilter(new LightingColorFilter(Color.RED, Color.TRANSPARENT));
                        Log.d("MainActivity", "Text Array " + nombreArray);

                        //btnLogin.setVisibility(INVISIBLE);
                        btnLogin.setEnabled(false);
                    }
                }
            }
        });

//controlar los cambios en el edittext repite Password
        txtPasswordRepite.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                String text = s.toString();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // you can call or do what you want with your EditText here

                String text = s.toString();

                if (text.length() > 1) {
                    if (!text.equals(txtPassAlerta.getText().toString().trim())) {
                        setMensaje("no coincide");
                        setInfo("ingrese una contraseña que coincida con la original");
                        //imgAlerta.setBackgroundColor(getResources().getColor(R.color.colorAlerta));
                        imgAlerta.setColorFilter(new LightingColorFilter(Color.RED, Color.TRANSPARENT));
                        btnLogin.setEnabled(false);

                    } else {
                        setMensaje("correcto");
                        setInfo("");
                        //imgAlerta.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        imgAlerta.setColorFilter(new LightingColorFilter(Color.WHITE, Color.TRANSPARENT));
                        btnLogin.setEnabled(true);
                    }
                }

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();

                if (text.equals("")) {
                    setMensaje("");
                    setInfo("");
                    imgAlerta.setColorFilter(new LightingColorFilter(Color.WHITE, Color.TRANSPARENT));
                } else {
                    if (!text.equals("")) {
                        if (!text.equals(txtPassAlerta.getText().toString().trim())) {
                            lblMensaje.setTextColor(Color.RED);
                            setMensaje("no coincide");
                            setInfo("ingrese una contraseña que coincida con la original");
                            //imgAlerta.setBackgroundColor(getResources().getColor(R.color.colorAlerta));
                            imgAlerta.setColorFilter(new LightingColorFilter(Color.RED, Color.TRANSPARENT));
                            btnLogin.setEnabled(false);
                        } else {
                            lblMensaje.setTextColor(Color.GREEN);
                            setMensaje("correcto");
                            setInfo("");
                           // imgAlerta.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                            imgAlerta.setColorFilter(new LightingColorFilter(Color.WHITE, Color.TRANSPARENT));
                            btnLogin.setEnabled(true);
                        }
                    }
                }
            }
        });

//Asociamos los eventos necesarios
        asignarEventos();

    }


//para mostrar el mensajes en el label
    public void setMensaje(String msg)
    {
        lblMensaje.setText(msg);
    }

    public void setMensajeUsuario(String msg)
    {
        lblUsuario.setText(msg);
    }

//para mostrar en el label Info
    public void setInfo(String msg)
    {
        lblInfo.setText(msg);
    }
 //generico
    public void setMensajeLbl(EditText lbl, String m)
    {
        lbl.setText(m);
    }
//para mostrar el mensajes en el label

//interface
    public void setOnLoginListener(OnLoginListener l)
    {
        listener = l;
    }

//eventos botón
    private void asignarEventos() {

        //directamente el boton del componente
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //aplica el metodo de la interfaz y asigna lo que entra en los campos
                listener.onLogin(txtUsuario.getText().toString(), txtPassAlerta.getText().toString(),
                        txtPasswordRepite.getText().toString());

                setMensaje("");
                setMensajeUsuario("");

            }
        });

    }

//set para los camps de texto
    public void setTextusuario(String txt){
        txtUsuario.setText(txt);
    }

    public void setTxtPassAlerta(String txt){
        txtPassAlerta.setText(txt);
    }

    public void setTxtPassRepite(String txt){
        txtPasswordRepite.setText(txt);
    }

    public void limpiarCampos(){
        txtUsuario.setText("");
        txtPassAlerta.setText("");
        txtPasswordRepite.setText("");
    }
    // fin set para los camps de texto
}
