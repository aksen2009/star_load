package com.example.administrator.urltest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText urlEditText;
    Button urlSearch;
    WebView urlView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);




        urlEditText = (EditText) findViewById(R.id.urltext);
        urlSearch = (Button) findViewById(R.id.urlsearch);
        urlView = (WebView) findViewById((R.id.urlView));


        urlSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(urlEditText.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"주소를 입력해주세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                String str = "http://" + urlEditText.getText();
                urlEditText.setText("");
                urlView.setWebViewClient(new WebViewClient(){
                     @Override
                     public boolean shouldOverrideUrlLoading(WebView view , String url){

                         return false;
                     }

                });
                urlView.loadUrl(str);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.first:
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivityForResult(intent, 1);
                break;
        }
        return true;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode , Intent data){
        if(requestCode == 1 && resultCode == 1){
            urlView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url){

                    return false;
                }

            });
            urlView.loadUrl("http://"+data.getStringExtra("new_move"));
        }

    }
}







