package com.valamburi.henqueen2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends Activity implements OnClickListener {
    View startButton;
    Animation startButtonAnim;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // No Action Bar
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
        setContentView(R.layout.activity_main);
       
        // Start Button
        startButton=findViewById(R.id.imgStartButton);
		startButton.setOnClickListener(this);
		startButtonAnim = AnimationUtils.loadAnimation(this, R.anim.button_flicker);
		}
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent playScreenIntent=new Intent(this,ScoreScreenActivity.class);
	    v.startAnimation(startButtonAnim);
	    startButtonAnim.setAnimationListener(new StartActivityAfterAnimationAndSound(this,playScreenIntent,R.raw.applause));
        		
	}
	
	
}
