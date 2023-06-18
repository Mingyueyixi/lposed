package com.lu.lposed.api2.function;

import android.content.res.Resources;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Set;

import de.robv.android.xposed.XC_MethodHook;

public interface IXPosed {

    int getXposedVersion();

    void log(String text);

    void log(Throwable t);

    XC_MethodHook.Unhook hookMethod(Member hookMethod, XC_MethodHook callback);

    @Deprecated
    void unhookMethod(Member hookMethod, XC_MethodHook callback);

    Set<XC_MethodHook.Unhook> hookAllMethods(Class<?> hookClass, String methodName, XC_MethodHook callback);

    Set<XC_MethodHook.Unhook> hookAllConstructors(Class<?> hookClass, XC_MethodHook callback);

    Object invokeOriginalMethod(Member method, Object thisObject, Object[] args) throws NullPointerException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    Class<?> findClass(String className, ClassLoader classLoader);

    Class<?> findClassIfExists(String className, ClassLoader classLoader);

    Field findField(Class<?> clazz, String fieldName);

    Field findFieldIfExists(Class<?> clazz, String fieldName);

    Field findFirstFieldByExactType(Class<?> clazz, Class<?> type);

    XC_MethodHook.Unhook findAndHookMethod(Class<?> clazz, String methodName, Object... parameterTypesAndCallback);

    XC_MethodHook.Unhook findAndHookMethod(String className, ClassLoader classLoader, String methodName, Object... parameterTypesAndCallback);

    Method findMethodExact(Class<?> clazz, String methodName, Object... parameterTypes);

    Method findMethodExactIfExists(Class<?> clazz, String methodName, Object... parameterTypes);

    Method findMethodExact(String className, ClassLoader classLoader, String methodName, Object... parameterTypes);

    Method findMethodExactIfExists(String className, ClassLoader classLoader, String methodName, Object... parameterTypes);

    Method findMethodExact(Class<?> clazz, String methodName, Class<?>... parameterTypes);

    Method[] findMethodsByExactParameters(Class<?> clazz, Class<?> returnType, Class<?>... parameterTypes);

    Method findMethodBestMatch(Class<?> clazz, String methodName, Class<?>... parameterTypes);

    Method findMethodBestMatch(Class<?> clazz, String methodName, Object... args);

    Method findMethodBestMatch(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object[] args);

    Class<?>[] getParameterTypes(Object... args);

    Class<?>[] getClassesAsArray(Class<?>... clazzes);

    Constructor<?> findConstructorExact(Class<?> clazz, Object... parameterTypes);

    Constructor<?> findConstructorExactIfExists(Class<?> clazz, Object... parameterTypes);

    Constructor<?> findConstructorExact(String className, ClassLoader classLoader, Object... parameterTypes);

    Constructor<?> findConstructorExactIfExists(String className, ClassLoader classLoader, Object... parameterTypes);

    Constructor<?> findConstructorExact(Class<?> clazz, Class<?>... parameterTypes);

    XC_MethodHook.Unhook findAndHookConstructor(Class<?> clazz, Object... parameterTypesAndCallback);

    XC_MethodHook.Unhook findAndHookConstructor(String className, ClassLoader classLoader, Object... parameterTypesAndCallback);

    Constructor<?> findConstructorBestMatch(Class<?> clazz, Class<?>... parameterTypes);

    Constructor<?> findConstructorBestMatch(Class<?> clazz, Object... args);

    Constructor<?> findConstructorBestMatch(Class<?> clazz, Class<?>[] parameterTypes, Object[] args);

    void setObjectField(Object obj, String fieldName, Object value);

    void setBooleanField(Object obj, String fieldName, boolean value);

    void setByteField(Object obj, String fieldName, byte value);

    void setCharField(Object obj, String fieldName, char value);

    void setDoubleField(Object obj, String fieldName, double value);

    void setFloatField(Object obj, String fieldName, float value);

    void setIntField(Object obj, String fieldName, int value);

    void setLongField(Object obj, String fieldName, long value);

    void setShortField(Object obj, String fieldName, short value);

    <E> E getObjectField(Object obj, String fieldName);

    Object getSurroundingThis(Object obj);

    boolean getBooleanField(Object obj, String fieldName);

    byte getByteField(Object obj, String fieldName);

    char getCharField(Object obj, String fieldName);

    double getDoubleField(Object obj, String fieldName);

    float getFloatField(Object obj, String fieldName);

    int getIntField(Object obj, String fieldName);

    long getLongField(Object obj, String fieldName);

    short getShortField(Object obj, String fieldName);

    void setStaticObjectField(Class<?> clazz, String fieldName, Object value);

    void setStaticBooleanField(Class<?> clazz, String fieldName, boolean value);

    void setStaticByteField(Class<?> clazz, String fieldName, byte value);

    void setStaticCharField(Class<?> clazz, String fieldName, char value);

    void setStaticDoubleField(Class<?> clazz, String fieldName, double value);

    void setStaticFloatField(Class<?> clazz, String fieldName, float value);

    void setStaticIntField(Class<?> clazz, String fieldName, int value);

    void setStaticLongField(Class<?> clazz, String fieldName, long value);

    void setStaticShortField(Class<?> clazz, String fieldName, short value);

    Object getStaticObjectField(Class<?> clazz, String fieldName);

    boolean getStaticBooleanField(Class<?> clazz, String fieldName);

    byte getStaticByteField(Class<?> clazz, String fieldName);

    char getStaticCharField(Class<?> clazz, String fieldName);

    double getStaticDoubleField(Class<?> clazz, String fieldName);

    float getStaticFloatField(Class<?> clazz, String fieldName);

    int getStaticIntField(Class<?> clazz, String fieldName);

    long getStaticLongField(Class<?> clazz, String fieldName);

    short getStaticShortField(Class<?> clazz, String fieldName);

    <T> T callMethod(Object obj, String methodName, Object... args);

    <T> T callMethod(Object obj, String methodName, Class<?>[] parameterTypes, Object... args);

    <T> T callStaticMethod(Class<?> clazz, String methodName, Object... args);

    <T> T callStaticMethod(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object... args);

    Object newInstance(Class<?> clazz, Object... args);

    Object newInstance(Class<?> clazz, Class<?>[] parameterTypes, Object... args);

    Object setAdditionalInstanceField(Object obj, String key, Object value);

    Object getAdditionalInstanceField(Object obj, String key);

    Object removeAdditionalInstanceField(Object obj, String key);

    Object setAdditionalStaticField(Object obj, String key, Object value);

    Object getAdditionalStaticField(Object obj, String key);

    Object removeAdditionalStaticField(Object obj, String key);

    Object setAdditionalStaticField(Class<?> clazz, String key, Object value);

    Object getAdditionalStaticField(Class<?> clazz, String key);

    Object removeAdditionalStaticField(Class<?> clazz, String key);

    byte[] assetAsByteArray(Resources res, String path) throws IOException;

    String getMD5Sum(String file) throws IOException;

    int incrementMethodDepth(String method);

    int decrementMethodDepth(String method);

    int getMethodDepth(String method);
}
