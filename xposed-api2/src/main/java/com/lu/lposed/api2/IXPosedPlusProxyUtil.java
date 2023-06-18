package com.lu.lposed.api2;

import android.util.Log;

import com.lu.lposed.api2.function.IXPosedPlus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class IXPosedPlusProxyUtil {

    public static IXPosedPlus proxyXposedPlus(AbsXPosedPlus plus) {
        if (!Proxy.isProxyClass(plus.getClass())) {
            // 动态代理，将所有xpose执行函数抓取异常
            return (IXPosedPlus) Proxy.newProxyInstance(
                    plus.getClass().getClassLoader(),
                    new Class[]{IXPosedPlus.class},
                    new XPosedPlusProxy(plus)
            );
        }
        return plus;
    }


    private static class XPosedPlusProxy implements InvocationHandler {
        private IXPosedPlus sourcePlus;

        public XPosedPlusProxy(IXPosedPlus plus) {
            this.sourcePlus = plus;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //对所有的被代理方法抓取异常
            Object result = null;
            try {
                result = method.invoke(sourcePlus, args);
            } catch (Throwable throwable) {
                XposedHelpers2.Config.onFailed(throwable);
                if (XposedHelpers2.Config.mOnErrorReturnFallbackFunction != null) {
                    return XposedHelpers2.Config.mOnErrorReturnFallbackFunction.apply(method, throwable);
                }
            }
            return result;
        }
    }

}
