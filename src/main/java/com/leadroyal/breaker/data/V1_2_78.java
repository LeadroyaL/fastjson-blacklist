package com.leadroyal.breaker.data;

import com.leadroyal.breaker.BlackInfo;

import java.util.LinkedList;

public class V1_2_78 {
    private static BlackInfo data;

    public static BlackInfo getData() {
        if (data == null) {
            data = new BlackInfo();
            data.version = 1278;
            data.known = new LinkedList<BlackInfo.BlockItem>() {{
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-8614556368991373401L, "")); //0x8872f29fd0b0b7a7L
                add(new BlackInfo.BlockItem(-5472097725414717105L, "")); //0xb40f341c746ec94fL
                add(new BlackInfo.BlockItem(-3750763034362895579L, "")); //0xcbf29ce484222325L
                add(new BlackInfo.BlockItem(-1800035667138631116L, "")); //0xe704fd19052b2a34L
                add(new BlackInfo.BlockItem(-831789045734283466L, "")); //0xf474e44518f26736L
                add(new BlackInfo.BlockItem(33238344207745342L, "")); //0x761619136cc13eL
                add(new BlackInfo.BlockItem(3452379460455804429L, "")); //0x2fe950d3ea52ae0dL
                add(new BlackInfo.BlockItem(4215053018660518963L, "")); //0x3a7ee0635eb2bc33L
            }};
        }
        return data;
    }
}
