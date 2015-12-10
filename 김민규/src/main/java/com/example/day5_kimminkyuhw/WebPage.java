package com.example.day5_kimminkyuhw;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by 20140302 on 2015-12-10.
 */
public class WebPage extends LinearLayout{
    Context mContext;
    Button button1;
    EditText edit;
    WebView webView;
    public static final int CALL_NUMBER = 1001;

    public WebPage(Context context){
        super(context);

        init(context);

    }

    private void init(Context context) {
        mContext = context;

        // inflate XML layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.web_layout, this, true);
        button1 = (Button) findViewById(R.id.button01);
        edit = (EditText) findViewById(R.id.editText);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
       // WebSettings webSettings = webView.getSettings();
       // webSettings.setJavaScriptEnabled(true);

        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(edit.getText().toString());
            }
        });

    }

    public void setWeb(String web){
        webView.loadUrl(web);


    }
}
