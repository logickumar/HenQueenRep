package com.valamburi.henqueen2;

import java.util.LinkedList;

import android.graphics.Bitmap;

public class Kid extends GameScreenObject{
	public String kidDirection;
	//public AllConstants.KidDirection kidDirection;
	int nextIndex;
	Kid(float x,float y,String kidDirection)
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
		
		if(kidDirection==AllConstants.KID_WALK_FRONT){
			
			y+=5;
		}
		else
		{
			y-=5;
			
		}
		}
		
	public Bitmap NextBitmap()
	{
		return GetNextBitmap(kidDirection);		
	}
	

}

