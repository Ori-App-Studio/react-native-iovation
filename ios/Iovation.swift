import FraudForce

@objc(Iovation)
class Iovation: NSObject {
  @objc(getBlackbox:withRejecter:)
  func getBlackbox(resolve: RCTPromiseResolveBlock, reject: RCTPromiseRejectBlock) -> Void {
    let blackbox = FraudForce.blackbox()
    resolve(blackbox)
  }

  @objc(getBlackbox:withB:withResolver:withRejecter:)
  func getBlackbox(a: Float, b: Float, resolve:RCTPromiseResolveBlock,reject:RCTPromiseRejectBlock) -> Void {
    let blackbox = FraudForce.blackbox()
    resolve(blackbox);
  }
}
