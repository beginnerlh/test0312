/*
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
注意：你可以假设两个字符串均只含有小写字母。

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/
package lianxi0312;

public class test0312 {
	public static void main(String[] args) {
		Solution S = new Solution();
		String ransomNote = "aab";
		String magazine = "baba";
		boolean a = S.canConstruct(ransomNote, magazine);
		System.out.println(a);
	}
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = magazine.toCharArray();
        //首先 ransomNote的长度肯定要小于 magazine的长度。
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        //
        for(int i = 0; i < ransomNote.length(); i++){
        	//判断师傅有相同字符
            int j = judge(chars, ransomNote.charAt(i));
            if(j != -1){
            	//每出现一次相同字符将magazine中的字符变成 '0'，
            	//这样就不怕几个字符对应magazine中一个字符
                chars[j] = '0';
            }else{
                return false;
            }
        }
        return true;
        
    }
    public int judge(char[] chars,char a){
    	//判断magazine里面的是否有这个字符
        for(int i = 0; i< chars.length;i++){
            if(a == chars[i]){
                return i;
            }
        }
        return -1;
    }
} 
