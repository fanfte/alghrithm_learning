package com.fanfte.algorithm.recursive;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        doRestore(res, "", s, 0);
        return res;
    }

    private static void doRestore(List<String> result, String path, String s, int k) {
        if(s.isEmpty() || k ==4) {
            if(s.isEmpty() && k ==4) {
                result.add(path.substring(1));
            }
            return ;
        }

        for(int i = 1;i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length();i++) {
            String part = s.substring(0, i);
            if(Integer.valueOf(part) <= 255) {
                doRestore(result, path + "." + part, s.substring(i), k + 1);
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = restoreIpAddresses("25525511135");
        System.out.println(strings);
    }
}
