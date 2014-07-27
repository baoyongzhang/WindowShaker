package com.baoyz.windowshaker.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.baoyz.windowshake.sample.R;
import com.baoyz.windowshaker.WindowShaker;
import com.baoyz.windowshaker.WindowShaker.Option;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onShake(View v) {
		WindowShaker.shake(this);
	}

	public void onHorizontalShake(View v) {
		Option option = new Option.Builder(this).setOffsetY(0).build();
		WindowShaker.shake(this, option);
	}

	public void onVerticalShake(View v) {
		Option option = new Option.Builder(this).setOffsetX(0).build();
		WindowShaker.shake(this, option);
	}

	public void onCustomShake(View v) {
		Option option = new Option.Builder(this).setDuration(2000).setOffsetX(20)
				.setOffsetY(5).setRepeatCount(15).setVibrate(false).build();
		WindowShaker.shake(this, option);
	}
}
