package com.valamburi.henqueen2;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class Game {
	public boolean isRunning;
	public Hen hen=null;
	public Activity playScreenActivity=null;
	public SurfaceHolder holder=null;
	public GameThread gameThread=null;
	public SurfaceView surfaceView=null;
	public Bitmap bitmapBackground=null;
	public Chick chick;
	public Cat cat;
	//public Ant ant;
	
	
	public Kid kid;
	public int screenwidth,screenHeight;
	public Ant[] ant;
	public Coin coin;
	
	public int i = 0;
	public ScoreManager scoreManager;
	public TimerCalScreen timeCalScreen;
	
	

	
	@SuppressLint("NewApi")
	Game(Activity playScreenActivity,SurfaceHolder holder,SurfaceView surfaceView)
	{
		this.playScreenActivity=playScreenActivity;
		this.holder=holder;
		this.surfaceView=surfaceView;
		Display display = playScreenActivity.getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		screenwidth=size.x;
		screenHeight=size.y;
		Log.d("Game", screenwidth + " " + screenHeight);
		Initialize();	
	}
	
	private void  Initialize()
	{
		scoreManager=new ScoreManager();
		timeCalScreen=new TimerCalScreen(this);
		//Game
		isRunning=false;
		// Background
		bitmapBackground = BitmapFactory.decodeResource(playScreenActivity.getResources(),R.drawable.playscreenbackground);
		
		// Hen stand right
		hen=new Hen(70,130,AllConstants.HEN_STAND_FRONT);//AllConstants.HEN_FRONT,
		Bitmap henStandRightBitmap= BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henstandright);
		GameDrawableList henStandRightList=new GameDrawableList();
		//GameDrawableList henStandRightList=new GameDrawableList();
		henStandRightList.add(henStandRightBitmap);
		hen.resources.drawableListsMap.put(AllConstants.HEN_STAND_FRONT, henStandRightList);
				
		//hen stand left
		Bitmap henStandLeftBitmap=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henstandleft);
		GameDrawableList henStandLeftList=new GameDrawableList();
		henStandLeftList.add(henStandLeftBitmap);
		hen.resources.drawableListsMap.put(AllConstants.HEN_STAND_BACK, henStandLeftList);
				
		//hen walk right
		Bitmap henWalkRightBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(),R.drawable.henwalkright1);
		Bitmap henWalkRightBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(),R.drawable.henwalkright2);
		GameDrawableList henWalkRightList=new GameDrawableList();
		henWalkRightList.add(henWalkRightBitmap1);
		henWalkRightList.add(henWalkRightBitmap2);
		hen.resources.drawableListsMap.put(AllConstants.HEN_WALK_FRONT, henWalkRightList);
		hen.resources.playables.put(AllConstants.HEN_WALK_FRONT, R.raw.hensound);
					
		//hen walk left
		Bitmap henWalkLeftBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henwalkleft1);
		Bitmap henWalkLeftBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henwalkleft2);
		GameDrawableList henWalkLeftList=new GameDrawableList();
		henWalkLeftList.add(henWalkLeftBitmap1);
		henWalkLeftList.add(henWalkLeftBitmap2);
		hen.resources.drawableListsMap.put(AllConstants.HEN_WALK_BACK, henWalkLeftList);
		hen.resources.playables.put(AllConstants.HEN_WALK_BACK, R.raw.hensound);
		
		//Hen hit front
		Bitmap henhitFrontBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henhitright11);
		Bitmap henhitFrontBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henhitright2);
		GameDrawableList henhitFrontList=new GameDrawableList();
		henhitFrontList.add(henhitFrontBitmap1);
		henhitFrontList.add(henhitFrontBitmap2);
		henhitFrontList.EnableTrackAnimationCount();
		hen.resources.drawableListsMap.put(AllConstants.HEN_HIT_FRONT, henhitFrontList);
		hen.resources.playables.put(AllConstants.HEN_HIT_FRONT, R.raw.henhitsound);
		//soundQueue.add(cat.resources.playables.get(cat.action));
		
		//Hen hit back
		Bitmap henhitBackBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henhitleft11);
		Bitmap henhitBackBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henhitleft2);
		GameDrawableList henhitBackList=new GameDrawableList();
		henhitBackList.add(henhitBackBitmap1);
		henhitBackList.add(henhitBackBitmap2);
		henhitBackList.EnableTrackAnimationCount();
		hen.resources.drawableListsMap.put(AllConstants.HEN_HIT_BACK, henhitBackList);
		hen.resources.playables.put(AllConstants.HEN_HIT_BACK, R.raw.henhitsound);
		
		//chick
		chick=new Chick(70,160,AllConstants.CHICK_ANIM);
		Bitmap chickBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.chicksbitmap1);		
		Bitmap chickBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.chicksbitmap2);
		GameDrawableList chickBitmapList1=new GameDrawableList();
		chickBitmapList1.add(chickBitmap1);
		chickBitmapList1.add(chickBitmap2);
		chick.resources.drawableListsMap.put(AllConstants.CHICK_ANIM, chickBitmapList1);
		
		//chick eat
		Bitmap chickBitmap3=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.chickeatbitmap1);
		Bitmap chickBitmap4=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.chickeatbitmap11);
		GameDrawableList chickBitmapList2=new GameDrawableList();
		chickBitmapList2.add(chickBitmap3);
		chickBitmapList2.add(chickBitmap4);
		chickBitmapList2.EnableTrackAnimationCount();
		chick.resources.drawableListsMap.put(AllConstants.CHICK_WITH_FOOD, chickBitmapList2);
		chick.resources.playables.put(AllConstants.CHICK_WITH_FOOD, R.raw.chicksound);
		
		//Cat right
		cat=new Cat(70,400,AllConstants.CAT_WALK_BACK);
		Bitmap catWalkRightBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.catwalkright1);
		Bitmap catWalkRightBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.catwalkright2);
		GameDrawableList catWalkRightList=new GameDrawableList();
		catWalkRightList.add(catWalkRightBitmap1);
		catWalkRightList.add(catWalkRightBitmap2);
		cat.resources.drawableListsMap.put(AllConstants.CAT_WALK_FRONT, catWalkRightList);
		cat.resources.playables.put(AllConstants.CAT_WALK_FRONT, R.raw.catsound);
				
		//cat left
		Bitmap catWalkLeftBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.catwalkleft1);
		Bitmap catWalkLeftBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.catwalkleft2);
		GameDrawableList catWalkLeftList=new GameDrawableList();
		catWalkLeftList.add(catWalkLeftBitmap1);
		catWalkLeftList.add(catWalkLeftBitmap2);
		cat.resources.drawableListsMap.put(AllConstants.CAT_WALK_BACK, catWalkLeftList);
		
		
		coin=new Coin(150,160,AllConstants.COIN_NOT_START);
		Bitmap coinBitmap= BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.goldcoin);
		GameDrawableList coinList=new GameDrawableList();
		coinList.add(coinBitmap);
		coin.resources.drawableListsMap.put(AllConstants.WIN_COIN, coinList);
		coin.resources.playables.put(AllConstants.WIN_COIN, R.raw.coinsound);
		
		ant=new Ant[4];
		Bitmap antWalkRightBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antright1);
		Bitmap antWalkRightBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antrightmove1);
		GameDrawableList antWalkRightList=new GameDrawableList();
		antWalkRightList.add(antWalkRightBitmap1);
		antWalkRightList.add(antWalkRightBitmap2);
		
		Bitmap antWalkLeftBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antleft1);
		Bitmap antWalkLeftBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antleftmove1);
		GameDrawableList antWalkLeftList=new GameDrawableList();
		antWalkLeftList.add(antWalkLeftBitmap1);
		antWalkLeftList.add(antWalkLeftBitmap2);
		Random rm=new Random();
		int random;
		for(i=0;i<4;i++)
		{
			random=rm.nextInt(400);
			if(rm.nextInt(100)>50)
			{
				ant[i]=new Ant(70,0-random,AllConstants.ANT_FRONT);			
			}
			else
			{
				ant[i]=new Ant(70,screenwidth+random,AllConstants.ANT_BACK);
			}
			ant[i].resources.drawableListsMap.put(AllConstants.ANT_FRONT, antWalkRightList);		
			ant[i].resources.drawableListsMap.put(AllConstants.ANT_BACK, antWalkLeftList);
		}

		//ant left
		
		
		
		
		//Kid
		kid=new Kid(70,15,AllConstants.KID_WALK_FRONT);
		Bitmap kidBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.kidwalkright1);
		Bitmap kidBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.kidwalkright2);
		GameDrawableList kidFrontBitmapList=new GameDrawableList();
		kidFrontBitmapList.add(kidBitmap1);
		kidFrontBitmapList.add(kidBitmap2);
		kid.resources.drawableListsMap.put(AllConstants.KID_WALK_FRONT, kidFrontBitmapList);
		
		
		Bitmap kidBitmap3=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.kidwalkleft1);
	    Bitmap kidBitmap4=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.kidwalkleft2);
	    GameDrawableList kidBackBitmapList=new GameDrawableList();
		kidBackBitmapList.add(kidBitmap3);
		kidBackBitmapList.add(kidBitmap4);
		kid.resources.drawableListsMap.put(AllConstants.KID_WALK_BACK, kidBackBitmapList);
		
		
	//hen eat food right
    	Bitmap henEatRightBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatright1);
		Bitmap henEatRightBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatright2);
		GameDrawableList henEatRightList=new GameDrawableList();
		henEatRightList.add(henEatRightBitmap1);
		henEatRightList.add(henEatRightBitmap2);
		henEatRightList.EnableTrackAnimationCount();
		hen.resources.drawableListsMap.put(AllConstants.HEN_EAT_FOOD_FRONT, henEatRightList);
		
		//hen eat food left
		Bitmap henEatLeftBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatleft1);
		Bitmap henEatLeftBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatleft2);
		GameDrawableList henEatLeftList=new GameDrawableList();
		henEatLeftList.add(henEatLeftBitmap1);
		henEatLeftList.add(henEatLeftBitmap2);
		henEatLeftList.EnableTrackAnimationCount();
		hen.resources.drawableListsMap.put(AllConstants.HEN_EAT_FOOD_BACK, henEatLeftList);
		
		//hen walk with food right
		Bitmap henWalkFoodRightBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatfoodright1);
		Bitmap henWalkFoodRightBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatfoodright2);
		GameDrawableList henWalkFoodRightList=new GameDrawableList();
		henWalkFoodRightList.add(henWalkFoodRightBitmap1);
		henWalkFoodRightList.add(henWalkFoodRightBitmap2);
		hen.resources.drawableListsMap.put(AllConstants.HEN_WALK_WITH_FOOD_FRONT, henWalkFoodRightList);
		
		//hen walk with food left
		Bitmap henWalkFoodLeftBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatfoodleft1);
		Bitmap henWalkFoodLeftBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatfoodleft2);
		GameDrawableList henWalkFoodLeftList=new GameDrawableList();
		henWalkFoodLeftList.add(henWalkFoodLeftBitmap1);
		henWalkFoodLeftList.add(henWalkFoodLeftBitmap2);
		hen.resources.drawableListsMap.put(AllConstants.HEN_WALK_WITH_FOOD_BACK, henWalkFoodLeftList);
		
		
		
	}
	public void StartGame()
	{
		isRunning=true;
		gameThread=new GameThread(this);
		gameThread.start();
	}
	
	
	public void PauseGame()
	{
		
		
	}
	
	
	public void ResumeGame()
	{
		
	}

}
