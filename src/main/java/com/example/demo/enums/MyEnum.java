package com.example.demo.enums;

public enum  MyEnum {
    RED("红色",1),GREEN("绿色",2),BLACK("黑色",3),BLUE("蓝色",4);
    private String color;
    private int index;
     MyEnum(String color,int index) {
        this.color =color;
        this.index = index;
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
                '}';
    }
}
