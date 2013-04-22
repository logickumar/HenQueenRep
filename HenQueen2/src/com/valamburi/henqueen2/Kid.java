package com.valamburi.henqueen2;

//import java.util.LinkedList;

import java.util.Random;

import android.graphics.Bitmap;
import android.util.Log;

public class Kid extends GameScreenObject{
	public String action;
	public String kid_target;
	public float kidWidth,kidHeight,kid_startx,kid_starty,kid_endx,kid_endy;
	int nextIndex;
	Chick chick;
	Kid(float x,float y,String action)
	{
		this.x=x;
		this.y=y;
		this.action=action;
		nextIndex=0;
		kid_target=AllConstants.KID_TARGRT_CHICK;
	}
	public void DoUpdate(Game game)
	{
		Bitmap bitmap;
		bitmap=GetBitmapByIndex(AllConstants.KID_WALK_FRONT,0);
		kidWidth=bitmap.getWidth();
		kidHeight=bitmap.getHeight();
		kid_startx=x;
		kid_starty=y;
		kid_endx=x+kidWidth;
		kid_endy=y+kidHeight;
		Move(game);
	}
	public void Move(Game game)
	{
		Chick chick=game.chick;
		if(action==AllConstants.KID_WALK_FRONT){
			
			y+=8;
		}
		else if(action==AllConstants.KID_WALK_BACK)
		{
			y-=8;
			
		}
		Log.d("KID",action);
		Log.d("KID", kid_target);
		/*if(kid_target.equals(AllConstants.KID_TARGRT_CHICK))
		{
			
			if(action==AllConstants.KID_WALK_FRONT && kid_endy>=chick.y)
			 {
				 game.isRunning=false;
			 }
			else if(action==AllConstants.KID_WALK_BACK && kid_starty<=chick.chick_endy)
			{
				game.isRunning=false;
			}
				
		}*/
		
		Log.d("KID", kid_starty + "" + kid_endy + "" + chick.y + "" +chick.chick_endy);
		if((kid_starty>=chick.y && kid_starty<=chick.chick_endy) || (kid_endy>=chick.y && kid_endy<=chick.chick_endy))			
		 {
			Log.d("KID", "Inside chick & kid collision condition");
			 game.isRunning=false;
		 }
		/*if(kid_target.equals(AllConstants.KID_TARGRT_CHICK))
		{
			Log.d("KID", "Inside Target chick condition");
			if((kid_starty>=chick.y && kid_starty<=chick.chick_endy) || (kid_endy>=chick.y && kid_endy<=chick.chick_endy))
			
			 {
				Log.d("KID", "Inside chick & kid collision condition");
				 game.isRunning=false;
			 }
		}else
		{
			Random rm=new Random();
			float random=rm.nextInt(50);
		
			if(y>game.screenwidth)
			{
				y+=random;
				action=AllConstants.KID_WALK_BACK;
				Log.d("nextKid","walking back");
				
			}
			else if(y<0)
			{
				y-=random;
				action=AllConstants.KID_WALK_FRONT;
				Log.d("nextKid","walking front");
			}
		}*/
		
		
		
		}
		
		
	public Bitmap NextBitmap()
	{
		return GetNextBitmap(action);		
	}
	public boolean istouched(float tx,float ty)
	{   
		
		
		Log.d("HEN", "kid istouched");
		
		if(tx>=kid_startx && tx<=kid_endx && ty>=kid_starty && ty<=kid_endy)
		{
			return true;
		}
		return false;
	}
	

}

