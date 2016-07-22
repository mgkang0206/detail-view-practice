package ly.generalassemb.drewmahrt.cursoradapterdemo;

import android.database.Cursor;

/**
 * Created by mgkan on 2016-07-22.
 */
public class GroceryItem {
  int id;
  String name;
  String description;

  public GroceryItem(int id, String name, String description){
    this.id = id;
    this.name = name;
    this. description = description;
  }

  public String toString() {
    return this.name;
  }
}
