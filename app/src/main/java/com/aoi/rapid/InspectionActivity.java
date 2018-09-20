package com.aoi.rapid;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
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
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //Creating DB instance
        DBConnection dbConnection=new DBConnection(this);
        //inserting data in DB
        SQLiteDatabase sqLiteDatabase=dbConnection.getWritableDatabase();
        Boolean rows=   addData(sqLiteDatabase);
        System.out.println("Added data in DB"+rows);
        //Retrieving data from DB
        SQLiteDatabase sqLiteDatabaseRead=dbConnection.getWritableDatabase();
        Cursor data=getInspectionList(sqLiteDatabaseRead);
         List<InspectionVO> inspList=new ArrayList<InspectionVO>();
        List<String> inspListDetails=new ArrayList<String>();

        if(data.getCount()!=0)
        {
            while(data.moveToNext())
            {
                InspectionVO inspVO=new InspectionVO();
                inspVO.setInspectionId(data.getInt(data.getColumnIndex("INSPECTION_ID")));
                inspVO.setPropertyId(data.getString(data.getColumnIndex("REAC_PROPERTY_ID")));
                inspVO.setScheduleTime(data.getString(data.getColumnIndex("SCHEDULED_DATETIME")));
                inspVO.setInspectionStatusCd(data.getString(data.getColumnIndex("INSPECTION_STATUS_CODE")));

                inspList.add(inspVO);
                inspListDetails.add(String.valueOf(inspVO.getInspectionId())+","
                + inspVO.getInspectionStatusCd() +"@" + inspVO.getScheduleTime());
            }

            listView.setAdapter(new ArrayAdapter<>(InspectionActivity.this,android.R.layout.simple_expandable_list_item_1,inspListDetails) );
        }
        else{
            Toast.makeText(InspectionActivity.this,"No data available",Toast.LENGTH_SHORT).show();
        }










    }

    public boolean addData(SQLiteDatabase sqLiteDatabase)
    {
        ContentValues cv=new ContentValues();
        cv.put("INSPECTION_ID",5515167);
        cv.put("RAPID_SOFTWARE_ID",103);
        cv.put("INSPECTION_STATUS_CODE","UPLOAD");
        cv.put("REAC_PROPERTY_ID",40051);
        cv.put("INSPECTION_TYPE_CODE","STNDRD");
        cv.put("INSPECTION_CODE","REG");
        cv.put("SCHEDULED_INSPECTOR_CODE","CPASS2");
        cv.put("SCHEDULED_DATETIME","2018-20-09 10:30:00");

        cv.put("INSPECTION_START_TIMESTAMP","2018-04-09 15:30:00");
        cv.put("INSPECTION_FINISH_TIMESTAMP","2018-04-09 15:30:00");
        cv.put("SAMPLE_GENERATED_TIMESTAMP","2018-04-09 15:30:00");
        cv.put("SAMPLE_INTERVAL",3.54);
        cv.put("HUD_INSPECTOR_CODE","H55157");
        cv.put("MAX_SAMPLE_SIZE",2);

        cv.put("HUD_INSPECTOR_PRESENT_IND","Y");
        cv.put("EHS_COUNT",2);
        cv.put("EHS_REPORT_GENERATED_IND","Y");
        cv.put("MAX_DOWNLOAD_COUNT",2);
        cv.put("DOWNLOAD_CTR",1);
        cv.put("UPLOAD_CTR",1);
        cv.put("LAST_UPDATE_USER_ID","vindy");
        cv.put("LAST_UPDATE_TIMESTAMP","2018-09-18 9:00:00");
        cv.put("CREATE_USER_ID","vindy");
        cv.put("CREATE_TIMESTAMP","2018-09-18 9:00:00");
        cv.put("INSPECTION_STATUS_CODE","PROGRESS");




        long row= sqLiteDatabase.insert("INSPECTION",null,cv);
        System.out.println("row inserted "+row);
        if(row==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor getInspectionList(SQLiteDatabase sqLiteDatabase)
    {

        Cursor data =null;

        data= sqLiteDatabase.rawQuery("SELECT * FROM INSPECTION",null);
        int count=data.getCount();
        System.out.println("Count"+count);
        return data;
    }
}
