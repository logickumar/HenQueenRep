package com.valamburi.henqueen2;

import com.valamburi.henqueen2.AllConstants.HenAction;

import android.graphics.Bitmap;


public class Hen extends GameScreenObject
{
	//public int direction1;
	public AllConstants.HenDirection direction;
	public AllConstants.HenAction henAction;
	public int stepsToMove;
	public int nextIndex;
	Bitmap bitmap;
	Ant ant;
	Chick chick;
	float henHeight,henWidth,hen_startx,hen_starty,hen_endx,hen_endy;
	//float ant_startx;
	
	Hen(float x,float y,AllConstants.HenDirection direction,AllConstants.HenAction henAction)
	{
		this.x=x;
		this.y=y;
		
		this.direction=direction;
		this.henAction=henAction;
		this.stepsToMove=0;
		nextIndex=0;
		
		//ant_startx=0;
	}
	public boolean istouched()
	{
		
		
		bitmap=resources.drawables.get(nextIndex);
		henHeight=bitmap.getHeight();
		henWidth=bitmap.getWidth();
	     hen_startx=x;
		 hen_starty=y;
		
		 hen_endx=hen_startx+henWidth+henHeight;
		hen_endy=hen_starty+henHeight+henWidth;
		
		//ant.istouched(hen_startx,hen_starty,hen_endx,hen_endy);hen.HenCollision();
		/*if(hen_startx>=ant.ant_startx && hen_endx<=ant.ant_endx && hen_starty>=ant.ant_starty && hen_endy<=ant.ant_endy)
		{
			henAction=AllConstants.HenAction.HEN_EAT_FOOD;
			// boolean istouched=true;
			
		}*/
		return true;
	}
		
	
	
	public void Move()
	{
					
		if(henAction==AllConstants.HenAction.HEN_WALK)
		{
			
	
		if(direction==AllConstants.HenDirection.HEN_FRONT)
		{
			if(y<=ant.y && y<ant.y+ant.antWidth)
			{
			y+=5;	
			}
			else
			{
				henAction=AllConstants.HenAction.HEN_EAT_FOOD;
			}
	    }
		else
		{
			if(y>10 && y>ant.y && y>ant.y+ant.antWidth)
			{
				y-=5;
			}
			else
			{
				
				henAction=AllConstants.HenAction.HEN_EAT_FOOD;
			}
		}
		}
		
	 else 
	{
		henAction=AllConstants.HenAction.HEN_STAND;
	}
	
	
	if(henAction==AllConstants.HenAction.HEN_WALK_WITH_FOOD)
		{
			
	
		if(direction==AllConstants.HenDirection.HEN_FRONT)
		{
			if(y<chick.chick_starty && y<chick.chick_endy)
			{
				y+=5;
				
			}else
			{
				
				henAction=AllConstants.HenAction.HEN_FEED;
			}
		}
		else
		{
			if(direction==AllConstants.HenDirection.HEN_BACK)
			{
				if(y>chick.chick_starty && y>chick.chick_endy)
				{
					y-=5;
				}
				else
				{
					henAction=AllConstants.HenAction.HEN_FEED;
				}
			}
		}
		
	}
	 else 
		{
			henAction=AllConstants.HenAction.HEN_STAND_WITH_FOOD;
		}
		
	
	    
		if(henAction==AllConstants.HenAction.HEN_FLY)
		{
			
		if(direction==AllConstants.HenDirection.HEN_FRONT ){
		  x=5;
		  y=7;
		}
		else
		{
			x=5;
			y=7;
			
		}
		}
		
		}
		
		
	

	public void DoUpdate()
	{
		Move();
	}
	
	public Bitmap NextBitmap(){
		Bitmap bitmapNext=null;
		
		switch(henAction)
			{
				case HEN_WALK:
					if(direction==AllConstants.HenDirection.HEN_FRONT)
					{
						if(nextIndex==2)
						{
							bitmapNext=resources.drawables.get(nextIndex);
							nextIndex=3;
						}
						else
						{
							bitmapNext=resources.drawables.get(nextIndex);
							nextIndex=2;
						}
					}
					//if(direction==AllConstants.HenDirection.HEN_BACK)
					else
					{
						if(nextIndex==4)
						{
							bitmapNext=resources.drawables.get(nextIndex);
							nextIndex=5;
						}
						else
						{
							bitmapNext=resources.drawables.get(nextIndex);
							nextIndex=4;
						}
					}					
					break;
				case HEN_STAND:
					if(direction==AllConstants.HenDirection.HEN_FRONT)						
						bitmapNext=resources.drawables.get(0);
					else
						bitmapNext=resources.drawables.get(1);					
					break;
				case HEN_EAT_FOOD:
					if(direction==AllConstants.HenDirection.HEN_FRONT)
					{
					if(nextIndex==6)
					{
						bitmapNext=resources.drawables.get(nextIndex);
						nextIndex=7;
					}
					else
					{
						bitmapNext=resources.drawables.get(nextIndex);
						
					}
					
					}
					else
					{
						if(nextIndex==8)
						{
							bitmapNext=resources.drawables.get(nextIndex);
							nextIndex=9;
						}
						else
						{
							bitmapNext=resources.drawables.get(nextIndex);
						}
					}
					break;
				case HEN_STAND_WITH_FOOD:
					if(direction==AllConstants.HenDirection.HEN_FRONT)						
						bitmapNext=resources.drawables.get(10);
					else
						bitmapNext=resources.drawables.get(11);					
					break;
					
				case HEN_WALK_WITH_FOOD:
					if(direction==AllConstants.HenDirection.HEN_FRONT)
					{
					 if(nextIndex==11)
					 {
						 bitmapNext=resources.drawables.get(nextIndex);
						 nextIndex=10;
					 }
					 else
					 {
						 bitmapNext=resources.drawables.get(nextIndex);
						 nextIndex=11;
					 }
					}
					 else
					 {
						 if(nextIndex==13)
						 {
							 bitmapNext=resources.drawables.get(nextIndex);
							 nextIndex=12;
						 }
						 else
						 {
							 bitmapNext=resources.drawables.get(nextIndex);
							 nextIndex=13;
						 }	 
						 
					 
					}
					 break;
				case HEN_FLY:
					if(direction==AllConstants.HenDirection.HEN_FRONT)
					{
						if(nextIndex==10)
						{
							bitmapNext=resources.drawables.get(nextIndex);
							nextIndex=11;
						}
							else{
								bitmapNext=resources.drawables.get(nextIndex);
								nextIndex=10;
						}
					}
					
					else
					{
						if(nextIndex==12)
						{
						bitmapNext=resources.drawables.get(nextIndex);
						nextIndex=13;
					}
					else
					{
						bitmapNext=resources.drawables.get(nextIndex);
						nextIndex=12;
						
					}
			}
					break;
			}
						
			
				
		return bitmapNext;
		}
	
	}


