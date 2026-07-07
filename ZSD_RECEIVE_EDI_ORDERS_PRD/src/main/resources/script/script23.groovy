import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;

def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper(false, false).parseText(body)
    
    // Register namespace manually if needed
    def ns = new groovy.xml.Namespace("http://schemas.microsoft.com/ado/2007/08/dataservices/metadata", '')

    // Extract the top-level message
    def mainMessage = xml.'message'.text()
    
    // Extract nested messages
    def nestedMessages = xml.'**'.findAll { it.name() == 'message' && it.text() != mainMessage }*.text()
    
    // You can store these in properties if needed
    message.setProperty("MainMessage", mainMessage)
    message.setProperty("NestedMessages", nestedMessages.join("; "))

    return message
}
