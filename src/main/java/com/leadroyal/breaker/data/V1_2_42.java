package com.leadroyal.breaker.data;

import com.leadroyal.breaker.BlackInfo;

import java.util.HashMap;
import java.util.LinkedList;

public class V1_2_42 {
    private static BlackInfo data;

    public static BlackInfo getData() {
        if (data == null) {
            data = new BlackInfo();
            data.version = 1242;
            data.known = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-8720046426850100497L, "org.apache.commons.collections4.comparators"));
                add(new BlackInfo.BlockItem(-8109300701639721088L, "org.python.core"));
                add(new BlackInfo.BlockItem(-7966123100503199569L, "org.apache.tomcat"));
                add(new BlackInfo.BlockItem(-7766605818834748097L, "org.apache.xalan"));
                add(new BlackInfo.BlockItem(-6835437086156813536L, "javax.xml"));
                add(new BlackInfo.BlockItem(-4837536971810737970L, "org.springframework."));
                add(new BlackInfo.BlockItem(-4082057040235125754L, "org.apache.commons.beanutils"));
                add(new BlackInfo.BlockItem(-2364987994247679115L, "org.apache.commons.collections.Transformer"));
                add(new BlackInfo.BlockItem(-1872417015366588117L, "org.codehaus.groovy.runtime"));
                add(new BlackInfo.BlockItem(-254670111376247151L, "java.lang.Thread"));
                add(new BlackInfo.BlockItem(-190281065685395680L, "javax.net."));
                add(new BlackInfo.BlockItem(313864100207897507L, "com.mchange"));
                add(new BlackInfo.BlockItem(1203232727967308606L, "org.apache.wicket.util"));
                add(new BlackInfo.BlockItem(1502845958873959152L, "java.util.jar."));
                add(new BlackInfo.BlockItem(3547627781654598988L, "org.mozilla.javascript"));
                add(new BlackInfo.BlockItem(3730752432285826863L, "java.rmi"));
                add(new BlackInfo.BlockItem(3794316665763266033L, "java.util.prefs."));
                add(new BlackInfo.BlockItem(4147696707147271408L, "com.sun."));
                add(new BlackInfo.BlockItem(5347909877633654828L, "java.util.logging."));
                add(new BlackInfo.BlockItem(5450448828334921485L, "org.apache.bcel"));
                add(new BlackInfo.BlockItem(5751393439502795295L, "java.net.Socket"));
                add(new BlackInfo.BlockItem(5944107969236155580L, "org.apache.commons.fileupload"));
                add(new BlackInfo.BlockItem(6742705432718011780L, "org.jboss"));
                add(new BlackInfo.BlockItem(7179336928365889465L, "org.hibernate"));
                add(new BlackInfo.BlockItem(7442624256860549330L, "org.apache.commons.collections.functors"));
                add(new BlackInfo.BlockItem(8838294710098435315L, "org.apache.myfaces.context.servlet"));
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(33238344207745342L, ""));
            }};
        }
        return data;
    }
}