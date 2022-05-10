package com.appapp26.rihlati.Db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.appapp26.rihlati.Trip;
import com.appapp26.rihlati.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper single_instance = null;


    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "station";

    // Table Names
    private static final String TABLE_TRIP = "trips";
    private static final String TABLE_USER = "user";
    private static final String TABLE_RESERVATION = "resevation";

    // Common column names
    private static final String KEY_ID = "id";

    // USER Table - column nmaes
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_ROLE = "role";

    // TRIP Table - column nmaes
    private static final String KEY_DESTINATION = "destination";
    private static final String KEY_N_PLACES = "n_places";
    private static final String KEY_PRICE = "price";
    private static final String KEY_TIME = "time";

    // RESERVATION Table - column names
    private static final String KEY_TRIP_ID = "trip_id";
    private static final String KEY_USER_ID = "user_id";


    // Table Create Statements
    // User table create statement
    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USERNAME
            + " TEXT," + KEY_PASSWORD + " TEXT," + KEY_ROLE
            + " INTEGER" + ")";

    // trip table create statement
    private static final String CREATE_TABLE_TRIP = "CREATE TABLE "
            + TABLE_TRIP + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_DESTINATION
            + " TEXT," + KEY_TIME + " INTEGER," + KEY_PRICE + " INTEGER, " + KEY_N_PLACES + " INTEGER " + ")";

    // reservation table create statement
    private static final String CREATE_TABLE_RESERVATION = "CREATE TABLE "
            + TABLE_RESERVATION + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_USER_ID + " INTEGER," + KEY_TRIP_ID + " INTEGER"
            + ")";

    private DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public static DatabaseHelper getInstance(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version)
    {
        if (single_instance == null)
            single_instance = new DatabaseHelper(context, name, factory,version);

        return single_instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_TRIP);
        db.execSQL(CREATE_TABLE_RESERVATION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRIP);

        // create new tables
        onCreate(db);
    }
    /*
     * Creating a trip
     */
    public long createTrip(Trip trip) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DESTINATION, trip.getDestination());
        values.put(KEY_PRICE, trip.getPrice());
        values.put(KEY_TIME, trip.getTime());
        values.put(KEY_N_PLACES, trip.getAv_places());

        // insert row
        long trip_id = db.insert(TABLE_TRIP, null, values);



        return trip_id;
    }
    public long createUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME,user.getEmail());
        values.put(KEY_PASSWORD,user.getPassword());
        values.put(KEY_ROLE, user.getRole());


        // insert row
        long user_id = db.insert(TABLE_USER, null, values);



        return user_id;
    }
    public boolean checkUser(String email, String password) {
        // array of columns to fetch
        String[] columns = {
                KEY_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = KEY_USERNAME + " = ?" + " AND " + KEY_PASSWORD + " = ?";
        // selection arguments
        String[] selectionArgs = {email, password};
        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }
    /*
     * getting all trips
     * */
    @SuppressLint("Range")
    public List<Trip> getAllTrips() {
        List<Trip> trips = new ArrayList<Trip>();
        String selectQuery = "SELECT  * FROM " + TABLE_TRIP;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Trip trip = new Trip();
                trip.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                trip.setDestination((c.getString(c.getColumnIndex(KEY_DESTINATION))));
                trip.setAv_places(c.getInt(c.getColumnIndex(KEY_N_PLACES)));
                trip.setPrice(c.getInt(c.getColumnIndex(KEY_PRICE)));
                trip.setTime(c.getString(c.getColumnIndex(KEY_TIME)));

                // adding to trip list
                trips.add(trip);
            } while (c.moveToNext());
        }

        return trips;
    }

    // getting only recent trip after < 1 hour


    public List<Trip> getRecentTrips()  {
        List<Trip> recentTrips = new ArrayList<Trip>();
        List<Trip> trips = getAllTrips();
        for (Trip trip:trips) {
            String time= trip.getTime();
            time =time.substring(0,2);
            Calendar myObj=Calendar.getInstance();
            if(Integer.parseInt(time)==myObj.get(Calendar.HOUR_OF_DAY)||Integer.parseInt(time)==(myObj.get(Calendar.HOUR_OF_DAY)+1)){
                recentTrips.add(trip);
            }
        }
        return recentTrips;
    }

    @SuppressLint("Range")
    public List<Trip> getSearchTrips(String destination) {
        List<Trip> trips = new ArrayList<Trip>();
       // String selectQuery = "SELECT  * FROM " + TABLE_TRIP + " WHERE "+KEY_DESTINATION+" = ?"+ new String[] {destination};

        //Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_TRIP+" WHERE TRIM("+KEY_DESTINATION+") = '"+destination.trim()+"'", null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Trip trip = new Trip();
                trip.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                trip.setDestination((c.getString(c.getColumnIndex(KEY_DESTINATION))));
                trip.setAv_places(c.getInt(c.getColumnIndex(KEY_N_PLACES)));
                trip.setPrice(c.getInt(c.getColumnIndex(KEY_PRICE)));
                trip.setTime(c.getString(c.getColumnIndex(KEY_TIME)));

                // adding to trip list
                trips.add(trip);
            } while (c.moveToNext());
        }

        return trips;
    }
    /*
     * Updating a trip
     */
    public int updateTrip(Trip trip) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DESTINATION, trip.getDestination());
        values.put(KEY_PRICE, trip.getPrice());
        values.put(KEY_TIME, trip.getTime());
        values.put(KEY_N_PLACES, trip.getAv_places());

        // updating row
        return db.update(TABLE_TRIP, values, KEY_ID + " = ?",
                new String[] { String.valueOf(trip.getId()) });
    }

    public void closeDb(){
        SQLiteDatabase db = this.getReadableDatabase();
        if(db != null && db.isOpen())
            db.close();
    }
}
