package com.aoi.rapid;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

import com.aoi.rapid.db.DBConnection;
import com.aoi.rapid.model.InspectionVO;

public class InspectionActivity extends AppCompatActivity {

DBConnection db;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection);
        ListView listView=(ListView)findViewById(R.id.listview);
        db=new DBConnection(this);


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        List<InspectionVO> inspList=new ArrayList<InspectionVO>();
        Cursor data=db.getInspectionList();
        if(data.getCount()!=0)
        {
            while(data.moveToNext())
            {
                InspectionVO inspVO=new InspectionVO();
                inspVO.setInspectionId(data.getInt(data.getColumnIndex("INSPECTION_ID")));
                inspVO.setPropertyId(data.getString(data.getColumnIndex("REAC_PROPERTY_ID")));
                inspVO.setScheduledTime(data.getString(data.getColumnIndex("SCHEDULED_DATETIME")));
                inspList.add(inspVO);
            }
            ListAdapter listAdapter=new ArrayAdapter<InspectionVO>(this,android.R.layout.simple_list_item_1,inspList) ;
            listView.setAdapter(listAdapter);
        }
        else{
            Toast.makeText(InspectionActivity.this,"No data available",Toast.LENGTH_SHORT).show();
        }










    }


}
