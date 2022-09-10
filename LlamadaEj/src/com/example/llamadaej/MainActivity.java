package com.example.llamadaej;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	private String[] telefonos={"+543584825126", "4582753", "4182758",
			"4761846", "4761723", "4123874"}; 
	private ListView lv1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1=(ListView)findViewById(R.id.lv1); 
        ArrayAdapter<String> adaptador = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1, telefonos);
        lv1.setAdapter(adaptador);
        lv1.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> nadaxd, View view, int posicion, long nada3xd) {
				Intent llamar = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefonos[posicion]));
				startActivity(llamar);
				
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
