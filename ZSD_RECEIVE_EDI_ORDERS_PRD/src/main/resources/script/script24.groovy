/* Refer the link below to learn more about the use cases of script.
https://help.sap.com/viewer/368c481cd6954bdfa5d0435479fd4eaf/Cloud/en-US/148851bf8192412cba1f9d2c17f4bd25.html

If you want to know more about the SCRIPT APIs, refer the link below
https://help.sap.com/doc/a56f52e1a58e4e2bac7f7adbf45b2e26/Cloud/en-US/index.html */
import com.sap.gateway.ip.core.customdev.util.Message;
import java.text.SimpleDateFormat;
import java.util.Date;
def Message processData(Message message) {
    //Body
    def body = message.getBody();
/*To set the body, you can use the following method. Refer SCRIPT APIs document for more detail*/
    //String TomorrowDate = "2024-02-26";
    Date date = new Date().plus(1);
    //String datePart = date.format("dd/MM/yyyy")
    //SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    //Date TomorrowDateNew = sdf1.parse(datePart);
    message.setProperty("TomorrowDate", date.format("yyyy-MM-dd"));
    
    Date datetoday = new Date();
    message.setProperty("CurrentDate", datetoday.format("yyyy-MM-dd"));
    
    return message;
}