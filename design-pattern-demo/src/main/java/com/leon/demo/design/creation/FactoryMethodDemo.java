package com.leon.demo.design.creation;

/**
 * @Author : leonwang
 * @Descpriction 工厂方法模式  子类决定实例化哪个类
 * @Date:created 2019/6/27
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        DBDriverFactory dbDriverFactory = new MongodbDriverFactory();
        dbDriverFactory.createDBDriver().drive();

        DBDriverFactory dbDriverFactory2 = new MysqlDriverFactory();
        dbDriverFactory2.createDBDriver().drive();
    }
}


interface DBDriver {
    void drive();
}

class MysqlDriver implements DBDriver {

    public void drive() {
        System.out.println("mysql driver start");
    }
}

class MongodbDriver implements DBDriver {

    public void drive() {
        System.out.println("mongodb driver start");
    }
}


interface DBDriverFactory {
    DBDriver createDBDriver();
}

class MysqlDriverFactory implements DBDriverFactory{

    public DBDriver createDBDriver() {
        return new MysqlDriver();
    }
}

class MongodbDriverFactory implements DBDriverFactory {

    public DBDriver createDBDriver() {
        return new MongodbDriver();
    }
}
