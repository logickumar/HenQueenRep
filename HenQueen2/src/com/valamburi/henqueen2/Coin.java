package com.valamburi.henqueen2;

import android.graphics.Bitmap;

public class Coin extends GameScreenObject {
	public String action;
	Coin(float x,float y,String action)
	{
		this.x=x;
		this.y=y;
		this.action=action;
		visibility=false;
	}
	public void Move(Game game)
	{
		//if(action.equals(AllConstants.WIN_COIN))
		//{
			x+=30;
		//}
		if(x>=game.screenwidth || action.equals(AllConstants.COIN_NOT_START))
		{
			visibility=false;
			action=AllConstants.COIN_NOT_START;
			x=150;
	     }
		
	}
	public void DoUpdate(Game game)
	{
		Move(game);
	}
	public Bitmap NextBitmap()
	{
		return GetNextBitmap(action);
		
	}
}
	
