package com.abs104a.effectivecircle.objects;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * 円を表わすクラス
 * @author Kouki
 *
 */
public class Circle {

	//円の加速度x
	private float dx = 10;
	//円の加速度y
	private float dy = 10;
	
	//円の座標x
	private int circle_x = 1;
	//円の座標y
	private int circle_y = 1;
	
	//radius
	private int radius = 10;
	
	//円の色
	private int circle_color = Color.WHITE;
	
	//半径最大
	private static final int MAX_RADIUS = 100;
	private static final int MAX_DX = 20;
	private static final int MAX_DY = 20;
	
	public Circle(int disp_width,int disp_height){
		
		//Randomクラスのインスタンス化
        Random rnd = new Random();
        
        circle_x = rnd.nextInt(disp_width);
        circle_y = rnd.nextInt(disp_height);
        
        radius = rnd.nextInt(MAX_RADIUS);
        
        dx = rnd.nextInt(MAX_DX);
        dy = rnd.nextInt(MAX_DY);
        
        circle_color = rndColor(rnd.nextInt(9));
		
	}
	
	public static void moveCircle(int disp_width,int disp_height,Circle circle,Canvas canvas,Paint paint){
		//丸の表示位置を動かす
		 if( circle.circle_x < 0 || circle.circle_x > disp_width ){
			 circle.dx = -circle.dx;
		 }
		 if( circle.circle_y < 0 || circle.circle_y > disp_height ){
			 circle.dy = -circle.dy;
		 }
		 circle.circle_x += circle.dx;
		 circle.circle_y += circle.dy;
		 paint.setColor(circle.circle_color);
		 canvas.drawCircle( circle.circle_x, circle.circle_y, circle.radius, paint);
	}
	
	public static int rndColor(int num){
		switch(num){
		default:
		case 0:
			return Color.BLUE;
		case 1:
			return Color.CYAN;
		case 2:
			return Color.DKGRAY;
		case 3:
			return Color.GRAY;
		case 4:
			return Color.GREEN;
		case 5:
			return Color.LTGRAY;
		case 6:
			return Color.MAGENTA;
		case 7:
			return Color.RED;
		case 8:
			return Color.WHITE;
		case 9:
			return Color.YELLOW;
		}
	}
	

	public final float getDx() {
		return dx;
	}

	public final void setDx(float dx) {
		this.dx = dx;
	}

	public final float getDy() {
		return dy;
	}

	public final void setDy(float dy) {
		this.dy = dy;
	}

	public final int getCircle_x() {
		return circle_x;
	}

	public final void setCircle_x(int circle_x) {
		this.circle_x = circle_x;
	}

	public final int getCircle_y() {
		return circle_y;
	}

	public final void setCircle_y(int circle_y) {
		this.circle_y = circle_y;
	}

	public final int getRadius() {
		return radius;
	}

	public final void setRadius(int radius) {
		this.radius = radius;
	}

	public final int getCircle_color() {
		return circle_color;
	}

	public final void setCircle_color(int circle_color) {
		this.circle_color = circle_color;
	}
	
}
