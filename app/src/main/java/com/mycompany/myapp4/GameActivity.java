
import android.app.*;
import android.os.*;
import android.view.*;//Game Activity that must be declared in manifest file
public class GameActivity extends Activity{
	


	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		GameView gameView = new GameView(this);

		//toggle no screen timeout
		gameView.setKeepScreenOn(true);

		requestWindowFeature(Window.FEATURE_NO_TITLE); 
 		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


		setContentView(gameView);

	}

}
