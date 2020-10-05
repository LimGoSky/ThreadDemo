package com.example.lambda;

public class TestLambda1 {
    //2.静态内部类
    static class Love implements ILove {

        public void ILove(int a) {
            System.out.println("i like lambda" + a);
        }
    }

    public static void main(String[] args) {
        Love love = new Love();
        love.ILove(1);
        Love love1 = new Love();
        love1.ILove(2);
        class Love implements ILove {
            //3.局部内部类
            public void ILove(int a) {
                System.out.println("i like lambda" + a);
            }
        }
        Love love2 = new Love();
        love2.ILove(3);
        //4.匿名内部类
        ILove iLove = new ILove() {
            @Override
            public void ILove(int a) {
                System.out.println("i like lambda" + a);
            }
        };
        iLove.ILove(4);
        //5.lambda表达式
        ILove iLove1 = (int a) -> {
            System.out.println("i like lambda" + a);
        };
        iLove1.ILove(5);

        //6
        iLove1 = a-> System.out.println("i like lambda" + a);
        iLove1.ILove(6);
    }
}

//定义一个接口,只有一个方法，函数式接口
interface ILove {
    void ILove(int a);
}

//1.普通实现
class Love implements ILove {
    @Override
    public void ILove(int a) {
        System.out.println("i like lambda" + a);
    }
}

class TestLambda2 {
    public static void main(String[] args) {
        YouLove youLove = (a, b) -> {
            System.out.println("一句话你说:" + a + b);
        };
        youLove.youLove(10, 20);
    }
}

interface YouLove {
    void youLove(int a, int b);
}
