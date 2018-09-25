package com.ctrip.configurationapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    private val mModuleConfiguration = ModuleConfiguration()
    private lateinit var mContainer: LinearLayout
    private lateinit var mPresenter: BasePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        init()
    }

    private fun initViews() {
        mContainer = findViewById(R.id.container)
    }

    private fun init() {
        mPresenter = BasePresenter()

        mModuleConfiguration.init(this, mPresenter).doConfigure().assemblePage(mContainer)
    }

    override fun onDestroy() {
        super.onDestroy()
        mModuleConfiguration.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        mModuleConfiguration.onResume()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mModuleConfiguration.onActivityResult(requestCode, resultCode, data)
    }
}
