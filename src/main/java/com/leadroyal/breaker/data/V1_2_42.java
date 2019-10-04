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
                add(new BlackInfo.BlockItem(-8720046426850100497L, "org.apache.commons.collections4.comparators")); //0x86fc2bf9beaf7aefL
                add(new BlackInfo.BlockItem(-8109300701639721088L, "org.python.core")); //0x8f75f9fa0df03f80L
                add(new BlackInfo.BlockItem(-7966123100503199569L, "org.apache.tomcat")); //0x9172a53f157930afL
                add(new BlackInfo.BlockItem(-7766605818834748097L, "org.apache.xalan")); //0x9437792831df7d3fL
                add(new BlackInfo.BlockItem(-6835437086156813536L, "javax.xml")); //0xa123a62f93178b20L
                add(new BlackInfo.BlockItem(-4837536971810737970L, "org.springframework.")); //0xbcdd9dc12766f0ceL
                add(new BlackInfo.BlockItem(-4082057040235125754L, "org.apache.commons.beanutils")); //0xc7599ebfe3e72406L
                add(new BlackInfo.BlockItem(-2364987994247679115L, "org.apache.commons.collections.Transformer")); //0xdf2ddff310cdb375L
                add(new BlackInfo.BlockItem(-1872417015366588117L, "org.codehaus.groovy.runtime")); //0xe603d6a51fad692bL
                add(new BlackInfo.BlockItem(-254670111376247151L, "java.lang.Thread")); //0xfc773ae20c827691L
                add(new BlackInfo.BlockItem(-190281065685395680L, "javax.net.")); //0xfd5bfc610056d720L
                add(new BlackInfo.BlockItem(313864100207897507L, "com.mchange")); //0x45b11bc78a3aba3L
                add(new BlackInfo.BlockItem(1203232727967308606L, "org.apache.wicket.util")); //0x10b2bdca849d9b3eL
                add(new BlackInfo.BlockItem(1502845958873959152L, "java.util.jar.")); //0x14db2e6fead04af0L
                add(new BlackInfo.BlockItem(3547627781654598988L, "org.mozilla.javascript")); //0x313bb4abd8d4554cL
                add(new BlackInfo.BlockItem(3730752432285826863L, "java.rmi")); //0x33c64b921f523f2fL
                add(new BlackInfo.BlockItem(3794316665763266033L, "java.util.prefs.")); //0x34a81ee78429fdf1L
                add(new BlackInfo.BlockItem(4147696707147271408L, "com.sun.")); //0x398f942e01920cf0L
                add(new BlackInfo.BlockItem(5347909877633654828L, "java.util.logging.")); //0x4a3797b30328202cL
                add(new BlackInfo.BlockItem(5450448828334921485L, "org.apache.bcel")); //0x4ba3e254e758d70dL
                add(new BlackInfo.BlockItem(5751393439502795295L, "java.net.Socket")); //0x4fd10ddc6d13821fL
                add(new BlackInfo.BlockItem(5944107969236155580L, "org.apache.commons.fileupload")); //0x527db6b46ce3bcbcL
                add(new BlackInfo.BlockItem(6742705432718011780L, "org.jboss")); //0x5d92e6ddde40ed84L
                add(new BlackInfo.BlockItem(7179336928365889465L, "org.hibernate")); //0x63a220e60a17c7b9L
                add(new BlackInfo.BlockItem(7442624256860549330L, "org.apache.commons.collections.functors")); //0x6749835432e0f0d2L
                add(new BlackInfo.BlockItem(8838294710098435315L, "org.apache.myfaces.context.servlet")); //0x7aa7ee3627a19cf3L
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(33238344207745342L, "")); //0x761619136cc13eL
            }};
        }
        return data;
    }
}