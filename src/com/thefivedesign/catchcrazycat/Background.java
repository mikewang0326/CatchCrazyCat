package com.thefivedesign.catchcrazycat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class Background extends SurfaceView{
	
	public static final int ROW = 10;//行
	public static final int COL = 10;//列
	
	public static final int BLOCK = 10; //随机路障数
	
    private Dot[][] matrix = new Dot [ROW][COL];;	
    
    private Dot cat;
	
    private int width = 40;
    

	public Background(Context context) {
		super(context);
		
		getHolder().addCallback(callback);
		
		for (int i=0; i<ROW; i++) {
			for (int j=0; j<COL; j++) {
				matrix[i][j] = new Dot(j, i); //note
			}
		}
		
		initGame();
	}
	
	public void redraw() {
		Canvas canvas = getHolder().lockCanvas();
		canvas.drawColor(Color.LTGRAY);
		
		for (int i=0; i<ROW; i++) {
			int offset = 0;
			if (i % 2 != 0) {
				offset = width/2;
			}
			
			for (int j=0; j<COL; j++) {
				Dot dot = getDot(j, i);
				Paint paint = new Paint();
				switch (dot.getStatus()) {
				case Dot.STATUS_OFF:
					paint.setColor(0xFFEEEEEE);
					break;
				case Dot.STATUS_ON:
					paint.setColor(0xFFFFAA00);
					break;
				case Dot.STATUS_IN:
					paint.setColor(0xFFFF0000);
					break;
				default:
					break;
				}
				
				canvas.drawOval(new RectF(dot.getX() * width + offset, (dot.getY()) * width, (dot.getX() + 1) * width + offset, (dot.getY() + 1) * width), paint);
			}
		}
		
		getHolder().unlockCanvasAndPost(canvas);
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
			Background.this.width = width/(COL+1);
			redraw();
		}
	};
	
	private void initGame() {
		
		//init all dots
		for (int i=0; i<ROW; i++) {
			for (int j=0; j<COL; j++) {
				Dot dot = matrix[i][j];
				dot.setStatus(Dot.STATUS_OFF);
			}
		}
		
		//init cat
		cat = new Dot(4, 5);
		getDot(4, 5).setStatus(Dot.STATUS_IN);
		
		//create random blocks
		for (int i=0; i< BLOCK;) {
			int x = (int) (Math.random()*1000%COL);
			int y = (int) (Math.random()*1000%ROW);			
			if (getDot(x, y).getStatus() == Dot.STATUS_OFF) {
				getDot(x, y).setStatus(Dot.STATUS_ON);
				i++;
				Log.d("tt", "block i = " + i);
			}
		}
	}
	
	private Dot getDot(int x, int y) {
		return matrix[y][x];
	}
	

}
