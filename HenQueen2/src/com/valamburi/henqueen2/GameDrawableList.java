package com.valamburi.henqueen2;

import java.util.LinkedList;
import android.graphics.Bitmap;

public class GameDrawableList {
	private int nextIndex=0;
	public LinkedList<Bitmap> drawables;
	private boolean trackAnimation=false;
	private int animationCount=0;
	public GameDrawableList()
	{		
		nextIndex=0;
		drawables=new LinkedList<Bitmap>();
	}	
	
	public Bitmap  GetNextBitmap()
	{
		Bitmap bitmap=null;
	    if(nextIndex<drawables.size())
	    {
	    	bitmap=drawables.get(nextIndex);
	    	nextIndex=nextIndex+1;	    	
	    }
	    else
	    {
	    	if(trackAnimation)
	    		animationCount++;
	    	bitmap=drawables.get(0);
	    	nextIndex=1;
	    }	
	    return bitmap;
	}
	
	public void add(Bitmap bitmap)
	{
		drawables.add(bitmap);
	}
	
	public Bitmap  GetBitmapByIndex(int index)
	{
	   return drawables.get(index);	  
	}
	
	public void EnableTrackAnimationCount()
	{		
		animationCount=0;
		trackAnimation=true;		
	}
	
	public void DisableTrackAnimationCount()
	{		
		trackAnimation=false;
		animationCount=0;
	}
	
	public int GetAnimationCount()
	{
		return animationCount;
	}
	
	public boolean isTrackAnimationEnabled()
	{
		
		return trackAnimation;
	}
	
	

}
