package com.example.parcial1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Factura extends Activity {

	private TextView cantidad, nombre, total, descuento, precio, metodo, envio;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_factura);

        nombre=(TextView)findViewById(R.id.nombre);  
        cantidad=(TextView)findViewById(R.id.cantidad1);  
        precio=(TextView)findViewById(R.id.precio);  
        total=(TextView)findViewById(R.id.total);  
        descuento=(TextView)findViewById(R.id.descuento);  
        metodo=(TextView)findViewById(R.id.metodo);  
        envio=(TextView)findViewById(R.id.envio);  
        Bundle b = getIntent().getExtras();
        
        
        nombre.setText(b.getString("nombre1"));
        cantidad.setText(b.getString("cantidad1"));
        total.setText("$" + b.getString("total1").toString());
        precio.setText("$" + b.getString("precio1").toString());
        total.setText("$" + b.getString("total1").toString());
        descuento.setText("$" + b.getString("descuento1").toString());
        metodo.setText(b.getString("pago1"));
        envio.setText(b.getString("envio1"));
        
        
	}

	public void aceptar(View view)
	{
		finish();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_factura, menu);
		return true;
	}

}
