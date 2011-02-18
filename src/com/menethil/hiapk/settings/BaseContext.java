package com.menethil.hiapk.settings;

import android.content.Context;

public class BaseContext {
	private Context context;
	private boolean inistable = true;

	private BaseContext() {

	}

	private static class InitInstance {
		public static BaseContext baseContext = new BaseContext();

		public static BaseContext get() {
			return baseContext;
		}
	}

	public static BaseContext getInstance() {
		return InitInstance.get();
	}

	public void inist(Context context) {
		if (inistable) {
			synchronized (this) {
				this.context = context;
				inistable = false;
			}
		}
	}

	public Context getContext() {
		return this.context;
	}
}
