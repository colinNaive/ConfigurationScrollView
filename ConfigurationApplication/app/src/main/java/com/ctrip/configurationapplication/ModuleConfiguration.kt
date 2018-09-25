package com.ctrip.configurationapplication

import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import com.ctrip.configurationapplication.module.*

/**
 * @author Zhenhua on 2018/9/25.
 * @email zhshan@ctrip.com ^.^
 */
class ModuleConfiguration {
    private val mModuleMap = LinkedHashMap<String, BaseModule>()
    private val mModuleList = ArrayList<String>()

    interface ModuleTagKey {
        companion object {
            val aModule = AModule::class.java.name
            val bModule = BModule::class.java.name
            val cModule = CModule::class.java.name
            val dModule = DModule::class.java.name
        }
    }

    fun doConfigure(): ModuleConfiguration {
        mModuleList.clear()
        mModuleList.add(ModuleTagKey.aModule)
        mModuleList.add(ModuleTagKey.aModule)
        mModuleList.add(ModuleTagKey.dModule)
        mModuleList.add(ModuleTagKey.cModule)
        return this
    }

    fun assemblePage(container: ViewGroup): ModuleConfiguration {
        for (moduleKey in mModuleList) {
            var module = getModule(moduleKey)
            module?.bind(container)
        }
        return this
    }

    private fun getModule(key: String): BaseModule? {
        return mModuleMap[key]
    }


    fun init(context: Context, presenter: BasePresenter): ModuleConfiguration {
        mModuleMap.clear()
        mModuleMap[ModuleTagKey.aModule] = AModule()
        mModuleMap[ModuleTagKey.bModule] = BModule()
        mModuleMap[ModuleTagKey.cModule] = CModule()
        mModuleMap[ModuleTagKey.dModule] = DModule()

        onViewCreated(context, presenter)

        return this
    }

    fun onViewCreated(context: Context, presenter: BasePresenter) {
        for (module in mModuleMap.values) {
            module.onCreateView(context, presenter)
        }
    }

    fun onResume() {
        for (module in mModuleMap.values) {
            module.onResume()
        }
    }

    fun onResumeAndLoginStateChanged() {
        for (module in mModuleMap.values) {
            module.onResumeAndLoginStateChanged()
        }
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        for (module in mModuleMap.values) {
            module.onActivityResult(requestCode, resultCode, data)
        }
    }

    fun onDestroy() {
        for (module in mModuleMap.values) {
            module.onDestroy()
        }
    }

}