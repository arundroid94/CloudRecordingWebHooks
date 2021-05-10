package model

data class AgoraCallback(val noticeId:String, val productId:Int, val eventType:Int,val payload: Payload)
data class Payload(val cname:String, val uid:Int, val sid:String, val sequence:Int, val sentTs:Long, val serviceType:String, val details:String)