import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper
def Message processData(Message message)

{

  def unformattedJson = message.getBody(String)
  def body = unformattedJson.minus("\"included\":")
  def map = new JsonSlurper()

  def object = map.parseText(body)

  def Count_Sales_Area = object.count;
  message.setProperty("Count_Sales_Area", Count_Sales_Area)

  return message;

}