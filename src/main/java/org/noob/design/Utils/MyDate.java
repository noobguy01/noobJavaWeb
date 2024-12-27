package org.noob.design.Utils;




public class MyDate {
    public static  Integer getDay(Integer year, Integer month) {
        int [] arr = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            arr[1] = 29 ;
        }
        return arr[month - 1];
    }
}
