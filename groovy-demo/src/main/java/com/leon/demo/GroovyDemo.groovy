package com.leon.demo

/**
 *
 * @Author : leonwang
 * @Descpriction 入门https://www.w3cschool.cn/groovy/groovy_operators.html
 * @Date:created 2019/10/8
 *
 */
class GroovyDemo {
    static void main(String[] args) {
        println('hello world~')
        test011()
        println("-------------------------------")

        test021()
        println("-------------------------------")

        //调用java类
        JavaBean.test();

        println("-------------------------------")
        readFile();
    }

    /**
     * 方法定义:
     * Groovy中的方法是使用返回类型或使用def关键字定义的。
     * 方法可以接收任意数量的参数。
     * 定义参数时，不必显式定义类型。
     * 可以添加修饰符，如public，private和protected。默认情况下，如果未提供可见性修饰符，则该方法为public。
     * 定义的参数可以设置默认值
     */
    static void test011() {
        println("返回值为空")
        println("调用返回值为def的方法,返回值：" + test012())
        test013()
        println(test014(1))
//      println(test014())  //出错，没有默认值的参数必须传
    }

    static def test012() {
        return "hello";
    }

    static def test013() {
        println("定义def方法，不返回任何值")
    }

    static def test014(int a, int b = 2, int c = 3) {
        return a + b + c;
    }

    /**
     * 变量定义：
     * 1. 可以不指定变量类型，自动推断，变量名明明商基本与java相同。
     * 2. 可以指定范围
     * 3. 程序行之间可以不用";"隔开
     */
    static void test021() {
        def intVar = 10
        println("intVar=" + intVar)

        def floatWar = 10.01f
        println("floatWar=" + floatWar)

        def stringWar = 'hello'
        println("stringWar=" + stringWar)


        def intRange = 3..5;
        println(intRange)
        println(intRange + "," + intRange[1])

        def charRange = 'a'..'z'
        println(charRange)
        println(charRange + "," + charRange[1])

        println(new Date())
    }


    static def readFile() {
        def content = "";
        File file = new File("/Users/leonwang/Documents/workspace/github/demo/groovy-demo/src/main/java/com/leon/demo/helloworld.txt")
        file.eachLine() {
            content += it;
        }

        println("直接打印文件内容：" + file.text)
        println("读取文件：" + content)
    }

}
