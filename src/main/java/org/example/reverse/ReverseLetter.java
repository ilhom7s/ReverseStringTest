package org.example.reverse;

public class ReverseLetter {
    public String reverse(String s){
        if (s==null){
           return "";
        }

        int left = 0;
        int right = s.length()-1;
        char[] chars = s.toCharArray();
        while(left<right){
            if(!Character.isLetter(chars[left])){
                left++;
            }
            else if(!Character.isLetter(chars[right])){
                right--;
            }
            else{
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
