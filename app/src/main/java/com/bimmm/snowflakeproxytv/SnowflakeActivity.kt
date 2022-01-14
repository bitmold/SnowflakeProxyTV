package com.bimmm.snowflakeproxytv

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import com.bimmm.snowflakeproxyservice.SnowflakeProxyService

class SnowflakeActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snowflake)
        startProxy()
    }

    private fun startProxy() {
        val intent = Intent(this, SnowflakeProxyService::class.java)
            .setAction(SnowflakeProxyService.ACTION_START)
            .putExtra(SnowflakeProxyService.EXTRA_START_SHOW_TOAST, true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            startForegroundService(intent)
        else
            startService(intent)
    }

}