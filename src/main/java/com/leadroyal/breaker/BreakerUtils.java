package com.leadroyal.breaker;

import com.leadroyal.breaker.data.V1_2_all;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class BreakerUtils {

    // TODO:几个已知的两个case [ L;
    // 确认某个class是否被ban
    public static boolean isBanned(String keyword) {
        boolean flag = false;
        final long BASIC = 0xcbf29ce484222325L;
        final long PRIME = 0x100000001b3L;

        final long h3 = (((((BASIC ^ keyword.charAt(0))
                * PRIME)
                ^ keyword.charAt(1))
                * PRIME)
                ^ keyword.charAt(2))
                * PRIME;

        Long hash = h3;
        for (int i = 3; i < keyword.length(); ++i) {
            hash ^= keyword.charAt(i);
            hash *= PRIME;
            for (BlackInfo info : V1_2_all.blackInfoList) {
                for (BlackInfo.BlockItem item : info.known)
                    if (item.hash.equals(hash)) {
                        System.out.println("Banned! " + keyword);
                        System.out.println("Version: " + info.version);
                        System.out.println("Hash: " + item.hash);
                        flag = true;
                        break;
                    }
                for (BlackInfo.BlockItem item : info.unknown)
                    if (item.hash.equals(hash)) {
                        System.out.println("Version:" + info.version);
                        System.out.println("Hash:" + item.hash);
                        flag = true;
                        break;
                    }
            }
        }
        return flag;
    }

    // 列出每个版本已知未知黑名单
    public static void listDatabase() {
        for (BlackInfo info : V1_2_all.blackInfoList)
            System.out.println(info);
    }

    // 列出某个版本已知未知黑名单
    public static void listDatabase(int version) {
        for (BlackInfo info : V1_2_all.blackInfoList)
            if (info.version == version)
                System.out.println(info);
    }

    // 使用给定列表完善数据库
    public static BlackInfo completeDatabase(String[] keywords) {
        BlackInfo ret = new BlackInfo();
        ret.version = 0;
        ret.known = new LinkedList<>();
        ret.unknown = new LinkedList<>();

        final long BASIC = 0xcbf29ce484222325L;
        final long PRIME = 0x100000001b3L;

        List<Long> unknownList = new LinkedList<>();
        for (BlackInfo info : V1_2_all.blackInfoList)
            for (BlackInfo.BlockItem item : info.unknown)
                unknownList.add(item.hash);
        for (String keyword : keywords) {
            if(keyword.length() < 3)
                continue;
            final long h3 = (((((BASIC ^ keyword.charAt(0))
                    * PRIME)
                    ^ keyword.charAt(1))
                    * PRIME)
                    ^ keyword.charAt(2))
                    * PRIME;

            Long hash = h3;
            for (int i = 3; i < keyword.length(); ++i) {
                hash ^= keyword.charAt(i);
                hash *= PRIME;
                if (unknownList.contains(hash)) {
                    ret.known.add(new BlackInfo.BlockItem(hash, keyword.substring(0, i + 1)));
                    System.out.println(String.format("Find(%d, %s);", hash, keyword.substring(0, i + 1)));
                    unknownList.remove(hash);
                }
            }
        }
        for (Long hash : unknownList) {
            ret.unknown.add(new BlackInfo.BlockItem(hash, ""));
        }
        Collections.sort(ret.known);
        Collections.sort(ret.unknown);
        System.out.println("ret.known");
        for (BlackInfo.BlockItem i : ret.known)
            System.out.println(String.format("add(new BlackInfo.BlockItem(%dL, \"%s\")); //0x%sL", i.hash, i.banned, Long.toHexString(i.hash)));
        System.out.println("ret.unknown");
        for (BlackInfo.BlockItem i : ret.unknown)
            System.out.println(String.format("add(new BlackInfo.BlockItem(%dL, \"%s\")); //0x%sL", i.hash, i.banned, Long.toHexString(i.hash)));
        return ret;
    }

    // 使用给定的jar完善数据库
    public static BlackInfo completeDatabase(File jarFile) throws IOException {
        if (jarFile.isFile())
            return completeDatabase(jarFile, false);
        else
            throw new IOException(jarFile.getParent() + " is not file.");
    }

    public static BlackInfo completeDatabase(File path, boolean recursive) throws IOException {
        if (path.isDirectory()) {
            List<File> fileList = find(path, recursive);
            Set<String> clzSet = new HashSet<>();
            for (File ppath : fileList) {
                System.out.println("check path " + ppath);
                try {
                    readJarFile(clzSet, ppath);
                } catch (IOException e) {
                    System.out.println("check path FAILED " + ppath);
                }
            }
            String[] ss = new String[clzSet.size()];
            clzSet.toArray(ss);
            return completeDatabase(ss);
        } else {
            Set<String> clzSet = new HashSet<>();
            readJarFile(clzSet, path);
            String[] ss = new String[clzSet.size()];
            clzSet.toArray(ss);
            return completeDatabase(ss);
        }
    }

    private static void readJarFile(Set<String> set, File ppath) throws IOException {
        ZipFile zipFile = new ZipFile(ppath);
        Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            String name = entry.getName();
            if (name.endsWith(".class")) {
                set.add(name.replace(".class", "").replace("/", "."));
            }
        }
    }

    private static List<File> find(File path, boolean recursive) {
        List<File> ret = new ArrayList<>();
        for (File inner : path.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().endsWith(".jar");
            }
        })) {
            if (inner.isDirectory() && recursive)
                ret.addAll(find(inner, recursive));
            else if (inner.getName().endsWith(".jar"))
                ret.add(inner);
        }
        return ret;
    }


}
