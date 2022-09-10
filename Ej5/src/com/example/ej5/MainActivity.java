package com.example.ej5;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et4;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         et4=(EditText)findViewById(R.id.et4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void verificar(View view)
    {
    	int randomn = (int) (Math.random() * 1000) + 1;
    	int numeroingresado = Integer.parseInt(et4.getText().toString());
    	if(numeroingresado == randomn)
    	{
        	Toast toast1 = Toast.makeText(this, "Ganaste! Numero generado: " + randomn + " Tu numero es: " + numeroingresado, Toast.LENGTH_SHORT);
        	toast1.show();
    	} else 
    	{
        	Toast toast1 = Toast.makeText(this, "El nro generado es: " + randomn + " Tu numero es: " + numeroingresado, Toast.LENGTH_SHORT);
        	toast1.show();
    	}
    }
    
    
}
