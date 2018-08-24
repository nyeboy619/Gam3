package com.mycompany.myapp4;

import android.*;
import android.content.*;
import android.graphics.*;
import android.view.*;
import com.mycompany.myapp4.R;

public class TitleView extends SurfaceView implements SurfaceHolder.Callbacks
{
	private MainThread thread;
	
	private Bitmap titleGraphic;
	private int screenW;
	private int screenH;
	private Bitmap playButtonUp;
	private Bitmap playButtonDown;

	private boolean playButtonPressed=false;

	private Context myContext;
	
	private Paint paint;

	private Rect r;

	public TitleView(Context context){
		super(context);

		thread = new MainThread(getHolder(), this);


		//Holding a reference to Context.
		//passing the context allowing the current activity
		// to call for new activity
		myContext = context;

		//sourcing the graphic file from drawables
		playButtonUp = BitmapFactory.decodeResource(getResources(),R.drawable.play_button_up);
		playButtonDown = BitmapFactory.decodeResource(getResources(),R.drawable.play_button_down);

		//Bitmap.createScaledBitmap(titleGraphic,800,1198,false);
		titleGraphic = BitmapFactory.decodeResource(getResources(),R.drawable.bg);
		
		r = new Rect();
		r.set(0,0,720,1198);
		
		paint = new Paint();
		paint.setColor(Color.WHITE);


		setFocusable(true);
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height){
		super.onSizeChanged(w,h,oldw,oldh);
		screenW = w;
		screenH = h;
	}

	@Override
	public void surfaceCreated(SurfaceHolder surfaceHolder){

		thread = new MaintThread(getHolder(),this);

		thread.setRunning(true);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder surfaceHolder){
		boolean retry = true;
		while(true){
			try{
				thread.setRunning(false);
				thread.join();
			} catch (Exception e) { e.printStackTrace();	}
			retry = false;
		}
	}


	@Override
	protected void onDraw(Canvas canvas){
		//Here is where canvas drawing will be put

		canvas.drawBitmap(titleGraphic,r,r,null);
		
		
		canvas.drawText(screenW+":"+screenH,100,100,paint);
	

		if(playButtonPressed==false){
			
		canvas.drawBitmap(playButtonUp,(screenW-playButtonUp.getWidth())/2,(int)(screenH*0.7),null);

		}
		
		else{
		canvas.drawBitmap(playButtonDown,(screenW-playButtonDown.getWidth())/2,(int)(screenH*0.7),null);
		}
		
	}

	//Responsible for capturing touch event from the title screen
	public boolean onTouchEvent(MotionEvent event){
		    int eventAction;
			int x = eventAction = (int)event.getX();
			int y = eventAction = (int)event.getY();

			switch( event.getAction()){

			case MotionEvent.ACTION_DOWN:

				playButtonPressed =true;
				
				break;

			case MotionEvent.ACTION_MOVE:
				break;


			case MotionEvent.ACTION_UP:

				
				if(playButtonPressed){
					Intent gameIntent = new Intent(myContext,GameActivity.class);
					myContext.startActivity(gameIntent);
				}
				
				

				playButtonPressed = false;

		        
				break;

			}
			invalidate();
			return true;




	}

	public void update(){

		
	}
}
