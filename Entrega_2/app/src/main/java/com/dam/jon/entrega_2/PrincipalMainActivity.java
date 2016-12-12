package com.dam.jon.entrega_2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PrincipalMainActivity extends AppCompatActivity implements View.OnClickListener {

    //Objeto que vamos a usar para realizar las operaciones y conservar los datos en RAM
    private OperationsAction operations;
    //Boton de la pantalla
    private Button btn_calcular;
    //Campo donde nos indicaran la posicion
    private TextView tvw_posicion;
    //Consola de mensajes
    private TextView tvw_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_main);
        //Instanciamos el objeto nada mas arrancar la aplicacion
        operations = new OperationsAction();
        //Al igual que el resto de elementos indicando el Listener(escuchador) del boton que vamos a presionar
        btn_calcular = (Button) findViewById(R.id.app_btn);
        btn_calcular.setOnClickListener(this);
        tvw_posicion = (TextView) findViewById(R.id.app_valor);
        tvw_resultado = (TextView) findViewById(R.id.app_resultado);
    }

    @Override
    public void onClick(View view) {
        //Información que vamos a mostrar al usuario para guiarle por el proceso y el resultado final.
        String infor = "";
        /*Validaciones:
            -> Comprobamos que el campo posicion no este vacio
            -> Comprobamos que el campo posicion no tengas mas de 6 digitos
            -> Comprobamos que el campo posicion no sea negativo
                  ( Tengo que indicar que la ultima validacion no es necesaria ya que el campo tvw_posicion
                    es de tipo inputType : NUMBER y esto evita, valores negativos, caracteres especiales, letras
                    y que sean números enteros )
         */

        if( !tvw_posicion.getText().toString().equals("")
                && Integer.parseInt(tvw_posicion.getText().toString()) >= 0
                && tvw_posicion.getText().toString().length() <= 6){

            /* Si superamos la validaciones mostraremos en color NEGRO el número primo de la poscion indicada
             * ordenados de menor a mayor
             */

            //No tiene sentido pero el enunciado admite 0 como posicion
            // he decidido cortarlo por lo sano
            if(Integer.parseInt(tvw_posicion.getText().toString()) != 0){
                infor += "El numero primo de la poscion "
                        + tvw_posicion.getText().toString()
                        + " es: "
                        + operations.primoByPosicion(Integer.parseInt(tvw_posicion.getText().toString())).toString();
                tvw_resultado.setTextColor(Color.BLACK);
            }else{
                infor += "El primo eres tú xD...";
                tvw_resultado.setTextColor(Color.BLUE);
            }


        }else{
            /* Por el contrario si no supera la validaciones indicaremos al usuario un mensaje en ROJO
             * con lo que tiene que corregir para poder realizar las operaciones necesarias
             */
            if(tvw_posicion.getText().toString().equals(""))
                infor += "El campo posicion no puede estar vacio";
            else if(tvw_posicion.getText().toString().length() > 6)
                infor += "La posicion introducida no puede ser de mas de 6 digitos ";
            else if(Integer.parseInt(tvw_posicion.getText().toString()) < 0)
                infor += "La posición no puede ser negativa";

            tvw_resultado.setTextColor(Color.RED);
        }
        //Finalmente mostraremos el mensaje de informacion que corresponda suceda lo que suceda
        tvw_resultado.setText(infor);

    }
}
