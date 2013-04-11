package com.valamburi.henqueen2;

import android.graphics.Bitmap;

public class AntFood extends GameScreenObject{
	public AllConstants.AntFoodDirection antFoodDirection;
	int nextIndex;
	AntFood(float x,float y,AllConstants.AntFoodDirection antFoodDirection)
	{
		this.x=x;
		this.y=y;
		nextIndex=0;
		this.antFoodDirection=antFoodDirection;
	}
	public void Move()
	{
		
		if(antFoodDirection==AllConstants.AntFoodDirection.ANT_FOOD_FRONT)
		{
		y++;	
		}else
		{
			y--;
		}
	
	}
	public void DoUpdate()
	{
		Move();
	}
	public Bitmap NextBitmap()
	{
		Bitmap bitmapNext;
		if(nextIndex==0)
		{
			bitmapNext=resources.drawables.get(nextIndex);
			//this.sleep(500);
			
			nextIndex=1;
		}
		else
		{
			bitmapNext=resources.drawables.get(nextIndex);
			nextIndex=0;
		}
		return bitmapNext;
	}

}
