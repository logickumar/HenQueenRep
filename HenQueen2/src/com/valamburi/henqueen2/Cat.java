package com.valamburi.henqueen2;

import android.graphics.Bitmap;

public class Cat extends GameScreenObject {
	public String direction;
	int nextIndex;
	Cat(float x,float y,String direction)
	{
	this.x=x;
	this.y=y;
	nextIndex=0;
	this.direction=direction;
	}
	public void Move()
	{
		
			if(direction.equals(AllConstants.CAT_FRONT)){
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
		return GetNextBitmap(direction);
	}
}
