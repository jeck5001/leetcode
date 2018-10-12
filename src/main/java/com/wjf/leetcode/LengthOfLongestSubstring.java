package com.wjf.leetcode;

/**
 * description ：给定一个字符串，找出不含有重复字符的最长子串的长度。
 * @author : wjf
 * Date ：2018/10/11 15:36
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 判断字符串是否为空或者为一个字符，然后转为字符数组，遍历数组，若结果字符串中没有该字符，则追加到该字符串中，
     * 判断结果字符串长度是否大于返回结果，若大于，则令返回结果等于结果字符串的长度
     * 若结果字符串有该字符，则找到该字符的index：charIndex，然后删除结果字符串中index为0到charIndex-1位置的字符
     *
     * @param s 给定字符串
     * @return int
     */
    private static int lengthOfLongestSubstring(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int result = 1;
        char[] strArray = s.toCharArray();
        StringBuilder resultStr = new StringBuilder();
        for(char str : strArray){
            int charIndex;
            if((charIndex = resultStr.toString().indexOf(str)) == -1){
                resultStr.append(str);
                if(resultStr.length() > result){
                    result = resultStr.length();
                }
            } else {
                resultStr.delete(0, charIndex + 1);
                resultStr.append(str);
            }
        }
        return result;
    }
}
