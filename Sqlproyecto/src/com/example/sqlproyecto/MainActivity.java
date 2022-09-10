package com.example.sqlproyecto;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	public EditText et1, et2, et3;
	public Toast t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void alta(View view)
    {
    	AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
    	SQLiteDatabase bd = admin.getWritableDatabase();
    	String dni = et1.getText().toString();
    	String nombre = et2.getText().toString();
    	String colegio = et3.getText().toString();
    	ContentValues registro = new ContentValues();
    	registro.put("dni", dni);
    	registro.put("nombre", nombre);
    	registro.put("colegio", colegio);
    	bd.insert("votantes", null, registro);
    	bd.close();
    	et1.setText("");
    	et2.setText("");
    	et3.setText("");
    	t1.makeText(this, "Se cargaron los datos", Toast.LENGTH_SHORT).show();
    	
    }
    
    
    public void consulta(View xd){
    	AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
    	SQLiteDatabase bd = admin.getWritableDatabase(); // SQLiteDatabase bd1=admin1.getWritableDatabase();
    	String dni = et1.getText().toString(); // String dni1=et1.getText().toString();
    	Cursor fila=bd.rawQuery("select nombre,colegio from votantes1 where dni="+dni+"",null);  // Cursor fila1=bd1.rawQuery("select nombre,colegio from votantes where dni="+dni1+"",null);
    	if(fila.moveToFirst()) // if (fila1.moveToFirst())
    	{
   		 et2.setText(fila.getString(0));
   		 et3.setText(fila.getString(1));
    	} else
    	{
    		Toast.makeText(this, "No existe una persona con dicho dni", Toast.LENGTH_SHORT).show();
    		bd.close(); 
    	}
    }
    
    public void baja(View view)
    {
    	AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
    	SQLiteDatabase bd=admin.getWritableDatabase();
    	String dni = et1.getText().toString();
    	int cant=bd.delete("votantes", "dni="+dni+"", null);
    	bd.close();
    	et1.setText("");
    	et2.setText("");
    	et3.setText("");
    	if(cant==1)
    	{
    		Toast.makeText(this, "Se borro la persona con dicho documento", Toast.LENGTH_SHORT).show();
    	} else
    	{
    		Toast.makeText(this, "no existe una persona con dicho documento", Toast.LENGTH_SHORT).show();
    	}
    	
    }
    
    public void modificar(View view)
    {
    	AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"administracion", null, 1); 
    	SQLiteDatabase bd = admin.getWritableDatabase();
    	 String dni=et1.getText().toString();
    	 String nombre=et2.getText().toString();
    	 String colegio=et3.getText().toString();
    	 ContentValues registro = new ContentValues();
    	 registro.put("nombre", nombre);
    	 registro.put("colegio", colegio);
 int cant = bd.update("votantes", registro, "dni="+dni, null);
 bd.close();
 if(cant==1)
 {
	 Toast.makeText(this, "Se logro correctamente", Toast.LENGTH_SHORT).show();
	 
 } else
 {
	 Toast.makeText(this, "no existe dicha persona con ese documento", Toast.LENGTH_SHORT);
 }
    }
    

	
}
