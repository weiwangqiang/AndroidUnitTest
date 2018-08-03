package com.demo.demoaunittest.bean;

/**
 * class description here
 *
 * @author wangqiang
 * @since 2018-05-12
 */
public class Item {
public static String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name ;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj ==null) return false ;
        if(obj instanceof Item){
            Item other = (Item) obj;
            return other.toString().equals(toString());
        }
        return false;
    }
}
