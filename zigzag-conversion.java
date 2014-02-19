/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".


每行每两个之间的间隔为2*row-2，除了首尾两行还需要添加一个额外的元素
*/

public class Solution {
    public String convert(String s, int nRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s.length()<=2 || nRows==1)
            return s;
        String result="";
        for (int i=0;i<nRows;i++){
            for(int j=i;j<s.length();j+=2*nRows-2){
                result+=s.charAt(j);
                if(i>0 && i<nRows-1 && (j+2*nRows-2-2*i)<s.length()){
                    result+=s.charAt(j+2*nRows-2-2*i);
                }
            }
        }
        return result;
    }
}