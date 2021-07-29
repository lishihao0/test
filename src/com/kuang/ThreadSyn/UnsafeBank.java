package com.kuang.ThreadSyn;

//两个人一块取钱
//不安全的取钱
public class UnsafeBank {

    public static void main(String[] args) {
        Account account = new Account(1000,"结婚基金");

        Drawing you = new Drawing(account,50,"李世豪");
        Drawing girlFriend = new Drawing(account,100,"胡伟华");

        you.start();
        girlFriend.start();
    }


}


//账户
class Account{
    int money; //余额
    String name; //卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行，模拟取款
class Drawing extends Thread{
    Account account; //账户
    int drawingMoney; //取多少钱
    int nowMoney;   //手里多少钱

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    //取钱
    @Override
    public void run() {
        synchronized (account){
            //判断卡里有没有钱
            if (account.money - drawingMoney < 0){
                System.out.println(Thread.currentThread().getName()+"余额不足");
                return;
            }

            //可以放大问题的发生性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //卡内余额
            account.money = account.money - drawingMoney;
            //你手里的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name+"余额为："+account.money);
            System.out.println(this.getName()+"手里余额为:"+nowMoney);
        }

    }
}