package com.example.basededatos1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private EditText et1; 
	private TextView tv1; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1); 
        tv1=(TextView)findViewById(R.id.tv1); 
        SharedPreferences 
        prefe=getSharedPreferences("datos",Context.MODE_PRIVATE);
        String mailxd = prefe.getString("mail","");
        tv1.setText(mailxd);
    }

    
   public void obtener(View view)
    {
        
        SharedPreferences 
        prefe=getSharedPreferences("datos",Context.MODE_PRIVATE);
          String mailxd = prefe.getString("mail","");
    	tv1.setText(mailxd);
    }
    
    public void ejecutar(View v) {
    	 SharedPreferences
    	preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
    	 Editor editor=preferencias.edit();
    	 editor.putString("mail", et1.getText().toString());
    	 editor.commit();
    	 finish();
    	 }
    	


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
