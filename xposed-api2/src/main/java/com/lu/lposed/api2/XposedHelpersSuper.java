package com.lu.lposed.api2;

import android.content.res.Resources;

import com.lu.lposed.api2.function.IXPosedPlus;
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
 * 代理了XPosedPlus ，而XPosedPlus代理了XposedBridge与XposedHelpers的所有方法，内部使用，用于子类覆盖继承，不提供外部使用
 */
class XposedHelpersSuper {
    protected static IXPosedPlus PLUS = XPosedPlusProvider.get();
    public static int getXposedVersion() {
        return PLUS.getXposedVersion();
    }

    public static void log(String text) {
        PLUS.log(text);
    }

    public static void log(Throwable t) {
        PLUS.log(t);
    }

    public static XC_MethodHook.Unhook hookMethod(Member hookMethod, XC_MethodHook callback) {
        return PLUS.hookMethod(hookMethod, callback);
    }

    @Deprecated
    public static void unhookMethod(Member hookMethod, XC_MethodHook callback) {
        PLUS.unhookMethod(hookMethod, callback);
    }

    public static Set<XC_MethodHook.Unhook> hookAllMethods(Class<?> hookClass, String methodName, XC_MethodHook callback) {
        return PLUS.hookAllMethods(hookClass, methodName, callback);
    }

    public static Set<XC_MethodHook.Unhook> hookAllConstructors(Class<?> hookClass, XC_MethodHook callback) {
        return PLUS.hookAllConstructors(hookClass, callback);
    }

    public static Object invokeOriginalMethod(Member method, Object thisObject, Object[] args) throws NullPointerException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return PLUS.invokeOriginalMethod(method, thisObject, args);
    }

    public static Class<?> findClass(String className, ClassLoader classLoader) {
        return PLUS.findClass(className, classLoader);
    }

    public static Class<?> findClassIfExists(String className, ClassLoader classLoader) {
        return PLUS.findClassIfExists(className, classLoader);
    }

    public static Field findField(Class<?> clazz, String fieldName) {
        return PLUS.findField(clazz, fieldName);
    }

    public static Field findFieldIfExists(Class<?> clazz, String fieldName) {
        return PLUS.findFieldIfExists(clazz, fieldName);
    }

    public static Field findFirstFieldByExactType(Class<?> clazz, Class<?> type) {
        return PLUS.findFirstFieldByExactType(clazz, type);
    }

    public static XC_MethodHook.Unhook findAndHookMethod(Class<?> clazz, String methodName, Object... parameterTypesAndCallback) {
        return PLUS.findAndHookMethod(clazz, methodName, parameterTypesAndCallback);
    }

    public static XC_MethodHook.Unhook findAndHookMethod(String className, ClassLoader classLoader, String methodName, Object... parameterTypesAndCallback) {
        return PLUS.findAndHookMethod(className, classLoader, methodName, parameterTypesAndCallback);
    }

    public static Method findMethodExact(Class<?> clazz, String methodName, Object... parameterTypes) {
        return PLUS.findMethodExact(clazz, methodName, parameterTypes);
    }

    public static Method findMethodExactIfExists(Class<?> clazz, String methodName, Object... parameterTypes) {
        return PLUS.findMethodExactIfExists(clazz, methodName, parameterTypes);
    }

    public static Method findMethodExact(String className, ClassLoader classLoader, String methodName, Object... parameterTypes) {
        return PLUS.findMethodExact(className, classLoader, methodName, parameterTypes);
    }

    public static Method findMethodExactIfExists(String className, ClassLoader classLoader, String methodName, Object... parameterTypes) {
        return PLUS.findMethodExactIfExists(className, classLoader, methodName, parameterTypes);
    }

    public static Method findMethodExact(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        return PLUS.findMethodExact(clazz, methodName, parameterTypes);
    }

    public static Method[] findMethodsByExactParameters(Class<?> clazz, Class<?> returnType, Class<?>... parameterTypes) {
        return PLUS.findMethodsByExactParameters(clazz, returnType, parameterTypes);
    }

    public static Method findMethodBestMatch(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        return PLUS.findMethodBestMatch(clazz, methodName, parameterTypes);
    }

    public static Method findMethodBestMatch(Class<?> clazz, String methodName, Object... args) {
        return PLUS.findMethodBestMatch(clazz, methodName, args);
    }

    public static Method findMethodBestMatch(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object[] args) {
        return PLUS.findMethodBestMatch(clazz, methodName, parameterTypes, args);
    }

    public static Class<?>[] getParameterTypes(Object... args) {
        return PLUS.getParameterTypes(args);
    }

    public static Class<?>[] getClassesAsArray(Class<?>... clazzes) {
        return PLUS.getClassesAsArray(clazzes);
    }

    public static Constructor<?> findConstructorExact(Class<?> clazz, Object... parameterTypes) {
        return PLUS.findConstructorExact(clazz, parameterTypes);
    }

    public static Constructor<?> findConstructorExactIfExists(Class<?> clazz, Object... parameterTypes) {
        return PLUS.findConstructorExactIfExists(clazz, parameterTypes);
    }

    public static Constructor<?> findConstructorExact(String className, ClassLoader classLoader, Object... parameterTypes) {
        return PLUS.findConstructorExact(className, classLoader, parameterTypes);
    }

    public static Constructor<?> findConstructorExactIfExists(String className, ClassLoader classLoader, Object... parameterTypes) {
        return PLUS.findConstructorExactIfExists(className, classLoader, parameterTypes);
    }

    public static Constructor<?> findConstructorExact(Class<?> clazz, Class<?>... parameterTypes) {
        return PLUS.findConstructorExact(clazz, parameterTypes);
    }

    public static XC_MethodHook.Unhook findAndHookConstructor(Class<?> clazz, Object... parameterTypesAndCallback) {
        return PLUS.findAndHookConstructor(clazz, parameterTypesAndCallback);
    }

    public static XC_MethodHook.Unhook findAndHookConstructor(String className, ClassLoader classLoader, Object... parameterTypesAndCallback) {
        return PLUS.findAndHookConstructor(className, classLoader, parameterTypesAndCallback);
    }

    public static Constructor<?> findConstructorBestMatch(Class<?> clazz, Class<?>... parameterTypes) {
        return PLUS.findConstructorBestMatch(clazz, parameterTypes);
    }

    public static Constructor<?> findConstructorBestMatch(Class<?> clazz, Object... args) {
        return PLUS.findConstructorBestMatch(clazz, args);
    }

    public static Constructor<?> findConstructorBestMatch(Class<?> clazz, Class<?>[] parameterTypes, Object[] args) {
        return PLUS.findConstructorBestMatch(clazz, parameterTypes, args);
    }

    public static void setObjectField(Object obj, String fieldName, Object value) {
        PLUS.setObjectField(obj, fieldName, value);
    }

    public static void setBooleanField(Object obj, String fieldName, boolean value) {
        PLUS.setBooleanField(obj, fieldName, value);
    }

    public static void setByteField(Object obj, String fieldName, byte value) {
        PLUS.setByteField(obj, fieldName, value);
    }

    public static void setCharField(Object obj, String fieldName, char value) {
        PLUS.setCharField(obj, fieldName, value);
    }

    public static void setDoubleField(Object obj, String fieldName, double value) {
        PLUS.setDoubleField(obj, fieldName, value);
    }

    public static void setFloatField(Object obj, String fieldName, float value) {
        PLUS.setFloatField(obj, fieldName, value);
    }

    public static void setIntField(Object obj, String fieldName, int value) {
        PLUS.setIntField(obj, fieldName, value);
    }

    public static void setLongField(Object obj, String fieldName, long value) {
        PLUS.setLongField(obj, fieldName, value);
    }

    public static void setShortField(Object obj, String fieldName, short value) {
        PLUS.setShortField(obj, fieldName, value);
    }

    public static <E> E getObjectField(Object obj, String fieldName) {
        return PLUS.getObjectField(obj, fieldName);
    }

    public static Object getSurroundingThis(Object obj) {
        return PLUS.getSurroundingThis(obj);
    }

    public static boolean getBooleanField(Object obj, String fieldName) {
        return PLUS.getBooleanField(obj, fieldName);
    }

    public static byte getByteField(Object obj, String fieldName) {
        return PLUS.getByteField(obj, fieldName);
    }

    public static char getCharField(Object obj, String fieldName) {
        return PLUS.getCharField(obj, fieldName);
    }

    public static double getDoubleField(Object obj, String fieldName) {
        return PLUS.getDoubleField(obj, fieldName);
    }

    public static float getFloatField(Object obj, String fieldName) {
        return PLUS.getFloatField(obj, fieldName);
    }

    public static int getIntField(Object obj, String fieldName) {
        return PLUS.getIntField(obj, fieldName);
    }

    public static long getLongField(Object obj, String fieldName) {
        return PLUS.getLongField(obj, fieldName);
    }

    public static short getShortField(Object obj, String fieldName) {
        return PLUS.getShortField(obj, fieldName);
    }

    public static void setStaticObjectField(Class<?> clazz, String fieldName, Object value) {
        PLUS.setStaticObjectField(clazz, fieldName, value);
    }

    public static void setStaticBooleanField(Class<?> clazz, String fieldName, boolean value) {
        PLUS.setStaticBooleanField(clazz, fieldName, value);
    }

    public static void setStaticByteField(Class<?> clazz, String fieldName, byte value) {
        PLUS.setStaticByteField(clazz, fieldName, value);
    }

    public static void setStaticCharField(Class<?> clazz, String fieldName, char value) {
        PLUS.setStaticCharField(clazz, fieldName, value);
    }

    public static void setStaticDoubleField(Class<?> clazz, String fieldName, double value) {
        PLUS.setStaticDoubleField(clazz, fieldName, value);
    }

    public static void setStaticFloatField(Class<?> clazz, String fieldName, float value) {
        PLUS.setStaticFloatField(clazz, fieldName, value);
    }

    public static void setStaticIntField(Class<?> clazz, String fieldName, int value) {
        PLUS.setStaticIntField(clazz, fieldName, value);
    }

    public static void setStaticLongField(Class<?> clazz, String fieldName, long value) {
        PLUS.setStaticLongField(clazz, fieldName, value);
    }

    public static void setStaticShortField(Class<?> clazz, String fieldName, short value) {
        PLUS.setStaticShortField(clazz, fieldName, value);
    }

    public static Object getStaticObjectField(Class<?> clazz, String fieldName) {
        return PLUS.getStaticObjectField(clazz, fieldName);
    }

    public static boolean getStaticBooleanField(Class<?> clazz, String fieldName) {
        return PLUS.getStaticBooleanField(clazz, fieldName);
    }

    public static byte getStaticByteField(Class<?> clazz, String fieldName) {
        return PLUS.getStaticByteField(clazz, fieldName);
    }

    public static char getStaticCharField(Class<?> clazz, String fieldName) {
        return PLUS.getStaticCharField(clazz, fieldName);
    }

    public static double getStaticDoubleField(Class<?> clazz, String fieldName) {
        return PLUS.getStaticDoubleField(clazz, fieldName);
    }

    public static float getStaticFloatField(Class<?> clazz, String fieldName) {
        return PLUS.getStaticFloatField(clazz, fieldName);
    }

    public static int getStaticIntField(Class<?> clazz, String fieldName) {
        return PLUS.getStaticIntField(clazz, fieldName);
    }

    public static long getStaticLongField(Class<?> clazz, String fieldName) {
        return PLUS.getStaticLongField(clazz, fieldName);
    }

    public static short getStaticShortField(Class<?> clazz, String fieldName) {
        return PLUS.getStaticShortField(clazz, fieldName);
    }

    public static <T> T callMethod(Object obj, String methodName, Object... args) {
        return PLUS.callMethod(obj, methodName, args);
    }

    public static <T> T callMethod(Object obj, String methodName, Class<?>[] parameterTypes, Object... args) {
        return PLUS.callMethod(obj, methodName, parameterTypes, args);
    }

    public static <T> T callStaticMethod(Class<?> clazz, String methodName, Object... args) {
        return PLUS.callStaticMethod(clazz, methodName, args);
    }

    public static <T> T callStaticMethod(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object... args) {
        return PLUS.callStaticMethod(clazz, methodName, parameterTypes, args);
    }

    public static Object newInstance(Class<?> clazz, Object... args) {
        return PLUS.newInstance(clazz, args);
    }

    public static Object newInstance(Class<?> clazz, Class<?>[] parameterTypes, Object... args) {
        return PLUS.newInstance(clazz, parameterTypes, args);
    }

    public static Object setAdditionalInstanceField(Object obj, String key, Object value) {
        return PLUS.setAdditionalInstanceField(obj, key, value);
    }

    public static Object getAdditionalInstanceField(Object obj, String key) {
        return PLUS.getAdditionalInstanceField(obj, key);
    }

    public static Object removeAdditionalInstanceField(Object obj, String key) {
        return PLUS.removeAdditionalInstanceField(obj, key);
    }

    public static Object setAdditionalStaticField(Object obj, String key, Object value) {
        return PLUS.setAdditionalStaticField(obj, key, value);
    }

    public static Object getAdditionalStaticField(Object obj, String key) {
        return PLUS.getAdditionalStaticField(obj, key);
    }

    public static Object removeAdditionalStaticField(Object obj, String key) {
        return PLUS.removeAdditionalStaticField(obj, key);
    }

    public static Object setAdditionalStaticField(Class<?> clazz, String key, Object value) {
        return PLUS.setAdditionalStaticField(clazz, key, value);
    }

    public static Object getAdditionalStaticField(Class<?> clazz, String key) {
        return PLUS.getAdditionalStaticField(clazz, key);
    }

    public static Object removeAdditionalStaticField(Class<?> clazz, String key) {
        return PLUS.removeAdditionalStaticField(clazz, key);
    }

    public static byte[] assetAsByteArray(Resources res, String path) throws IOException {
        return PLUS.assetAsByteArray(res, path);
    }

    public static String getMD5Sum(String file) throws IOException {
        return PLUS.getMD5Sum(file);
    }

    public static int incrementMethodDepth(String method) {
        return PLUS.incrementMethodDepth(method);
    }

    public static int decrementMethodDepth(String method) {
        return PLUS.decrementMethodDepth(method);
    }

    public static int getMethodDepth(String method) {
        return PLUS.getMethodDepth(method);
    }

    public static Method[] findMethodsByExactPredicate(Class<?> clazz, Predicate<Method> predicate) {
        return PLUS.findMethodsByExactPredicate(clazz, predicate);
    }

    public static Method[] findMethodsByExactPredicate(String className, ClassLoader classLoader, Predicate<Method> predicate) {
        return PLUS.findMethodsByExactPredicate(className, classLoader, predicate);
    }

    public static Field[] findFieldsByExactPredicate(Class<?> clazz, Predicate<Field> predicate) {
        return PLUS.findFieldsByExactPredicate(clazz, predicate);
    }

    public static Field[] findFieldsByExactPredicate(String className, ClassLoader classLoader, Predicate<Field> predicate) {
        return PLUS.findFieldsByExactPredicate(className, classLoader, predicate);
    }
}
