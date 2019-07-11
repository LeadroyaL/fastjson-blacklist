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
                add(new BlackInfo.BlockItem(-8165637398350707645L, "junit."));
                add(new BlackInfo.BlockItem(-8083514888460375884L, "org.apache.ibatis.datasource"));
                add(new BlackInfo.BlockItem(-7768608037458185275L, "org.apache.log4j."));
                add(new BlackInfo.BlockItem(-5194641081268104286L, "org.apache.logging."));
                add(new BlackInfo.BlockItem(-3935185854875733362L, "org.apache.commons.dbcp"));
                add(new BlackInfo.BlockItem(-1589194880214235129L, "org.jdom."));
                add(new BlackInfo.BlockItem(1073634739308289776L, "org.slf4j."));
                add(new BlackInfo.BlockItem(5688200883751798389L, "javassist."));
                add(new BlackInfo.BlockItem(8389032537095247355L, "org.jaxen."));
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-7921218830998286408L, ""));
                add(new BlackInfo.BlockItem(-6179589609550493385L, ""));
                add(new BlackInfo.BlockItem(-2753427844400776271L, ""));
                add(new BlackInfo.BlockItem(7017492163108594270L, ""));
            }};
        }
        return data;
    }
}