package com.lu.lposed.api2;

import com.lu.lposed.api2.function.BiFunction;
import com.lu.lposed.api2.function.Consumer;

import java.lang.reflect.Method;


public class XposedHelpers2 extends XposedHelpersSuper{

    public static final ConfigWith Config = new ConfigWith();

    public static class ConfigWith {
        //全局异常callBack
        Consumer<Throwable> throwableCallBack = Throwable::printStackTrace;
        BiFunction<Method, Throwable, Object> mOnErrorReturnFallbackFunction = (type, throwable) -> null;

        void onFailed(Throwable throwable) {
            if (throwableCallBack == null) {
                return;
            }
            throwableCallBack.accept(throwable);
        }

        /**
         * 全局异常回调配置
         *
         * @param callback 异常回调
         * @return config
         */
        public ConfigWith setThrowableCallBack(Consumer<Throwable> callback) {
            throwableCallBack = callback;
            return this;
        }

        /**
         * 配置 xposed 执行函数出错时，可以返回的一个备用的数据
         * 由动态代理实现catch error实现
         *
         * @param function 提供函数的 return 默认值
         * @return config
         */
        public ConfigWith setOnErrorReturnFallback(BiFunction<Method, Throwable, Object> function) {
            mOnErrorReturnFallbackFunction = function;
            return this;
        }
    }

}
