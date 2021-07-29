package com.kuang.JTDL;

public class StaticProxy {

    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }

}

//真实对象的行为
interface Marry{
    void HappyMarry();
}

//真实对象---专注于自己的事
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("李世豪，胡伟华结婚啦");
    }
}
//代理角色，帮助代理对象完成行为，添加一些代理对象没有的操作
class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {

        before();
        this.target.HappyMarry();
        after();
    }

    private void before(){
        System.out.println("道路坎坷");
    }

    private void after(){
        System.out.println("幸福美满");
    }
}

