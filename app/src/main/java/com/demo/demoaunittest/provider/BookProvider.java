package com.demo.demoaunittest.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class BookProvider extends ContentProvider {
    public static final String AUTHORITY = "com.example.test.BookProvider";

    private UriMatcher mUriMatcher;

    private static final String PATH_BOOK = BookTable.tableName;
    private static final int CODE_BOOK = 1;
    private BookSqLite bookSqLite;

    public BookProvider() {
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        mUriMatcher.addURI(AUTHORITY, PATH_BOOK, CODE_BOOK);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        SQLiteDatabase db = bookSqLite.getWritableDatabase();
        int res = db.delete(getTableName(uri), selection, selectionArgs);
        db.close();
        return res;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        return getTableName(uri);
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = bookSqLite.getWritableDatabase();
        db.insert(getTableName(uri), null, values);
        getContext().getContentResolver().notifyChange(uri, null);
        db.close();
        return uri;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        bookSqLite = new BookSqLite(getContext());
        bookSqLite.getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        return bookSqLite.getReadableDatabase().query(getTableName(uri),
            projection, selection, selectionArgs,
            null, null, sortOrder, null
        );
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        SQLiteDatabase db = bookSqLite.getWritableDatabase();
        db.update(getTableName(uri), values, selection, selectionArgs);
        db.close();
        return 0;
    }

    private String getTableName(Uri uri) {
        String tableName = null;
        switch (mUriMatcher.match(uri)) {
            case CODE_BOOK:
                tableName = BookTable.tableName;
                break;
            default:
                break;
        }
        return tableName;
    }

}
