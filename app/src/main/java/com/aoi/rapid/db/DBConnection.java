package com.aoi.rapid.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aoi.rapid.model.InspectionVO;

import java.io.*;

public class DBConnection extends SQLiteOpenHelper{

    public DBConnection(Context context)
    {
        super(context,"rapidDB.db",null,1);


    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        //InputStream is =context.getResources().getAssets().open("Inspection.sql");
        String sql= "CREATE TABLE INSPECTION (\n" +
                "\t\tINSPECTION_ID DECIMAL(10 , 0) NOT NULL,\n" +
                "\t\tRAPID_SOFTWARE_ID INTEGER NOT NULL,\n" +
                "\t\tINSPECTION_STATUS_CODE CHAR(6) NOT NULL,\n" +
                "\t\tREAC_PROPERTY_ID DECIMAL(10 , 0) NOT NULL,\n" +
                "\t\tINSPECTION_TYPE_CODE CHAR(6) NOT NULL,\n" +
                "\t\tINSPECTION_CODE CHAR(3) DEFAULT 'REG' NOT NULL,\n" +
                "\t\tSCHEDULED_INSPECTOR_CODE CHAR(6),\n" +
                "\t\tSCHEDULED_DATETIME TIMESTAMP NOT NULL,\n" +
                "\t\tINSPECTION_START_TIMESTAMP TIMESTAMP,\n" +
                "\t\tINSPECTION_FINISH_TIMESTAMP TIMESTAMP,\n" +
                "\t\tSAMPLE_GENERATED_TIMESTAMP TIMESTAMP,\n" +
                "\t\tSAMPLE_INTERVAL DECIMAL(10 , 2),\n" +
                "\t\tBUILDING_SAMPLE_SIZE INTEGER,\n" +
                "\t\tUNIT_SAMPLE_SIZE INTEGER,\n" +
                "\t\tMAX_SAMPLE_SIZE DECIMAL(10 , 5) NOT NULL,\n" +
                "\t\tRANDOM_SEED DECIMAL(20 , 0),\n" +
                "\t\tHUD_INSPECTOR_PRESENT_IND CHAR(1) DEFAULT 'N' NOT NULL,\n" +
                "\t\tHUD_INSPECTOR_CODE CHAR(6),\n" +
                "\t\tEHS_COUNT INTEGER DEFAULT 0 NOT NULL,\n" +
                "\t\tEHS_REPORT_GENERATED_IND CHAR(1) DEFAULT 'N' NOT NULL,\n" +
                "\t\tUNSUCCESSFUL_REASON_CODE CHAR(6),\n" +
                "\t\tCOMMENT_ID INTEGER,\n" +
                "\t\tMAX_DOWNLOAD_COUNT INTEGER DEFAULT 3 NOT NULL,\n" +
                "\t\tDOWNLOAD_CTR INTEGER NOT NULL,\n" +
                "\t\tUPLOAD_CTR INTEGER NOT NULL,\n" +
                "\t\tRECEIPT_NUMBER DECIMAL(10 , 0),\n" +
                "\t\tLAST_UPDATE_USER_ID CHAR(6) NOT NULL,\n" +
                "\t\tLAST_UPDATE_TIMESTAMP TIMESTAMP NOT NULL,\n" +
                "\t\tCREATE_USER_ID CHAR(6) NOT NULL,\n" +
                "\t\tCREATE_TIMESTAMP TIMESTAMP NOT NULL\n" +
                "\t);\n";
        /*try {
            sql = convertStreamToString(is);

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
      //  db.execSQL("drop table if exists INSPECTION");
       // onCreate(db);

    }
    public boolean addData()
    {
      //  DBConnection dbConnection=new DBConnection(this);
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
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
        if(row==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
public Cursor getInspectionList()
{
    SQLiteDatabase sqLiteDatabaseRead=this.getReadableDatabase();
    Cursor data =null;

    data= sqLiteDatabaseRead.rawQuery("SELECT * FROM INSPECTION",null);
   int count=data.getCount();
   System.out.println("Count"+count);
    return data;
}
}
