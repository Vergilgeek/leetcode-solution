package leetcode.solution;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 */
public class Zconvert {

    public static void main(String[] args) {
        String s = "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.";
        int numRows = 2;
        String a = solution(s, numRows);
        System.out.println(a);
        String b = "Aaidoeswr,haenme,rtesqecouishtabrateaeaietedrcinwtgnrlloacsoajsmnsoucutoadodiiesplnrmiaodprs,ubroohreunefnttacneedhsmwynihrieto,iheeaalwnefrdutettpntainnwrdvdr.";
        System.out.println(a.equals(b));
    }

    /**
     *
     */
    public static String solution(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[][] m = new char[numRows][s.length()];
        int status = 0;
        int x = -1, y = 0;
        for (char c : s.toCharArray()) {
            if (status == 0) {
                x++;
                m[x][y] = c;
                if (x + 1 >= numRows) {
                    status = 1;
                }
            } else {
                x--;
                y++;
                m[x][y] = c;
                if (x <= 0) {
                    status = 0;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (char[] chars : m) {
            for (char c : chars) {
                if (c != '\u0000')
                    result.append(c);
                }
            }
        return result.toString();
    }
}
