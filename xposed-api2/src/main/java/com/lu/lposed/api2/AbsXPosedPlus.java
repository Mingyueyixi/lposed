package com.lu.lposed.api2;

import android.content.res.Resources;

import com.lu.lposed.api2.function.IXPosedPlus;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Set;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

/**
 * 代理实现了所有的XPosed函数，不包含自己的实现
 */
abstract class AbsXPosedPlus implements IXPosedPlus {

    @Override
    public int getXposedVersion() {
        return XposedBridge.getXposedVersion();
    }

    @Override
    public void log(String text) {
        XposedBridge.log(text);
    }

    @Override
    public void log(Throwable t) {
        XposedBridge.log(t);
    }

    @Override
    public XC_MethodHook.Unhook hookMethod(Member hookMethod, XC_MethodHook callback) {
        return XposedBridge.hookMethod(hookMethod, callback);
    }

    @Deprecated
    @Override
    public void unhookMethod(Member hookMethod, XC_MethodHook callback) {
        XposedBridge.unhookMethod(hookMethod, callback);
    }

    @Override
    public Set<XC_MethodHook.Unhook> hookAllMethods(Class<?> hookClass, String methodName, XC_MethodHook callback) {
        return XposedBridge.hookAllMethods(hookClass, methodName, callback);
    }

    @Override
    public Set<XC_MethodHook.Unhook> hookAllConstructors(Class<?> hookClass, XC_MethodHook callback) {
        return XposedBridge.hookAllConstructors(hookClass, callback);
    }

    @Override
    public Object invokeOriginalMethod(Member method, Object thisObject, Object[] args) throws NullPointerException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return XposedBridge.invokeOriginalMethod(method, thisObject, args);
    }

    @Override
    public Class<?> findClass(String className, ClassLoader classLoader) {
        return XposedHelpers.findClass(className, classLoader);
    }

    @Override
    public Class<?> findClassIfExists(String className, ClassLoader classLoader) {
        return XposedHelpers.findClassIfExists(className, classLoader);
    }

    @Override
    public Field findField(Class<?> clazz, String fieldName) {
        return XposedHelpers.findField(clazz, fieldName);
    }

    @Override
    public Field findFieldIfExists(Class<?> clazz, String fieldName) {
        return XposedHelpers.findFieldIfExists(clazz, fieldName);
    }

    @Override
    public Field findFirstFieldByExactType(Class<?> clazz, Class<?> type) {
        return XposedHelpers.findFirstFieldByExactType(clazz, type);
    }

    @Override
    public XC_MethodHook.Unhook findAndHookMethod(Class<?> clazz, String methodName, Object... parameterTypesAndCallback) {
        return XposedHelpers.findAndHookMethod(clazz, methodName, parameterTypesAndCallback);
    }

    @Override
    public XC_MethodHook.Unhook findAndHookMethod(String className, ClassLoader classLoader, String methodName, Object... parameterTypesAndCallback) {
        return XposedHelpers.findAndHookMethod(className, classLoader, methodName, parameterTypesAndCallback);
    }

    @Override
    public Method findMethodExact(Class<?> clazz, String methodName, Object... parameterTypes) {
        return XposedHelpers.findMethodExact(clazz, methodName, parameterTypes);
    }

    @Override
    public Method findMethodExactIfExists(Class<?> clazz, String methodName, Object... parameterTypes) {
        return XposedHelpers.findMethodExactIfExists(clazz, methodName, parameterTypes);
    }

    @Override
    public Method findMethodExact(String className, ClassLoader classLoader, String methodName, Object... parameterTypes) {
        return XposedHelpers.findMethodExact(className, classLoader, methodName, parameterTypes);
    }

    @Override
    public Method findMethodExactIfExists(String className, ClassLoader classLoader, String methodName, Object... parameterTypes) {
        return XposedHelpers.findMethodExactIfExists(className, classLoader, methodName, parameterTypes);
    }

    @Override
    public Method findMethodExact(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        return XposedHelpers.findMethodExact(clazz, methodName, parameterTypes);
    }

    @Override
    public Method[] findMethodsByExactParameters(Class<?> clazz, Class<?> returnType, Class<?>... parameterTypes) {
        return XposedHelpers.findMethodsByExactParameters(clazz, returnType, parameterTypes);
    }

    @Override
    public Method findMethodBestMatch(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        return XposedHelpers.findMethodBestMatch(clazz, methodName, parameterTypes);
    }

    @Override
    public Method findMethodBestMatch(Class<?> clazz, String methodName, Object... args) {
        return XposedHelpers.findMethodBestMatch(clazz, methodName, args);
    }

    @Override
    public Method findMethodBestMatch(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object[] args) {
        return XposedHelpers.findMethodBestMatch(clazz, methodName, parameterTypes, args);
    }

    @Override
    public Class<?>[] getParameterTypes(Object... args) {
        return XposedHelpers.getParameterTypes(args);
    }

    @Override
    public Class<?>[] getClassesAsArray(Class<?>... clazzes) {
        return XposedHelpers.getClassesAsArray(clazzes);
    }

    @Override
    public Constructor<?> findConstructorExact(Class<?> clazz, Object... parameterTypes) {
        return XposedHelpers.findConstructorExact(clazz, parameterTypes);
    }

    @Override
    public Constructor<?> findConstructorExactIfExists(Class<?> clazz, Object... parameterTypes) {
        return XposedHelpers.findConstructorExactIfExists(clazz, parameterTypes);
    }

    @Override
    public Constructor<?> findConstructorExact(String className, ClassLoader classLoader, Object... parameterTypes) {
        return XposedHelpers.findConstructorExact(className, classLoader, parameterTypes);
    }

    @Override
    public Constructor<?> findConstructorExactIfExists(String className, ClassLoader classLoader, Object... parameterTypes) {
        return XposedHelpers.findConstructorExactIfExists(className, classLoader, parameterTypes);
    }

    @Override
    public Constructor<?> findConstructorExact(Class<?> clazz, Class<?>... parameterTypes) {
        return XposedHelpers.findConstructorExact(clazz, parameterTypes);
    }

    @Override
    public XC_MethodHook.Unhook findAndHookConstructor(Class<?> clazz, Object... parameterTypesAndCallback) {
        return XposedHelpers.findAndHookConstructor(clazz, parameterTypesAndCallback);
    }

    @Override
    public XC_MethodHook.Unhook findAndHookConstructor(String className, ClassLoader classLoader, Object... parameterTypesAndCallback) {
        return XposedHelpers.findAndHookConstructor(className, classLoader, parameterTypesAndCallback);
    }

    @Override
    public Constructor<?> findConstructorBestMatch(Class<?> clazz, Class<?>... parameterTypes) {
        return XposedHelpers.findConstructorBestMatch(clazz, parameterTypes);
    }

    @Override
    public Constructor<?> findConstructorBestMatch(Class<?> clazz, Object... args) {
        return XposedHelpers.findConstructorBestMatch(clazz, args);
    }

    @Override
    public Constructor<?> findConstructorBestMatch(Class<?> clazz, Class<?>[] parameterTypes, Object[] args) {
        return XposedHelpers.findConstructorBestMatch(clazz, parameterTypes, args);
    }

    @Override
    public void setObjectField(Object obj, String fieldName, Object value) {
        XposedHelpers.setObjectField(obj, fieldName, value);
    }

    @Override
    public void setBooleanField(Object obj, String fieldName, boolean value) {
        XposedHelpers.setBooleanField(obj, fieldName, value);
    }

    @Override
    public void setByteField(Object obj, String fieldName, byte value) {
        XposedHelpers.setByteField(obj, fieldName, value);
    }

    @Override
    public void setCharField(Object obj, String fieldName, char value) {
        XposedHelpers.setCharField(obj, fieldName, value);
    }

    @Override
    public void setDoubleField(Object obj, String fieldName, double value) {
        XposedHelpers.setDoubleField(obj, fieldName, value);
    }

    @Override
    public void setFloatField(Object obj, String fieldName, float value) {
        XposedHelpers.setFloatField(obj, fieldName, value);
    }

    @Override
    public void setIntField(Object obj, String fieldName, int value) {
        XposedHelpers.setIntField(obj, fieldName, value);
    }

    @Override
    public void setLongField(Object obj, String fieldName, long value) {
        XposedHelpers.setLongField(obj, fieldName, value);
    }

    @Override
    public void setShortField(Object obj, String fieldName, short value) {
        XposedHelpers.setShortField(obj, fieldName, value);
    }

    @Override
    public <E> E getObjectField(Object obj, String fieldName) {
        return (E) XposedHelpers.getObjectField(obj, fieldName);
    }

    @Override
    public Object getSurroundingThis(Object obj) {
        return XposedHelpers.getSurroundingThis(obj);
    }

    @Override
    public boolean getBooleanField(Object obj, String fieldName) {
        return XposedHelpers.getBooleanField(obj, fieldName);
    }

    @Override
    public byte getByteField(Object obj, String fieldName) {
        return XposedHelpers.getByteField(obj, fieldName);
    }

    @Override
    public char getCharField(Object obj, String fieldName) {
        return XposedHelpers.getCharField(obj, fieldName);
    }

    @Override
    public double getDoubleField(Object obj, String fieldName) {
        return XposedHelpers.getDoubleField(obj, fieldName);
    }

    @Override
    public float getFloatField(Object obj, String fieldName) {
        return XposedHelpers.getFloatField(obj, fieldName);
    }

    @Override
    public int getIntField(Object obj, String fieldName) {
        return XposedHelpers.getIntField(obj, fieldName);
    }

    @Override
    public long getLongField(Object obj, String fieldName) {
        return XposedHelpers.getLongField(obj, fieldName);
    }

    @Override
    public short getShortField(Object obj, String fieldName) {
        return XposedHelpers.getShortField(obj, fieldName);
    }

    @Override
    public void setStaticObjectField(Class<?> clazz, String fieldName, Object value) {
        XposedHelpers.setStaticObjectField(clazz, fieldName, value);
    }

    @Override
    public void setStaticBooleanField(Class<?> clazz, String fieldName, boolean value) {
        XposedHelpers.setStaticBooleanField(clazz, fieldName, value);
    }

    @Override
    public void setStaticByteField(Class<?> clazz, String fieldName, byte value) {
        XposedHelpers.setStaticByteField(clazz, fieldName, value);
    }

    @Override
    public void setStaticCharField(Class<?> clazz, String fieldName, char value) {
        XposedHelpers.setStaticCharField(clazz, fieldName, value);
    }

    @Override
    public void setStaticDoubleField(Class<?> clazz, String fieldName, double value) {
        XposedHelpers.setStaticDoubleField(clazz, fieldName, value);
    }

    @Override
    public void setStaticFloatField(Class<?> clazz, String fieldName, float value) {
        XposedHelpers.setStaticFloatField(clazz, fieldName, value);
    }

    @Override
    public void setStaticIntField(Class<?> clazz, String fieldName, int value) {
        XposedHelpers.setStaticIntField(clazz, fieldName, value);
    }

    @Override
    public void setStaticLongField(Class<?> clazz, String fieldName, long value) {
        XposedHelpers.setStaticLongField(clazz, fieldName, value);
    }

    @Override
    public void setStaticShortField(Class<?> clazz, String fieldName, short value) {
        XposedHelpers.setStaticShortField(clazz, fieldName, value);
    }

    @Override
    public Object getStaticObjectField(Class<?> clazz, String fieldName) {
        return XposedHelpers.getStaticObjectField(clazz, fieldName);
    }

    @Override
    public boolean getStaticBooleanField(Class<?> clazz, String fieldName) {
        return XposedHelpers.getStaticBooleanField(clazz, fieldName);
    }

    @Override
    public byte getStaticByteField(Class<?> clazz, String fieldName) {
        return XposedHelpers.getStaticByteField(clazz, fieldName);
    }

    @Override
    public char getStaticCharField(Class<?> clazz, String fieldName) {
        return XposedHelpers.getStaticCharField(clazz, fieldName);
    }

    @Override
    public double getStaticDoubleField(Class<?> clazz, String fieldName) {
        return XposedHelpers.getStaticDoubleField(clazz, fieldName);
    }

    @Override
    public float getStaticFloatField(Class<?> clazz, String fieldName) {
        return XposedHelpers.getStaticFloatField(clazz, fieldName);
    }

    @Override
    public int getStaticIntField(Class<?> clazz, String fieldName) {
        return XposedHelpers.getStaticIntField(clazz, fieldName);
    }

    @Override
    public long getStaticLongField(Class<?> clazz, String fieldName) {
        return XposedHelpers.getStaticLongField(clazz, fieldName);
    }

    @Override
    public short getStaticShortField(Class<?> clazz, String fieldName) {
        return XposedHelpers.getStaticShortField(clazz, fieldName);
    }

    @Override
    public <T> T callMethod(Object obj, String methodName, Object... args) {
        return (T) XposedHelpers.callMethod(obj, methodName, args);
    }

    @Override
    public <T> T callMethod(Object obj, String methodName, Class<?>[] parameterTypes, Object... args) {
        return (T) XposedHelpers.callMethod(obj, methodName, parameterTypes, args);
    }

    @Override
    public <T> T callStaticMethod(Class<?> clazz, String methodName, Object... args) {
        return (T) XposedHelpers.callStaticMethod(clazz, methodName, args);
    }

    @Override
    public <T> T callStaticMethod(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object... args) {
        return (T) XposedHelpers.callStaticMethod(clazz, methodName, parameterTypes, args);
    }

    @Override
    public Object newInstance(Class<?> clazz, Object... args) {
        return XposedHelpers.newInstance(clazz, args);
    }

    @Override
    public Object newInstance(Class<?> clazz, Class<?>[] parameterTypes, Object... args) {
        return XposedHelpers.newInstance(clazz, parameterTypes, args);
    }

    @Override
    public Object setAdditionalInstanceField(Object obj, String key, Object value) {
        return XposedHelpers.setAdditionalInstanceField(obj, key, value);
    }

    @Override
    public Object getAdditionalInstanceField(Object obj, String key) {
        return XposedHelpers.getAdditionalInstanceField(obj, key);
    }

    @Override
    public Object removeAdditionalInstanceField(Object obj, String key) {
        return XposedHelpers.removeAdditionalInstanceField(obj, key);
    }

    @Override
    public Object setAdditionalStaticField(Object obj, String key, Object value) {
        return XposedHelpers.setAdditionalStaticField(obj, key, value);
    }

    @Override
    public Object getAdditionalStaticField(Object obj, String key) {
        return XposedHelpers.getAdditionalStaticField(obj, key);
    }

    @Override
    public Object removeAdditionalStaticField(Object obj, String key) {
        return XposedHelpers.removeAdditionalStaticField(obj, key);
    }

    @Override
    public Object setAdditionalStaticField(Class<?> clazz, String key, Object value) {
        return XposedHelpers.setAdditionalStaticField(clazz, key, value);
    }

    @Override
    public Object getAdditionalStaticField(Class<?> clazz, String key) {
        return XposedHelpers.getAdditionalStaticField(clazz, key);
    }

    @Override
    public Object removeAdditionalStaticField(Class<?> clazz, String key) {
        return XposedHelpers.removeAdditionalStaticField(clazz, key);
    }

    @Override
    public byte[] assetAsByteArray(Resources res, String path) throws IOException {
        return XposedHelpers.assetAsByteArray(res, path);
    }

    @Override
    public String getMD5Sum(String file) throws IOException {
        return XposedHelpers.getMD5Sum(file);
    }

    @Override
    public int incrementMethodDepth(String method) {
        return XposedHelpers.incrementMethodDepth(method);
    }

    @Override
    public int decrementMethodDepth(String method) {
        return XposedHelpers.decrementMethodDepth(method);
    }

    @Override
    public int getMethodDepth(String method) {
        return XposedHelpers.getMethodDepth(method);
    }


}
