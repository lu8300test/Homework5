package com.hanssem.day5_heoyong;

import android.app.ActionBar;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JsResult;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.os.Handler;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private WebView webview;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        pager.setAdapter(adapter);
    }

    public void onClickgoBtn(View v){
        TextView writeUrl = (TextView)findViewById(R.id.urlText);
        String url =writeUrl.getText().toString();

        webview = (WebView)findViewById(R.id.webView1);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(url);
    }
    // 어댑터 정의
    public class ViewPagerAdapter extends PagerAdapter {
        private String[] url = {"http://m.kitchen.hanssem.com/kitchen/main/index.do", "http://m.ik.hanssem.com", "http://as.hanssem.com/main.as"};
        private Context mContext;

        public ViewPagerAdapter( Context context ) {
            mContext = context;
        }

        public int getCount() { // 페이지 수
            return url.length;
        }

        public Object instantiateItem(ViewGroup container, int position) {
            WebPage page = new WebPage(mContext);
            page.setUrlText(url[position]);
            container.addView(page, position);
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
