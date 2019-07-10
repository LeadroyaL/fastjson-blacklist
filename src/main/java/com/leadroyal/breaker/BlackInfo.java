package com.leadroyal.breaker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackInfo {
    public int version;
    public List<BlockItem> known;
    public List<BlockItem> unknown;

    public static class BlockItem implements Comparable<BlockItem> {
        public Long hash;
        public String banned;

        public BlockItem(Long hash, String banned) {
            this.hash = hash;
            this.banned = banned;
        }

        @Override
        public int compareTo(BlockItem o) {
            if (this.hash > o.hash)
                return 1;
            else if (this.hash.equals(o.hash))
                return 0;
            else
                return -1;
        }

        @Override
        public String toString() {
            return "(" + hash + ",\"" + banned + "\")";
        }
    }

    @Override
    public String toString() {
        return "Version:" + version + "\n" + "Known:" + known + "\n" + "Unknown:" + unknown;
    }
}
