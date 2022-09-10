package com.example.juegobasedatos;

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

	private TextView tv2, tv3;

	int random;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tv2 = (TextView)findViewById(R.id.tv2); // este textview hay que dejarlo vacío y es el que muestra el nivel

        tv3 = (TextView)findViewById(R.id.tv3); // el textview que nos dice si el numero es mas grande o mas chico

        et1 = (EditText)findViewById(R.id.et1); // donde insertamos el numero 

        random = (int) (Math.random() * 51 + 1);

        SharedPreferences

        prefe = getSharedPreferences("nvl", Context.MODE_PRIVATE); //  obtener los datos

        tv2.setText(prefe.getString("level","").toString()); // setear los datos en el text view

		   if(tv2.getText().equals("")) // si el textview esta vacío le va a enviar un 1 en la base de datos para luego obtenerlo y hacer un contador

		   {

			    Editor editor=prefe.edit();

			    int level = 1;

			    editor.putString("level", String.valueOf(level));

			    editor.commit();

			    tv2.setText(prefe.getString("level","").toString());

		   }

    }

   public void adivinar(View view)

    {

	   if(Integer.parseInt(et1.getText().toString()) == random) // verificar si el numero coincide con el ingresado

	   {

		   SharedPreferences

		    preferencias=getSharedPreferences("nvl",Context.MODE_PRIVATE);

		    Editor editor=preferencias.edit(); 

		    

		    int level = Integer.parseInt(tv2.getText().toString()); // obtiene lo del text view

		    int suma = level + 1; // suma lo del text view + 1 

		    editor.putString("level", String.valueOf(suma)); // introduce los datos del contador 

		    editor.commit();

		    tv2.setText(preferencias.getString("level","").toString()); // setea el nuevo valor en el text view

		   random = (int) (Math.random() * 51 + 1); // surge un nuevo numero random 

		   tv3.setText("Ganaste! subes un nivel");

	   } else if (Integer.parseInt(et1.getText().toString()) > random)

	   {

		   tv3.setText("Mas chico");

	   } else if (Integer.parseInt(et1.getText().toString()) < random)

	   {

		   tv3.setText("Mas grande");

	   }

    }

}