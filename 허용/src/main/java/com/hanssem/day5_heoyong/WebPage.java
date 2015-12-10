package com.hanssem.day5_heoyong;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 20151047 on 2015-12-10.
 */
public class WebPage extends LinearLayout{
    Context mContext;
    TextView url;
    Button go_btn;
    WebView webView;

    public WebPage(Context context){
        super(context);

        init(context);
    }

    public WebPage(Context context, AttributeSet attries){
        super(context, attries);

        init(context);
    }

    private void init(Context context){
        mContext=context;

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.web_page, this, true);

        url = (TextView)findViewById(R.id.urlText);
        go_btn = (Button)findViewById(R.id.go_btn);
        webView = (WebView)findViewById(R.id.webView1);
        webView.setWebViewClient(new WebViewClient());
        go_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(url.getText().toString());
            }
        });
    }

    public void setUrlText(String urlStr){
        url.setText(urlStr);
        webView.loadUrl(urlStr); //페이지를 로드
    }
}
