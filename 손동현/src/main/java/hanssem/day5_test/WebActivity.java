package hanssem.day5_test;

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

public class WebActivity extends LinearLayout{

    Context wContext;
    TextView url;
    Button btn_go;
    WebView webView;

    public WebActivity(Context context){
        super(context);

        init(context);
    }

    public WebActivity (Context context, AttributeSet attries){
        super(context, attries);

        init(context);
    }

    private void init(Context context){
        wContext=context;

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.web, this, true);

        url = (TextView)findViewById(R.id.url);
        btn_go = (Button)findViewById(R.id.btn_go);
        webView = (WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        btn_go.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                webView.loadUrl(url.getText().toString());
            }
        });
    }

    public void setUrlText(String urlStr){
        url.setText(urlStr);
        webView.loadUrl(urlStr);
    }

}