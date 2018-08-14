public class TitleView extends View{
	
	private Bitmap titleGraphic;
	private int screenW;
	private int screenH;
	private Bitmap playButtonUp;
	private Bitmap playButtonDown;

	private boolean playButtonPressed;

	public TitleView(Context context){
		super(context);
		//sourcing the graphic file from drawables
		playButtonUp = BitmapFactory.decodeResource(getResources(),R.drawable.play_button_up);
		playButtonDown = BitmapFactory.decodeResource(getResources(),R.drawable.play_button_down);

		titleGraphic = BitmapFactory.decodeResource(getResources(),R.drawable.title_graphic);
	}

	@Override
	public void onSizeChanged (int w, int h, int oldw, int oldh){
		super.onSizeChanged(w,h,oldw,oldh);
		screenW = w;
		screenH = h;
	}



	@Override
	protected void onDraw(Canvas canvas){
		//Here is where canvas drawing will be put

		canvas.drawBitmap(titleGraphic,(screenW-titleGraphic.getWidth())/2,0,null);
		canvas.drawBitmap(playButtonUp,(screenW-playButton.getWidth())/2,(int)(screenH*0.7),null);

	}

	//Responsible for capturing touch event from the title screen
	public boolean onTouchEvent(MotoinEvent event){
			int x = eventAction = (int)event.getX();
			int y = eventAction = (int)event.getY();

			switch( eventAction ){

			case MotionEvent.ACTION_DOWN:

				if (X > (screenW-playButtonUp.getWidth())/2 &&
 				X < ((screenW-playButtonUp.getWidth())/2) +
				playButtonUp.getWidth()) &&
 				Y > (int)(screenH*0.7) &&
 				Y < (int)(screenH*0.7) +
 				playButtonUp.getHeight()) {
 				playButtonPressed = true;
 				}



				break;

			case MotionEvent.ACTION_MOVE:
				break;


			case MotionEvent.ACTION_UP:

				playButtonPressed = false;

				break;

			}
			invalidate();
			return true;




	}
}