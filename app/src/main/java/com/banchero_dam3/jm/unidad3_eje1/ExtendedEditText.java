package com.banchero_dam3.jm.unidad3_eje1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by JM_B on 19-Oct-15.
 */
public class ExtendedEditText extends EditText {

    private  float escala ;
    private Paint p1,p2;
   //

    public ExtendedEditText(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs,defStyle);
        inicializacion();
    }

    public ExtendedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializacion();
    }

    public ExtendedEditText(Context context) {
        super(context);
        inicializacion();
    }

    private void inicializacion()
    {
        p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setColor(Color.DKGRAY);
        p1.setStyle(Paint.Style.FILL);


        p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.WHITE);
        p2.setTextSize(20);


        escala = getResources().getDisplayMetrics().density;

    }

    @Override
    public void onDraw(Canvas canvas)
    {
        //Llamamos al método de la clase base (EditText)
        super.onDraw(canvas);

        //Dibujamos el fondo negro del contador



        String contenido = this.getText().toString();
        String mensaje="";


        if (contenido.length() <= 5){
            mensaje = "seguridad baja";
            p2.setColor(Color.RED);
            //Dibujamos el número de caracteres sobre el contador
           // canvas.drawText(mensaje, this.getWidth() - 78 * escala, 17 * escala, p2);

        }
        if (contenido.length() > 5 && contenido.length() <= 10){
            mensaje = "seguridad media";
            p2.setColor(Color.rgb(255, 128, 0));
            //p1.setColor(Color.DKGRAY);
            //Dibujamos el número de caracteres sobre el contador
           // canvas.drawText(mensaje, this.getWidth() - 78 * escala, 17 * escala, p2);

        }
        if (contenido.length() > 10){
            mensaje = "seguridad alta";
            p2.setColor(Color.GREEN);
            //p1.setColor(Color.BLACK);
            //Dibujamos el número de caracteres sobre el contador
           // canvas.drawText(mensaje, this.getWidth() - 78 * escala, 17 * escala, p2);

        }

        //canvas.drawRect(this.getWidth()-89*escala, 5*escala, this.getWidth()-5*escala, 20*escala, p1);
        canvas.drawText(mensaje, this.getWidth() - 100 * escala, 10 * escala, p2);

        }
    }



