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
                add(new BlackInfo.BlockItem(-4401390804044377335L, "flex.messaging.util.concurrent.AsynchBeansWorkManagerExecutor"));
                add(new BlackInfo.BlockItem(-1650485814983027158L, "org.apache.openjpa.ee."));
                add(new BlackInfo.BlockItem(-1251419154176620831L, "oracle.jdbc.rowset.OracleJDBCRowSet"));
                add(new BlackInfo.BlockItem(-9822483067882491L, "com.mysql.cj.jdbc.admin."));
                add(new BlackInfo.BlockItem(99147092142056280L, "oracle.jdbc.connector.OracleManagedConnectionFactory"));
                add(new BlackInfo.BlockItem(3114862868117605599L, "org.apache.ibatis.parsing."));
                add(new BlackInfo.BlockItem(4814658433570175913L, "org.apache.axis2.jaxws.spi.handler."));
                add(new BlackInfo.BlockItem(6511035576063254270L, "jodd.db.connection."));
                add(new BlackInfo.BlockItem(8925522461579647174L, "org.apache.commons.configuration.JNDIConfiguration"));
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
            }};
        }
        return data;
    }
}