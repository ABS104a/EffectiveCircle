package com.abs104a.effectivecircle.surface_view;

import java.util.ArrayList;

import com.abs104a.effectivecircle.objects.Circle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.SurfaceHolder;

public class CircleHolderCallBack implements SurfaceHolder.Callback, Runnable{


	private SurfaceHolder holder = null;
	private Thread thread = null;
	private boolean isAttached = true;
	
	//画面幅
	private int width = 1;
	//画面縦
	private int height = 1;
	
	private final int CIRCLE_COUNT = 50;
	
	private ArrayList<Circle> circleList = new ArrayList<Circle>();
	
	@Override
	public void run() {
		// メインループ（無限ループ）
		 while( isAttached ){
			 //描画処理を開始
			 Canvas canvas = holder.lockCanvas();
			 Paint paint = new Paint();
			 canvas.drawColor(0,PorterDuff.Mode.CLEAR );
			 
			 for(Circle c : circleList)
				 Circle.moveCircle(this.width, this.height, c,canvas,paint);
			 
			//描画処理を終了
			 holder.unlockCanvasAndPost(canvas);
		 }
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		this.holder = holder;
		
		//円を作成する。
		for(int i = 0;i < CIRCLE_COUNT;i++)
			circleList.add(new Circle(this.width, this.height));
		
		thread = new Thread(this);
		thread.start(); //スレッドを開始

	}

	/**
	 * 画面サイズが変わったとき
	 * ex.縦画面→横画面など
	 */
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		 isAttached = false;
		 thread = null; //スレッドを終了
	}

}
