package com.lu.lposed.api2;

import com.lu.lposed.api2.function.Predicate;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;


public class XPosedPlus extends AbsXPosedPlus {
    // 由于XposedHelpersSuper中实际使用XPosedPlus这个类本身实现，所以这个类中不能调用
    // XposedHelpersSuper、XposedHelpers2的同名函数，否则相当于自己调用自己，造成递归死循环
    //
    //
    // --------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------
    // 增强方法，对XC_MethodHook回调进行代理，捕捉其中的异常
    // --------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------
    @Override
    public XC_MethodHook.Unhook hookMethod(Member hookMethod, XC_MethodHook callback) {
        return XposedBridge.hookMethod(hookMethod, createCallbackProxy(callback));
    }

    @Override
    public Set<XC_MethodHook.Unhook> hookAllMethods(Class<?> hookClass, String methodName, XC_MethodHook callback) {
        return XposedBridge.hookAllMethods(hookClass, methodName, createCallbackProxy(callback));
    }

    @Override
    public Set<XC_MethodHook.Unhook> hookAllConstructors(Class<?> hookClass, XC_MethodHook callback) {
        return XposedBridge.hookAllConstructors(hookClass, createCallbackProxy(callback));
    }

    @Override
    public XC_MethodHook.Unhook findAndHookMethod(Class<?> clazz, String methodName, Object... parameterTypesAndCallback) {
        modifyCallbackProxy(parameterTypesAndCallback);
        return XposedHelpers.findAndHookMethod(clazz, methodName, parameterTypesAndCallback);
    }

    @Override
    public XC_MethodHook.Unhook findAndHookMethod(String className, ClassLoader classLoader, String methodName, Object... parameterTypesAndCallback) {
        modifyCallbackProxy(parameterTypesAndCallback);
        return XposedHelpers.findAndHookMethod(className, classLoader, methodName, parameterTypesAndCallback);
    }

    @Override
    public XC_MethodHook.Unhook findAndHookMethodIfExits(Class<?> clazz, String methodName, Object... parameterTypesAndCallback) {
        modifyCallbackProxy(parameterTypesAndCallback);
        Method method = XposedHelpers2.findMethodExactIfExists(clazz, methodName, parameterTypesAndCallback);
        if (method != null) {
            XC_MethodHook callback = (XC_MethodHook) parameterTypesAndCallback[parameterTypesAndCallback.length-1];
            return XposedBridge.hookMethod(method, callback);
        }
        return null;
    }

    @Override
    public XC_MethodHook.Unhook findAndHookMethodIfExits(String className, ClassLoader classLoader, String methodName, Object... parameterTypesAndCallback) {
        modifyCallbackProxy(parameterTypesAndCallback);
        Method method = XposedHelpers2.findMethodExactIfExists(className, classLoader, methodName, parameterTypesAndCallback);
        if (method != null) {
            XC_MethodHook callback = (XC_MethodHook) parameterTypesAndCallback[parameterTypesAndCallback.length-1];
            return XposedBridge.hookMethod(method, callback);
        }
        return null;
    }

    @Override
    public XC_MethodHook.Unhook findAndHookConstructor(Class<?> clazz, Object... parameterTypesAndCallback) {
        modifyCallbackProxy(parameterTypesAndCallback);
        return XposedHelpers.findAndHookConstructor(clazz, parameterTypesAndCallback);
    }

    @Override
    public XC_MethodHook.Unhook findAndHookConstructor(String className, ClassLoader classLoader, Object... parameterTypesAndCallback) {
        modifyCallbackProxy(parameterTypesAndCallback);
        return XposedHelpers.findAndHookConstructor(className, classLoader, parameterTypesAndCallback);
    }


    private static void modifyCallbackProxy(Object... parameterTypesAndCallback) {
        // ide转为kotlin写法需要注意
        // kotlin vararg可变参数不能这样直接修改数组的值，对方法之外的数据无效
        // 因为kotlin调用方法传递可变参数时，需要使用*修饰符，这个修饰符编译后实际复制了一份数组作为参数
        int lastIndex = parameterTypesAndCallback.length - 1;
        Object callback = parameterTypesAndCallback[lastIndex];
        if (callback instanceof XC_MethodHook) {
            parameterTypesAndCallback[lastIndex] = createCallbackProxy((XC_MethodHook) callback);
        }
    }

    protected static XC_MethodHook createCallbackProxy(XC_MethodHook callback) {
        // XC_MethodReplacement继承自XC_MethodHook，所以先判断replace
        if (callback instanceof XC_MethodReplacement) {
            return new XC_MethodReplacement2Proxy((XC_MethodReplacement) callback);
        }
        return new XC_MethodHook2Proxy(callback);
    }

    // --------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------
    // 扩展函数，补充原先没有的函数
    // --------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------
    @Override
    public Method[] findMethodsByExactPredicate(Class<?> clazz, Predicate<Method> predicate) {
        List<Method> result = new LinkedList<Method>();
        if (clazz != null) {
            for (Method method : clazz.getDeclaredMethods()) {
                boolean match = predicate.test(method);
                if (match) {
                    method.setAccessible(true);
                    result.add(method);
                }
            }
        }
        return result.toArray(new Method[result.size()]);
    }

    @Override
    public Method[] findMethodsByExactPredicate(String className, ClassLoader classLoader, Predicate<Method> predicate) {
        Class<?> clazz = findClassIfExists(className, classLoader);
        return findMethodsByExactPredicate(clazz, predicate);
    }

    @Override
    public Field[] findFieldsByExactPredicate(Class<?> clazz, Predicate<Field> predicate) {
        List<Field> result = new LinkedList<>();
        for (Field declaredField : clazz.getDeclaredFields()) {
            boolean match = predicate.test(declaredField);
            if (match) {
                declaredField.setAccessible(true);
                result.add(declaredField);
            }
        }
        return result.toArray(new Field[result.size()]);
    }

    @Override
    public Field[] findFieldsByExactPredicate(String className, ClassLoader classLoader, Predicate<Field> predicate) {
        Class<?> clazz = findClassIfExists(className, classLoader);
        return findFieldsByExactPredicate(clazz, predicate);
    }

    @Override
    public <T> T callMethodElse(Object obj, String methodName, T fallback, Object... args) {
        try {
            return (T) XposedHelpers.callMethod(obj, methodName, args);
        } catch (Throwable e) {
        }
        return fallback;
    }

    @Override
    public <T> T callMethodElse(Object obj, String methodName, T fallback, Class<?>[] parameterTypes, Object... args) {
        try {
            return (T) XposedHelpers.callMethod(obj, methodName, parameterTypes, args);
        } catch (Throwable e) {
        }
        return fallback;
    }

    @Override
    public <T> T callStaticMethodElse(Class<?> clazz, String methodName, T fallback, Object... args) {
        try {
            return (T) XposedHelpers.callStaticMethod(clazz, methodName, args);
        } catch (Exception e) {

        }
        return fallback;
    }

    @Override
    public <T> T callStaticMethodElse(Class<?> clazz, String methodName, T fallback, Class<?>[] parameterTypes, Object... args) {
        try {
            return (T) XposedHelpers.callStaticMethod(clazz, methodName, parameterTypes, args);
        } catch (Exception e) {

        }
        return fallback;
    }
}

