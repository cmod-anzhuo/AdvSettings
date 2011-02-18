package com.menethil.hiapk.settings.ui;

import com.menethil.hiapk.settings.R;

import android.os.Bundle;

public class HiapkSettings extends BasePreferenceActivity {
	public static final String TAG = "Hiapk Settings";

	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	protected int getResourceId() {
		// TODO Auto-generated method stub
		return R.xml.settings;
	}
}
