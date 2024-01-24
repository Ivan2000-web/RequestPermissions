package com.vansoft.requestpermissions

import android.content.pm.PackageManager
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

    class PermissionManager(private val componentActivity: ComponentActivity) { //для xml заменить на AppCompatActivity

        companion object {
            private const val PERMISSION_REQUEST_CODE = 123
        }

        fun requestPermissions(permissions: Array<String>) {
            val permissionsToRequest = mutableListOf<String>()
            for (permission in permissions) {
                if (ContextCompat.checkSelfPermission(componentActivity, permission) != PackageManager.PERMISSION_GRANTED) {
                    permissionsToRequest.add(permission)
                }
            }
            if (permissionsToRequest.isNotEmpty()) {
                ActivityCompat.requestPermissions(componentActivity, permissionsToRequest.toTypedArray(), PERMISSION_REQUEST_CODE)
            }
        }

        fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
            if (requestCode == PERMISSION_REQUEST_CODE) {
                for (i in permissions.indices) {
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        componentActivity.showToast("Разрешения получены!")
                    } else {
                        componentActivity.showToast("Разрешения не получены!")
                    }
                }
            }
        }

        fun checkPermissions(permissions: Array<String>): Boolean {
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(componentActivity, permission) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
            return true
        }
    }
