package com.valamburi.henqueen2;

import android.graphics.Bitmap;


public class GameScreenObject {
	public float x;
	public float y;
	public boolean visibility=true;
	GameObjectResources resources=new GameObjectResources();
	
	
	public Bitmap GetNextBitmap(String actionKey)
	{
		return resources.drawableListsMap.get(actionKey).GetNextBitmap();
	}
	
	public Bitmap GetBitmapByIndex(String actionKey,int index)
	{
		return resources.drawableListsMap.get(actionKey).GetBitmapByIndex(index);
		
	}
	
}
