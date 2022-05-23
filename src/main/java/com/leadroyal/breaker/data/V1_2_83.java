package com.leadroyal.breaker.data;

import com.leadroyal.breaker.BlackInfo;

import java.util.LinkedList;

public class V1_2_83 {
    private static BlackInfo data;

    public static BlackInfo getData() {
        if (data == null) {
            data = new BlackInfo();
            data.version = 1283;
            data.known = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-8754006975464705441L, "org.apache.commons.io.")); //0x868385095a22725fL
                add(new BlackInfo.BlockItem(-6088208984980396913L, "kotlin.reflect.")); //0xab82562f53e6e48fL
                add(new BlackInfo.BlockItem(-1363634950764737555L, "org.aspectj.")); //0xed13653cb45c4bedL
                add(new BlackInfo.BlockItem(-803541446955902575L, "org.dom4j.")); //0xf4d93f4fb3e3d991L
                add(new BlackInfo.BlockItem(860052378298585747L, "org.apache.commons.cli.")); //0xbef8514d0b79293L
                add(new BlackInfo.BlockItem(1268707909007641340L, "com.google.common.eventbus.")); //0x119b5b1f10210afcL
                add(new BlackInfo.BlockItem(3058452313624178956L, "org.thymeleaf.")); //0x2a71ce2cc40a710cL
                add(new BlackInfo.BlockItem(3740226159580918099L, "org.junit.")); //0x33e7f3e02571b153L
                add(new BlackInfo.BlockItem(3977090344859527316L, "org.mockito.asm.")); //0x37317698dcfce894L
                add(new BlackInfo.BlockItem(4319304524795015394L, "com.google.common.io.")); //0x3bf14094a524f0e2L
                add(new BlackInfo.BlockItem(5120543992130540564L, "org.mockito.runners.")); //0x470fd3a18bb39414L
                add(new BlackInfo.BlockItem(5916409771425455946L, "org.mockito.cglib.")); //0x521b4f573376df4aL
                add(new BlackInfo.BlockItem(6090377589998869205L, "com.google.common.reflect.")); //0x54855e265fe1dad5L
                add(new BlackInfo.BlockItem(7164889056054194741L, "org.mockito.stubbing.")); //0x636ecca2a131b235L
                add(new BlackInfo.BlockItem(8711531061028787095L, "org.apache.commons.codec.")); //0x78e5935826671397L
                add(new BlackInfo.BlockItem(8735538376409180149L, "ognl.")); //0x793addded7a967f5L
                add(new BlackInfo.BlockItem(8861402923078831179L, "com.google.common.util.concurrent.")); //0x7afa070241b8cc4bL
                add(new BlackInfo.BlockItem(9144212112462101475L, "com.google.common.net.")); //0x7ee6c477da20bbe3L
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(4215053018660518963L, "")); //0x3a7ee0635eb2bc33L
                add(new BlackInfo.BlockItem(-8614556368991373401L, "")); //0x8872f29fd0b0b7a7L
                add(new BlackInfo.BlockItem(-8382625455832334425L, "")); //0x8baaee8f9bf77fa7L
                add(new BlackInfo.BlockItem(-4733542790109620528L, "")); //0xbe4f13e96a6796d0L
                add(new BlackInfo.BlockItem(-3750763034362895579L, "")); //0xcbf29ce484222325L
                add(new BlackInfo.BlockItem(-1800035667138631116L, "")); //0xe704fd19052b2a34L
            }};
        }
        return data;
    }
}
