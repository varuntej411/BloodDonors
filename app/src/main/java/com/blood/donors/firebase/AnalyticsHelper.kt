package com.blood.donors.firebase

import android.content.Context
import android.os.Bundle
import androidx.core.os.bundleOf
import com.blood.donors.domain.model.DonorModel
import com.google.firebase.analytics.FirebaseAnalytics
import java.util.Date

private const val MEDICATION_TIME = "medication_time"
private const val MEDICATION_END_DATE = "medication_end_date"
private const val NOTIFICATION_TIME = "notification_time"


class AnalyticsHelper(
    context: Context
) {
    private val firebaseAnalytics = FirebaseAnalytics.getInstance(context)

    fun trackNotificationShown(donorModel: DonorModel) {
        val params = bundleOf(
            MEDICATION_TIME to donorModel.medicationTime.toFormattedDateString(),
            MEDICATION_END_DATE to donorModel.endDate.toFormattedDateString(),
            NOTIFICATION_TIME to Date().toFormattedDateString()
        )
       logEvent(AnalyticsEvents.MEDICATION_NOTIFICATION_SHOWN, params)
    }

    fun trackNotificationScheduled(medication: DonorModel) {
        val params = bundleOf(
            MEDICATION_TIME to medication.medicationTime.toFormattedDateString(),
            MEDICATION_END_DATE to medication.endDate.toFormattedDateString(),
            NOTIFICATION_TIME to Date().toFormattedDateString()
        )
        logEvent(AnalyticsEvents.MEDICATION_NOTIFICATION_SCHEDULED, params)
    }

    private fun logEvent(eventName: String, params: Bundle? = null) {
        firebaseAnalytics.logEvent(eventName, params)
    }
}