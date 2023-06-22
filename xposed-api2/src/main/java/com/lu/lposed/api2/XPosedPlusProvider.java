package com.lu.lposed.api2;

import com.lu.lposed.api2.function.IXPosedPlus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class XPosedPlusProvider {
    private static final IXPosedPlus PLUS_NORMAL = new XPosedPlus();
    private static final IXPosedPlus PLUS_PROXY = proxy(PLUS_NORMAL);
    private static IXPosedPlus PLUS = PLUS_PROXY;

    private static IXPosedPlus proxy(IXPosedPlus plusNormal) {
        if (!Proxy.isProxyClass(plusNormal.getClass())) {
            // 动态代理，将所有xpose执行函数抓取异常
            return (IXPosedPlus) Proxy.newProxyInstance(
                    plusNormal.getClass().getClassLoader(),
                    new Class[]{IXPosedPlus.class},
                    new InnerPlusProxy(plusNormal)
            );
        }
        return plusNormal;
    }

    public static IXPosedPlus get() {

        return PLUS;
    }

    public synchronized static void setPlusProxy(boolean flag) {
        if (flag) {
            PLUS = PLUS_PROXY;
            XposedHelpersSuper.PLUS = PLUS_PROXY;
        } else {
            PLUS = PLUS_NORMAL;
            XposedHelpersSuper.PLUS = PLUS_NORMAL;
        }
    }

    private static class InnerPlusProxy implements InvocationHandler {
        private IXPosedPlus sourcePlus;

        public InnerPlusProxy(IXPosedPlus plus) {
            this.sourcePlus = plus;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //对所有的被代理方法抓取异常
            Object result = null;
            try {
                result = method.invoke(sourcePlus, args);
            } catch (Throwable throwable) {
                if (XposedHelpers2.Config.mOnErrorReturnFallbackFunction != null) {
                    return XposedHelpers2.Config.mOnErrorReturnFallbackFunction.apply(method, throwable);
                }
            }
            return result;
        }
    }

}
