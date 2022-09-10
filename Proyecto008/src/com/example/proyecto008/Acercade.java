package com.example.proyecto008;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Acercade extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acercade);
    }

    public void finalizar(View view){
    	finish(); 
    }
    
}
