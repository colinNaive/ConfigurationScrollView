package com.ctrip.configurationapplication.module

import android.view.LayoutInflater
import android.view.View
import com.ctrip.configurationapplication.R

/**
 * @author Zhenhua on 2018/9/25.
 * @email zhshan@ctrip.com ^.^
 */
class DModule : BaseModule() {
    override fun getModuleView(): View {
        mView = LayoutInflater.from(mContext).inflate(R.layout.layout_d,
                getParentView(), false)
        return mView
    }

}