package com.example.hikeapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "HikeAppDB";

    public static final String TABLE_ETAPE = "etape";

    public static final String KEY_PATROUiLLE = "patrouille";
    public static final String KEY_NUM = "numero";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_CODE = "code";
    public static final String KEY_STATUS = "status";

    private static final String CREATE_TABLE_ETAPE = "CREATE TABLE "+TABLE_ETAPE+" ("+
            KEY_PATROUiLLE+" NOT NULL, "+KEY_NUM+" NOT NULL, "+KEY_IMAGE+
            " NOT NULL, "+KEY_CODE+" NOT NULL, "+KEY_STATUS+" NOT NULL);";

    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME , null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys = ON");

        db.execSQL(CREATE_TABLE_ETAPE);

        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Eurostralie', '1', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Eurostralie', '2', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Eurostralie', '3', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Eurostralie', '4', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Eurostralie', '5', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Amerafrique', '1', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Amerafrique', '2', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Amerafrique', '3', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Amerafrique', '4', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Amerafrique', '5', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Indorussie', '1', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Indorussie', '2', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Indorussie', '3', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Indorussie', '4', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Indorussie', '5', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Eurantarctique', '1', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Eurantarctique', '2', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Eurantarctique', '3', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Eurantarctique', '4', 'logo','code1','0')");
        db.execSQL("INSERT INTO "+TABLE_ETAPE+" VALUES ('Eurantarctique', '5', 'logo','code1','0')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_ETAPE);

        onCreate(db);
    }
}
