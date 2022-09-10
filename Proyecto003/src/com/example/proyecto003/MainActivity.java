package com.example.proyecto003;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Toast toast1, toast2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void toast1(View view)
    {
    	Toast toast1=Toast.makeText(this, "Toast Basico", Toast.LENGTH_SHORT);
    	toast1.show();
    }
    
    public void toast2(View view)
    {
    	Toast toast2=Toast.makeText(this, "Otro Toast", Toast.LENGTH_LONG);
    	toast2.setGravity(Gravity.CENTER, 0, 0);
    	toast2.show();
    }
    
}
