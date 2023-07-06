package com.screenbeam.alertplus.hellocrash

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    private val TAG = "MyFirebaseMessagingService"

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        // Check if the message contains data
        if (remoteMessage.data.isNotEmpty()) {
            val title = remoteMessage.data["title"] // get data payload by key
            val message = remoteMessage.data["message"]
            Log.d(TAG,"TNI Line15 data:" + remoteMessage.data + " " + title + " " + message)
            // show notification using this data
            showNotification(title, message)
        }

        // Check if message contains a notification
        if (remoteMessage.notification != null) {
            // Get the title and body of the notification
            val title = remoteMessage.notification!!.title
            val body = remoteMessage.notification!!.body
            Log.d(TAG,"TNI Line27 " + title + body)

            // Show notification
            showNotification(title, body)
        }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // handle token refresh here
    }

    private fun showNotification(title: String?, message: String?) {
        // build and display the notification
    }
}
