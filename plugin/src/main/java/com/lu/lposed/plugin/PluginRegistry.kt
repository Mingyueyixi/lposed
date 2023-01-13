package com.lu.lposed.plugin

import android.content.Context
import android.util.Log
import de.robv.android.xposed.callbacks.XC_LoadPackage

/**
 * 插件注册中心
 */
object PluginRegistry {

    @JvmStatic
    @SafeVarargs
    fun register(vararg clazz: Class<out IPlugin>): PluginsHandler {
        return PluginsHandler(clazz.map {
            PluginProviders.from(it, PluginProviders.DefaultFactory())
        })
    }


}

class PluginsHandler(var plugins: List<IPlugin>) {
    fun handleHooks(context: Context, lpparam: XC_LoadPackage.LoadPackageParam) {
        plugins.forEach {
            try {
                it.handleHook(context, lpparam)
            } catch (e: Exception) {
                Log.e(">>>", "plugins handleHooks", e)
            }
        }
    }
}

object PluginProviders {

    @JvmStatic
    fun <E : IPlugin> from(clazz: Class<E>): E {
        return from(clazz, DefaultFactory())
    }

    @JvmStatic
    fun <E : IPlugin> from(clazz: Class<E>, factory: Factory<E>): E {
        var plugin = PluginStore.storeMap[clazz]
        if (plugin == null) {
            plugin = try {
                factory.create(clazz)
            } catch (e: Exception) {
                if (factory !is DefaultFactory) {
                    DefaultFactory<E>().create(clazz)
                } else {
                    null
                }
            }?.also {
                PluginStore.storeMap[clazz] = it
                it.onCreate()
            }
        }
        return clazz.cast(plugin)!!
    }

    private object PluginStore {
        @JvmField
        val storeMap = HashMap<Class<out IPlugin>, IPlugin?>()
    }

    fun interface Factory<E : IPlugin> {
        fun create(clazz: Class<E>): E
    }

    class DefaultFactory<E : IPlugin> : Factory<E> {
        override fun create(clazz: Class<E>): E {
            return clazz.newInstance()
        }
    }
}