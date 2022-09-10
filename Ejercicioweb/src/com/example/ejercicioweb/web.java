package com.example.ejercicioweb;

import android.os.Bundle;
import android.webkit.WebView;

public class web extends android.app.Activity {
	private WebView wv1;
	
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.web);
        
        wv1=(WebView)findViewById(R.id.webView1);
        Bundle bundle=getIntent().getExtras();
        wv1.loadUrl("http://"+bundle.getString("direccion"));
    }
    
}
