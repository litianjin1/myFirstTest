package com.example.study.util;

import java.text.DecimalFormat;

public class PercentUtil {

    public static String getPercent(int x,int total){
        String result = "";//接受百分比的值
        double x_double = x*1.0;
        double tempresult = x/(total*1.0);
        DecimalFormat df = new DecimalFormat("0.00%");    //##.00%   百分比格式，后面不足2位的用0补齐
        result= df.format(tempresult);
        return result;
    }
}
