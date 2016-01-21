package ca.anthonyn.stodo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class TodoListOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "stodo";
    private static final String TABLE_NAME = "stodo";
    private static final String TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(id INTEGER PRIMARY KEY, data TEXT)";

    public TodoListOpenHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String[] todo = new String[]{"sleeeeep", "slip", "scarecrow", "irritate", "whispering", "suit", "crowded", "space", "provide", "didactic", "advise", "boiling", "phobic", "clap", "bashful", "thunder", "rainy", "deserted", "tangible", "crabby", "drab", "fire", "boundary", "poison", "clear"};
        db.execSQL(TABLE_CREATE);

        for (String s : todo) {
            db.execSQL("INSERT INTO " + TABLE_NAME + " (data) VALUES (\"" + s + "\")");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldv, int newv) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<TodoItem> getAllItems() {
        ArrayList<TodoItem> items = new ArrayList<TodoItem>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(TABLE_NAME, new String[] {"id", "data"}, null, null, null, null, null);

        if (c.moveToFirst()) {
            do {
                TodoItem item;
                item = new TodoItem(c.getString(1), c.getInt(0));
                items.add(item);
            } while (c.moveToNext());
        }

        c.close();

        return items;
    }

    public void removeItemById(int id) {
        SQLiteDatabase db = getWritableDatabase();
        int s = db.delete(TABLE_NAME, "id = " + id, null);
        Log.w("stodo", "Removed item with id " + id + " from database");
        Log.w("stodo", "Returned: " + s);
        db.close();
    }
}
