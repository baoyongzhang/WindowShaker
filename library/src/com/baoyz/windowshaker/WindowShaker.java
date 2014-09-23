package com.baoyz.windowshaker;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;

/**
 * 
 * @author baoyz
 * @date 2014-7-24
 * 
 */
public class WindowShaker {

	private static Option option;

	public static void shake(Activity act) {
		shake(act, getOption(act));
	}

	public static void shake(Fragment fragment) {
		shake(fragment.getActivity());
	}

	public static void shake(Activity act, Option option) {
		ViewGroup vgl = (ViewGroup) act.getWindow().getDecorView();
		shake(vgl.getChildAt(0), option);
	}

	public static void shake(Fragment fragment, Option option) {
		shake(fragment.getActivity(), option);
	}

	public static void shake(View view, Option option) {

		if (option == null) {
			option = getOption(view.getContext());
		}

		TranslateAnimation ta = new TranslateAnimation(-option.mOffsetX,
				option.mOffsetX, -option.mOffsetY, option.mOffsetY);
		ta.setDuration(option.mDuration);
		ta.setInterpolator(new CycleInterpolator(option.mRepeatCount));

		view.startAnimation(ta);

		if (option.mVibrate) {
			Vibrator v = (Vibrator) view.getContext().getSystemService(
					Context.VIBRATOR_SERVICE);
			v.vibrate(getVibratePattern(option), -1);
		}
	}

	private static long[] getVibratePattern(Option option) {
		long[] pattern = new long[option.mRepeatCount];
		for (int i = 0; i < pattern.length; i++) {
			pattern[i] = option.mDuration / option.mRepeatCount;
		}
		return pattern;
	}

	private static Option getOption(Context context) {
		if (option == null) {
			return new Option.Builder(context).build();
		}
		return option;
	}

	public static void setOption(Option option) {
		WindowShaker.option = option;
	}

	public static class Option {

		private int mOffsetX;
		private int mOffsetY;
		private int mDuration;
		private int mRepeatCount;
		private boolean mVibrate;

		private Option() {
		}

		public int getmOffsetX() {
			return mOffsetX;
		}

		public void setmOffsetX(int mOffsetX) {
			this.mOffsetX = mOffsetX;
		}

		public int getmOffsetY() {
			return mOffsetY;
		}

		public void setmOffsetY(int mOffsetY) {
			this.mOffsetY = mOffsetY;
		}

		public int getmDuration() {
			return mDuration;
		}

		public void setmDuration(int mDuration) {
			this.mDuration = mDuration;
		}

		public boolean ismVibrate() {
			return mVibrate;
		}

		public void setmVibrate(boolean mVibrate) {
			this.mVibrate = mVibrate;
		}

		public int getmRepeatCount() {
			return mRepeatCount;
		}

		public void setmRepeatCount(int mRepeatCount) {
			this.mRepeatCount = mRepeatCount;
		}

		public static class Builder {
			private Option mOption;
			private Context mContext;

			public Builder(Context context) {
				mContext = context;
				mOption = new Option();
				// default
				mOption.setmDuration(800);
				mOption.setmOffsetX(dp2px(5));
				mOption.setmOffsetY(dp2px(5));
				mOption.setmRepeatCount(6);
				mOption.setmVibrate(true);
			}

			private int dp2px(int dp) {
				return (int) TypedValue.applyDimension(
						TypedValue.COMPLEX_UNIT_DIP, dp, mContext
								.getResources().getDisplayMetrics());
			}

			/**
			 * 
			 * @param offsetX
			 * @return
			 */
			public Builder setOffsetX(int dip) {
				mOption.setmOffsetX(dp2px(dip));
				return this;
			}

			/**
			 * 
			 * @param dip
			 * @return
			 */
			public Builder setOffsetY(int dip) {
				mOption.setmOffsetY(dp2px(dip));
				return this;
			}

			public Builder setDuration(int duration) {
				mOption.setmDuration(duration);
				return this;
			}

			public Builder setRepeatCount(int count) {
				mOption.setmRepeatCount(count);
				return this;
			}

			public Builder setVibrate(boolean vibrate) {
				mOption.setmVibrate(vibrate);
				return this;
			}

			public Option build() {
				return mOption;
			}
		}
	}
}
