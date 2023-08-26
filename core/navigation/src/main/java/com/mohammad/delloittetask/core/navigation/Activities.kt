package com.mohammad.delloittetask.core.navigation

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment

fun Context.intentTo(addressableActivity: AddressableActivity): Intent {
    return Intent(addressableActivity.action).setPackage(packageName)
}

fun Fragment.intentTo(addressableActivity: AddressableActivity): Intent {
    return Intent(addressableActivity.action).setPackage(requireContext().packageName)
}

interface AddressableActivity {

    val action: String
}

object Activities {

    object Main : AddressableActivity {

        override val action: String = "com.mohammad.delloittetask.Main"
    }

}
