package com.menethil.hiapk.settings.ui;

import com.menethil.hiapk.settings.R;

import android.os.Bundle;

public class Tools extends BasePreferenceActivity {
	public static final String TAG = "Hiapk Tools";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected int getResourceId() {
		// TODO Auto-generated method stub
		return R.xml.tools;
	}
}