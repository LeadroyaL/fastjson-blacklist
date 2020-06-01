package com.leadroyal.breaker.data;

import com.leadroyal.breaker.BlackInfo;

import java.util.LinkedList;

public class V1_2_70 {
    private static BlackInfo data;

    public static BlackInfo getData() {
        if (data == null) {
            data = new BlackInfo();
            data.version = 1270;
            data.known = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-5076846148177416215L, "org.apache.commons.collections4.Transformer")); //0xb98b6b5396932fe9L
                add(new BlackInfo.BlockItem(-4703320437989596122L, "org.apache.commons.collections4.functors")); //0xbeba72fb1ccba426L
                add(new BlackInfo.BlockItem(-4314457471973557243L, "org.jdom2.transform.")); //0xc41ff7c9c87c7c05L
                add(new BlackInfo.BlockItem(-2533039401923731906L, "org.apache.hadoop.shaded.com.zaxxer.hikari.")); //0xdcd8d615a6449e3eL
                add(new BlackInfo.BlockItem(156405680656087946L, "com.p6spy.engine.")); //0x22baa234c5bfb8aL
                add(new BlackInfo.BlockItem(1214780596910349029L, "org.apache.activemq.pool.")); //0x10dbc48446e0dae5L
                add(new BlackInfo.BlockItem(3085473968517218653L, "org.apache.aries.transaction.")); //0x2ad1ce3a112f015dL
                add(new BlackInfo.BlockItem(3129395579983849527L, "org.apache.activemq.ActiveMQConnectionFactory")); //0x2b6dd8b3229d6837L
                add(new BlackInfo.BlockItem(4241163808635564644L, "org.apache.activemq.spring.")); //0x3adba40367f73264L
                add(new BlackInfo.BlockItem(7240293012336844478L, "org.apache.activemq.ActiveMQXAConnectionFactory")); //0x647ab0224e149ebeL
                add(new BlackInfo.BlockItem(7347653049056829645L, "org.apache.commons.jelly.")); //0x65f81b84c1d920cdL
                add(new BlackInfo.BlockItem(7617522210483516279L, "org.apache.axis2.transport.jms.")); //0x69b6e0175084b377L
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
            }};
        }
        return data;
    }
}