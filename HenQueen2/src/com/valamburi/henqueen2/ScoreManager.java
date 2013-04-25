package com.valamburi.henqueen2;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ScoreManager  {
	
	public int score=0;

	
	public void add(int value)
	{
		score=score+value;
		Log.d("HEN","score:"+score);
		
	}

	
}
