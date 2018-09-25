package com.ctrip.configurationapplication.module

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import com.ctrip.configurationapplication.BasePresenter

/**
 * @author Zhenhua on 2018/9/25.
 * @email zhshan@ctrip.com ^.^
 */
abstract class BaseModule {
    lateinit var mContext: Context
    lateinit var mView: View
    lateinit var mParent: ViewGroup
    lateinit var mPresenter: BasePresenter

    open fun onCreateView(context: Context, presenter: BasePresenter) {
        this.mContext = context
        this.mPresenter = presenter
    }

    open fun onDestroy() {

    }

    open fun onResume() {

    }

    open fun onResumeAndLoginStateChanged() {

    }

    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }

    fun bind(parent: ViewGroup) {
        if (parent == null) {
            return
        }
        mParent = parent
        var view = getModuleView()
        if (view == null || view.parent != null) {
            return
        }
        view.visibility = View.VISIBLE
        parent.addView(view)
    }

    abstract fun getModuleView(): View

    fun getParentView(): ViewGroup {
        return mParent
    }

}