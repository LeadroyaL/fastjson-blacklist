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
                add(new BlackInfo.BlockItem(-8024746738719829346L, "java.io.Serializable")); //0x90a25f5baa21529eL
                add(new BlackInfo.BlockItem(-5811778396720452501L, "java.io.Closeable")); //0xaf586a571e302c6bL
                add(new BlackInfo.BlockItem(-3053747177772160511L, "oracle.jms.AQ")); //0xd59ee91f0b09ea01L
                add(new BlackInfo.BlockItem(-2114196234051346931L, "java.util.Collection")); //0xe2a8ddba03e69e0dL
                add(new BlackInfo.BlockItem(-2027296626235911549L, "java.lang.Iterable")); //0xe3dd9875a2dc5283L
                add(new BlackInfo.BlockItem(-2939497380989775398L, "java.lang.Object")); //0xd734ceb4c3e9d1daL
                add(new BlackInfo.BlockItem(-1368967840069965882L, "java.lang.AutoCloseable")); //0xed007300a7b227c6L
                add(new BlackInfo.BlockItem(2980334044947851925L, "java.lang.Readable")); //0x295c4605fd1eaa95L
                add(new BlackInfo.BlockItem(3247277300971823414L, "java.lang.Cloneable")); //0x2d10a5801b9d6136L
                add(new BlackInfo.BlockItem(5183404141909004468L, "java.lang.Runnable")); //0x47ef269aadc650b4L
                add(new BlackInfo.BlockItem(7222019943667248779L, "java.util.EventListener")); //0x6439c4dff712ae8bL
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
            }};
        }
        return data;
    }
}
