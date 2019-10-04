package com.leadroyal.breaker.data;

import com.leadroyal.breaker.BlackInfo;

import java.util.LinkedList;

public class V1_2_59 {
    private static BlackInfo data;

    public static BlackInfo getData() {
        if (data == null) {
            data = new BlackInfo();
            data.version = 1259;
            data.known = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(5100336081510080343L, "org.apache.cxf.jaxrs.provider.")); //0x46c808a4b5841f57L
                add(new BlackInfo.BlockItem(6456855723474196908L, "ch.qos.logback.")); //0x599b5c1213a099acL
                add(new BlackInfo.BlockItem(8537233257283452655L, "net.sf.ehcache.transaction.manager.")); //0x767a586a5107feefL
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
            }};
        }
        return data;
    }
}