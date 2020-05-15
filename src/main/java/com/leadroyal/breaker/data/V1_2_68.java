package com.leadroyal.breaker.data;

import com.leadroyal.breaker.BlackInfo;

import java.util.LinkedList;

public class V1_2_68 {
    private static BlackInfo data;

    public static BlackInfo getData() {
        if (data == null) {
            data = new BlackInfo();
            data.version = 1268;
            data.known = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-3077205613010077203L,"org.apache.shiro.jndi.")); //0xd54b91cc77b239edL
            }};
            data.unknown = new LinkedList<BlackInfo.BlockItem>() {{
                add(new BlackInfo.BlockItem(-2825378362173150292L, "")); //0xd8ca3d595e982bacL
                add(new BlackInfo.BlockItem(9140390920032557669L, "")); //0x7ed9311d28bf1a65L
                add(new BlackInfo.BlockItem(9140416208800006522L, "")); //0x7ed9481d28bf417aL
            }};
        }
        return data;
    }
}
