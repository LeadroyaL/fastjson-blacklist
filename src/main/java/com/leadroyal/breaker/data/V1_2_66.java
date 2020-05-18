package com.leadroyal.breaker.data;

import com.leadroyal.breaker.BlackInfo;

import java.util.LinkedList;

public class V1_2_66 {
    private static BlackInfo data;

    public static BlackInfo getData() {
        if (data == null) {
            data = new BlackInfo();
            data.version = 1266;
            data.known = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-2439930098895578154L, "javax.script.")); //0xde23a0809a8b9bd6L
                add(new BlackInfo.BlockItem(-582813228520337988L, "javax.sound.")); //0xf7e96e74dfa58dbcL
                add(new BlackInfo.BlockItem(-26639035867733124L, "javax.print.")); //0xffa15bf021f1e37cL
                add(new BlackInfo.BlockItem(386461436234701831L, "javax.activation.")); //0x55cfca0f2281c07L
                add(new BlackInfo.BlockItem(1153291637701043748L, "javax.tools.")); //0x100150a253996624L
                add(new BlackInfo.BlockItem(1698504441317515818L, "javax.management.")); //0x17924cca5227622aL
                add(new BlackInfo.BlockItem(7375862386996623731L, "org.apache.xbean.")); //0x665c53c311193973L
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(7658177784286215602L, "")); //0x6a47501ebb2afdb2L
                add(new BlackInfo.BlockItem(8055461369741094911L, "")); //0x6fcabf6fa54cafffL
            }};
        }
        return data;
    }
}