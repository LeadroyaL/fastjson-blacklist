package com.leadroyal.breaker.data;

import com.leadroyal.breaker.BlackInfo;

import java.util.LinkedList;

public class V1_2_71 {
    private static BlackInfo data;

    public static BlackInfo getData() {
        if (data == null) {
            data = new BlackInfo();
            data.version = 1271;
            data.known = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-4537258998789938600L, "java.io.FileReader")); //0xc1086afae32e6258L
                add(new BlackInfo.BlockItem(-4150995715611818742L, "java.io.ObjectInputStream")); //0xc664b363baca050aL
                add(new BlackInfo.BlockItem(-2995060141064716555L, "java.io.FileInputStream")); //0xd66f68ab92e7fef5L
                add(new BlackInfo.BlockItem(-965955008570215305L, "java.io.ObjectOutputStream")); //0xf2983d099d29b477L
                add(new BlackInfo.BlockItem(-219577392946377768L, "java.io.DataOutputStream")); //0xfcf3e78644b98bd8L
                add(new BlackInfo.BlockItem(2622551729063269307L, "java.io.PrintWriter")); //0x24652ce717e713bbL
                add(new BlackInfo.BlockItem(2930861374593775110L, "java.io.Buffered")); //0x28ac82e44e933606L
                add(new BlackInfo.BlockItem(4000049462512838776L, "java.io.InputStreamReader")); //0x378307cb0111e878L
                add(new BlackInfo.BlockItem(4193204392725694463L, "java.io.OutputStreamWriter")); //0x3a31412dbb05c7ffL
                add(new BlackInfo.BlockItem(5545425291794704408L, "java.io.FileWriter")); //0x4cf54eec05e3e818L
                add(new BlackInfo.BlockItem(6584624952928234050L, "java.io.FileOutputStream")); //0x5b6149820275ea42L
                add(new BlackInfo.BlockItem(7045245923763966215L, "java.io.DataInputStream")); //0x61c5bdd721385107L
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(3452379460455804429L, "")); //0x2fe950d3ea52ae0dL
            }};
        }
        return data;
    }
}
