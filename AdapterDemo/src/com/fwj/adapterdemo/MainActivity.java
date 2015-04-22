package com.fwj.adapterdemo;

import java.util.ArrayList;
import java.util.List;

import com.fwj.adapterdemo.utils.CommonAdater;
import com.fwj.adapterdemo.utils.ViewHolder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	private List<Bean> data;
	private ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		initView();
		initData();
	}

	private void initView() {
		setContentView(R.layout.activity_main);
		listview = (ListView) findViewById(R.id.listview);
	}

	private void initData() {
		data = new ArrayList<Bean>();
		for (int i = 0; i < 200; i++) {
			data.add(new Bean("title" + i, "content" + i));

		}
		listview.setAdapter(new CommonAdater<Bean>(MainActivity.this,
				R.layout.item_listview, data) {

			@Override
			public void convert(ViewHolder holder, Bean bean) {
				// 链式编程
				holder.setText(R.id.item_title, bean.title).setText(
						R.id.item_content, bean.content);

			}
		});

	}
}
