package com.valamburi.henqueen2;

import java.util.LinkedList;

import android.graphics.Bitmap;

public class AntFood extends GameScreenObject{
	String antFoodDirection;
	//public AllConstants.AntFoodDirection antFoodDirection;
	int nextIndex;
	AntFood(float x,float y,String antFoodDirection)
	{
		this.x=x;
		this.y=y;
		nextIndex=0;
		this.antFoodDirection=antFoodDirection;
	}
	public void Move()
	{
		
		if(antFoodDirection==AllConstants.ANT_FOOD_FRONT)
		{
		y+=5;	
		} else if(antFoodDirection==AllConstants.ANT_FOOD_BACK)
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
		Bitmap bitmapNext=null;
		if(antFoodDirection.equals(AllConstants.ANT_FOOD_FRONT))
		{
			bitmapNext=GetNextBitmap(AllConstants.ANT_FOOD_FRONT);
		}
		return bitmapNext;
	}

}
