package com.example.parcial1;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et1, et2, et3;
    private CheckBox cb1;
    private RadioButton rd1, rd2, rd3;
    private TextView importe, descuentotv;
    private Toast toast1;
    
    float precioventa;
    float cantidad;
    float operacion;
    float total;
    float descuento;
    String pago;
    String envio = "No";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        importe=(TextView)findViewById(R.id.importe);
        descuentotv=(TextView)findViewById(R.id.descuentotv);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        rd1=(RadioButton)findViewById(R.id.rd1);
        rd2=(RadioButton)findViewById(R.id.rd2);
        rd3=(RadioButton)findViewById(R.id.rd3);
        cb1=(CheckBox)findViewById(R.id.cb1);

    }



    


    void operacion()
    {
   	 float precioventa = Float.valueOf(et2.getText().toString());
   	 float cantidad = Float.valueOf(et3.getText().toString());
   		 
    		  if(rd1.isChecked() && !cb1.isChecked())
    	        {
    	             operacion = precioventa * cantidad;
    	        	 descuento = (float) (operacion * 0.10);
    	        	 total = operacion - descuento;
    	        	descuentotv.setText("$" + descuento); 
    	        	importe.setText("$" + total);
    	        	pago = "Contado"; 
    	        	envio = "No"; 
    	        } 
    	        
    	        ///----
    	        if(rd2.isChecked() && !cb1.isChecked())
    	        {
    	        	 operacion = precioventa * cantidad;
    	        	 descuento = 0;
    	        	 total = operacion;
    	        	descuentotv.setText("$0.00");
    	        	importe.setText("$" + total);
    	        	pago = "Tarjeta un pago"; 
    	        	envio = "No";
    	        }  

    	        
    	        //------
    	        if(rd3.isChecked() && !cb1.isChecked())
    	        {
    	        	operacion = precioventa * cantidad;
    	        	descuento = (float) (operacion * 0.10);
    	        	total = operacion + descuento;
    	        	descuentotv.setText("$" + descuento); 
    	        	 pago = "Tarjeta 3 cuotas"; 
    	        	importe.setText("$" + total);
    	        	envio = "No";
    	        } 
    	        
    	        //---------------------------------------- fin 
    	        if(rd1.isChecked() && cb1.isChecked())
    	        {
    	        	 operacion = precioventa * cantidad;
    	        	 descuento = (float) (operacion * 0.10);
    	        	total = operacion - descuento + 100;
    	        	descuentotv.setText("$" + descuento); 
    	        	importe.setText("$" + total);
    	        	 pago = "Contado"; 
    	             envio = "Si - 100$";
    	        } 
    	        
    	        ///----
    	        if(rd2.isChecked() && cb1.isChecked())
    	        {
    	        	operacion = precioventa * cantidad;
    	        	 total = operacion + 100; 
    	        	descuentotv.setText("$0.00");
    	        	importe.setText("$" + total);
    	        	descuento = 0;
    	       	 pago = "Tarjeta un pago"; 
    	         envio = "Si - 100$";
    	        }  

    	        
    	        //------
    	        if(rd3.isChecked() && cb1.isChecked())
    	        {
    	        	operacion = precioventa * cantidad;
    	        	descuento = (float) (operacion * 0.10);
    	        	total = operacion + descuento + 100;
    	        	descuentotv.setText("$" + descuento); 
    	        	importe.setText("$" + total);
    	          	 pago = "Tarjeta 3 cuotas"; 
    	             envio = "Si - 100$";
    	        } 
    } 
    	 //------------------- main 
      
  	 

    

 

 	
    public void importe(View view)
 {
    	 String ett1 = et1.getText().toString();
    	 	String ett2 = et2.getText().toString();
    	 	String ett3 = et3.getText().toString();
        	 if(ett1.equals("") || ett2.equals("") || ett3.equals(""))
        	 {
           		 Toast toast1 = Toast.makeText(this, "Ingresa todos datos antes de continuar", Toast.LENGTH_LONG);
           		 toast1.show();
        	 } else 
           	 {
        		 operacion();
           	 }
 }
    
	  

        public void imprimir(View view)
        {
        String ett1 = et1.getText().toString();
        String ett2 = et2.getText().toString();
        String ett3 = et3.getText().toString();
       	 if(ett1.equals("") || ett2.equals("") || ett3.equals(""))
       	 {
          		 Toast toast1 = Toast.makeText(this, "Ingresa todos dato antes de continuar", Toast.LENGTH_LONG);
          		 toast1.show();
       	 } else 
          	 {
         	operacion();
            Intent i = new Intent(this, Factura.class);
        	i.putExtra("nombre1", et1.getText().toString());
        	i.putExtra("cantidad1", et3.getText().toString());
        	i.putExtra("precio1", et2.getText().toString());
        	i.putExtra("descuento1", String.valueOf(descuento));
        	i.putExtra("total1", String.valueOf(total));
        	i.putExtra("pago1", pago);
        	i.putExtra("envio1", envio);
        	startActivity(i);
          	 }

        }
   
    
}
