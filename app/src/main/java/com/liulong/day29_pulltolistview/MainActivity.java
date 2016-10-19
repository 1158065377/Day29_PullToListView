package com.liulong.day29_pulltolistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PullToRefreshBase.OnRefreshListener, PullToRefreshBase.OnLastItemVisibleListener {
    private PullToRefreshListView plv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plv = (PullToRefreshListView) findViewById(R.id.plv);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i+"");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        ImageView iv = new ImageView(this);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 200);
        iv.setLayoutParams(params);
        iv.setImageResource(R.mipmap.ic_launcher);
        plv.getRefreshableView().addHeaderView(iv);
        plv.setAdapter(adapter);
        /***
         * 下拉刷新监听器
         */
        plv.setOnRefreshListener(this);
        /**
         * 下拉加载监听器
         */
        plv.setOnLastItemVisibleListener(this);
    }

    /**
     * 下拉刷新需要实现的方法
     * @param refreshView
     */
    @Override
    public void onRefresh(PullToRefreshBase refreshView) {

    }

    /**
     * 上拉加载需要实现的方法
     */
    @Override
    public void onLastItemVisible() {

    }
}
