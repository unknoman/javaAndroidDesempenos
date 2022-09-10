package com.example.ej14;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv3;
	private RadioButton sumar1, restar1;
	private EditText et1, et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv3 = (TextView)findViewById(R.id.tv3);
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        sumar1 = (RadioButton)findViewById(R.id.sumar1);
        restar1 = (RadioButton)findViewById(R.id.restar1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void operar(View view)
    {
		String et1xd = et1.getText().toString();
		String et2xd = et2.getText().toString();
		int numero1 = Integer.parseInt(et1xd);
		int numero2 = Integer.parseInt(et2xd);
		 if(sumar1.isChecked() == true)
	    	{
	    		int resultado = numero1 + numero2;
	    		 tv3.setText(String.valueOf(resultado));
	    		 
	    	} else if (restar1.isChecked()== true)
	    	{
	    	    int resultado = numero1 - numero2;
	    		 tv3.setText(String.valueOf(resultado));
	    	}
    }

}
