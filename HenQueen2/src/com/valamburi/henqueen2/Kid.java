package com.valamburi.henqueen2;

import android.graphics.Bitmap;

public class Kid extends GameScreenObject{
	public AllConstants.KidDirection kidDirection;
	int nextIndex;
	Kid(float x,float y,AllConstants.KidDirection kidDirection)
	{
		this.x=x;
		this.y=y;
		this.kidDirection=kidDirection;
		nextIndex=0;
	}
	public void DoUpdate()
	{
		Move();
	}
	public void Move()
	{
		//int stepsToMove=1;
		//if(stepsToMove>0)
		//{
		if(kidDirection==AllConstants.KidDirection.KID_WALK_FRONT){
			
			y+=5;
		}
		else
		{
			y-=5;
			
		}
		}
		//stepsToMove++;
	//}
	public Bitmap NextBitmap()
	{
		Bitmap bitmapNext = null;
		if(nextIndex==0)
		{
			bitmapNext=resources.drawables.get(nextIndex);
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

