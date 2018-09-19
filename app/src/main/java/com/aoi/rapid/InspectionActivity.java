package com.aoi.rapid;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
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

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        DBConnection dbConnection=new DBConnection(this);
        SQLiteDatabase sqLiteDatabase= dbConnection.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("INSPECTION_ID",5515101);
        cv.put("RAPID_SOFTWARE_ID",10);
        cv.put("INSPECTION_STATUS_CODE","UPLOAD");
        cv.put("REAC_PROPERTY_ID",40051);
        cv.put("INSPECTION_TYPE_CODE","STNDRD");
        cv.put("INSPECTION_CODE","REG");
        cv.put("SCHEDULED_INSPECTOR_CODE","CPASS2");
        cv.put("SCHEDULED_DATETIME","2018-04-09 15:30:00");

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




       long row= sqLiteDatabase.insert("INSPECTION",null,cv);
        System.out.println("row inserted "+row);
       List<InspectionVO> inspList=new ArrayList<InspectionVO>();
        SQLiteDatabase sqLiteDatabaseRead=dbConnection.getReadableDatabase();
        String inspectionData[]={"INSPECTION_ID","REAC_PROPERTY_ID","SCHEDULED_DATETIME"};
       // int [] toViews={R.id.inspID,R.id.reacProp,R.id.schDt};
        Cursor c =null;
         //c= sqLiteDatabaseRead.query("INSPECTION",inspectionData,null,null,null,null,null);
        c= sqLiteDatabaseRead.rawQuery("SELECT * FROM INSPECTION",null);
        int totalcount=c.getCount();
        System.out.println("totalCoiunt" +totalcount);

        if(c.moveToFirst())
        {
            while(!c.isAfterLast())
            {
                int inspId=c.getInt(c.getColumnIndex("INSPECTION_ID"));
                String reacPropID=c.getString(c.getColumnIndex("REAC_PROPERTY_ID"));
               //TextView tv1=(TextView)findViewById(R.id.textView);
                //TextView tv2=(TextView)findViewById(R.id.textView2);

                c.moveToNext();

            }
        }









    }


}
