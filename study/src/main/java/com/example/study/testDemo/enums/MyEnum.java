package com.example.study.testDemo.enums;

public enum  MyEnum {
    RED("红色",1,"热情"),GREEN("绿色",2,"自然"),BLACK("黑色",3,"厚重"),BLUE("蓝色",4,"大海");
    private String color;
    private int index;
    private String desc;
     MyEnum(String color,int index,String desc) {
        this.color =color;
        this.index = index;
        this.desc = desc;
    }

    MyEnum() {

    }


    public static String getColor(int index) {
        for(MyEnum m :MyEnum.values()){
            if(m.getIndex() ==index){
                return  m.color;
            }
        }
        return null;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "MyEnum{" +
                "color='" + color + '\'' +
                ", index=" + index +
                ", desc='" + desc + '\'' +
                '}';
    }
}
