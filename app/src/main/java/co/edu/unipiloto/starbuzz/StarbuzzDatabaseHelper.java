package co.edu.unipiloto.starbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StarbuzzDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "starbuzz";

    private static final int DB_VERSION = 1;
    StarbuzzDatabaseHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PET ("
        + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "NAME TEXT, "
        + "DESCRIPTION TEXT, "
        + "NAMEUSER TEXT) ;");
    }

    public void initData(){
        SQLiteDatabase db = this.getWritableDatabase();
        onUpgrade(db,1,1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PET");
        onCreate(db);
    }

    public static void insertPet(SQLiteDatabase db, String name, String description, String nameUser){
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME",name);
        drinkValues.put("DESCRIPTION",description);
        drinkValues.put("NAMEUSER",nameUser);
        db.insert("PET",null,drinkValues);
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM PET",null);
        return res;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM PET WHERE ID =" + id,null);
        return res;
    }

    public Cursor findDataByName(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM PET WHERE NAME = '" + name+ "'",null);
        return res;
    }
}
