
package database.Entity;

import database.sqlcontrol.StockCategoryRoom;
import database.sqlcontrol.StockCharges;
import database.sqlcontrol.StockRoom;
import javax.swing.JComboBox;

public class Utility {
    public void selectCaterory(JComboBox catagoryCombo) {
        CategoryRoom croom;
        for (int i = 0; i < StockCategoryRoom.v.size(); i++) {
            croom = (CategoryRoom) StockCategoryRoom.v.elementAt(i);
            catagoryCombo.addItem(croom.getCategory_id());
        }
    }
    public void selectIDRent(JComboBox catagoryCombo) {
        Charges charges;
        for (int i = 0; i < StockCharges.v.size(); i++) {
            charges = (Charges) StockCharges.v.elementAt(i);
            catagoryCombo.addItem(charges.getChargesName());
        }
    }

}
