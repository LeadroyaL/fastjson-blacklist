package com.leadroyal.breaker.data;

import com.leadroyal.breaker.BlackInfo;

import java.util.LinkedList;

public class V1_2_46 {
    private static BlackInfo data;

    public static BlackInfo getData() {
        if (data == null) {
            data = new BlackInfo();
            data.version = 1246;
            data.known = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-8165637398350707645L, "junit.")); //0x8eadd40cb2a94443L
                add(new BlackInfo.BlockItem(-8083514888460375884L, "org.apache.ibatis.datasource")); //0x8fd1960988bce8b4L
                add(new BlackInfo.BlockItem(-7921218830998286408L, "org.osjava.sj.")); //0x92122d710e364fb8L
                add(new BlackInfo.BlockItem(-7768608037458185275L, "org.apache.log4j.")); //0x94305c26580f73c5L
                add(new BlackInfo.BlockItem(-6179589609550493385L, "org.logicalcobwebs.")); //0xaa3daffdb10c4937L
                add(new BlackInfo.BlockItem(-5194641081268104286L, "org.apache.logging.")); //0xb7e8ed757f5d13a2L
                add(new BlackInfo.BlockItem(-3935185854875733362L, "org.apache.commons.dbcp")); //0xc963695082fd728eL
                add(new BlackInfo.BlockItem(-2753427844400776271L, "com.ibatis.sqlmap.engine.datasource")); //0xd9c9dbf6bbd27bb1L
                add(new BlackInfo.BlockItem(-1589194880214235129L, "org.jdom.")); //0xe9f20bad25f60807L
                add(new BlackInfo.BlockItem(1073634739308289776L, "org.slf4j.")); //0xee6511b66fd5ef0L
                add(new BlackInfo.BlockItem(5688200883751798389L, "javassist.")); //0x4ef08c90ff16c675L
                add(new BlackInfo.BlockItem(7017492163108594270L, "oracle.net")); //0x616323f12c2ce25eL
                add(new BlackInfo.BlockItem(8389032537095247355L, "org.jaxen.")); //0x746bd4a53ec195fbL
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
            }};
        }
        return data;
    }
}