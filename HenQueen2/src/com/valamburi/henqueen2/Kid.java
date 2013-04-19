package com.valamburi.henqueen2;

//import java.util.LinkedList;

import android.graphics.Bitmap;
import android.util.Log;

public class Kid extends GameScreenObject{
	public String action;
	public float kidWidth,kidHeight,kid_startx,kid_starty,kid_endx,kid_endy;
	int nextIndex;
	Kid(float x,float y,String action)
	{
		this.x=x;
		this.y=y;
		this.action=action;
		nextIndex=0;
	}
	public void DoUpdate()
	{
		Move();
	}
	public void Move()
	{
		
		if(action==AllConstants.KID_WALK_FRONT){
			
			y+=8;
		}
		else if(action==AllConstants.KID_WALK_BACK)
		{
			y-=8;
			
		}
		}
		
	public Bitmap NextBitmap()
	{
		return GetNextBitmap(action);		
	}
	public boolean istouched(float tx,float ty)
	{   
		Bitmap bitmap;
		bitmap=GetBitmapByIndex(AllConstants.KID_WALK_FRONT,0);
		kidWidth=bitmap.getWidth();
		kidHeight=bitmap.getHeight();
		kid_startx=x;
		kid_starty=y;
		kid_endx=x+kidWidth;
		kid_endy=y+kidHeight;
		
		Log.d("HEN", "kid istouched");
		
		if(tx>=kid_startx && tx<=kid_endx && ty>=kid_starty && ty<=kid_endy)
		{
			return true;
		}
		return false;
	}
	

}

