package com.valamburi.henqueen2;

import java.util.LinkedList;

//import com.valamburi.henqueen2.AllConstants.HenAction;

import android.graphics.Bitmap;

public class Chick extends GameScreenObject {
	
	int nextIndex;
	Hen hen;
	float chick_width,chick_height,chick_endx,chick_endy;
	String chickAction;
	String nextChickAction;
		
	Chick(float x,float y,String chickAction)
	{
		this.x=x;
		this.y=y;
		nextIndex=0;
		this.chickAction=chickAction;
	}
	
	public Bitmap NextBitmap()
	{
		Bitmap bitmapNext=null;
	{
			bitmapNext=GetNextBitmap(chickAction);
			if(GetCurrentDrawablesList().isTrackAnimationEnabled() && GetCurrentDrawablesList().GetAnimationCount()>0)
			{
				chickAction=nextChickAction;
				GetCurrentDrawablesList().DisableTrackAnimationCount();
			}
	}
		
		return bitmapNext;
	}
	public void DoUpdate()
	{
		Move();
	}
	public void  Move()
	{
		Bitmap bitmap = GetBitmapByIndex(AllConstants.CHICK_ANIM,0);
		chick_height=bitmap.getHeight();
		chick_width=bitmap.getWidth();
		chick_endx=x+chick_width;
		chick_endy=y+chick_height;
	}
	
	public GameDrawableList GetCurrentDrawablesList()
	{
		
		return resources.drawableListsMap.get(chickAction);
	}
}
