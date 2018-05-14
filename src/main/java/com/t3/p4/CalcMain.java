package com.t3.p4;

public class CalcMain {
    public static void main(String[] args) {
        try {
            new CalcImpl().calculate("3rf rfuyfrt4h er~rtkgt8");
//            new CalcImpl().calculate(null);
        } catch (EvException | NullPointerException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("3333333");
    }
}
