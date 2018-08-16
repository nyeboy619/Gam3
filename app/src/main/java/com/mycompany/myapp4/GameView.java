package com.mycompany.myapp4;
import android.view.*;
import android.content.*;
import android.graphics.*;public class GameView extends View
{

	public GameView (Context context){
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas){

	}

	public boolean onTouchEvent(MotionEvent event){
		int eventaction = event.getAction();
		int x = (int)event.getX();
		int y = (int)event.getY();

		switch(eventaction){

			case MotionEvent.ACTION_DOWN:
			break;
			case MotionEvent.ACTION_MOVE:
			break;
			case MotionEvent.ACTION_UP:
			break;

		}

		invalidate();
		return true;
	}

}
