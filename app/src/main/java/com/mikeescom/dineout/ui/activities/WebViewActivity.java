package com.mikeescom.dineout.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.mikeescom.dineout.R;
import com.mikeescom.dineout.utils.Constants;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView;
    private String collectionUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        getData();
        showCollectionUrl();
    }

    private void getData() {
        collectionUrl = getIntent().getStringExtra(Constants.INTENT_EXTRA_COLLECTION_URL);
    }

    private void showCollectionUrl() {
        if (TextUtils.isEmpty(collectionUrl)) {
            Toast.makeText(this, getResources().getString(R.string.invalid_collection_url), Toast.LENGTH_LONG).show();
            finish();
        }
        mWebView = findViewById(R.id.collection_web_view);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(collectionUrl);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
