package ly.generalassemb.drewmahrt.cursoradapterdemo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    Intent intent = getIntent();
    int id = intent.getIntExtra("id", 0);


    TextView text = (TextView) findViewById(R.id.itemId);
    text.setText("id: "+ id);

    ExampleSQLiteOpenHelper db = ExampleSQLiteOpenHelper.getInstance(getApplicationContext());
    String description = db.getDescription(id);

    TextView desc = (TextView) findViewById(R.id.positionId);
    desc.setText(description);
  }
}
