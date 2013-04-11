package com.valamburi.henqueen2;

import android.graphics.Bitmap;

public class Cat extends GameScreenObject {
	public AllConstants.CatDirection catDirection;
	int nextIndex;
	Cat(float x,float y,AllConstants.CatDirection catDirection)
	{
	this.x=x;
	this.y=y;
	nextIndex=0;
	this.catDirection=catDirection;
	}
	public void Move()
	{
		
			if(catDirection==AllConstants.CatDirection.CAT_FRONT){
				y+=5;
				
			}
			else
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
		Bitmap bitMapNext;
		if(nextIndex==2)
		{
			
			bitMapNext=resources.drawables.get(nextIndex);
			nextIndex=3;
			
		}
		else
		{
			bitMapNext=resources.drawables.get(nextIndex);
			nextIndex=2;
			
			
		}
		return bitMapNext;
	}
}
