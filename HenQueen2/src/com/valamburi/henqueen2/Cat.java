package com.valamburi.henqueen2;

import android.graphics.Bitmap;
import android.util.Log;

public class Cat extends GameScreenObject {
	public String action;
	int nextIndex;
	public float catWidth,catHeight,cat_startx,cat_starty,cat_endx,cat_endy;
	
	Cat(float x,float y,String action)
	{
		this.x=x;
		this.y=y;
		nextIndex=0;
		this.action=action;
	}
	
	public void Move()
	{		
		if(action.equals(AllConstants.CAT_WALK_FRONT))
		{
			y+=5;				
		}
		else if(action.equals(AllConstants.CAT_WALK_BACK))
		{
			y-=5;			
		}			
	}
		
	public void DoUpdate()
	{
		Move();
	}
	
	public Bitmap NextBitmap()
	{
		return GetNextBitmap(action);
	}
	
	public boolean istouched(float tx,float ty)
	{   
		Bitmap bitmap;
		bitmap=GetBitmapByIndex(AllConstants.CAT_WALK_FRONT,0);
		catWidth=bitmap.getWidth();
		catHeight=bitmap.getHeight();
		cat_startx=x;
		cat_starty=y;
		cat_endx=x+catWidth;
		cat_endy=y+catHeight;
		
		Log.d("HEN", "Inside Cat istouched");
		
		if(tx>=cat_startx && tx<=cat_endx && ty>=cat_starty && ty<=cat_endy)
		{
			return true;
		}
		return false;
	}
		
}

