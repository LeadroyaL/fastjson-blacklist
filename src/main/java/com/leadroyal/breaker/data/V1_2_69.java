package com.leadroyal.breaker.data;

import com.leadroyal.breaker.BlackInfo;

import java.util.LinkedList;

public class V1_2_69 {
    private static BlackInfo data;

    public static BlackInfo getData() {
        if (data == null) {
            data = new BlackInfo();
            data.version = 1269;
            data.known = new LinkedList<BlackInfo.BlockItem>() {{
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-3053747177772160511L, "")); //0xd59ee91f0b09ea01L
            }};
        }
        return data;
    }
}
