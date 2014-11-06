package com.abs104a.effectivecircle.surface_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public final class CircleSurficeView extends SurfaceView {

	private CircleHolderCallBack cb;
	
	public CircleSurficeView(Context context) {
		super(context);
		SurfaceHolder holder = getHolder();
		cb = new CircleHolderCallBack();
		holder.addCallback(cb);
	}
	
	public CircleSurficeView(Context context, AttributeSet attrs) {
		super(context,attrs);
		SurfaceHolder holder = getHolder();
		cb = new CircleHolderCallBack();
		holder.addCallback(cb);
	}
	
	public CircleSurficeView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context,attrs,defStyleAttr);
		SurfaceHolder holder = getHolder();
		cb = new CircleHolderCallBack();
		holder.addCallback(cb);
	}

}
