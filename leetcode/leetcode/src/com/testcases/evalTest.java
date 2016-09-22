package com.testcases;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by shiyanghuang on 15/6/23.
 */
public class evalTest {
    public int calculate(String s) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            Object result = engine.eval(s);
            return (int)Double.parseDouble(result.toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        String s = "0";
        try {
            Object result = engine.eval(s);
            System.out.print(result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.out.print(new evalTest().calculate(s));
    }
}
