package com.valamburi.henqueen2;

import android.graphics.Bitmap;

public class Chick extends GameScreenObject {
	
	int nextIndex;
	Bitmap bitmap;
	float chick_width,chick_height,chick_startx,chick_starty,chick_endx,chick_endy;
	Chick(float x,float y)
	{
	this.x=x;
	this.y=y;
	nextIndex=0;
	}
	
	public Bitmap NextBitmap()
	{
		Bitmap bitMapNext;
		if(nextIndex==0)
		{
			
			bitMapNext=resources.drawables.get(nextIndex);
			nextIndex=1;
			/*this.x=70;
			this.y=130;*/
		}
		else
		{
			bitMapNext=resources.drawables.get(nextIndex);
			nextIndex=0;
			/*this.x=70;
			this.y=132;*/
			
			
		}
		return bitMapNext;
	}
	
	public boolean istouched(float tx,float ty)
	{   bitmap=resources.drawables.get(0);
	    chick_width=bitmap.getWidth();
	    chick_height=bitmap.getHeight();
	    chick_startx=x;
	    chick_starty=y;
	    chick_endx=chick_startx+chick_width+chick_height;
	    chick_endy=chick_starty+chick_width+chick_height;
	    if(tx>chick_startx && tx<chick_endy && ty>chick_startx && ty<chick_endy)
	    {
	    	return true;
	    }
		return false;
	}
	

}
