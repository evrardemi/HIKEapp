package com.example.hikeapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

//CTRL + SHIFT + O pour générer les imports
public class EtapeDAO extends DAO<Etape> {
    public EtapeDAO(DataBaseHelper dbHelper) {
        super(dbHelper);
    }

    public boolean create(Etape obj) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Etape test = this.find(obj.getPat(),obj.getNum());
        if(test==null){
            db.execSQL("INSERT INTO "+dbHelper.TABLE_ETAPE+" VALUES ('"+obj.getPat()+"', '"
                    +obj.getNum()+"', '"+obj.getImage()+"', '"+obj.getCode()+"','"+obj.getStatus()+"')");
            return true;
        }else{
            return false;
        }
    }

    public boolean delete(Etape obj) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Etape test = this.find(obj.getPat(),obj.getNum());
        if(test!=null){
            String query = "DELETE FROM "+dbHelper.TABLE_ETAPE+" WHERE "+dbHelper.KEY_PATROUiLLE+" = '"+obj.getPat()
                    +"' and "+dbHelper.KEY_NUM+" = '"+obj.getNum()+"'";
            db.execSQL(query);
            return true;
        }else{
            return false;
        }
    }

    public boolean update(Etape obj) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Etape test = this.find(obj.getPat(),obj.getNum());

        if(test!=null){
            if(test.getStatus()==0){
                String query = "UPDATE "+dbHelper.TABLE_ETAPE+" SET "+dbHelper.KEY_STATUS+" = '1' WHERE "+dbHelper.KEY_PATROUiLLE+" = '"+
                        obj.getPat()+"' AND "+dbHelper.KEY_NUM+" = '"+obj.getNum()+"'";
                System.out.println(query);
                db.execSQL(query);
            }else{
                String query = "UPDATE "+dbHelper.TABLE_ETAPE+" SET "+dbHelper.KEY_STATUS+" = '1' WHERE "+dbHelper.KEY_PATROUiLLE+" = '"+
                        obj.getPat()+"' AND "+dbHelper.KEY_NUM+" = '"+obj.getNum()+"'";
                db.execSQL(query);
            }
            return true;
        }
        return false;
    }

    public Etape find(String PatName, int num) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "SELECT * FROM "+dbHelper.TABLE_ETAPE+" WHERE "+dbHelper.KEY_PATROUiLLE+" = '"+PatName
                +"' and "+dbHelper.KEY_NUM+" = '"+num+"'";
        Cursor c = db.rawQuery(query, null);
        if(c.getCount()==1) {
            c.moveToFirst();
            String image = c.getString(c.getColumnIndex(dbHelper.KEY_IMAGE));
            String code = c.getString(c.getColumnIndex(dbHelper.KEY_CODE));
            int status = c.getInt(c.getColumnIndex(dbHelper.KEY_STATUS));
            c.close();
            return new Etape(PatName, num, image, code, status);
        }else{
            return null;
        }
    }
}
