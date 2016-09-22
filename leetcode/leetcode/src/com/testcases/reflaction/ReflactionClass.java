package com.testcases.reflaction;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by shiyanghuang on 16/3/2.
 */
public class ReflactionClass {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Class classtype = ToBeReflact.class;
        Object toBeReflact = classtype.newInstance();

        Method setNameMethod = classtype.getDeclaredMethod("setName", new Class[] {String.class});
        setNameMethod.setAccessible(true);
        Object invoke1 = setNameMethod.invoke(toBeReflact, "qwer");

        Method getNameMethod = classtype.getDeclaredMethod("getName", null);
        getNameMethod.setAccessible(true);
        Object invoke2 = getNameMethod.invoke(toBeReflact, null);
        System.out.print(invoke2);

        Field field = classtype.getDeclaredField("name"); //获取域
        Object invoke3 = field.getInt("name");
        System.out.print(invoke3);
    }
}
