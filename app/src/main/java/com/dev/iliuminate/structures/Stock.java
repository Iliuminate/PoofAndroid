package com.dev.iliuminate.structures;

import java.io.Serializable;

/**
 * Created by Iliuminate on 05/07/2015.
 */
@SuppressWarnings("serial")
public class Stock implements Serializable {


    String itemName;
    long value;

    byte image;


    public Stock() {
    }

    public Stock(String itemName, long value, byte image) {
        this.itemName = itemName;
        this.value = value;
        this.image = image;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public byte getImage() {
        return image;
    }

    public void setImage(byte image) {
        this.image = image;
    }
}
