package com.mycompany.myapp4;

import com.mycompany.myapp4.R;
import android.app.*;
import android.os.*;
import android.view.*;

public class Gam3 extends Activity
{
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		TitleView titleView = new TitleView(this);

		//toggle no screen timeout
		titleView.setKeepScreenOn(true);

		requestWindowFeature(Window.FEATURE_NO_TITLE); 
 		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


		setContentView(titleView);

		
	}

}
