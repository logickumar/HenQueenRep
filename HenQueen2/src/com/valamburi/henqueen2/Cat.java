package com.valamburi.henqueen2;

import java.util.Random;

import android.graphics.Bitmap;
import android.util.Log;

public class Cat extends GameScreenObject {
	public String action;
	int nextIndex;
	public float catWidth,catHeight,cat_startx,cat_starty,cat_endx,cat_endy;
	public String cat_target;
	//public Chick chick;
	
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
	Chick chick=game.chick;
			
		/*if(y<=0 || y>=game.screenwidth){
			cat_target=AllConstants.CAT_TARGET_NULL;
		}*/
		
	/*		Random rm=new Random();
			float random=rm.nextInt(50);
			if(y>game.screenwidth)
			{
				y+=random;
				action=AllConstants.CAT_WALK_BACK;
				Log.d("nextcat","walking back");
			}
			else if(y<0)
			{
				y-=random;
				action=AllConstants.CAT_WALK_FRONT;
				Log.d("nextcat","walking front");
			}*/
			
		
		
			if(action.equals(AllConstants.CAT_WALK_FRONT))
			{
				y+=5;				
			}
			else if(action.equals(AllConstants.CAT_WALK_BACK))
			{
				y-=5;			
			}
			if(cat_target.equals(AllConstants.CAT_TARGET_CHICK))
			{
				
				if((cat_starty>=chick.y && cat_starty<=chick.chick_endy) || (cat_endy>=chick.y && cat_endy<=chick.chick_endy))
				 {
					 game.isRunning=false;
				 }
			}
		
	}
		
	public void DoUpdate(Game game)
	{
		Bitmap bitmap;
		bitmap=GetBitmapByIndex(AllConstants.CAT_WALK_FRONT,0);
		catWidth=bitmap.getWidth();
		catHeight=bitmap.getHeight();
		cat_startx=x;
		cat_starty=y;
		cat_endx=x+catWidth;
		cat_endy=y+catHeight;
		Move(game);
	}
	
	public Bitmap NextBitmap()
	{
		return GetNextBitmap(action);
	}
	
	public boolean istouched(float tx,float ty)
	{   
		
		Log.d("HEN", "Inside Cat istouched");
		if(tx>=cat_startx && tx<=cat_endx && ty>=cat_starty && ty<=cat_endy)
		{
			return true;
		}
		return false;
	}
		
}

