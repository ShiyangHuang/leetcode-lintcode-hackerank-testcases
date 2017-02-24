package com.testcases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by shiyanghuang on 17/1/23.
 */
public class classLoaderTest {
    public classLoaderTest() {
        URL[] urls = new URL[] {};
        MyClassLoader classLoader = new MyClassLoader(urls, null);

        try {
            classLoader.addJar(new File("/Users/shiyanghuang/Dropbox/leetcode/java/classLoaderJar.jar").toURI().toURL());
            Class<?> clazz = classLoader.loadClass("classLoaderJar");

            Object classloader = clazz.newInstance();
            Class[] parameterTypes = {int.class, int.class};
            Method method = clazz.getDeclaredMethod("add", parameterTypes);
            method.setAccessible(true);
            System.out.print(method.invoke(classloader, 1, 2));
            classLoader.close();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new classLoaderTest();
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
