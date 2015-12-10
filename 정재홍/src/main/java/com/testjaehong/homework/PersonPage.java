package com.testjaehong.homework;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by 20150461 on 2015-12-10.
 */
public class PersonPage extends LinearLayout{
    Context mContext;

    //TextView nameText;
    EditText edtText;
    Button Button1;
    WebView webView;

    public static final int CALL_NUMBER = 1001;

    public void PersonPage(){
        Log.d(">>>>>>", "pppppppp");
    }


    public PersonPage(Context context)  {
        super(context);
        init(context);
    }

    public PersonPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;

        // inflate XML layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_person, this, true);

        //iconImage = (ImageView) findViewById(R.id.iconImage);
        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());

        Button1 = (Button) findViewById(R.id.Button1);
        edtText = (EditText) findViewById(R.id.edtUri);
        Button1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                //String callNumber = (String) Button1.getTag();
                //Log.d(">>>>>>", edtText.getText().toString());
                webView.loadUrl(edtText.getText().toString());
                //Toast.makeText(mContext, "전화걸기 버튼 클릭됨 : " + callNumber, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setUri(String resId) {
        webView.loadUrl(resId);
    }

}
