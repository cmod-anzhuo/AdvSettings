package com.menethil.hiapk.settings.bean;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.drawable.Drawable;

import com.menethil.hiapk.settings.BaseContext;
import com.menethil.hiapk.settings.utils.Utils;

public class SubMenuItem {
	@SuppressWarnings("unused")
	private static final String TAG = "SubMenuItem";
	private Drawable icon;
	private String title;
	private List<SubMenuItem> subMenuList = new ArrayList<SubMenuItem>();
	private Intent intent;

	public SubMenuItem(String paramString, Drawable paramBitmap, List<SubMenuItem> subMenuItem, Intent intent) {
		this.title = paramString;
		this.icon = paramBitmap;
		this.subMenuList = subMenuItem;
		this.intent = intent;
	}

	public Drawable getIcon() {
		return this.icon;
	}

	public String getTitle() {
		return this.title;
	}

	public void setSubMenuList(List<SubMenuItem> subMenuList) {
		this.subMenuList = subMenuList;
	}

	public List<SubMenuItem> getSubMenuList() {
		return subMenuList;
	}

	public void doAction() {
		BaseContext.getInstance().getContext().startActivity(getIntent());
	}

	public Intent getIntent() {
		return intent;
	}

	public boolean isExists() {
		return Utils.checkIntent(intent);
	}
}