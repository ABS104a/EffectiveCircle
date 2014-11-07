package com.abs104a.effectivecircle.objects;

import java.util.Random;

import android.graphics.Color;

/**
 * �~��\�킷�N���X
 * @author Kouki
 *
 */
public class Circle {

	//�~�̉����xx
	private float dx = 10;
	//�~�̉����xy
	private float dy = 10;
	
	//�~�̍��Wx
	private int circle_x = 1;
	//�~�̍��Wy
	private int circle_y = 1;
	
	//radius
	private int radius = 10;
	
	//�~�̐F
	private int circle_color = Color.WHITE;
	
	//�~�̏d��
	private int circle_weight = 1;
	
	//���a�ő�
	private static final int MAX_RADIUS = 100;
	private static final int MAX_DX = 10;
	private static final int MAX_DY = 10;
	
	/**
	 * �������֐�
	 * @param disp_width�@��ʂ̉���
	 * @param disp_height�@��ʂ̏c��
	 */
	public Circle(int disp_width,int disp_height){
		
		//Random�N���X�̃C���X�^���X��
        Random rnd = new Random();
        
        circle_x = rnd.nextInt(disp_width + 100);
        circle_y = rnd.nextInt(disp_height + 100);
        
        radius = rnd.nextInt(MAX_RADIUS);
        
        dx = rnd.nextInt(MAX_DX);
        dy = rnd.nextInt(MAX_DY);
        
        circle_color = CircleController.rndColor(rnd.nextInt(9));
		
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

	public final int getCircleX(){
		return circle_x;
	}

	public final void setCircleX(int circle_x) {
		this.circle_x = circle_x;
	}

	public final int getCircleY() {
		return circle_y;
	}

	public final void setCircleY(int circle_y) {
		this.circle_y = circle_y;
	}

	public final int getRadius() {
		return radius;
	}

	public final void setRadius(int radius) {
		this.radius = radius;
	}

	public final int getCircleColor() {
		return circle_color;
	}

	public final void setCircleColor(int circle_color) {
		this.circle_color = circle_color;
	}


	public int getCircleWeight() {
		return circle_weight;
	}


	public void setCircleWeight(int circle_weight) {
		this.circle_weight = circle_weight;
	}
	
}
