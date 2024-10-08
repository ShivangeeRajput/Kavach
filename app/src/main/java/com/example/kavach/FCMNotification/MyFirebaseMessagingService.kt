package com.example.kavach.FCMNotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import com.example.kavach.MainActivity
import com.example.kavach.R
import com.example.kavach.repository.ThoughtRepository
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channelId="notification_channel"
const val channelName="com.example.cupid"
class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if (remoteMessage.notification != null) {
            val title = remoteMessage.notification!!.title ?: "Thought of the Day"
            val message = remoteMessage.notification!!.body ?: "Brighten your day!"
            ThoughtRepository.updateThought(title, message)
            generateNotification(title, message)
        }
    }
    //attaching notification with customview
    fun getRemoteView(title: String,message: String) : RemoteViews{
        val remoteView= RemoteViews("com.example.kavach",R.layout.custom_notification)
        remoteView.setTextViewText(R.id.title,title)
        remoteView.setTextViewText(R.id.message,message)
        remoteView.setImageViewResource(R.id.ivLogo,R.drawable.wom)
        return remoteView
    }

    //generating the notification
    fun generateNotification(title:String,message:String){
        val intent= Intent(this, MainActivity::class.java)
        intent.action = "NOTIFICATIONS_ACTION"
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent= PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT
                or PendingIntent.FLAG_IMMUTABLE)
        //channel id, channel name
        var builder: NotificationCompat.Builder=NotificationCompat.Builder(applicationContext,
            channelId).setSmallIcon(R.drawable.wom)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)

        builder=builder.setContent(getRemoteView(title,message))
        val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //checking client android is gretaer than oreo or not
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel= NotificationChannel(channelId, channelName,
                NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)

        }
        notificationManager.notify(0,builder.build()  )
    }
}