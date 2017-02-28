
package database.Entity;

public class CategoryRoom {
    private String category_id;
    private String categoryName;
    private String price;
    
    public CategoryRoom() {
    }

    public CategoryRoom(String category_id, String categoryName, String price) {
        this.category_id = category_id;
        this.categoryName = categoryName;
        this.price = price;
    }
    
    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    
    
    
}
