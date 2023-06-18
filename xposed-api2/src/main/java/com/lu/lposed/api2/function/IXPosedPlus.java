package com.lu.lposed.api2.function;

import android.content.res.Resources;

import com.lu.lposed.api2.function.Predicate;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Set;

import de.robv.android.xposed.XC_MethodHook;

/**
 * 抽象所有的xposed函数聚合到一起，主要是XposedBridge 和 XposedHelpers;,
 */
public interface IXPosedPlus extends IXPosed{
    Method[] findMethodsByExactPredicate(Class<?> clazz, Predicate<Method> predicate);

    Method[] findMethodsByExactPredicate(String className, ClassLoader classLoader, Predicate<Method> predicate);

    Field[] findFieldsByExactPredicate(Class<?> clazz, Predicate<Field> predicate);

    Field[] findFieldsByExactPredicate(String className, ClassLoader classLoader, Predicate<Field> predicate);
}
