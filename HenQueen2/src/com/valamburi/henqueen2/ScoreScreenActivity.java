package com.valamburi.henqueen2;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class ScoreScreenActivity extends Activity {
	View scoreButton;
	View scoreValue,scoreValue1,scoreValue2;
	
    ImageButton playAgain,home;
    Intent playScreenIntent,homeScreenIntent;
    
    int[] scores={ R.drawable.score0,R.drawable.score1,R.drawable.score2,R.drawable.score3,R.drawable.score4,R.drawable.score5,R.drawable.score6,R.drawable.score7,R.drawable.score8,R.drawable.score9 };
  //  Bitmap bitmap=BitmapFactory.decodeResource(getResources(), scores[AllConstants.SCORE]);
    
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
   
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
		setContentView(R.layout.activity_score_screen);
	   
		 
			
		scoreButton=findViewById(R.id.imgScore);
		scoreValue=(ImageView)findViewById(R.id.imgScoreValue1);
		scoreValue1=(ImageView)findViewById(R.id.imgScoreValue2);
		scoreValue2=(ImageView)findViewById(R.id.imgScoreValue3);
		int a=AllConstants.SCORE/10;
		int b=a/10;
		int c=b/10;
		int x=AllConstants.SCORE%10;
	    int y=b%10;
	    int z=c%10;
		 Bitmap bitmapx=BitmapFactory.decodeResource(getResources(), scores[x]);
		 Bitmap bitmapy=BitmapFactory.decodeResource(getResources(), scores[y]);
		 Bitmap bitmapz=BitmapFactory.decodeResource(getResources(), scores[z]);
		 Log.d("Scorex",x + ""); 
		  Log.d("Scorey",y + ""); 
		  Log.d("Scorez",z + ""); 
		 
		 ((ImageView) scoreValue).setImageBitmap(bitmapx);
		 ((ImageView) scoreValue1).setImageBitmap(bitmapy);
		 ((ImageView) scoreValue2).setImageBitmap(bitmapz);
		  
	    
		
		 addListener();
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
		
		/*scoreButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.score_screen, menu);
		return true;
	}

}
