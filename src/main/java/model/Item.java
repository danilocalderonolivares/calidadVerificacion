package model;

public class Item {
    String itemName;
    String itemPath;
    String itemXpath;

    public Item(String itemName, String itemXpath, String itemPath) {
        this.itemName = itemName;
        this.itemXpath = itemXpath;
        this.itemPath = itemPath;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPath() {
        return itemPath;
    }

    public void setItemPath(String itemPath) {
        this.itemPath = itemPath;
    }

    public String getItemXpath() {
        return itemXpath;
    }

    public void setItemXpath(String itemXpath) {
        this.itemXpath = itemXpath;
    }

    @Override
    public String toString() {
        return "item{" +
                "itemName='" + itemName + '\'' +
                ", itemPath='" + itemPath + '\'' +
                ", itemXpath='" + itemXpath + '\'' +
                '}';
    }
}
