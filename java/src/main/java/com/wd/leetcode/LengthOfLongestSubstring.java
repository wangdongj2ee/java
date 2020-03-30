package com.wd.leetcode;

import java.util.*;

public class LengthOfLongestSubstring {

    public static void main(String[] arg0){
//        String ss = "dvdf"; 测试1
        String ss = "abcabcbb";
//        String ss = "pwwkewprp";测试2
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
//        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstringV3(ss));测试3
        System.out.println(System.currentTimeMillis());
        //测试4
    }


    public int lengthOfLongestSubstringV3(String s) {
        int n = s.length(), ans = 0,j=0,i=0;
        Map<Character, Integer> map = new LinkedHashMap<>(); // current index of character
        for (; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
//            map.put(s.charAt(j), j);
            System.out.println("j:"+j+";i:"+i+";ans:"+ans+";map:"+map);
        }

        return ans;
    }

    public int lengthOfLongestSubstringV2(String s) {
        int n = s.length(),i=0,j=0,ans=0;
        HashSet<Character> set = new HashSet<>();
        while (i<n && j<n) {
            char ch = s.charAt(j);
            if (set.contains(ch)) {
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(ch);
                j++;
            }
            ans = Math.max(ans, j - i);
            System.out.println("set:"+set+";i:"+i+";j:"+j+";ans:"+ans);
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans =0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(allUnique(s,i,j)){
                    ans = Math.max(ans,(j-i));
                }
            }
        }
        return ans;
    }

    public boolean allUnique(String s,int start,int end){
        Set<Character> set = new HashSet<>();
        for(int i=start;i<end;i++){
            char ss = s.charAt(i);
            if(set.contains(ss)){
                return false;
            }else{
                set.add(ss);
            }
        }
        return true;
    }


}
