package com.example.day5_kimminkyuhw;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

    Button button;
    EditText edit;

    String naver = "http://m.naver.com";
    String daum = "http://m.daum.net";
    String intra = "http://login.hanssem.com/Dev/login_main_sofo.jsp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        button = (Button) findViewById(R.id.button01);
        edit = (EditText) findViewById(R.id.editText);


        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        pager.setAdapter(adapter);
    }


    public class ViewPagerAdapter extends PagerAdapter {
        // sample names
        private String[] names = { "네이버", "다음", "인트라" };
        // sample image resource ids
        private String[] urls = {naver, daum, intra};

        /**
         * Context 객체
         */
        private Context mContext;

        /**
         * 초기화
         *
         * @param context
         */
        public ViewPagerAdapter( Context context ) {
            mContext = context;
        }

        /**
         * 페이지 갯수
         */
        public int getCount() {
            return names.length;
        }

        /**
         * 뷰페이저가 만들어졌을 때 호출됨
         */
        public Object instantiateItem(ViewGroup container, int position) {
            // create a instance of the page and set data
            WebPage page = new WebPage(mContext);
            //page.setNameText(names[position]);
            page.setWeb(urls[position]);
            //page.setCallNumber(callNumbers[position]);

            // 컨테이너에 추가
            container.addView(page, position);

            return page;
        }

        /**
         * Called to remove the page
         */
        public void destroyItem(ViewGroup container, int position, Object view) {
            container.removeView((View)view);
        }

        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
