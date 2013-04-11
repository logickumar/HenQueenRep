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
	int test=0;

	
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
		bitmapBackground = BitmapFactory.decodeResource(playScreenActivity.getResources(),R.drawable.backplay);
		
		// Hen stand right
		Bitmap henStandBitmap= BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henstandright);
		hen=new Hen(70,130,AllConstants.HenDirection.HEN_FRONT,AllConstants.HenAction.HEN_STAND);
		hen.resources.drawables.add(henStandBitmap);
		//hen stand left
		Bitmap henLeftBitmap=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henstandleft);
		hen.resources.drawables.add(henLeftBitmap);
		//hen walk right
		Bitmap henWalkRightBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(),R.drawable.henwalkright1);
		hen.resources.drawables.add(henWalkRightBitmap1);
		
		Bitmap henWalkRightBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(),R.drawable.henwalkright2);
		hen.resources.drawables.add(henWalkRightBitmap2);
		//hen walk left
		Bitmap henWalkLeftBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henwalkleft1);
		hen.resources.drawables.add(henWalkLeftBitmap1);
		
		Bitmap henWalkLeftBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henwalkleft2);
		hen.resources.drawables.add(henWalkLeftBitmap2);
		//chick
		Bitmap chickBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.chicksbitmap1);
		chick=new Chick(70,160);
		chick.resources.drawables.add(chickBitmap1);
		Bitmap chickBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.chicksbitmap2);
		chick.resources.drawables.add(chickBitmap2);
		//Cat right
		Bitmap catWalkRightBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.catwalkright1);
		cat=new Cat(70,400,AllConstants.CatDirection.CAT_BACK);
		cat.resources.drawables.add(catWalkRightBitmap1);
		Bitmap catWalkRightBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.catwalkright2);
		cat.resources.drawables.add(catWalkRightBitmap2);
		//cat left
		Bitmap catWalkLeftBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.catwalkleft1);
		cat.resources.drawables.add(catWalkLeftBitmap1);
		Bitmap catWalkLeftBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.catwalkleft2);
		cat.resources.drawables.add(catWalkLeftBitmap2);
		//ant right
		Bitmap antWalkRightBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antright1);
		ant=new Ant(70,10,AllConstants.AntDirection.ANT_FRONT);
		ant.resources.drawables.add(antWalkRightBitmap1);
		Bitmap antWalkRightBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antrightmove1);
		ant.resources.drawables.add(antWalkRightBitmap2);
		//ant left
		Bitmap antWalkLeftBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antleft1);
		ant.resources.drawables.add(antWalkLeftBitmap1);
		Bitmap antWalkLeftBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antleftmove1);
		ant.resources.drawables.add(antWalkLeftBitmap2);
		//Ant food
		Bitmap antFoodBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antfood);
		antFood=new AntFood(69,35,AllConstants.AntFoodDirection.ANT_FOOD_FRONT);
		antFood.resources.drawables.add(antFoodBitmap1);
		Bitmap antFoodBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.antfoodsss);
		antFood.resources.drawables.add(antFoodBitmap2);
		//Crow
		Bitmap crowBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.crowrightimg1);
		crow=new Crow(300,5,AllConstants.CrowDirection.CROW_DOWN);
		crow.resources.drawables.add(crowBitmap1);
		Bitmap crowBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.crowmoveright1);
		crow.resources.drawables.add(crowBitmap2);
		Bitmap crowBitmap3=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.crowleftimg);
		crow.resources.drawables.add(crowBitmap3);
		Bitmap crowBitmap4=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.crowmoveleft);
		crow.resources.drawables.add(crowBitmap4);
		//Kid
		Bitmap kidBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.kidwalkright1);
		kid=new Kid(70,15,AllConstants.KidDirection.KID_WALK_FRONT);
		kid.resources.drawables.add(kidBitmap1);
		Bitmap kidBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.kidwalkright2);
		kid.resources.drawables.add(kidBitmap2);
		//Bitmap kidBitmap3=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.kidwalkleft1);
		//kid.resources.drawables.add(kidBitmap3);
		//Bitmap kidBitmap4=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.kidwalkleft2);
		//kid.resources.drawables.add(kidBitmap4);
		
		//hen eat food
		Bitmap henEatBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatright1);
		hen.resources.drawables.add(henEatBitmap1);
		Bitmap henEatBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatright2);
		hen.resources.drawables.add(henEatBitmap2);
		Bitmap henEatBitmap3=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatleft1);
		hen.resources.drawables.add(henEatBitmap3);
		Bitmap henEatBitmap4=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatleft2);
		hen.resources.drawables.add(henEatBitmap4);
		Bitmap henEatFoodBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatfoodright1);
		hen.resources.drawables.add(henEatFoodBitmap1);
		Bitmap henEatFoodBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatfoodright2);
		hen.resources.drawables.add(henEatFoodBitmap2);
		Bitmap henEatFoodBitmap3=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatfoodleft1);
		hen.resources.drawables.add(henEatFoodBitmap3);
		Bitmap henEatFoodBitmap4=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.heneatfoodleft2);
		hen.resources.drawables.add(henEatFoodBitmap4);
		//hen fly
		Bitmap henFlyBitmap1=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henjumpright1);
		hen.resources.drawables.add(henFlyBitmap1);
		Bitmap henFlyBitmap2=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henjumpright2);
		hen.resources.drawables.add(henFlyBitmap2);
		Bitmap henFlyBitmap3=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henjumpleft1);
		hen.resources.drawables.add(henFlyBitmap3);
		Bitmap henFlyBitmap4=BitmapFactory.decodeResource(playScreenActivity.getResources(), R.drawable.henjumpleft2);
		hen.resources.drawables.add(henFlyBitmap4);
		
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
