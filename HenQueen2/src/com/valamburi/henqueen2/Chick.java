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
		
	Chick(float x,float y)
	{
		this.x=x;
		this.y=y;
		nextIndex=0;
		chickAction=AllConstants.CHICK_ANIM;
	}
	
	public Bitmap NextBitmap()
	{
		Bitmap bitmapNext=null;
//		if(hen.henAction.equals(AllConstants.HEN_FEED))
//		{
//			bitmapNext=GetNextBitmap(AllConstants.CHICK_WITH_FOOD);
//		}
//		else
		{
			bitmapNext=GetNextBitmap(chickAction);
			if(GetCurrentDrawablesList().isTrackAnimationEnabled() && GetCurrentDrawablesList().GetAnimationCount()>0)
			{
				chickAction=nextChickAction;
				GetCurrentDrawablesList().DisableTrackAnimationCount();
			}
		}
		
		/*if(nextIndex==0)
		{
			
			bitmapNext=resources.drawables.get(nextIndex);
			nextIndex=1;
			this.x=70;
			this.y=130;
		}
		else if(nextIndex==1)
		{
			bitmapNext=resources.drawables.get(nextIndex);
			nextIndex=0;
			this.x=70;
			this.y=132;
			}*/
		
		/*if(nextIndex==2)
        {
			bitmapNext=resources.drawables.get(2);
			nextIndex=3;
		}
		else if(nextIndex==3)
		{
			bitmapNext=resources.drawables.get(3);
			nextIndex=0;
			hen.henAction=AllConstants.HenAction.HEN_STAND;
			
		}*/
		
		
		return bitmapNext;
	}
	public void DoUpdate()
	{
		Move();
	}
	public void  Move()
	{
		Bitmap bitmap = GetNextBitmap(AllConstants.CHICK_ANIM);
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
