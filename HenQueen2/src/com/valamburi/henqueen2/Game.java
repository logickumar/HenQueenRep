package com.valamburi.henqueen2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
	public Ant ant;
	public AntFood antFood;
	public Crow crow;
	public Kid kid;
	

	
	Game(Activity playScreenActivity,SurfaceHolder holder,SurfaceView surfaceView)
	{
		this.playScreenActivity=playScreenActivity;
		this.holder=holder;
		this.surfaceView=surfaceView;
		Initialize();	
	}
	
	private void  Initialize()
	{
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
					
		//hen walk left
		Bitmap henWalkLeftBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henwalkleft1);
		Bitmap henWalkLeftBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henwalkleft2);
		GameDrawableList henWalkLeftList=new GameDrawableList();
		henWalkLeftList.add(henWalkLeftBitmap1);
		henWalkLeftList.add(henWalkLeftBitmap2);
		hen.resources.drawableListsMap.put(AllConstants.HEN_WALK_BACK, henWalkLeftList);
		
		//Hen hit front
		Bitmap henhitFrontBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henhitright11);
		Bitmap henhitFrontBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henhitright2);
		GameDrawableList henhitFrontList=new GameDrawableList();
		henhitFrontList.add(henhitFrontBitmap1);
		henhitFrontList.add(henhitFrontBitmap2);
		henhitFrontList.EnableTrackAnimationCount();
		hen.resources.drawableListsMap.put(AllConstants.HEN_HIT_FRONT, henhitFrontList);
		
		//Hen hit back
		Bitmap henhitBackBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henhitleft11);
		Bitmap henhitBackBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henhitleft2);
		GameDrawableList henhitBackList=new GameDrawableList();
		henhitBackList.add(henhitBackBitmap1);
		henhitBackList.add(henhitBackBitmap2);
		henhitBackList.EnableTrackAnimationCount();
		hen.resources.drawableListsMap.put(AllConstants.HEN_HIT_BACK, henhitBackList);
		
		//chick
		chick=new Chick(70,160);
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
		
		//Cat right
		cat=new Cat(70,400,AllConstants.CAT_WALK_BACK);
		Bitmap catWalkRightBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.catwalkright1);
		Bitmap catWalkRightBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.catwalkright2);
		GameDrawableList catWalkRightList=new GameDrawableList();
		catWalkRightList.add(catWalkRightBitmap1);
		catWalkRightList.add(catWalkRightBitmap2);
		cat.resources.drawableListsMap.put(AllConstants.CAT_WALK_FRONT, catWalkRightList);
				
		//cat left
		Bitmap catWalkLeftBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.catwalkleft1);
		Bitmap catWalkLeftBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.catwalkleft2);
		GameDrawableList catWalkLeftList=new GameDrawableList();
		catWalkLeftList.add(catWalkLeftBitmap1);
		catWalkLeftList.add(catWalkLeftBitmap2);
		cat.resources.drawableListsMap.put(AllConstants.CAT_WALK_BACK, catWalkLeftList);
		
		//ant right
		ant=new Ant(70,10,AllConstants.ANT_FRONT);
		Bitmap antWalkRightBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antright1);
		Bitmap antWalkRightBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antrightmove1);
		GameDrawableList antWalkRightList=new GameDrawableList();
		antWalkRightList.add(antWalkRightBitmap1);
		antWalkRightList.add(antWalkRightBitmap2);
		ant.resources.drawableListsMap.put(AllConstants.ANT_FRONT, antWalkRightList);
			
		
		//ant left
		Bitmap antWalkLeftBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antleft1);
		Bitmap antWalkLeftBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antleftmove1);
		GameDrawableList antWalkLeftList=new GameDrawableList();
		antWalkRightList.add(antWalkLeftBitmap1);
		antWalkRightList.add(antWalkLeftBitmap2);
		ant.resources.drawableListsMap.put(AllConstants.ANT_BACK, antWalkLeftList);
		
		//Ant food
		antFood=new AntFood(69,35,AllConstants.ANT_FOOD_FRONT);
		Bitmap antFoodBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antfood);
		Bitmap antFoodBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antfoodsss);
		GameDrawableList antFoodList=new GameDrawableList();
		antFoodList.add(antFoodBitmap1);
		antFoodList.add(antFoodBitmap2);
		antFood.resources.drawableListsMap.put(AllConstants.ANT_FOOD_FRONT, antFoodList);
				
	
		//Crow down right
		crow=new Crow(300,5,AllConstants.CROW_FRONT);
		Bitmap crowBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.crowrightimg1);
        Bitmap crowBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.crowmoveright1);
        GameDrawableList crowFrontBitmapList=new GameDrawableList();
		crowFrontBitmapList.add(crowBitmap1);
		crowFrontBitmapList.add(crowBitmap2);
		crow.resources.drawableListsMap.put(AllConstants.CROW_FRONT, crowFrontBitmapList);
    	
		
		/*Bitmap crowBitmap3=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.crowleftimg);
		Bitmap crowBitmap4=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.crowmoveleft);
		GameDrawableList crowBackBitmapList=new GameDrawableList();
		crowBackBitmapList.add(crowBitmap1);
		crowDownBitmapList.add(crowBitmap2);
		hen.resources.drawables.put(AllConstants.CROW_FRONT, crowDownBitmapList);*/
    	
		
		//Kid
		kid=new Kid(70,15,AllConstants.KID_WALK_FRONT);
		Bitmap kidBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.kidwalkright1);
		Bitmap kidBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.kidwalkright2);
		GameDrawableList kidFrontBitmapList=new GameDrawableList();
		kidFrontBitmapList.add(kidBitmap1);
		kidFrontBitmapList.add(kidBitmap2);
		kid.resources.drawableListsMap.put(AllConstants.KID_WALK_FRONT, kidFrontBitmapList);
		
		
		//Bitmap kidBitmap3=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.kidwalkleft1);
		//kid.resources.drawables.add(kidBitmap3);
		//Bitmap kidBitmap4=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.kidwalkleft2);
		//kid.resources.drawables.add(kidBitmap4);
		
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
		
		//hen fly
		Bitmap henFlyFrontBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henjumpright1);
		Bitmap henFlyFrontBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henjumpright2);
		GameDrawableList henFlyFrontList=new GameDrawableList();
		henFlyFrontList.add(henFlyFrontBitmap1);
		henFlyFrontList.add(henFlyFrontBitmap2);
		hen.resources.drawableListsMap.put(AllConstants.HEN_FLY_FRONT, henFlyFrontList);
		
		Bitmap henFlyBackBitmap3=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henjumpleft1);
		Bitmap henFlyBackBitmap4=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henjumpleft2);
		GameDrawableList henFlyBackList=new GameDrawableList();
		henFlyBackList.add(henFlyBackBitmap3);
		henFlyBackList.add(henFlyBackBitmap4);
		hen.resources.drawableListsMap.put(AllConstants.HEN_FLY_BACK, henFlyFrontList);
		
		
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
