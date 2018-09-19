package com.aoi.rapid.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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
    /*public  String convertStreamToString(InputStream is)
            throws IOException {
        Writer writer = new StringWriter();
        char[] buffer = new char[2048];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is,
                    "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
            is.close();
        }
        String text = writer.toString();
        return text;
    }*/

}
