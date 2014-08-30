package com.thefivedesign.catchcrazycat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Background extends SurfaceView{

	public Background(Context context) {
		super(context);
		getHolder().addCallback(callback);
	}
	
	public void redraw() {
		Canvas c = getHolder().lockCanvas();
		c.drawColor(Color.CYAN);
		getHolder().unlockCanvasAndPost(c);
	}
	
	
	Callback callback =  new Callback() {
		
		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			
		}
		
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			redraw();
		}
		
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			
		}
	};
	
	

}
