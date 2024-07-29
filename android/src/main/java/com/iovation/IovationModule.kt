package com.iovationreactnative

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import com.iovation.mobile.android.FraudForceConfiguration
import com.iovation.mobile.android.FraudForceManager

class IovationModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  @ReactMethod
  fun multiply(a: Double, b: Double, promise: Promise) {
    promise.resolve(a * b)
  }

  val context = reactContext.getApplicationContext()
  val ai = context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
  val iovationKey = ai.metaData.getString("com.iovation.IOVATION_KEY") ?: ""
  val configuration = FraudForceConfiguration.Builder()
	  .subscriberKey(iovationKey)
		.enableNetworkCalls(true)
		.build()

	init {
	  FraudForceManager.initialize(configuration, context)
    FraudForceManager.refresh(context)
	}

  @ReactMethod
  fun getBlackbox(a: Double, b:Double, promise: Promise) {
    val blackbox = FraudForceManager.getBlackbox(context)
    promise.resolve(blackbox)
  }

  companion object {
    const val NAME = "Iovation"
  }
}
