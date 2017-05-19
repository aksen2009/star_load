package com.example.administrator.urltest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

public class FragmentUrl3 extends Fragment implements AdapterView.OnItemClickListener {
    ListView del_listView;
    CustomAdapter del_customAdapter;
    ArrayList<listItem> del_arrayList;
    UrlDatabaseOpenHelper urlDatabaseOpenHelper;
    Cursor cursor;
    Button del, cancel;
    int position = 999;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.fragment_url3,container,false);
        urlDatabaseOpenHelper = new UrlDatabaseOpenHelper(view.getContext(),"url_list.db", null, 1);    // 디비 연결
        cursor = urlDatabaseOpenHelper.PrintData();
        final View header = inflater.inflate(R.layout.listview_header, null, false) ;


        del = (Button) view.findViewById(R.id.delbtn);
        cancel = (Button) view.findViewById(R.id.del_cancelbtn);

        del_arrayList = new ArrayList<listItem>();

        while(cursor.moveToNext()){
            del_arrayList.add(new listItem(cursor.getString(0),cursor.getString(1), cursor.getString(2)));
        }


        del_customAdapter  = new CustomAdapter(view.getContext(), del_arrayList);


        del_listView = (ListView)view.findViewById(R.id.del_list_view);
        del_listView.addHeaderView(header);
        del_listView.setAdapter(del_customAdapter);

        del_listView.setOnItemClickListener(this);

        del.setOnClickListener(new View.OnClickListener() { // 삭제 이벤트
            @Override
            public void onClick(View v) {
                if(position == 999){
                    Toast.makeText(v.getContext(),"삭제할 url을 선택 해주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }else{
                       urlDatabaseOpenHelper = new UrlDatabaseOpenHelper(v.getContext(),"url_list.db", null, 1);    // 디비 연결
                       urlDatabaseOpenHelper.delete("delete from url_list where title = '"+del_arrayList.get(position).getTitle()+"' and url = '"+del_arrayList.get(position).getUrl()+"' ");
                       del_arrayList.remove(position);
                       del_customAdapter.notifyDataSetChanged();
                    Toast.makeText(v.getContext(),"삭제 완료.",Toast.LENGTH_SHORT).show();
                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {  // 종료 함수  result를 넘기지 않는다.
            @Override
            public void onClick(View v) {

                getActivity().setResult(0);
                getActivity().finish();
            }
        });






        return view;
    }
    public void onItemClick(AdapterView<?> parent, View v, int position, long id){  // 리스트뷰 아이템 클릭 이벤트
        this.position = position-1;
        Toast.makeText(v.getContext(),"삭제할 url을 선택 하였습니다.",Toast.LENGTH_SHORT).show();
    }
}
