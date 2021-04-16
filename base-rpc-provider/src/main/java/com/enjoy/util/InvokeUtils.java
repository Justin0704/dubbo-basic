package com.enjoy.util;

import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 反射工具类
 */
public class InvokeUtils {
    /**
     * java反射
     * @param target 目标对象
     * @param methodName 目标方法
     * @param argTypes 方法参数类型
     * @param args 实参
     * @return
     */
    public static Object call(Object target,String methodName, Class[] argTypes,Object[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = target.getClass().getMethod(methodName,argTypes);
        return method.invoke(target,args);
    }

    public static Object call(Map<String,String> paraMap, ApplicationContext ctx){
        String target = paraMap.get("target");
        String methodName = paraMap.get("methodName");
        String arg = paraMap.get("arg");

        try {
            return call(ctx.getBean(target),methodName, new Class[]{String.class},new Object[]{arg});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
