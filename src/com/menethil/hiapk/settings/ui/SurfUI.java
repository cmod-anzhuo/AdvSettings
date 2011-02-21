package com.menethil.hiapk.settings.ui;

import com.menethil.hiapk.settings.BaseContext;
import com.menethil.hiapk.settings.R;
import com.menethil.hiapk.settings.SubMenuAdapter;
import com.menethil.hiapk.settings.bean.SubMenuItem;
import com.menethil.hiapk.settings.module.SubMenuModule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class SurfUI extends Activity {

	private SubMenuItem subMenuItem;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		BaseContext.getInstance().inist(this);

		Intent intent = getIntent();

		int i = intent.getIntExtra("sub_index", 0);

		subMenuItem = SubMenuModule.getInstance().getSubMenu().get(i);

		setContentView(R.layout.gridview_tools);

		GridView gridview = (GridView) findViewById(R.id.gridview);
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

		// 添加并且显示
		gridview.setAdapter(new SubMenuAdapter(this, subMenuItem.getSubMenuList()));
		// 添加消息处理
		gridview.setOnItemClickListener(new ItemClickListener());
	}

	// 当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
	class ItemClickListener implements OnItemClickListener {
		public void onItemClick(AdapterView<?> arg0,// The AdapterView where the
													// click happened
				View arg1,// The view within the AdapterView that was clicked
				int arg2,// The position of the view in the adapter
				long arg3// The row id of the item that was clicked
		) {
			// 在本例中arg2=arg3
			subMenuItem.getSubMenuList().get(arg2).doAction();
		}

	}
}
