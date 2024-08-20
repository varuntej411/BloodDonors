package com.blood.donors.firebase

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.room.Delete
import com.blood.donors.MainActivity
import com.blood.donors.R
import com.blood.donors.data.dto.DonorsDTo
import com.blood.donors.data.local.DonorEntity
import com.blood.donors.domain.model.DonorModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

const val MEDICATION_INTENT = "medication_intent"
const val MEDICATION_NOTIFICATION = "medication_notification"

@Suppress("DEPRECATION")
@AndroidEntryPoint
class DonorNotificationReceiver : BroadcastReceiver() {

    @Inject
    lateinit var analytics: AnalyticsHelper

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let {
            intent?.getParcelableExtra<DonorModel>(MEDICATION_INTENT)?.let { donorModel ->
                showNotification(it, donorModel)
            }
        }
    }

    @SuppressLint("StringFormatInvalid", "ServiceCast")
    private fun showNotification(context: Context?, donorModel: DonorModel) {
        val activityIntent = Intent(context, MainActivity::class.java)
        activityIntent.putExtra(MEDICATION_NOTIFICATION, true)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )

        val receiverIntent = Intent(context, NotificationActionReceiver::class.java)
        /*val takenPendingIntent = PendingIntent.getBroadcast(
            context,
            2,
            receiverIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )*/

        // TODO: Add action.
        val notification = NotificationCompat.Builder(
            context!!,
            MedicationNotificationService.MEDICATION_CHANNEL_ID
        )
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(context.getString(R.string.blood_reminder))
            .setContentText(context.getString(R.string.blood_reminder, donorModel.name))
            .setContentIntent(activityPendingIntent)
            /*.addAction(
                R.drawable.doctor,
                "Take now",
                takenPendingIntent)*/
            .build()

        // TODO: Use medication id as notification id.
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(donorModel.hashCode(), notification)

        analytics.trackNotificationShown(donorModel)
    }
}