package com.example.administrator.urltest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017-05-15.
 */

public class FragmaentUrl2 extends Fragment {

        Button inserttBtn;
        EditText editText1, editText2;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){


            View view = inflater.inflate(R.layout.fragment_url2,container,false);
            final UrlDatabaseOpenHelper urlDatabaseOpenHelper = new UrlDatabaseOpenHelper(view.getContext(), "url_list.db", null, 1);   //  데이터베이스 헬퍼 생성
            inserttBtn = (Button) view.findViewById(R.id.insertbtn);
            editText1 = (EditText)view.findViewById(R.id.title);
            editText2 = (EditText) view.findViewById(R.id.url);
            inserttBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {   // 새로운  url 추가
                    long now = System.currentTimeMillis();

                    Date date = new Date(now);  //  현재 시간

                    SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd");
                    String strNow = sdfNow.format(date);

                   urlDatabaseOpenHelper.insert("insert into url_list(title, url , date) values ('"+editText1.getText().toString()+"' , '"+editText2.getText().toString()+"' , '"+strNow +"')");
                    Toast.makeText(v.getContext(),"url 추가 완료.",Toast.LENGTH_SHORT).show();
                    editText1.setText("");
                    editText2.setText("");

                }
            });



            return view;

        }


}
