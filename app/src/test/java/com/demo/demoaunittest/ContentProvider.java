package com.demo.demoaunittest;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.constraint.BuildConfig;

import com.demo.demoaunittest.provider.BookProvider;
import com.demo.demoaunittest.provider.BookTable;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ContentProviderController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowContentResolver;

/**
 * 测试contentProvider 增删改查
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class ContentProvider {
    BookProvider dataBaseProvider;
    Uri uri = Uri.parse(String.format("content://%s/%s", BookProvider.AUTHORITY, BookTable.tableName));

    @Before
    public void init() {
        ContentProviderController<BookProvider> controller = Robolectric.buildContentProvider(BookProvider.class).create();
        dataBaseProvider = controller.get();
        ShadowContentResolver.registerProviderInternal(uri.getPath(), dataBaseProvider);

        ContentValues contentValues = new ContentValues();
        contentValues.put(BookTable.id, "1");
        contentValues.put(BookTable.name, "book 1");
        dataBaseProvider.insert(uri, contentValues);
        test_insert();
    }

    /**
     * 插入一条数据
     */
    @Test
    public void test_insert() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BookTable.id, "2");
        contentValues.put(BookTable.name, "book 2");
        dataBaseProvider.insert(uri, contentValues);
    }

    @Test
    public void test_delete() {
        test_queryAll();
        dataBaseProvider.delete(uri, BookTable.id + " = ?", new String[] {"1"});
        System.out.println("-------delete ------------");
        test_queryAll();
    }

    /**
     * 条件查询
     */
    @Test
    public void test_queryCondition() {
        Cursor cursor = dataBaseProvider.query(uri,
            new String[] {BookTable.id, BookTable.name},
            BookTable.id + " = ?", new String[] {"2"}, null);
        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            print(id, name);
        }
        cursor.close();
    }

    /**
     * 查询全部数据
     */
    @Test
    public void test_queryAll() {
        Cursor cursor = dataBaseProvider.query(uri,
            new String[] {BookTable.id, BookTable.name},
            null, null, null);
        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            print(id, name);
        }
        cursor.close();
    }

    /**
     * 更新数据
     */
    @Test
    public void test_update() {
        test_queryAll();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BookTable.name, "book 2 update");
        dataBaseProvider.update(uri, contentValues,
            BookTable.id + " = ?", new String[] {"2"});
        System.out.println("-------- update ------");
        test_queryAll();
    }

    private void print(String id, String name) {
        System.out.println(String.format("id: %s  name: %s ", id, name));
    }
}
