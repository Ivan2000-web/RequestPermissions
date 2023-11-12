package com.vansoft.requestpermissions

import android.widget.Toast
import androidx.activity.ComponentActivity

fun ComponentActivity.showToast(s: String) { //для xml заменить на AppCompatActivity
    Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
}
