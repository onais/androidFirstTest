package com.example.test;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	TextView tvRes;
	EditText txtPoids;
	EditText txtTaille;
	CheckBox chkFonction;
	RadioButton rdM;
	RadioButton rdC;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		  tvRes=(TextView) findViewById(R.id.res);
		  txtPoids=(EditText) findViewById(R.id.txtPoids);
		  txtTaille=(EditText) findViewById(R.id.txtTaille);
		  chkFonction=(CheckBox) findViewById(R.id.chkFonction);
		  rdM=(RadioButton) findViewById(R.id.rdM);
		  rdC=(RadioButton) findViewById(R.id.rdC);
			TextWatcher tw=	new TextWatcher(){
				
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {
					tvRes.setText("vous devez cliquer sur le button -Calculer l'IMC- pour obtenir le resultat");
					
					
				}
				
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void afterTextChanged(Editable s) {
					// TODO Auto-generated method stub
					
				}
			};
		  txtPoids.addTextChangedListener(tw);
		  txtTaille.addTextChangedListener(tw);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void remettreZero(View v){
		tvRes.setText("vous devez cliquer sur le button -Calculer l'IMC- pour obtenir le resultat");
		txtPoids.getText().clear();
		txtTaille.getText().clear();
		chkFonction.setChecked(false);
		rdM.setChecked(false);
		rdC.setChecked(true);
	}
	
	public void calculer(View v){
		if(txtPoids.getText().toString().equals("")||txtTaille.getText().toString().equals(""))
			  Toast.makeText(MainActivity.this, "Hého, tu es un Minipouce ou quoi ?", Toast.LENGTH_SHORT).show();
		else{
		
		float poids=Float.parseFloat(txtPoids.getText().toString());
		float taille=Float.parseFloat(txtTaille.getText().toString());
		if(rdC.isChecked()) taille=taille/100;
		
		float r=poids/taille;
		
		
		
		if(chkFonction.isChecked())
			tvRes.setText("Le resultat est "+r);
		else	
		tvRes.setText("res= "+r);
		}
	}
	
	
}
