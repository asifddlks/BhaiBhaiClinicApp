package dev.asifddlks.bhaibhaiclinicApp.utils

import android.app.Dialog
import android.content.Context
import dev.asifddlks.bhaibhaiclinicApp.R

class CustomDialog(val context: Context) {

    var dialog: Dialog = Dialog(context)

    fun progressDialog(): Dialog {

        dialog.setContentView(R.layout.dialog_progress)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        dialog.setCancelable(false)
        return dialog
    }

}