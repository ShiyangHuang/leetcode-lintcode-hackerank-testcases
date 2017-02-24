package com.testcases.reflaction;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by shiyanghuang on 16/10/21.
 */
public class ClassLoaderTest {
    public void classloader() {
        try {
            // 包路径定义
            URL urls = new URL("file:/Users/shiyanghuang/Documents/Dataguise/classloader/test.jar");
            //GetPI.class
            URLClassLoader urlLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
            Class<URLClassLoader> sysclass = URLClassLoader.class;
            Method method = sysclass.getDeclaredMethod("addURL", new Class[]{URL.class});
            method.setAccessible(true);
            method.invoke(urlLoader, urls);
            /*
             * 实例化一个对象 ，这个类(yerasel.GetPI)可以是串行化传来的多个类的一个，运行时才知道需要哪个类
             * 或者从xml 配置文件中获得字符串
             * 例如
             * String className = readfromXMlConfig;//从xml 配置文件中获得字符串
             * class c = Class.forName(className);
             * factory = (ExampleInterface)c.newInstance();
             * 上面代码已经不存在类名称，它的优点是，无论Example类怎么变化，上述代码不变，
             * 甚至可以更换Example的兄弟类Example2 , Example3 , Example4……，只要他们继承ExampleInterface就可以。
             */
            // 输入类名
            String className = "com.test.classloader";
            Class<?> tidyClass = urlLoader.loadClass(className);
            Object obj = tidyClass.newInstance();
            // 被调用函数的参数
            Class[] parameterTypes = {};
            Method method2 = tidyClass.getDeclaredMethod("output", parameterTypes);
            method2.setAccessible(true);
            method2.invoke(obj, null);

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
    public static void main(String[] args) {

        URL[] urls = new URL[] {};
        MyClassLoader classLoader = new MyClassLoader(urls, null);

        try {
            classLoader.addJar(new File("/Users/shiyanghuang/Documents/Dataguise/classloader/hello.jar").toURI().toURL());
            Class<?> clazz = classLoader.loadClass("com.test.classloader");
            // Method method = clazz.getDeclaredMethod("output");
            // method.invoke(null);


            Object classloader = clazz.newInstance();
            Class[] parameterTypes = {String.class};
            Method method2 = clazz.getDeclaredMethod("maskString", parameterTypes);
            method2.setAccessible(true);
            System.out.print(method2.invoke(classloader, "HELLO"));
            classLoader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class MyClassLoader extends URLClassLoader {

        public MyClassLoader(URL[] urls) {
            super(urls);
        }

        public MyClassLoader(URL[] urls, ClassLoader parent) {
            super(urls, parent);
        }

        public void addJar(URL url) {
            this.addURL(url);
        }

    }
}
