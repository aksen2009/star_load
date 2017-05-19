package com.example.administrator.urltest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if(findViewById(R.id.fragment_container)!=null){
                if(savedInstanceState != null){return;}
            FragmentUrl fragmentUrl1 = new FragmentUrl();
            getFragmentManager().beginTransaction().add(R.id.fragment_container, fragmentUrl1).commit();

        }
    }

    public void selectFragment(View view){
        Fragment fr = null;
        String str = "";
        switch (view.getId()){
            case R.id.urlbtn:
                fr = new FragmentUrl();
                str = "f1";
                break;
            case R.id.newurl:
                fr = new FragmaentUrl2();
                str="f2";
                break;
            case R.id.delurl:
                fr = new FragmentUrl3();
                str = "f3";
                break;
        }
        FragmentManager fm = getFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fr,str);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
