package com.valamburi.henqueen2;

import java.util.LinkedList;

import android.graphics.Bitmap;

public class Crow extends GameScreenObject {
	public String crowDirection;
	int nextIndex;
	Crow(float x,float y,String crowDirection)
	{
		this.x=x;
		this.y=y;
		this.crowDirection=crowDirection;
		nextIndex=0;
	}
	public void DoUpdate()
	{
		Move();
	}
	public void Move()
	{
		//int stepsToMove=0;
		if(crowDirection==AllConstants.CROW_FRONT){
			x-=7;
			y+=7;
		}
		else
		{
			y+=7;
			x-=7;
			
		}
	}
	public Bitmap NextBitmap()
	{
		Bitmap bitmapNext = null;
		if(crowDirection.equals(AllConstants.CROW_FRONT))
		{
			bitmapNext=GetNextBitmap(AllConstants.CROW_FRONT);
		}
		else if(crowDirection.equals(AllConstants.CROW_BACK))
		{
			bitmapNext=GetNextBitmap(AllConstants.CROW_BACK);
		}		
		return bitmapNext;
	}

}
