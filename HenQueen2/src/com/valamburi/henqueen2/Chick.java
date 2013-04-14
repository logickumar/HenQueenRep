package com.valamburi.henqueen2;

import com.valamburi.henqueen2.AllConstants.HenAction;

import android.graphics.Bitmap;

public class Chick extends GameScreenObject {
	
	int nextIndex;
	Bitmap bitmap;
	Hen hen;
	float chick_width,chick_height,chick_endx,chick_endy;
	Chick(float x,float y)
	{
	this.x=x;
	this.y=y;
	nextIndex=0;
	}
	
	public Bitmap NextBitmap()
	{
		Bitmap bitmapNext;
		
		if(nextIndex==0)
		{
			
			bitmapNext=resources.drawables.get(nextIndex);
			nextIndex=1;
			/*this.x=70;
			this.y=130;*/
		}
		else
		{
			bitmapNext=resources.drawables.get(nextIndex);
			nextIndex=0;
			/*this.x=70;
			this.y=132;*/
			}
		
		if(nextIndex==2)
        {
			bitmapNext=resources.drawables.get(2);
			nextIndex=3;
		}
		else
		{
			bitmapNext=resources.drawables.get(3);
			nextIndex=0;
			hen.henAction=HenAction.HEN_STAND;
			
		}
		
		
		return bitmapNext;
	}
	public void DoUpdate()
	{
		Move();
	}
	public void  Move()
	{
		bitmap=resources.drawables.get(0);
		chick_height=bitmap.getHeight();
		chick_width=bitmap.getWidth();
		chick_endx=x+chick_width+chick_height;
		chick_endy=y+chick_width+chick_height;
	}
	
	
	

}
