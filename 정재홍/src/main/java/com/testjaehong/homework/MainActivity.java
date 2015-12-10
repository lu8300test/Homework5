package com.testjaehong.homework;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity  {

    EditText edtText;
    Button btn01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 뷰페이저 객체를 참조하고 어댑터를 설정합니다.
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        pager.setAdapter(adapter);

    }

    public class ViewPagerAdapter extends PagerAdapter {
        private String[] resIds = {"http://www.naver.com", "http://www.daum.net", "http://www.nate.com"};
        private Context mContext;

        public ViewPagerAdapter( Context context ) {
                mContext = context;
            }

        public int getCount() {
            return resIds.length;
        }

        public Object instantiateItem(ViewGroup container, int position) {
            PersonPage page = new PersonPage(mContext);
            page.setUri(resIds[position]);

            container.addView(page, position);
            Log.d(">>>>>>>>>>","here");
            return page;
        }

        public void destroyItem(ViewGroup container, int position, Object view) {
            container.removeView((View)view);
        }

        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }
    }
}
