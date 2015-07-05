package com.dev.iliuminate.poofandroid;

/**
 * Created by Iliuminate on 05/07/2015.
 */
public class Item {

    public ItemPK itemPK;
    public String name;
    public String price;
    public String category;
    public String type;

    public class ItemPK {

        private int iditem;
        private int storeIdstore;
    }


    public Item(ItemPK itemPK, String name, String price, String category, String type) {
        this.itemPK = itemPK;
        this.name = name;
        this.price = price;
        this.category = category;
        this.type = type;
    }


    public Item() {
    }

    public ItemPK getItemPK() {
        return itemPK;
    }

    public void setItemPK(ItemPK itemPK) {
        this.itemPK = itemPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
