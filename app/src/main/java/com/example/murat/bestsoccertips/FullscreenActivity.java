package com.example.murat.bestsoccertips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.net.URL;

public class FullscreenActivity extends AppCompatActivity {
    InterstitialAd mInterstitialAd;
    Button mNewGameButton;


    WebView myweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);
        setPage();
        mNewGameButton = (Button) findViewById(R.id.newgame_button);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mNewGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    //Begin Game, continue with app
                }

            }
        });

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {

                //Begin Game, continue with app

                AdView mAdView = (AdView) findViewById(R.id.adView);
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);
                mInterstitialAd.loadAd(adRequest);
                

            }


        });


    }


    private void setPage(){

        myweb = (WebView) findViewById(R.id.my);

        WebSettings mysettings = myweb.getSettings();
        mysettings.setJavaScriptEnabled(true);;
        myweb.loadUrl("Your website Url");
        myweb.setWebViewClient(new WebViewClient());
    }
}