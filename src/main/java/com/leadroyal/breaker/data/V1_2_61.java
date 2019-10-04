package com.leadroyal.breaker.data;

import com.leadroyal.breaker.BlackInfo;

import java.util.LinkedList;

public class V1_2_61 {
    private static BlackInfo data;

    public static BlackInfo getData() {
        if (data == null) {
            data = new BlackInfo();
            data.version = 1261;
            data.known = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-4401390804044377335L, "flex.messaging.util.concurrent.AsynchBeansWorkManagerExecutor")); //0xc2eb1e621f439309L
                add(new BlackInfo.BlockItem(-1650485814983027158L, "org.apache.openjpa.ee.")); //0xe9184be55b1d962aL
                add(new BlackInfo.BlockItem(-1251419154176620831L, "oracle.jdbc.rowset.OracleJDBCRowSet")); //0xeea210e8da2ec6e1L
                add(new BlackInfo.BlockItem(-9822483067882491L, "com.mysql.cj.jdbc.admin.")); //0xffdd1a80f1ed3405L
                add(new BlackInfo.BlockItem(99147092142056280L, "oracle.jdbc.connector.OracleManagedConnectionFactory")); //0x1603dc147a3e358L
                add(new BlackInfo.BlockItem(3114862868117605599L, "org.apache.ibatis.parsing.")); //0x2b3a37467a344cdfL
                add(new BlackInfo.BlockItem(4814658433570175913L, "org.apache.axis2.jaxws.spi.handler.")); //0x42d11a560fc9fba9L
                add(new BlackInfo.BlockItem(6511035576063254270L, "jodd.db.connection.")); //0x5a5bd85c072e5efeL
                add(new BlackInfo.BlockItem(8925522461579647174L, "org.apache.commons.configuration.JNDIConfiguration")); //0x7bddd363ad3998c6L
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
            }};
        }
        return data;
    }
}