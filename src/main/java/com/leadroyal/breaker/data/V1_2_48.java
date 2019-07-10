package com.leadroyal.breaker.data;

import com.leadroyal.breaker.BlackInfo;

import java.util.LinkedList;

public class V1_2_48 {
    private static BlackInfo data;

    public static BlackInfo getData() {
        if (data == null) {
            data = new BlackInfo();
            data.version = 1248;
            data.known = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(1459860845934817624L, "java.net.InetAddress"));
                add(new BlackInfo.BlockItem(8409640769019589119L, "java.lang.Class"));
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
            }};
        }
        return data;
    }
}