package com.example.saviour.contacts;

import android.R;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.widget.TextView;
import android.widget.Toast;

public class Contacts extends Activity {

  private Fragment detailFragment = null;
    
	private ContactList list = null;
	
	private TextView Name = null, Mobile = null, Message = null;
    
	SharedPreferences myKey = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(com.example.saviour.R.layout.contact);
	    
		myKey = PreferenceManager.getDefaultSharedPreferences(this);
		
		list = new ContactList();
		
		
		 detailFragment = getFragmentManager().findFragmentById(com.example.saviour.R.id.details);
		
	    	 Name = (TextView)detailFragment.getView().findViewById(com.example.saviour.R.id.textView1);
		    
		    Mobile = (TextView)detailFragment.getView().findViewById(com.example.saviour.R.id.number);
		    
		    Message = (TextView)detailFragment.getView().findViewById(com.example.saviour.R.id.textView4);
		    
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	
		getMenuInflater().inflate(com.example.saviour.R.menu.home_xml, menu);
	
		return true;
	
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		switch (item.getNumericShortcut()) {
	
		case '1':
			
			Log.w("idd", String.valueOf(1));
				
			Intent create = new Intent(getApplicationContext(), Create.class);
			create.putExtra("Type", "New");
			create.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(create);
			
			break;
			
		case '2' :

			Log.w("idd", String.valueOf(2));

			
			Intent edit = new Intent(getApplicationContext(), Create.class);
			edit.putExtra("Type", "Edit");
		   	
			edit.putExtra("Key", myKey.getInt("Key", 0));
			edit.putExtra("Name", Name.getText().toString());
			edit.putExtra("Mobile", Mobile.getText().toString());
			edit.putExtra("Message", Message.getText().toString());
			
			
			edit.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(edit);	
			
		 break;

		case '3' :
			
			 break;
		 
		default:
			
			break;
		}
		
		
		return true;
	}
}

