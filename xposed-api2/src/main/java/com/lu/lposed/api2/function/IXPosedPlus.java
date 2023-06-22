package com.lu.lposed.api2.function;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 抽象所有的xposed函数聚合到一起，主要是XposedBridge 和 XposedHelpers;,
 */
public interface IXPosedPlus extends IXPosed{
    Method[] findMethodsByExactPredicate(Class<?> clazz, Predicate<Method> predicate);

    Method[] findMethodsByExactPredicate(String className, ClassLoader classLoader, Predicate<Method> predicate);

    Field[] findFieldsByExactPredicate(Class<?> clazz, Predicate<Field> predicate);

    Field[] findFieldsByExactPredicate(String className, ClassLoader classLoader, Predicate<Field> predicate);

    <T> T callMethodElse(Object obj, String methodName, T fallback, Object... args);

    <T> T callMethodElse(Object obj, String methodName, T fallback, Class<?>[] parameterTypes, Object... args);

    <T> T callStaticMethodElse(Class<?> clazz, String methodName, T fallback, Object... args);

    <T> T callStaticMethodElse(Class<?> clazz, String methodName, T fallback, Class<?>[] parameterTypes, Object... args);
}
