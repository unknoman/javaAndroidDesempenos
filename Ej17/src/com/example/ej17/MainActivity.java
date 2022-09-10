package com.example.ej17;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private CheckBox cb1x, cb2x;
	private EditText et1, et2;
	private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        tv1=(TextView)findViewById(R.id.tv1);
        cb1x=(CheckBox)findViewById(R.id.cb1);
        cb2x=(CheckBox)findViewById(R.id.cb2);
    }

    public void operar(View view) 
    {
    	if(cb1x.isChecked()== true)
    	{
    		int var1 = Integer.parseInt(et1.getText().toString());
    		int var2 = Integer.parseInt(et2.getText().toString());
    		int resultado = var1 + var2;
    		 tv1.setText("El resultado es " + resultado);
    	} else if(cb2x.isChecked()==true)
    	{
    		int var1 = Integer.parseInt(et1.getText().toString());
    		int var2 = Integer.parseInt(et2.getText().toString());
    		int resultado = var1 - var2;
    		 tv1.setText("El resultado es " + resultado);
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
