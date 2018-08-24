public class MainThread extends Thread{
	public static final int MAX_FPS = 30;

	private double aveFPS;
	private SurfaceHolder surfaceHolder;
	private TitleView titleView;
	private boolean running;
	public static Canvas canvas;

	public MainThread(SurfaceHolder surfaceHolder, TitleView titleView){
		super();
		this.surfaceHolder = surfaceHolder;
		this.titleView = titleView;
	}

	@Override
	public void run(){
		long startTime;
		long waitTime;
		long timeMillis = 1000/MAX_FPS;
		long frameCount = 0;
		long totalTime = 0;
		long targetTime = 1000/MAX_FPS;

		while(running){
			startTime = System.nanoTime();
			canvas = null;
				try	{
				canvas = this.surfaceHolder.lockCanvas();
				sychronized(surfaceHolder){
					this.titleView.update();
					this.titleView.draw(canvas);
				}	catch (Exception e)	{
					e.printStackTrace();
				}	finally {
					if(canvas != null){
						try{
							surfaceHolder.unlockCanvasAndPost(canvas);
						}	catch(Exception e)	{	e.printStackTrace();}
					}
				}

				timeMillis = (System.nanoTime() - startTime)/1000000;
				waitTime = targetTime - timeMillis;
				try {
					if(waitTime > 0){
						this.sleep(waitTime);
					}	catch(Exception e) {	e.printStackTrace();	}
				}

				totalTime += System.nanoTime() - startTime;
				frameCount++;
				if(frameCount == MAX_FPS){
					aveFPS = 1000/((totalTime/frameCount)/1000000);
					frameCount = 0;
					totalTime = 0;
					System.out.println(aveFPS);
				}
			}
		}
	}
}