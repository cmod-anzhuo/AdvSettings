package com.menethil.hiapk.settings;

import java.util.List;

import com.menethil.hiapk.settings.bean.SubMenuItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SubMenuAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<SubMenuItem> mData;

	public SubMenuAdapter(Context context, List<SubMenuItem> data) {
		this.mInflater = LayoutInflater.from(context);
		this.mData = data;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return mData.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;

		if (convertView == null) {

			holder = new ViewHolder();

			convertView = mInflater.inflate(R.layout.gridview_item, null);
			holder.img = (ImageView) convertView.findViewById(R.id.menu_submenu_icon);
			holder.title = (TextView) convertView.findViewById(R.id.menu_submenu_title);
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.img.setImageDrawable(mData.get(position).getIcon());
		holder.title.setText((String) mData.get(position).getTitle());

		return convertView;
	}

	public final class ViewHolder {
		public ImageView img;
		public TextView title;
	}
}
