package com.menethil.hiapk.settings.utils;

import java.util.List;

import com.menethil.hiapk.settings.BaseContext;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

public class Utils {
	public static final boolean DEBUG = true;
	public static final String LOGTAG = "HiAPK Settings";

	/**
	 * 检查 Intent 是否有效
	 * 
	 * @param intent
	 * @return
	 */
	public static boolean checkIntent(Intent intent) {
		PackageManager pm = BaseContext.getInstance().getContext().getPackageManager();
		List<ResolveInfo> resolveInfoList = pm.queryIntentActivities(intent, PackageManager.GET_ACTIVITIES);

		if (resolveInfoList.size() == 0) {
			return false;
		}

		return true;
	}

	/**
	 * 检查指定包名是否存在
	 * 
	 * @return boolean if is exist
	 */
	public static boolean checkExists(String packageName) {
		try {
			PackageManager aPackageManager = BaseContext.getInstance().getContext().getPackageManager();
			List<PackageInfo> allPackages = aPackageManager.getInstalledPackages(0);
			for (PackageInfo pi : allPackages) {
				if (packageName.equals(pi.packageName)) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
}
