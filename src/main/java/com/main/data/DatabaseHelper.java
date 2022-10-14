package com.main.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="USER";
    private static final String TABLE_NAME="USERS";
    private static final String COL_1="FIRSTNAME";
    private static final String COL_2="LASTNAME";
    private static final String COL_3="EMAIL";
    private static final String COL_4="PASSWORD";
    private static final String COL_5="CONFIRMPASS";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(FIRSTNAME TEXT, LASTNAME TEXT , EMAIL TEXT , PASSWORD TEXT,CONFIRMPASS TEXT )");
        //AIzaSyCrcVmCmoawEa99gml2XpPH5KideMbZSSI
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean registerUser(String firstName , String lastName,String email , String password,String confirmPass){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_1 , firstName);
        values.put(COL_2 , lastName);
        values.put(COL_3 , email);
        values.put(COL_4 , password);
        values.put(COL_5 , confirmPass);

        long result = db.insert(TABLE_NAME , null , values);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean checkUser(String email , String password){

        SQLiteDatabase db = this.getWritableDatabase();
        String [] columns = { COL_3 };
        String selection = COL_3 + "=?" + " and " + COL_4 + "=?";
        String [] selectionargs = { email, password};
        Cursor cursor = db.query(TABLE_NAME , columns , selection ,selectionargs , null , null , null);
        int count = cursor.getCount();
        db.close();
        cursor.close();
        if (count > 0)
            return true;
        else
            return false;

    }
}
