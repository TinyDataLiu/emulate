package com.my99;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            /*Robot robot = new Robot();
            robot.getAutoDelay();
            robot.keyPress(KeyEvent.VK_Q);*/
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("D:\\Program Files\\Git\\git-bash.exe");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Hello World!");
    }
}
