package com.menethil.hiapk.settings.bean;

import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;

import com.menethil.hiapk.settings.BaseContext;

public class BaseApp {
	private String appName;
	private String pkgName;
	private String targetClass;
	private Drawable icon;

	public BaseApp(String pkgName, String targetClass) {
		this.pkgName = pkgName;
		this.targetClass = targetClass;
		inistAppDetail();
	}

	private void inistAppDetail() {
		try {
			icon = BaseContext.getInstance().getContext().getPackageManager().getApplicationIcon(pkgName);
			appName = BaseContext.getInstance().getContext().getPackageManager().getPackageInfo(pkgName, 0).applicationInfo
					.loadLabel(BaseContext.getInstance().getContext().getPackageManager()).toString();
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Intent getIntent() {
		Intent intent = new Intent();
		intent.setClassName(pkgName, targetClass);

		return intent;
	}

	public String getAppName() {
		return appName;
	}

	public String getPkgName() {
		return pkgName;
	}

	public Drawable getIcon() {
		return icon;
	}
}
