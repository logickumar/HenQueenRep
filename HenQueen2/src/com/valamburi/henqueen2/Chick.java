package com.valamburi.henqueen2;

import android.graphics.Bitmap;

public class Chick extends GameScreenObject {
	
	int nextIndex;
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
	
	
	

}
