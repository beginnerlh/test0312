/*
 * ����һ������� (ransom) �ַ�����һ����־(magazine)�ַ�����
 �жϵ�һ���ַ���ransom�ܲ����ɵڶ����ַ���magazines������ַ����ɡ�������Թ��ɣ����� true �����򷵻� false��
(��Ŀ˵����Ϊ�˲���¶������ּ���Ҫ����־������������Ҫ����ĸ����ɵ����������˼��)
ע�⣺����Լ��������ַ�����ֻ����Сд��ĸ��

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
        //���� ransomNote�ĳ��ȿ϶�ҪС�� magazine�ĳ��ȡ�
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        //
        for(int i = 0; i < ransomNote.length(); i++){
        	//�ж�ʦ������ͬ�ַ�
            int j = judge(chars, ransomNote.charAt(i));
            if(j != -1){
            	//ÿ����һ����ͬ�ַ���magazine�е��ַ���� '0'��
            	//�����Ͳ��¼����ַ���Ӧmagazine��һ���ַ�
                chars[j] = '0';
            }else{
                return false;
            }
        }
        return true;
        
    }
    public int judge(char[] chars,char a){
    	//�ж�magazine������Ƿ�������ַ�
        for(int i = 0; i< chars.length;i++){
            if(a == chars[i]){
                return i;
            }
        }
        return -1;
    }
} 
