package com.valamburi.henqueen2;

import java.io.IOException;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class SoundManager {

	MediaPlayer musicPlayer;
	

	void play(Context context,int resid)
	{ 
		if(musicPlayer!=null)
		{
			if(musicPlayer.isPlaying())
			musicPlayer.stop();
			//musicPlayer.reset();
			musicPlayer.release();
			musicPlayer=null;
			
		}
		musicPlayer= MediaPlayer.create(context, resid);
		//musicPlayer.prepare();
		musicPlayer.start();
		Log.d("music","starting");
	}
}
