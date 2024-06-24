#import <FraudForce/FraudForce.h>
#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE (Iovation, NSObject)

RCT_EXTERN_METHOD(getBlackbox:(float)a withB:(float)b
                 withResolver:(RCTPromiseResolveBlock)resolve
                 withRejecter:(RCTPromiseRejectBlock)reject)

(BOOL)requiresMainQueueSetup
  return NO;
}


@end
