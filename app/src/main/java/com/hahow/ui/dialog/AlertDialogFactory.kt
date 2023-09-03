package com.hahow.ui.dialog


import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AlertDialog.Builder
import `in`.hahow.android_recruit_project.R


object AlertDialogFactory {

    /**
     * 顯示Loading Dialog
     * */
    fun showLoadingDialog(context: Context): AlertDialog {
        return Builder(context).apply {
            setCancelable(false)
            setView(R.layout.dialog_loading)
        }.create()
    }


    /**
     * 顯示 警示 Dialog
     * */
    fun showAlertDialog(context: Context, message: String): AlertDialog {
        return Builder(context).apply {
            setMessage(message)
            setPositiveButton(R.string.alert_dialog_positive_button_text) { dialog, _ ->
                dialog.dismiss()
            }
        }.create()
    }
}