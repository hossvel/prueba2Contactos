package com.example.contactos;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.FocusFinder;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	 DatabaseHandler db = new DatabaseHandler(this);
	  
	 
	 @Override
		 public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.activity_main);
		         
		        
		        //iniciar();
		        Button b1=(Button)findViewById(R.id.actualizar);
		    	Button b2=(Button)findViewById(R.id.eliminar);
		    	b1.setEnabled(false);
		    	b2.setEnabled(false);
		    	
			      
		            Button btinsertar=(Button)findViewById(R.id.insertar);
			        btinsertar.setOnClickListener(this );//Button.OnClickListener(){});
			           
		        Button mostrarContactos=(Button)findViewById(R.id.mostrar);
		        mostrarContactos.setOnClickListener(this);
		       
		        Button buscar=(Button)findViewById(R.id.buscar);
		        buscar.setOnClickListener(this);
			}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		TextView tv1=(TextView)findViewById(R.id.TextView1);
		
		if(v.getId() ==findViewById(R.id.mostrar).getId() ){
			Intent i=new Intent(this,MostrarContactos.class);	
		     
			startActivity(i);
			tv1.setText(" ");
		}
		
		if(v.getId() ==findViewById(R.id.insertar).getId() ){
				cInsertar(v);
		}
	
		if(v.getId() ==findViewById(R.id.buscar).getId() ){
			cBuscar(v);
	}
		
			}

	
public void cInsertar(View v){
	
	EditText id=(EditText)findViewById(R.id.editText1);
	EditText nom=(EditText)findViewById(R.id.editText2);
	EditText con=(EditText)findViewById(R.id.editText3);
	
	TextView tv1=(TextView)findViewById(R.id.TextView1);
	try {
		db.addContact(new Contact( Integer.valueOf(id.getText().toString()) , nom.getText().toString() , con.getText().toString() ));   
        tv1.setText("insertion correcta");
        limpiar();
        id.setEnabled(true);
        id.requestFocus();
	} catch (Exception e) {
	  e.printStackTrace();
	}
	
	}

public void cBuscar(View v){

	EditText id=(EditText)findViewById(R.id.editText1);
	EditText nom=(EditText)findViewById(R.id.editText2);
	EditText con=(EditText)findViewById(R.id.editText3);
	
	Button insertar=(Button)findViewById(R.id.insertar);
	Button buscar=(Button)findViewById(R.id.buscar);
	Button actualizar=(Button)findViewById(R.id.actualizar);
	Button eliminar=(Button)findViewById(R.id.eliminar);
	
	
	Contact c1=db.getContact(Integer.valueOf(id.getText().toString()));
	
	nom.setText(c1.getName());
	con.setText(c1.getPhoneNumber());
	
	insertar.setEnabled(false);
	buscar.setEnabled(false);
	actualizar.setEnabled(true);
	eliminar.setEnabled(true);
	
	id.setEnabled(false);
	
}


public void cActualizar(View v){

	EditText id=(EditText)findViewById(R.id.editText1);
	EditText nom=(EditText)findViewById(R.id.editText2);
	EditText con=(EditText)findViewById(R.id.editText3);
	Button b1=(Button)findViewById(R.id.insertar);
	Button buscar=(Button)findViewById(R.id.buscar);
	
	db.updateContact(new Contact(Integer.valueOf(id.getText().toString()) , nom.getText().toString() , con.getText().toString() ));
	
	TextView tv1=(TextView)findViewById(R.id.TextView1);
	  tv1.setText("actualizacion correcta");
	      limpiar();
	      id.setEnabled(true);
	      b1.setEnabled(true);
	      buscar.setEnabled(true);
	      id.requestFocus();
	      
}

public void cEliminar(View v){
	
	EditText id=(EditText)findViewById(R.id.editText1);
	TextView tv1=(TextView)findViewById(R.id.TextView1);
	
	Button b1=(Button)findViewById(R.id.insertar);
	Button buscar=(Button)findViewById(R.id.buscar);
	
	try {
		
		
		Contact c1=db.getContact(Integer.valueOf(id.getText().toString()));
		db.deleteContact(c1);
		
		tv1.setText("eliminacion correcta");	    
	  	
		
	} catch (Exception e) {
		 tv1.setText("no existe el dato");
	}
	  limpiar();
     id.setEnabled(true);
     buscar.setEnabled(true);
    b1.setEnabled(true);
    id.requestFocus();
}
	

	
public void limpiar(){
	
	EditText id=(EditText)findViewById(R.id.editText1);
	EditText nom=(EditText)findViewById(R.id.editText2);
	EditText con=(EditText)findViewById(R.id.editText3);
	
	id.setText("");
	nom.setText("");
	con.setText("");
	
	
	Button b1=(Button)findViewById(R.id.actualizar);
	Button b2=(Button)findViewById(R.id.eliminar);
	b1.setEnabled(false);
	b2.setEnabled(false);
	
}

public void iniciar(){
	Button b1=(Button)findViewById(R.id.actualizar);
	Button b2=(Button)findViewById(R.id.eliminar);
	b1.setEnabled(false);
	b2.setEnabled(false);
	
	
}


	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

}
