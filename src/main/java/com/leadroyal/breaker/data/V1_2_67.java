package com.leadroyal.breaker.data;

import com.leadroyal.breaker.BlackInfo;

import java.util.LinkedList;

public class V1_2_67 {
    private static BlackInfo data;

    public static BlackInfo getData() {
        if (data == null) {
            data = new BlackInfo();
            data.version = 1267;
            data.known = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-7775351613326101303L, "org.apache.shiro.realm.")); //0x941866e73beff4c9L
                add(new BlackInfo.BlockItem(-6025144546313590215L, "org.apache.http.conn.")); //0xac6262f52c98aa39L
                add(new BlackInfo.BlockItem(-5939269048541779808L, "org.quartz.")); //0xad937a449831e8a0L
                add(new BlackInfo.BlockItem(-3975378478825053783L, "org.apache.http.impl.")); //0xc8d49e5601e661a9L
                add(new BlackInfo.BlockItem(-2378990704010641148L, "com.ibatis.")); //0xdefc208f237d4104L
                add(new BlackInfo.BlockItem(-905177026366752536L, "org.apache.catalina.")); //0xf3702a4a5490b8e8L
                add(new BlackInfo.BlockItem(2660670623866180977L, "org.apache.http.auth.")); //0x24ec99d5e7dc5571L
                add(new BlackInfo.BlockItem(2731823439467737506L, "br.com.anteros.")); //0x25e962f1c28f71a2L
                add(new BlackInfo.BlockItem(3637939656440441093L, "com.caucho.")); //0x327c8ed7c8706905L
                add(new BlackInfo.BlockItem(4254584350247334433L, "org.apache.http.cookie.")); //0x3b0b51ecbf6db221L
                add(new BlackInfo.BlockItem(5274044858141538265L, "org.javasimon.")); //0x49312bdafb0077d9L
                add(new BlackInfo.BlockItem(5596129856135573697L, "org.apache.activemq.jms.pool.")); //0x4da972745feb30c1L
                add(new BlackInfo.BlockItem(6854854816081053523L, "org.mortbay.jetty.")); //0x5f215622fb630753L
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-5885964883385605994L, "")); //0xae50da1fad60a096L
                add(new BlackInfo.BlockItem(-831789045734283466L, "")); //0xf474e44518f26736L
                add(new BlackInfo.BlockItem(5474268165959054640L, "")); //0x4bf881e49d37f530L
            }};
        }
        return data;
    }
}