package com.prabhakar.jantagrocery.viewmodels

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.prabhakar.jantagrocery.Utils
import kotlinx.coroutines.flow.MutableStateFlow

class AuthViewModel : ViewModel() {
    private val _verificationId = MutableStateFlow<String?>(null)
    private val _otpSent = MutableStateFlow(false)
    val exposeOtp = _otpSent

    fun sendOTP(userNumber: String, activity: Activity) {
        val callBacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {

            }

            override fun onVerificationFailed(p0: FirebaseException) {

            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                _verificationId.value = verificationId
                _otpSent.value = true
            }

        }

        val option = PhoneAuthOptions.newBuilder(Utils.getFirebaseAuthInstance())
            .setPhoneNumber("+91 $userNumber")
            .setActivity(activity)
            .setCallbacks(callBacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(option)
    }
}