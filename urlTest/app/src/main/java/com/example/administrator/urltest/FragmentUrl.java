package com.example.administrator.urltest;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-05-15.
 */

public class FragmentUrl extends Fragment implements AdapterView.OnItemClickListener {
    ListView listView;
    CustomAdapter customAdapter;
    ArrayList<listItem> arrayList;
    UrlDatabaseOpenHelper urlDatabaseOpenHelper;
    Cursor cursor;
    Button new_cancel, new_move;
    String move_url="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.fragment_url1,container,false);
        urlDatabaseOpenHelper = new UrlDatabaseOpenHelper(view.getContext(),"url_list.db", null, 1);    // 디비 연결
        cursor = urlDatabaseOpenHelper.PrintData();
        final View header = inflater.inflate(R.layout.listview_header, null, false) ;
        arrayList = new ArrayList<listItem>();
        new_cancel = (Button) view.findViewById(R.id.new_cancel);
        new_move = (Button) view.findViewById(R.id.new_move);

        while(cursor.moveToNext()){
            arrayList.add(new listItem(cursor.getString(0),cursor.getString(1), cursor.getString(2)));
        }


        customAdapter  = new CustomAdapter(view.getContext(), arrayList);


        listView = (ListView)view.findViewById(R.id.url_list_view);
        listView.addHeaderView(header);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(this);
        new_cancel.setOnClickListener(new View.OnClickListener() {  // 닫기 이벤트  result를 남기지 않는다.
            @Override
            public void onClick(View v) {

                getActivity().setResult(0);

                getActivity().finish();
            }
        });

        new_move.setOnClickListener(new View.OnClickListener() {    // 선택한  url을 메인액티비티로 남겨준다.
            @Override
            public void onClick(View v) {
                if(move_url.equals("")) {
                    Toast.makeText(view.getContext(),"이동할 url을 선택 해 주세요. ", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent();
                intent.putExtra("new_move", move_url);
                getActivity().setResult(1, intent);
                getActivity().finish();
            }
        });

        return view;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id){  // 리스트뷰 아이템 클릭 이벤트
       move_url = arrayList.get(position-1).getUrl();
        Toast.makeText(v.getContext(),"이동할 url이 선택 되었습니다.",Toast.LENGTH_SHORT).show();
    }
}


