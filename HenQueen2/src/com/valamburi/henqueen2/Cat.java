package com.valamburi.henqueen2;

import java.util.Random;

import android.graphics.Bitmap;
import android.util.Log;

public class Cat extends GameScreenObject {
	public String action;
	int nextIndex;
	public float catWidth,catHeight,cat_startx,cat_starty,cat_endx,cat_endy;
	public String cat_target;
	
	Cat(float x,float y,String action)
	{
		this.x=x;
		this.y=y;
		nextIndex=0;
		this.action=action;
		cat_target=AllConstants.CAT_TARGET_CHICK;
	}
	
	public void Move(Game game)
	
	{		
		/*if(y<=0 || y>=game.screenwidth){
			cat_target=AllConstants.CAT_TARGET_NULL;
		}*/
		if(cat_target==AllConstants.CAT_TARGET_NULL)
		{
			Random rm=new Random();
			float random=rm.nextInt(50);
			if(y>game.screenwidth)
			{
				y+=random;
				action=AllConstants.CAT_WALK_BACK;
				cat_target=AllConstants.CAT_TARGET_CHICK;
				Log.d("nextcat","walking back");
			}
			else if(y<0)
			{
				y-=random;
				action=AllConstants.CAT_WALK_FRONT;
				cat_target=AllConstants.CAT_TARGET_CHICK;
				Log.d("nextcat","walking front");
			}
			Log.d("nextcat","walking");
			//cat_target=AllConstants.CAT_TARGET_CHICK;
		}
		
			if(action.equals(AllConstants.CAT_WALK_FRONT))
			{
				y+=5;				
			}
			else if(action.equals(AllConstants.CAT_WALK_BACK))
			{
				y-=5;			
			}
		
	}
		
	public void DoUpdate(Game game)
	{
		Move(game);
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

