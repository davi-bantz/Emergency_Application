package com.example.emergencyapplication.Rescuer_Registration;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBService extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "Rescuer Service.db";

    // User table name
    private static final String TABLE_SERVICE = "user";


    // User Table Columns names

    private static final String ORGNAME = "Org Name";
    private static final String ORGROLE = "Role";
    private static final String ORGADDRESS = "Address";
    private static final String BASICS_SKILLS = "Skills";

    //Create table query
    private static final String CREATE_TABLE = "Create Table " + TABLE_SERVICE + "("  + ORGNAME + "Text Not Null," + ORGROLE +
            "Text Not Null," + ORGADDRESS + "Text Not Null," + BASICS_SKILLS + "Text Not Null" + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_SERVICE;

    //Consructor
    public DBService(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Drop User Table if exist
        sqLiteDatabase.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(sqLiteDatabase);
    }

    //Add new Rescuer
    public void addServiceRescuer(ReadWriteService readWriteService) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBService.ORGNAME, readWriteService.getOrgname());
        contentValues.put(DBService.ORGROLE, readWriteService.getOrgRole());
        contentValues.put(DBService.ORGADDRESS, readWriteService.getOrgAddress());
        contentValues.put(DBService.BASICS_SKILLS, readWriteService.getSkills());

        SQLiteDatabase insertdata = this.getWritableDatabase();
        insertdata.insert(DBService.TABLE_SERVICE, null, contentValues);
    }
}
