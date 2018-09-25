package com.ctrip.configurationapplication.module

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.ctrip.configurationapplication.BasePresenter
import com.ctrip.configurationapplication.R

/**
 * @author Zhenhua on 2018/9/25.
 * @email zhshan@ctrip.com ^.^
 */
class BModule : BaseModule() {
    override fun getModuleView(): View {
        mView = LayoutInflater.from(mContext).inflate(R.layout.layout_b,
                getParentView(), false)
        return mView
    }

    override fun onCreateView(context: Context, presenter: BasePresenter) {
        super.onCreateView(context, presenter)

    }

    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onResumeAndLoginStateChanged() {
        super.onResumeAndLoginStateChanged()

    }



}