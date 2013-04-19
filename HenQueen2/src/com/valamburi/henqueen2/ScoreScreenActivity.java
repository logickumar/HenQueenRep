package com.valamburi.henqueen2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

public class ScoreScreenActivity extends Activity {
	View scoreButton;
	TextView value;
    ImageButton playAgain,home;
    Intent playScreenIntent,homeScreenIntent;
   
   /* int score=0;
   
	public ScoreScreenActivity(Hen hen)
	{
		score=0;
	}*/
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
		setContentView(R.layout.activity_score_screen);
		value=(TextView)findViewById(R.id.scoreValue);
		//add(score);
		
		//playAgain=(ImageButton)findViewById(R.id.imageButton1);
		//playAgain=(ImageButton)findViewById(R.id.imageButton2);
		 addListener();
	}
	public void add(int score)
	{
		score=score+10;
	}

	private void addListener() {
		// TODO Auto-generated method stub
		home=(ImageButton)findViewById(R.id.homeButton);
		home.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent homeScreenIntent=new Intent(getBaseContext(),MainActivity.class);
				startActivity(homeScreenIntent);
			}
			
		});
		playAgain=(ImageButton)findViewById(R.id.playAgainButton);
		playAgain.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent playScreenIntent=new Intent(getBaseContext(), PlayScreenctivity.class);
				startActivity(playScreenIntent);
				
			}
			
		});
		scoreButton=findViewById(R.id.imgScore);
		scoreButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//value.setText(score);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.score_screen, menu);
		return true;
	}

}
