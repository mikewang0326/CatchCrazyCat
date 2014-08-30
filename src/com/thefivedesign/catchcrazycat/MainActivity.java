package com.thefivedesign.catchcrazycat;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Background background = new Background(this);
		setContentView(background);
	}
}
