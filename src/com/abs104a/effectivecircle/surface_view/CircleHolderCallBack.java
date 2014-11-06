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
	
	//��ʕ�
	private int width = 1;
	//��ʏc
	private int height = 1;
	
	private final int CIRCLE_COUNT = 50;
	
	private ArrayList<Circle> circleList = new ArrayList<Circle>();
	
	@Override
	public void run() {
		// ���C�����[�v�i�������[�v�j
		 while( isAttached ){
			 //�`�揈�����J�n
			 Canvas canvas = holder.lockCanvas();
			 Paint paint = new Paint();
			 canvas.drawColor(0,PorterDuff.Mode.CLEAR );
			 
			 for(Circle c : circleList)
				 Circle.moveCircle(this.width, this.height, c,canvas,paint);
			 
			//�`�揈�����I��
			 holder.unlockCanvasAndPost(canvas);
		 }
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		this.holder = holder;
		
		//�~���쐬����B
		for(int i = 0;i < CIRCLE_COUNT;i++)
			circleList.add(new Circle(this.width, this.height));
		
		thread = new Thread(this);
		thread.start(); //�X���b�h���J�n

	}

	/**
	 * ��ʃT�C�Y���ς�����Ƃ�
	 * ex.�c��ʁ�����ʂȂ�
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
		 thread = null; //�X���b�h���I��
	}

}
