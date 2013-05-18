package com.example.contactos;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import android.app.Activity;


public class MostrarContactos extends Activity  {
     String []items;
	 TextView selection;
	@Override
		 public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.activity_contactos);
		        
		        DatabaseHandler db = new DatabaseHandler(this);
			       
				List<Contact> contacts = db.getAllContacts();
				
				/*for(int j = 1;j < contacts.size();j++){
					  String conta="ID="+db.getContact(j).getID()+" nOMBRE: "+db.getContact(j).getName();
					  items[j]=conta;
				 }
				
				  setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,items));
				  selection=(TextView)findViewById(R.id.selection); 
                    */
				
				//ListView lv1=(ListView)findViewById(R.id.list);
				 TextView tv1=(TextView)findViewById(R.id.TextView1);
				
				for (Contact cn : contacts) {
		              String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
		              tv1.setText(log);
		    }
		      				
	}
	

	


	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

}
