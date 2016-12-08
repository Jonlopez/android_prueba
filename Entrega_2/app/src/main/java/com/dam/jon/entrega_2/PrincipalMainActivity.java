package com.dam.jon.entrega_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PrincipalMainActivity extends AppCompatActivity implements View.OnClickListener {

    private OperationsAction operations;
    private Button btn_calcular;
    private TextView tvw_posicion;
    private TextView tvw_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_main);

        operations = new OperationsAction();

        btn_calcular = (Button) findViewById(R.id.app_btn);
        btn_calcular.setOnClickListener(this);
        tvw_posicion = (TextView) findViewById(R.id.app_valor);
        tvw_resultado = (TextView) findViewById(R.id.app_resultado);
    }

    @Override
    public void onClick(View view) {
        tvw_resultado.setText(
                "El numero primo de la poscion " + tvw_posicion.getText().toString()
                + " es: "
                + operations.primoByPosicion(Integer.parseInt(tvw_posicion.getText().toString())).toString()
        );
    }
}
