package com.lu.lposed.plugin

import android.content.Context
import android.util.Log
import com.lu.lposed.plugin.PluginProviders.PluginStore
import de.robv.android.xposed.callbacks.XC_LoadPackage

/**
 * 插件注册中心
 */
object PluginRegistry {

    @JvmStatic
    @SafeVarargs
    fun register(vararg clazz: Class<out IPlugin>): PluginsHandler {
        clazz.map {
            PluginProviders.from(it)
        }
        return PluginsHandler()
    }

    @JvmStatic
    fun register(vararg plugin: IPlugin): PluginsHandler {
        PluginProviders.put(*plugin)
        return PluginsHandler()
    }

}

class PluginsHandler() {
    fun handleHooks(context: Context, lpparam: XC_LoadPackage.LoadPackageParam) {
        PluginProviders.all().forEach {
            try {
                it?.handleHook(context, lpparam)
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

    @JvmStatic
    fun clear() {
        PluginStore.storeMap.clear()
    }

    @JvmStatic
    fun all(): MutableCollection<IPlugin?> {
        return PluginStore.storeMap.values
    }

    @JvmStatic
    fun put(vararg plugins: IPlugin) {
        plugins.forEach {
            PluginStore.storeMap[it.javaClass] = it
        }
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
            return clazz.getDeclaredConstructor().newInstance()
        }
    }
}