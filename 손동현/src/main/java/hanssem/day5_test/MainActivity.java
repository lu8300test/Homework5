package hanssem.day5_test;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        pager.setAdapter(adapter);

    }

    public void onClickgoBtn(View v) {
        TextView writeUrl = (TextView) findViewById(R.id.url);
        String url = writeUrl.getText().toString();

        webview = (WebView) findViewById(R.id.webView);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(url);
    }

    // 뷰페이저 어댑터
    public class ViewPagerAdapter extends PagerAdapter {

        private String[] url = {"http://www.naver.com", "http://www.daum.net", "http://www.google.com/"};

        private Context mContext;

        public ViewPagerAdapter(Context context) {
            mContext = context;
        }

        public int getCount() {
            return url.length;
        }

        public Object instantiateItem(ViewGroup container, int position) {
            WebActivity page = new WebActivity(mContext);
            page.setUrlText(url[position]);

            container.addView(page, position);

            return page;
        }

        public void destroyItem(ViewGroup container, int position, Object view) {
            container.removeView((View) view);
        }

        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

    }

}
