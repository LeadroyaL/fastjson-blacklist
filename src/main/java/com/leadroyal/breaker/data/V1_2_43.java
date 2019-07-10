package com.leadroyal.breaker.data;

import com.leadroyal.breaker.BlackInfo;

import java.util.LinkedList;

public class V1_2_43 {
    private static BlackInfo data;

    public static BlackInfo getData() {
        if (data == null) {
            data = new BlackInfo();
            data.version = 1243;
            data.known = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-2262244760619952081L, "java.net.URL"));
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
            }};
        }
        return data;
    }
}