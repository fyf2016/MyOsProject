package util;

import java.util.Random;

/**
 * @auther fyf
 * @date 2018/12/17 - 8:16
 */
public class RandomChar {
    public static char getRandomChar() {
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        Random random = new Random();
        return str.charAt(random.nextInt(str.length()));
    }
}
