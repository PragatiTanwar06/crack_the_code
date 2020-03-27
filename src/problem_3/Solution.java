package problem_3;

/**
 * Created by pragati on 26/03/20.
 * URLify: Write a method to replace all spaces in a string with '%20.
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string. (Note: If implementing in Java,
 * please use a character array so that you can perform this operation in place.)
 *
 */
public class Solution {

    public char[] urlify(char[] stringToConvert, int actualLength){

        int spaces = countSpaces(stringToConvert,actualLength);

        if(spaces==0)
            return  stringToConvert;

        for(int i = actualLength-1; i >=0 ; i--){

            int currPos = 2*spaces + i;

            if(stringToConvert[i]==' ') {

                stringToConvert[currPos] = '0';
                stringToConvert[currPos-1] = '2';
                stringToConvert[currPos-2] = '%';
                spaces--;
            }

            else{
                stringToConvert[currPos] = stringToConvert[i];
            }
        }

        return stringToConvert;
    }

    private int countSpaces(char[] stringToConvert, int actualLength) {

        int spaces=0;
        for(int i = 0;i<actualLength;i++){

            if(stringToConvert[i]==' '){
                spaces++;
            }
        }
        return spaces;
    }

    public static void main(String[] args){
        Solution obj = new Solution();

        String str = "hello world test     ";
        System.out.println(obj.urlify(str.toCharArray(),16));
    }
}
