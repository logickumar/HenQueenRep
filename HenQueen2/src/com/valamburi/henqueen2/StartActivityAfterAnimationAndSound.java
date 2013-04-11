package com.valamburi.henqueen2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class StartActivityAfterAnimationAndSound implements AnimationListener {

	 private Intent mIntent;
	 private Activity activity;
	 private MediaPlayer music;
     
	 StartActivityAfterAnimationAndSound(Activity activity,Intent intent,int id) {
         mIntent = intent;
         this.activity=activity;
         this.music=MediaPlayer.create(activity.getBaseContext(), id);
     }

		@Override
		public void onAnimationEnd(Animation animation) {
			// TODO Auto-generated method stub
		activity.startActivity(mIntent);
			music.stop();
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
			music.start();
		}

}
