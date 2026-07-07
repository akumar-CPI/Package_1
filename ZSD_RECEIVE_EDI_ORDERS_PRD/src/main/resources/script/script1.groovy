import com.sap.gateway.ip.core.customdev.util.Message;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
def Message processData(Message message) {  
    // Get the XML payload.    
    def payload = message.getBody(String);    
    // Parse it using XmlSlurper. That second false is to ignore namespaces.  
    def response = new XmlSlurper(false, false).parseText(payload); 
    // Extract the required ID. 
    def Buyer_Gln = response.OrderHeader.BuyerInformation.EANCode;   
    // Store the ID in a property.  
    message.setProperty("Buyer_Gln", Buyer_Gln);
    
    def Seller_Gln = response.OrderHeader.SellerInformation.EANCode;   
    // Store the ID in a property.  
    message.setProperty("Seller_Gln", Seller_Gln);
    
     def BP_Gln = response.OrderHeader.BillToPartyInformation.EANCode as String;   
    // Store the ID in a property.  
    message.setProperty("BP_Gln", BP_Gln);
    
     def Buyer_Dep = response.OrderHeader.BuyerInformation.Department as String;   
    // Store the ID in a property.  
    message.setProperty("Buyer_Dep", Buyer_Dep);
    
     def Del_Place_Inf = response.OrderHeader.DeliveryPlaceInformation.EANCode as String;   
    // Store the ID in a property.  
    message.setProperty("Delivery_Gln", Del_Place_Inf);
    
    
    return message;
    
}  // All done.   