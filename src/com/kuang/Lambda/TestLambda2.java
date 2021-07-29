package com.kuang.Lambda;

public class TestLambda2 {
    public static void main(String[] args) {
        ILove love = null;
        love = (int a,int b)->{
            System.out.println("I love you"+a+b);
        };
        //简化1.去掉参数类型，要去掉都得去掉
        love = (a,b)->{
            System.out.println("I love you 2");
        };
        //简化2.去掉括号
        //只有一个参数才可以去掉括号。多个参数必须加括号
//        love = a->{
//            System.out.println("I love you 2");
//        };
        //简化3.去掉花括号只有一行代码时可以去掉花括号

        love = (a,b)-> System.out.println("I love you 3");

        love.Love(13,14);
    }


}

interface ILove{
    void Love(int a,int b);
}
