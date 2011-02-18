package com.menethil.hiapk.settings.ui;

import java.util.ArrayList;
import java.util.List;

import com.menethil.hiapk.settings.BaseContext;
import com.menethil.hiapk.settings.utils.Utils;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceGroup;

public abstract class BasePreferenceActivity extends PreferenceActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		BaseContext.getInstance().inist(this);
		addPreferencesFromResource(getResourceId());
		inistPreferenceActivity();
	}

	protected abstract int getResourceId();

	protected void inistPreferenceActivity() {
		try {
			for (int i = 0; i < getPreferenceScreen().getPreferenceCount(); i++) {
				PreferenceGroup parent = (PreferenceGroup) getPreferenceScreen()
						.getPreference(i);

				List<Preference> removeList = new ArrayList<Preference>();

				for (int j = 0; j < parent.getPreferenceCount(); j++) {
					// Intent 无法到达
					if (!Utils.checkIntent(parent.getPreference(j).getIntent())) {
						removeList.add(parent.getPreference(j));
					}
				}

				if (removeList.size() == 0) {
					continue;
				}

				// 移出无用选项
				for (Preference pre : removeList) {
					parent.removePreference(pre);
				}

				// 无子项，移出父项
				if (parent.getPreferenceCount() == 0) {
					getPreferenceScreen().removePreference(parent);
					i--;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
