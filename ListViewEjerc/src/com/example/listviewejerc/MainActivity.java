package com.example.listviewejerc;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	 private String[] lista = {"uno", "dos", "tres", "cuatro",
			 "cinco", "seis", "siete", "ocho", "nueve", "diez", "once"}; 
	 private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   	   lv1=(ListView)findViewById(R.id.lv1); 
   	ArrayAdapter <String>adaptador= new  ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
   	lv1.setAdapter(adaptador);
   	lv1.setOnItemClickListener(new OnItemClickListener()
   	{
   		public void onItemClick(AdapterView<?> a, View v, int posicion, long id)
   		{
   			Toast.makeText(MainActivity.this, lista[posicion], Toast.LENGTH_SHORT).show(); 
   		}
   	}
   			
   			);
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
