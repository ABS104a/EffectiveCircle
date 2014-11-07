package com.abs104a.effectivecircle.objects;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * 円のオブジェクトを管理するクラス
 * @author Kouki
 *
 */
public final class CircleController {

	//円のリスト
	private static final ArrayList<Circle> circleList = new ArrayList<Circle>();

	//円リストのゲッター
	public static final ArrayList<Circle> getCircleList() {
		return circleList;
	}

	public static final void moveCircle(int disp_width,int disp_height,Circle circle,Canvas canvas,Paint paint){

		//丸の表示位置を動かす
		if( circle.getCircleX() < 0 || circle.getCircleX() > disp_width ){
			circle.setDx(-circle.getDx());
		}
		if( circle.getCircleY() < 0 || circle.getCircleY() > disp_height ){
			circle.setDy(-circle.getDy());
		}

		//円同士の衝突判定
		//呼び出された円の場所
		final int circlePosition = circleList.indexOf(circle);
		for(int p = 0;p < circleList.size();p++){
			//同じオブジェクトは計算しない．
			if(circlePosition == p)continue;
			final Circle targetCircle = circleList.get(p);

			int posX2 = (circle.getCircleX() - targetCircle.getCircleX()) * 
					(circle.getCircleX() - targetCircle.getCircleX());
			int posY2 = (circle.getCircleY() - targetCircle.getCircleY()) * 
					(circle.getCircleY() - targetCircle.getCircleY());
			int rad2 = (circle.getRadius() + targetCircle.getRadius()) * 
					(circle.getRadius() + targetCircle.getRadius());

			if(posX2 + posY2 <= rad2){
				
				//衝突軸ベクトル
				float colVecX = targetCircle.getCircleX() - circle.getCircleX();
				float colVecY = targetCircle.getCircleY() - circle.getCircleY();
				final float vecSize = (float) Math.sqrt((colVecX * colVecX + colVecY * colVecY));

				colVecX /= vecSize;
				colVecY /= vecSize;

				//ベクトルの内積
				final float dot = (circle.getDx() - targetCircle.getDx()) * colVecX +
						(circle.getDy() - targetCircle.getDy()) * colVecY;

				final float constVecX = (2.0f * dot) / (circle.getCircleWeight() + targetCircle.getCircleWeight()) * colVecX;
				final float constVecY = (2.0f * dot) / (circle.getCircleWeight() + targetCircle.getCircleWeight()) * colVecY;

				//衝突してる．
				circle.setDx( -targetCircle.getCircleWeight() * constVecX + circle.getDx());
				circle.setDy( -targetCircle.getCircleWeight() * constVecY + circle.getDy());

				targetCircle.setDx(circle.getCircleWeight() * constVecX + targetCircle.getDx());
				targetCircle.setDy(circle.getCircleWeight() * constVecY + targetCircle.getDy());

				android.util.Log.v("衝突Py",circle.getCircleY() + "");

				circle.setCircleX((int) (circle.getCircleX() + circle.getCircleWeight() *  circle.getDx() ) + 1);
				circle.setCircleY((int) (circle.getCircleY() + circle.getCircleWeight() *  circle.getDy() ) + 1);

				targetCircle.setCircleX((int) (targetCircle.getCircleX() + targetCircle.getCircleWeight() * targetCircle.getDx()) + 1);
				targetCircle.setCircleY((int) (targetCircle.getCircleY() + targetCircle.getCircleWeight() * targetCircle.getDy()) + 1);

			}

		}
		circle.setCircleX((int) (circle.getCircleX() + circle.getCircleWeight() * circle.getDx()));
		circle.setCircleY((int) (circle.getCircleY() + circle.getCircleWeight() * circle.getDy()));
				

		paint.setColor(circle.getCircleColor());
		canvas.drawCircle( circle.getCircleX(), circle.getCircleY(), circle.getRadius(), paint);
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



}
