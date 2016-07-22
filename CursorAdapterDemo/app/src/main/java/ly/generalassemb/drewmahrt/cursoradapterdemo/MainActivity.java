package ly.generalassemb.drewmahrt.cursoradapterdemo;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.List;

import ly.generalassemb.drewmahrt.cursoradapterdemo.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        ListView listView = (ListView)findViewById(R.id.example_list_view);

        ExampleSQLiteOpenHelper helper = ExampleSQLiteOpenHelper.getInstance(MainActivity.this);

        List<GroceryItem> items = helper.getExampleList();

//        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(MainActivity.this,android.R.layout.simple_list_item_1,cursor,new String[]{ExampleSQLiteOpenHelper.COL_ITEM_NAME},new int[]{android.R.id.text1},0);
        final ArrayAdapter<GroceryItem> simpleAdapter1 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, items);

        listView.setAdapter(simpleAdapter1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =  new Intent(MainActivity.this,DetailActivity.class);
//
                GroceryItem item = simpleAdapter1.getItem(position);

                intent.putExtra("id", item.id);
                startActivity(intent);
            }
        });

    }
}
