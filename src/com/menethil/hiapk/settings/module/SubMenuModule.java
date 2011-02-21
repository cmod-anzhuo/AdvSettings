package com.menethil.hiapk.settings.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.menethil.hiapk.settings.BaseContext;
import com.menethil.hiapk.settings.R;
import com.menethil.hiapk.settings.bean.BaseApp;
import com.menethil.hiapk.settings.bean.SubMenuItem;

import android.content.Context;

public class SubMenuModule {
	private Map<Integer, SubMenuItem> subMenu = new HashMap<Integer, SubMenuItem>();

	private SubMenuModule() {
		inistMenu();
	}

	public static SubMenuModule getInstance() {
		return SubMenuModuleCreator.getSubMenuModule();
	}

	public Map<Integer, SubMenuItem> getSubMenu() {
		return subMenu;
	}

	/**
	 * 初始化菜单
	 */
	private void inistMenu() {
		Context context = BaseContext.getInstance().getContext();

		List<SubMenuItem> subMenuTools = new ArrayList<SubMenuItem>();
		BaseApp recorder = new BaseApp("com.android.soundrecorder", "com.android.soundrecorder.SoundRecorder");
		addToList(new SubMenuItem(recorder.getAppName(), recorder.getIcon(), null, recorder.getIntent()), subMenuTools);
		BaseApp calculator = new BaseApp("com.android.calculator2", "com.android.calculator2.Calculator");
		addToList(new SubMenuItem(calculator.getAppName(), calculator.getIcon(), null, calculator.getIntent()),
				subMenuTools);
		BaseApp fm_radio = new BaseApp("com.android.fm", "com.android.fm.radio.FMRadio");
		addToList(new SubMenuItem(fm_radio.getAppName(), fm_radio.getIcon(), null, fm_radio.getIntent()), subMenuTools);
		BaseApp clock = new BaseApp("com.android.deskclock", "com.android.deskclock.DeskClock");
		addToList(new SubMenuItem(clock.getAppName(), clock.getIcon(), null, clock.getIntent()), subMenuTools);
		BaseApp dps_manager = new BaseApp("com.bel.android.dspmanager",
				"com.bel.android.dspmanager.activity.DSPManager");
		addToList(new SubMenuItem(dps_manager.getAppName(), dps_manager.getIcon(), null, dps_manager.getIntent()),
				subMenuTools);
		BaseApp stk = new BaseApp("com.android.stk", "com.android.stk.StkLauncherActivity");
		addToList(new SubMenuItem(stk.getAppName(), stk.getIcon(), null, stk.getIntent()), subMenuTools);

		subMenu.put(0, new SubMenuItem("工具", context.getResources().getDrawable(R.drawable.nav_mypsn), subMenuTools,
				null));
	}

	private void addToList(SubMenuItem subMenuItem, List<SubMenuItem> subMenuList) {
		if (subMenuItem.isExists()) {
			subMenuList.add(subMenuItem);
		}
	}

	private static class SubMenuModuleCreator {
		private static SubMenuModule subMenuModule = new SubMenuModule();

		public static SubMenuModule getSubMenuModule() {
			return subMenuModule;
		}
	}
}
