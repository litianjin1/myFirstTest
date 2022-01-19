package com.example.study.testDemo.hashDemo;

public class HashCodeDemo {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString( 512));
        System.out.println(Integer.toBinaryString( Integer.MAX_VALUE));
        System.out.println( Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString( Integer.MIN_VALUE));
        System.out.println( Integer.MIN_VALUE);
        String a = "小明有";
        String m = "小明有";
        String b = "撒拉嘿";
        String c = "巴萨卡";
        String d = "五五开";
        String a1 = "小明有发";
        String b1 = "撒拉嘿地方";
        String c1 = "巴萨卡的";
        String d1 = "五五开地方";
        String a11 = "小明有的d";
        String b11 = "撒拉嘿说的";
        String c11 = "巴萨卡说的";
        String d11 = "五五开撒";
        System.out.println(" a.hashCode()       "+Integer.toBinaryString( a.hashCode()));
        System.out.println(" a.hashCode()       "+Integer.toBinaryString( a.hashCode()>>>16));
        System.out.println(" m.hashCode()       "+Integer.toBinaryString( m.hashCode()));
        System.out.println(" b.hashCode()       "+Integer.toBinaryString( b.hashCode()));
        System.out.println(" c.hashCode()       "+Integer.toBinaryString( c.hashCode()));
        System.out.println(" d.hashCode()       "+Integer.toBinaryString( d.hashCode()));

        int h1 =(h1 = a.hashCode()) ^ (h1 >>> 16);
        int h2 =(h2 = b.hashCode()) ^ (h2 >>> 16);
        int h3 =(h3 = c.hashCode()) ^ (h3 >>> 16);
        int h4 =(h4 = d.hashCode()) ^ (h4 >>> 16);
        int h11 =(h11 = a1.hashCode()) ^ (h11 >>> 16);
        int h21 =(h21 = b1.hashCode()) ^ (h21 >>> 16);
        int h31 =(h31 = c1.hashCode()) ^ (h31 >>> 16);
        int h41 =(h41 = d1.hashCode()) ^ (h41 >>> 16);
        int h111 =(h111 = a11.hashCode()) ^ (h111 >>> 16);
        int h211 =(h211 = b11.hashCode()) ^ (h211 >>> 16);
        int h311 =(h311 = c11.hashCode()) ^ (h311>>> 16);
        int h411 =(h411 = d11.hashCode()) ^ (h411 >>> 16);

        System.out.println(Integer.toBinaryString(h41));
        System.out.println(Integer.toBinaryString(h111));

        System.out.println("hash ---a {}"+  (15&h1));
        System.out.println("hash ---b {}"+  (15&h2));
        System.out.println("hash ---c {}"+  (15&h3));
        System.out.println("hash ---d {}"+  (15&h4));
        System.out.println("hash ---a1 {}"+  (15&h11));
        System.out.println("hash ---b1{}"+  (15&h21));
        System.out.println("hash ---c1 {}"+  (15&h31));
        System.out.println("hash ---d1{}"+  (15&h41));
        System.out.println("hash ---a11 {}"+  (15&h111));
        System.out.println("hash ---b11{}"+  (15&h211));
        System.out.println("hash ---c11 {}"+  (15&h311));
        System.out.println("hash ---d11 {}"+  (15&h411));


    }

}
