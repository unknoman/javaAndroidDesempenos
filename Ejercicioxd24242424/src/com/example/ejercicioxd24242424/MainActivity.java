package com.example.ejercicioxd24242424;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	 private Spinner spinner1;
	 private EditText et1, et2;
	 private TextView tv3; 
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        tv3=(TextView)findViewById(R.id.tv3); 
        spinner1 = (Spinner) findViewById(R.id.spinner1); 

        String[] Opciones = {"sumar", "restar", "multiplicar", "dividir"};
        ArrayAdapter<String> adapter = new
        		ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,
        		Opciones);
        		 spinner1.setAdapter(adapter); } 


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void reaccionar(View view)
    {
    	String selec=spinner1.getSelectedItem().toString();
    	int et1s = Integer.parseInt(et1.getText().toString());
    	int et2s = Integer.parseInt(et2.getText().toString());
    	if(selec.equalsIgnoreCase("sumar"))
    	{
        	int resultado = et1s + et2s;
    	tv3.setText("Resultado " + resultado);
    	} 
    	else if (selec.equalsIgnoreCase("restar"))
    	{
        	int resultado = et1s - et2s;
        	tv3.setText("Resultado " + resultado);
    	}
    	else if (selec.equalsIgnoreCase("multiplicar"))
    	{
        	int resultado = et1s * et2s;
        	tv3.setText("Resultado " + resultado);
    	}
    	else if (selec.equalsIgnoreCase("dividir"))
    	{
        	int resultado = et1s / et2s;
        	tv3.setText("Resultado " + resultado);
    	}
    }
    
}
