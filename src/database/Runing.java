
package database;

import database.Form.Window;
import database.design.Index;
import database.sqlcontrol.DbStore;

public class Runing {
    public static void main(String[] args) {
        new DbStore().doConnect();
        new Index().show();
    }
}
