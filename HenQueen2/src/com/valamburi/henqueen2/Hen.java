package com.valamburi.henqueen2;

import java.util.LinkedList;

//import com.valamburi.henqueen2.AllConstants.HenAction;

import android.graphics.Bitmap;
import android.util.Log;


public class Hen extends GameScreenObject
{
//	public String direction;
	public String henAction;
	public String nextHenAction;
	public String target;
	
	public int targetAntIndex;
	
	
	//public AllConstants.HenDirection direction;
	//public AllConstants.HenAction henAction;
	//public int stepsToMove;
	public int nextIndex;
	Bitmap bitmap;
	//Ant ant;
	//Chick chick;
	float henHeight,henWidth,hen_startx,hen_starty,hen_endx,hen_endy;
	//float ant_startx;
	
	//Hen(float x,float y,AllConstants.HenDirection direction,AllConstants.HenAction henAction)
	Hen(float x,float y,String henAction)
	{
		this.x=x;
		this.y=y;
		
	//	this.direction=direction;
		this.henAction=henAction;
		//this.stepsToMove=0;
		nextIndex=0;
	}
	
	public void Move(Game game)
	{
			
		Ant[] ant=game.ant;
		Chick chick=game.chick;
		Cat cat=game.cat;
		Kid kid=game.kid;
		
		
		bitmap=GetBitmapByIndex(AllConstants.HEN_STAND_FRONT,0);
		henHeight=bitmap.getHeight();
		henWidth=bitmap.getWidth();
		hen_startx=x;
		hen_starty=y;
		
		 hen_endx=hen_startx+henWidth;
		 hen_endy=hen_starty+henHeight;
		// Case when Hen Walks
		int i=targetAntIndex;
		 
		if(henAction==AllConstants.HEN_WALK_FRONT && target.equals(AllConstants.HEN_TARGET_ANT))
			{
				
					if(y<=ant[i].y && y<=ant[i].y+ant[i].antWidth)
					{
						y+=10;	
						Log.d("HEN", "Walking Front");
						
					}
					else
					{
					  henAction=AllConstants.HEN_EAT_FOOD_FRONT;
					  Log.d("HEN", "Eat Front");
					  ant[i].visibility=false;
					  ant[i].randomize(game);
					  nextHenAction=AllConstants.HEN_WALK_WITH_FOOD_BACK;	
					}
			}				
			else if(henAction==AllConstants.HEN_WALK_BACK  && target.equals(AllConstants.HEN_TARGET_ANT))
				{
					if(y>ant[i].y && y>ant[i].y+ant[i].antWidth)
					{
						y-=10;
						Log.d("HEN", "Walking Back");
					}
					else
					{
						
						henAction=AllConstants.HEN_EAT_FOOD_BACK;
						ant[i].visibility=false;
						ant[i].randomize(game);
						nextHenAction=AllConstants.HEN_WALK_WITH_FOOD_FRONT;					
						Log.d("HEN", "Eat Back");					
					}
				}
		
	
	// Case when when hen walks with food
		
	if(henAction==AllConstants.HEN_WALK_WITH_FOOD_FRONT )
	{
			
				if(y<chick.y && y<chick.chick_endy)
				{
					y+=5;
					Log.d("HEN","Walking Front");
				}else
				{					
					henAction=AllConstants.HEN_STAND_FRONT;
					chick.nextChickAction=AllConstants.CHICK_WITH_FOOD;
					Log.d("chick","chick_with_food");
					// score.add(10);
				}
			
	}
			else if(henAction==AllConstants.HEN_WALK_WITH_FOOD_BACK )
			{
				//if(direction==AllConstants.HenDirection.HEN_BACK)
					if(y>chick.y && y>chick.chick_endy)
					{
						y-=5;
						Log.d("HEN","Walking back");
					}
				else
					{
						henAction=AllConstants.HEN_STAND_BACK;
						chick.nextChickAction=AllConstants.CHICK_WITH_FOOD;
						// score.add(10);
					}
			}
	if(henAction==AllConstants.HEN_WALK_FRONT && target.equals(AllConstants.HEN_TARGET_CAT))
	{
		if(hen_endy<=cat.y)// && y<=cat.y+cat.catWidth)
		{
			y+=12;	
			Log.d("HEN", "Walking Front");			
		}
		else
		{
		  henAction=AllConstants.HEN_HIT_FRONT;
		  Log.d("HEN", "Hit Front");
		  nextHenAction=AllConstants.HEN_STAND_FRONT;
		  //cat.cat_target=AllConstants.CAT_TARGET_CHICK;
		  cat.action=AllConstants.CAT_WALK_FRONT;
		  cat.cat_target=AllConstants.CAT_TARGET_NULL;
		 
		 // score.add(10);
		}
    }
	else if(henAction==AllConstants.HEN_WALK_BACK && target.equals(AllConstants.HEN_TARGET_CAT))
	{
		if(hen_endy>=cat.y)// && y>cat.y+cat.catWidth)
		{
			y-=12;
			Log.d("HEN", "Walking Back");
		}
		else
		{			
			henAction=AllConstants.HEN_HIT_BACK;
			Log.d("HEN", "Hit Back");
			nextHenAction=AllConstants.HEN_STAND_BACK;
			cat.action=AllConstants.CAT_WALK_BACK;
			cat.cat_target=AllConstants.CAT_TARGET_NULL;
			
			// score.add(10);
		}
	}
	if(henAction==AllConstants.HEN_WALK_FRONT && target.equals(AllConstants.HEN_TARGET_KID))
	{
		if(hen_endy<=kid.y)// && y<=kid.y+kid.kidWidth)
		{
			y+=10;	
			Log.d("HEN", "Walking Front");			
		}
		else
		{
		  henAction=AllConstants.HEN_HIT_FRONT;
		  nextHenAction=AllConstants.HEN_STAND_FRONT;
		  kid.action=AllConstants.KID_WALK_FRONT;
		 // score.add(10);
		  Log.d("HEN", "Hit Front");
		}
    }
	else if(henAction==AllConstants.HEN_WALK_BACK && target.equals(AllConstants.HEN_TARGET_KID))
	{
		if(y>=kid.kid_endy+7)// && y>kid.y+kid.kidWidth)
		{
			y-=10;
			Log.d("HEN", "Walking Back");
		}
		else
		{			
			henAction=AllConstants.HEN_HIT_BACK;
			kid.action=AllConstants.KID_WALK_BACK;
			nextHenAction=AllConstants.HEN_STAND_BACK;
			Log.d("HEN", "Hit Back");
			// score.add(10);
		}
	}



 }
		
		
	

	public void DoUpdate(Game game)
	{
		Move(game);
	}
	
	public  Bitmap NextBitmap(){
		Bitmap bitmapNext=null;
		bitmapNext=GetNextBitmap(henAction);
		if(GetCurrentDrawablesList().isTrackAnimationEnabled() && GetCurrentDrawablesList().GetAnimationCount()>0)
		{
			henAction=nextHenAction;	
			GetCurrentDrawablesList().DisableTrackAnimationCount();
		}
				
		return bitmapNext;
		}
	
	public GameDrawableList GetCurrentDrawablesList()
	{
		
		return resources.drawableListsMap.get(henAction);
	}



	
		
	}
	
	


