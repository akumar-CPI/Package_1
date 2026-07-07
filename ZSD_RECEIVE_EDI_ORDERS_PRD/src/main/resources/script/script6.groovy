/* Refer the link below to learn more about the use cases of script.
https://help.sap.com/viewer/368c481cd6954bdfa5d0435479fd4eaf/Cloud/en-US/148851bf8192412cba1f9d2c17f4bd25.html

If you want to know more about the SCRIPT APIs, refer the link below
https://help.sap.com/doc/a56f52e1a58e4e2bac7f7adbf45b2e26/Cloud/en-US/index.html */
import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import groovy.xml.MarkupBuilder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;
import groovy.xml.*;
import com.sap.gateway.ip.core.customdev.util.Message;

def Message processData(Message message) {
    //Body
    def body = message.getBody(String);
    def root = new XmlParser().parseText(body);
    def properties = message.getProperties();
    Prod = properties.get("FinalMaterial");
    root.'**'.find { it.name() == 'Material' }.value = Prod;
    //message.body = XmlUtil.serialize(root);

    //UOM = properties.get("SalesUnit");
    //SellerUnit = properties.get("OrderQuantityUnit");
    //if (SellerUnit != ''){
      //SellerISOUnit =  properties.get("ISO_UOM");
      //root.'**'.find { it.name() == 'OrderQuantityUnit' }.value =  SellerISOUnit;  
   // }
   // root.'**'.find { it.name() == 'OrderQuantityUnit' }.value = UOM;
    message.body = XmlUtil.serialize(root);
    return message;
}