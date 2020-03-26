package com.alice.dubbo.provider.dubbo03provider;

public class CharTest {

    public static void main(String[] args) {
//        语句
        String s = "hello alice , alice     alice ";
        char[] chars = s.toCharArray();
        int count = 0;
//        所有的原因字母
        String string = "aeiou";
        char[] array = string.toCharArray();
//        用于将字符串从新组装 ，成子数组
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
            // 空格&
            if (chars[i] == 32 && stringBuilder.length() > 0) {
                System.out.println(stringBuilder.toString());
                char[] subChar = stringBuilder.toString().toCharArray();
                if (isYuanyin(subChar)) {
                    count++;
                }
                // 删除等待下次使用
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
        System.out.println(String.format("元音单词个数%s", count));


        System.out.println(countYuanYin(chars));

    }


    private static boolean isYuanyin(char[] chars) {
        String string = "aeiou";
        char[] array = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (chars[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }


    private static int countYuanYin(char[] chars) {

        String s = String.valueOf(chars);
        String[] split = s.split("");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chars);

        for (int i = 0; i < split.length; i++) {
            stringBuilder.indexOf("");
        }
        return 0;
    }

}
