package com.fanhl.hellosnapchat

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.snap.loginkit.LoginResultCallback
import com.snap.loginkit.SnapLoginProvider
import com.snap.loginkit.exceptions.LoginException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val snapLogin = SnapLoginProvider.get(this)
        findViewById<Button>(R.id.btn_snapchat).setOnClickListener {
            snapLogin.startTokenGrant(object : LoginResultCallback {
                override fun onStart() {
                    Log.d(TAG, "fanhl MainActivity onStart")
                }

                override fun onSuccess(accessToken: String) {
                    Log.d(TAG, "fanhl MainActivity onSuccess accessToken:$accessToken")
                }

                override fun onFailure(exception: LoginException) {
                    Log.e(TAG, "fanhl MainActivity onFailure", exception)
                }
            })
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}