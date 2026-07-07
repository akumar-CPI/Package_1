import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import groovy.xml.MarkupBuilder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import groovy.xml.NamespaceBuilder;
def Message processData(Message message) {
    //Body
// Get the XML payload.
def payload = message.getBody(String)
 
// Parse it using XmlSlurper.
def response = new XmlSlurper(false, false).parseText(payload)
def Contract = response.SalesContract.SalesContract;
message.setProperty("Contract", Contract);

return message;
}