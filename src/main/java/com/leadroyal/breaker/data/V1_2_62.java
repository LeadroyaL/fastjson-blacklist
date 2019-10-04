package com.leadroyal.breaker.data;

import com.leadroyal.breaker.BlackInfo;

import java.util.LinkedList;

public class V1_2_62 {
    private static BlackInfo data;

    public static BlackInfo getData() {
        if (data == null) {
            data = new BlackInfo();
            data.version = 1262;
            data.known = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-8649961213709896794L, "net.sf.cglib.")); //0x87f52a1b07ea33a6L
                add(new BlackInfo.BlockItem(-3319207949486691020L, "oracle.jdbc.")); //0xd1efcdf4b3316d34L
                add(new BlackInfo.BlockItem(-2095516571388852610L, "net.sf.ehcache.hibernate.")); //0xe2eb3ac7e56c467eL
                add(new BlackInfo.BlockItem(823641066473609950L, "org.apache.commons.logging.")); //0xb6e292fa5955adeL
                add(new BlackInfo.BlockItem(2164696723069287854L, "org.apache.ibatis.datasource.")); //0x1e0a8c3358ff3daeL
                add(new BlackInfo.BlockItem(2653453629929770569L, "org.objectweb.asm.")); //0x24d2f6048fef4e49L
                add(new BlackInfo.BlockItem(2836431254737891113L, "flex.messaging.util.concurrent.")); //0x275d0732b877af29L
                add(new BlackInfo.BlockItem(7123326897294507060L, "org.apache.commons.collections.functors.")); //0x62db241274397c34L
                add(new BlackInfo.BlockItem(8488266005336625107L, "org.apache.commons.configuration")); //0x75cc60f5871d0fd3L
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-9164606388214699518L, "")); //0x80d0c70bcc2fea02L
                add(new BlackInfo.BlockItem(-6316154655839304624L, "")); //0xa85882ce1044c450L
                add(new BlackInfo.BlockItem(-5764804792063216819L, "")); //0xafff4c95b99a334dL
                add(new BlackInfo.BlockItem(-5472097725414717105L, "")); //0xb40f341c746ec94fL
                add(new BlackInfo.BlockItem(-4608341446948126581L, "")); //0xc00be1debaf2808bL
                add(new BlackInfo.BlockItem(-4438775680185074100L, "")); //0xc2664d0958ecfe4cL
                add(new BlackInfo.BlockItem(-2192804397019347313L, "")); //0xe1919804d5bf468fL
                add(new BlackInfo.BlockItem(4750336058574309L, "")); //0x10e067cd55c5e5L
                add(new BlackInfo.BlockItem(218512992947536312L, "")); //0x3085068cb7201b8L
                add(new BlackInfo.BlockItem(1534439610567445754L, "")); //0x154b6cb22d294cfaL
                add(new BlackInfo.BlockItem(1818089308493370394L, "")); //0x193b2697eaaed41aL
                add(new BlackInfo.BlockItem(3089451460101527857L, "")); //0x2adfefbbfe29d931L
                add(new BlackInfo.BlockItem(3256258368248066264L, "")); //0x2d308dbbc851b0d8L
                add(new BlackInfo.BlockItem(3718352661124136681L, "")); //0x339a3e0b6beebee9L
                add(new BlackInfo.BlockItem(4046190361520671643L, "")); //0x3826f4b2380c8b9bL
                add(new BlackInfo.BlockItem(4841947709850912914L, "")); //0x43320dc9d2ae0892L
                add(new BlackInfo.BlockItem(6280357960959217660L, "")); //0x5728504a6d454ffcL
                add(new BlackInfo.BlockItem(6534946468240507089L, "")); //0x5ab0cb3071ab40d1L
                add(new BlackInfo.BlockItem(6734240326434096246L, "")); //0x5d74d3e5b9370476L
            }};
        }
        return data;
    }
}