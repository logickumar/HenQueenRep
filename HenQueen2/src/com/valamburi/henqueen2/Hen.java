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
		Coin coin=game.coin;
		ScoreManager scoreManager=game.scoreManager;
		GameThread gameThread=game.gameThread;
		
		
		
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
				
					if(hen_endy<ant[i].y+4)// && hen_endy<=ant[i].ant_endy )
					{
						gameThread.soundQueue.add(resources.playables.get(henAction));
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
					if(y>ant[i].ant_endy-4)// && y>=ant[i].ant_starty)
					{
						gameThread.soundQueue.add(resources.playables.get(henAction));
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
					gameThread.soundQueue.add(resources.playables.get(chick.nextChickAction));
					Log.d("chick","chick_with_food");
					
					scoreManager.add(1);
					coin.visibility=true;
					coin.action=AllConstants.WIN_COIN;
					gameThread.soundQueue.add(resources.playables.get(coin.action));
					Log.d("coin", "win_coin");
				}
			
	}
			else if(henAction==AllConstants.HEN_WALK_WITH_FOOD_BACK )
			{
			
					if(hen_endy>chick.y && hen_endy>chick.chick_endy)
					{
						y-=5;
						Log.d("HEN","Walking back");
					}
				else
					{
						henAction=AllConstants.HEN_STAND_BACK;
						chick.nextChickAction=AllConstants.CHICK_WITH_FOOD;
						gameThread.soundQueue.add(resources.playables.get(chick.nextChickAction));
					    scoreManager.add(1);
					    coin.action=AllConstants.WIN_COIN;
					    gameThread.soundQueue.add(resources.playables.get(coin.action));
					    Log.d("coin", "win_coin");
					}
			}
	if(henAction==AllConstants.HEN_WALK_FRONT && target.equals(AllConstants.HEN_TARGET_CAT))
	{
		if(hen_endy<cat.y)// && y<=cat.y+cat.catWidth)
		{
			gameThread.soundQueue.add(resources.playables.get(henAction));
			y+=12;	
			Log.d("HEN", "Walking Front");			
		}
		
		else
		{
		  henAction=AllConstants.HEN_HIT_FRONT;
		  gameThread.soundQueue.add(resources.playables.get(henAction));
		  Log.d("HEN", "Hit Front");
		  scoreManager.add(1);
		  coin.visibility=true;
		  coin.action=AllConstants.WIN_COIN;
		  gameThread.soundQueue.add(resources.playables.get(coin.action));
		  Log.d("coin", "win_coin");
		  nextHenAction=AllConstants.HEN_STAND_FRONT;
		  //cat.cat_target=AllConstants.CAT_TARGET_CHICK;
		  cat.action=AllConstants.CAT_WALK_FRONT;
		  gameThread.soundQueue.add(resources.playables.get(cat.action));
		  cat.cat_target=AllConstants.CAT_TARGET_NULL;
		 
		  //scoreManager.add(10);
		}
    }
	else if(henAction==AllConstants.HEN_WALK_BACK && target.equals(AllConstants.HEN_TARGET_CAT))
	{
		if(hen_endy>cat.y)// && y>cat.y+cat.catWidth)
		{
			gameThread.soundQueue.add(resources.playables.get(henAction));
			y-=12;
			Log.d("HEN", "Walking Back");
			 
		}
		
		else
		{			
			henAction=AllConstants.HEN_HIT_BACK;
			gameThread.soundQueue.add(resources.playables.get(henAction));
			Log.d("HEN", "Hit Back");
			scoreManager.add(1);
			coin.visibility=true;
			coin.action=AllConstants.WIN_COIN;
			gameThread.soundQueue.add(resources.playables.get(coin.action));
			Log.d("coin", "win_coin");
			nextHenAction=AllConstants.HEN_STAND_BACK;
			cat.action=AllConstants.CAT_WALK_BACK;
			//gameThread.soundQueue.add(resources.playables.get(cat.action));
			cat.cat_target=AllConstants.CAT_TARGET_NULL;
			
			// score.add(10);
		}
	}
	if(henAction==AllConstants.HEN_WALK_FRONT && target.equals(AllConstants.HEN_TARGET_KID))
	{
		if(hen_endy<kid.y)// && y<=kid.y+kid.kidWidth)
		{
			gameThread.soundQueue.add(resources.playables.get(henAction));
			y+=10;	
			Log.d("HEN", "Walking Front");			
		}
		
		else
		{
		  henAction=AllConstants.HEN_HIT_FRONT;
		  gameThread.soundQueue.add(resources.playables.get(henAction));
		  Log.d("HEN", "Hit Front");
		  scoreManager.add(1);
		  coin.visibility=true;
		  coin.action=AllConstants.WIN_COIN;
		  gameThread.soundQueue.add(resources.playables.get(coin.action));
		  Log.d("coin", "win_coin");
		  nextHenAction=AllConstants.HEN_STAND_FRONT;
		  kid.action=AllConstants.KID_WALK_FRONT;
		  kid.kid_target=AllConstants.KID_TARGET_NULL;
		 
		 
		}
    }
	else if(henAction==AllConstants.HEN_WALK_BACK && target.equals(AllConstants.HEN_TARGET_KID))
	{
		if(y>kid.kid_endy)// && y>kid.y+kid.kidWidth)
		{
			gameThread.soundQueue.add(resources.playables.get(henAction));
			y-=10;
			Log.d("HEN", "Walking Back");
		}
		
		else
		{	
			
			henAction=AllConstants.HEN_HIT_BACK;
			gameThread.soundQueue.add(resources.playables.get(henAction));
			Log.d("HEN", "Hit Back");
			scoreManager.add(1);
			coin.visibility=true;
			coin.action=AllConstants.WIN_COIN;
			gameThread.soundQueue.add(resources.playables.get(coin.action));
			Log.d("coin", "win_coin");
			kid.action=AllConstants.KID_WALK_BACK;
			nextHenAction=AllConstants.HEN_STAND_BACK;
			kid.kid_target=AllConstants.KID_TARGET_NULL;
			
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
	
	


