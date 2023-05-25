package com.example.emergencyapplication.Rescuer_Registration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class DBHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "RescuerRecord.db";

    // User table name
    private static final String TABLE_USER = "user";


    // User Table Columns names
    private static final String NAME = "Name";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "Password";
    private static final String DOB = "DOB";
    private static final String PHONE = "Number";
    private static final String ORGNAME = "Org Name";
    private static final String ORGROLE = "Role";
    private static final String ORGADDRESS = "Address";
    private static final String BASICS_SKILLS = "Skills";

    //Create table query
    private static final String CREATE_TABLE = "Create Table " + TABLE_USER + "(" + NAME + "Text Not Null, " + USERNAME + " Text Not Null," +
            PASSWORD + "Text Not Null," + DOB + "Text Not Null," + PHONE + "Text Not Null," + ORGNAME + "Text Not Null," + ORGROLE +
            "Text Not Null," + ORGADDRESS + "Text Not Null," + BASICS_SKILLS + "Text Not Null" + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    //Consructor
    public DBHelper(Context context) {
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
    public void addNewRescuer(ReadWriteUserDetails readWriteUserDetails) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.NAME, readWriteUserDetails.getName());
        contentValues.put(DBHelper.USERNAME, readWriteUserDetails.getEmail());
        contentValues.put(DBHelper.DOB, readWriteUserDetails.getDob());
        contentValues.put(DBHelper.PHONE, readWriteUserDetails.getPhone());


        SQLiteDatabase insertdata = this.getWritableDatabase();
        insertdata.insert(DBHelper.TABLE_USER, null, contentValues);


    }

    //get data
    public List<ReadWriteUserDetails> getBasicDetails() {
            String details = "SELECT name, username, dob, phone FROM TABLE_USER WHERE current_user = ?";
            SQLiteDatabase insertdata = this.getReadableDatabase();
            List<ReadWriteUserDetails> storeRescuer = new ArrayList<>();
            String currentUserValue = "current_value_user";

            Cursor cursor = insertdata.rawQuery(details, new String[]{currentUserValue});
            if (cursor.moveToFirst()){
                do {
                    String name = cursor.getString(0);
                    String username = cursor.getString(1);
                    String Dob = cursor.getString(2);
                    String Phone = cursor.getString(3);

                    ReadWriteUserDetails readWriteUserDetails = new ReadWriteUserDetails(name, username, Dob, Phone);
                    storeRescuer.add(readWriteUserDetails);

                } while (cursor.moveToNext());
            }
            cursor.close();
            return storeRescuer;
    }
}
