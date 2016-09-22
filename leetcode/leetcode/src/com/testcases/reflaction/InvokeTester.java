/**
 * InvokeTester.java 
 * 版权所有(C) 2010 cuiran2001@163.com 
 * 创建:崔冉  2010-2-9 下午02:07:13 
 */
package com.testcases.reflaction;

import java.lang.reflect.Method;

/**
 * @author 崔冉
 *
 */
public class InvokeTester {
    public int add(int param1, int param2) {
        return param1 + param2;
    }

    public String echo(String mesg) {

        return "echo" + mesg;
    }

    public static void main(String[] args) throws Exception {
        Class classType = InvokeTester.class;
        Object invokertester = classType.newInstance();

        Method addMethod = classType.getMethod("add", new Class[] { int.class,
                int.class });
        //Method类的invoke(Object obj,Object args[])方法接收的参数必须为对象，
        //如果参数为基本类型数据，必须转换为相应的包装类型的对象。invoke()方法的返回值总是对象，
        //如果实际被调用的方法的返回类型是基本类型数据，那么invoke()方法会把它转换为相应的包装类型的对象，
        //再将其返回

        Object result = addMethod.invoke(invokertester, new Object[] {
                new Integer(100), new Integer(200) });
        //在jdk5.0中有了装箱 拆箱机制 new Integer(100)可以用100来代替，系统会自动在int 和integer之间转换
        System.out.println(result);

        Method echoMethod = classType.getMethod("echo",
                new Class[] { String.class });
        result = echoMethod.invoke(invokertester, new Object[] { "hello"});
        System.out.println(result);
    }



}