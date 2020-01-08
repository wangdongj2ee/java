package com.wd.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] arg0){
//        String ss = "dvdf";
//        String ss = "abcabcbb";
        String ss = "pwwkew";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstringV2(ss));
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
