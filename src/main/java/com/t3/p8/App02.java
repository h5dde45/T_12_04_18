package com.t3.p8;

import java.util.HashMap;
import java.util.Map;

public class App02 {
    //    Object lok = new Object();
    private Map<Integer, String> map = new HashMap<>();


    public synchronized String get(Object key) {
//        synchronized (lok) {
        return map.get(key);
//        }
    }

    public synchronized String put(Integer key, String value) {
//        synchronized (lok) {
        return map.put(key, value);
//        }
    }
}

class X {
    public static void main(String[] args) throws InterruptedException {
//        App02 map = null;
//        App02 map2 = null;
//        synchronized (map) {
//            synchronized (map2) {
//                map.put(0,"a");
//                map2.put(0,"a");
//            }
//        }
    }
}
