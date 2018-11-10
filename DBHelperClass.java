package first.internal.com.ursdoctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class DBHelperClass extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Register.db";
    public static final String TABLE_NAME = "Register_dt";
    public static final String TABLE_NAME2 = "Patient_Details";
    public static final String COL_1 = "id";
    public static final String COL_2 = "username";
    public static final String COL_3 = "createpassword";
    public static final String COL_4 = "confirmpassword";
    public static final String COL2_1 = "first_name";
    public static final String COL2_2 = "last_name";
    public static final String COL2_3 = "dob";
    public static final String COL2_4 = "sex";
    public static final String COL2_5 = "height";
    public static final String COL2_6 = "weight";
    public static final String COL2_7 = "blood_group";


    public DBHelperClass(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(id Text Primary Key ,username Text, createpassword Text, confirmpassword Text )");
        db.execSQL("create table " + TABLE_NAME2 + "(first_name  Text ,last_name Text, dob Text, sex Text,height Text,weight Text,blood_group Text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);

    }

    public boolean insertData(String id, String username, String createpassword, String confirmpassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(COL_1, id);
        contentValue.put(COL_2, username);
        contentValue.put(COL_3, createpassword);
        contentValue.put(COL_4, confirmpassword);

        long result = db.insert(TABLE_NAME, null, contentValue);
        db.close();

        if (result == -1) {
            return false;
        }

        return true;
    }

    public boolean insertData1(String first_name, String last_name, String dob, String sex, String height,String weight, String blood_group) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(COL2_1, first_name);
        contentValue.put(COL2_2, last_name);
        contentValue.put(COL2_3, dob);
        contentValue.put(COL2_4, sex);
        contentValue.put(COL2_5, height);
        contentValue.put(COL2_6, weight);
        contentValue.put(COL2_7, blood_group);


        long result = db.insert(TABLE_NAME2, null, contentValue);
        db.close();

        if (result == -1) {
            return false;
        }

        return true;
    }

    public boolean validate(String username, String confirmpassword) {
        Log.v("validate", username);
        Log.v("validate", confirmpassword);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from Register_dt where username=? and confirmpassword=?", new String[]{username, confirmpassword});
        if (cs.getCount() > 0)
            return true;
        else
            return false;

    }


    public String fetchByID(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Register_dt where id=?", new String[]{id});
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String name = cursor.getString(0)+"\n"+cursor.getString(1)+"\n"+cursor.getString(2)+"\n"+cursor.getString(3);
            cursor.close();
            return name;
        } else {
            cursor.close();
            return null;
        }
    }
}