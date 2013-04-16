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
		

		
		
		//ant_startx=0;
	}
	/*public boolean istouched()
	{
		
		
		bitmap=resources.drawables.get(nextIndex);
		henHeight=bitmap.getHeight();
		henWidth=bitmap.getWidth();
	     hen_startx=x;
		 hen_starty=y;
		
		 hen_endx=hen_startx+henWidth+henHeight;
		hen_endy=hen_starty+henHeight+henWidth;
		
		//ant.istouched(hen_startx,hen_starty,hen_endx,hen_endy);hen.HenCollision();
		if(hen_startx>=ant.ant_startx && hen_endx<=ant.ant_endx && hen_starty>=ant.ant_starty && hen_endy<=ant.ant_endy)
		{
			henAction=AllConstants.HenAction.HEN_EAT_FOOD;
			// boolean istouched=true;
			
		}
		return false;
	}*/
		
	
	
	public void Move(Game game)
	{
			
		Ant ant=game.ant;
		Chick chick=game.chick;
		
		bitmap=GetBitmapByIndex(AllConstants.HEN_STAND_FRONT,0);
		henHeight=bitmap.getHeight();
		henWidth=bitmap.getWidth();
		hen_startx=x;
		hen_starty=y;
		
		 hen_endx=hen_startx+henWidth;
		 hen_endy=hen_starty+henHeight;
		// Case when Hen Walks
		
			if(henAction==AllConstants.HEN_WALK_FRONT)
			{
				if(y<=ant.y && y<=ant.y+ant.antWidth)
				{
					y+=5;	
					Log.d("HEN", "Walking Front");
					
				}
				else
				{
				  henAction=AllConstants.HEN_EAT_FOOD_FRONT;
				 //	ant.visibility=false;
				//	nextIndex=6;
					Log.d("HEN", "Eat Front");
				}
		    }
			else if(henAction==AllConstants.HEN_WALK_BACK)
			{
				if(y>ant.y && y>ant.y+ant.antWidth)
				{
					y-=5;
					Log.d("HEN", "Walking Back");
				}
				else
				{
					
					henAction=AllConstants.HEN_EAT_FOOD_BACK;
					nextHenAction=AllConstants.HEN_WALK_WITH_FOOD_FRONT;
				//	nextIndex=8;
					//ant.visibility=false;
					Log.d("HEN", "Eat Back");
				}
			}
				

		
	// Case when when hen walks with food
		
	if(henAction==AllConstants.HEN_WALK_WITH_FOOD_FRONT)
	{
			//if(direction==AllConstants.HEN_FRONT)
			//{
				if(y<chick.y && y<chick.chick_endy)
				{
					y+=5;
					Log.d("HEN","Walking Front");
				}else
				{					
					henAction=AllConstants.HEN_STAND_FRONT;
					chick.nextChickAction=AllConstants.CHICK_WITH_FOOD;
				
				}
			
	}
			else if(henAction==AllConstants.HEN_WALK_WITH_FOOD_BACK)
			{
				//if(direction==AllConstants.HenDirection.HEN_BACK)
				//{
					if(y>chick.y && y>chick.chick_endy)
					{
						y-=5;
						Log.d("HEN","Walking back");
					}
				else
					{
						henAction=AllConstants.HEN_STAND_BACK;
						chick.nextChickAction=AllConstants.CHICK_WITH_FOOD;
					}
			}
			
		
//	
//	if(henAction==AllConstants.HenAction.HEN_STAND_WITH_FOOD)
//	{
//		henAction=AllConstants.HenAction.HEN_WALK_WITH_FOOD;
//	}
	
//	// Case wheen hen feeds food
//	if(henAction==AllConstants.HenAction.HEN_FEED)
//	{
//		henAction=AllConstants.HenAction.HEN_STAND;
//	}
//	
//	if(henAction==AllConstants.HenAction.HEN_STAND_WITH_FOOD)
//	{
//		ant.visibility=false;
//	}
		
//    // Case when hen flies		    
//	if(henAction==AllConstants.HenAction.HEN_FLY)
//	{
//		
//		if(direction==AllConstants.HenDirection.HEN_FRONT )
//		{
//		  x=5;
//		  y=7;
//		}
//		else
//		{
//			x=5;
//			y=7;
//		}
//	}
		
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
		
//				case HEN_EAT_FOOD:
//					if(direction==AllConstants.HenDirection.HEN_FRONT)
//					{
//						if(nextIndex==6)
//						{
//							
//							nextIndex=7;
//						}
//						else if(nextIndex==7)
//						{
//							nextIndex=6;
//							henAction=AllConstants.HenAction.HEN_WALK_WITH_FOOD;
//						}
//					
//					}
//					else if(direction==AllConstants.HenDirection.HEN_BACK)
//					{
//						if(nextIndex==8)
//						{							
//							nextIndex=9;
//						}
//						else if(nextIndex==9)
//						{
//							nextIndex=8;
//							henAction=AllConstants.HenAction.HEN_WALK_WITH_FOOD;
//						}
//					}
//					break;
//				case HEN_STAND_WITH_FOOD:
//					if(direction==AllConstants.HenDirection.HEN_FRONT)						
//						nextIndex=10;
//					else
//						nextIndex=11;					
//					break;
					
//				case HEN_WALK_WITH_FOOD:
//					if(direction==AllConstants.HenDirection.HEN_FRONT)
//					{
//					 if(nextIndex==11)
//					 {
//						 
//						 nextIndex=10;
//					 }
//					 else if(nextIndex==10)
//					 {
//						 
//						 nextIndex=11;
//					 }
//					}
//					 else if(direction==AllConstants.HenDirection.HEN_BACK)
//					 {
//						 if(nextIndex==13)
//						 {
//							
//							 nextIndex=12;
//						 }
//						 else if(nextIndex==12)
//						 {
//							
//							 nextIndex=13;
//						 }	 
//						 
//					 
//					}
//					 break;
//				case HEN_FEED:
//					//chick.nextIndex=2;
//					break;
//				case HEN_FLY:
//					if(direction==AllConstants.HenDirection.HEN_FRONT)
//					{
//						if(nextIndex==10)
//						{
//							
//							nextIndex=11;
//						}
//							else{
//					
//								nextIndex=10;
//						}
//					}
//					
//					else if(direction==AllConstants.HenDirection.HEN_BACK)
//					{
//						if(nextIndex==12)
//						{
//					
//						nextIndex=13;
//					}
//					else
//					{
//					
//						nextIndex=12;
//					
//					}
//			}
//					break;
			
						
		
				
		return bitmapNext;
		}
	
	public GameDrawableList GetCurrentDrawablesList()
	{
		
		return resources.drawableListsMap.get(henAction);
	}
	
	}


