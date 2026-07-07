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
    def Customer = response.YY1_GLN_EDIType.CLIENT_EDI as String;   
    // Store the ID in a property.  
    message.setProperty("Customer_No", Customer);
    
    return message;
    
}  // All done.   