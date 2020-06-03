package arithmetic;
/** 字符替换，将字符中出现的空格替换成 %20
 *
 *主要是避免出现重复移动的原则，如果将原来的字符串直接copy到新的char[]后，直接替换移动 字符可能会被移动多次
 * Created by 10718 on 2019/10/18.
 */
public class StringReplace {

    private static String replaceStr(String oriStr){
        char space = ' ';
        if(oriStr == null){
            return null;
        }else{
            int space_num = 0;
            for(int i = 0;i<oriStr.length();i++){
                Character character = oriStr.charAt(i);
                if(character.equals(space)){
                    space_num ++;
                }
            }

            if(space_num == 0){
                return oriStr;
            }else{
                int new_char_length = oriStr.length()+space_num*2;
                char[] newChar = new char[new_char_length];
                for(int j = oriStr.length()-1;j>=0;j--){
                    Character character = oriStr.charAt(j);
                    if(character.equals(space)){
                        newChar[new_char_length-1] = '0';
                        newChar[new_char_length-2] = '2';
                        newChar[new_char_length-3] = '%';
                        new_char_length = new_char_length-3;
                    }else{

                        newChar[new_char_length-1] = character;
                        new_char_length --;
                    }
                }
            }
        }
        return null;
    }


    public static void main(String[] args) {
        String oriStr = "we are happy";
        replaceStr(oriStr);
    }
}
