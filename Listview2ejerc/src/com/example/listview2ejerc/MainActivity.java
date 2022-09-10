package com.example.listview2ejerc;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private String[] paises = {"Argentina", "Chile", "Paraguay", "Bolivia"};
	private String[] habitantes = {"1000", "2000", "3000", "4000"};
	
	private TextView tv1;
	private ListView lv1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView)findViewById(R.id.tv1);
        lv1 = (ListView)findViewById(R.id.lv1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises);
        lv1.setAdapter(adapter);
        
        lv1.setOnItemClickListener(new OnItemClickListener()
        		{

					@Override
					public void onItemClick(AdapterView<?> arg0, View view,
							int posicion, long arg3) {
						
						tv1.setText(" poblacion de " + lv1.getItemAtPosition(posicion) + "es de " + habitantes[posicion]);
						
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
