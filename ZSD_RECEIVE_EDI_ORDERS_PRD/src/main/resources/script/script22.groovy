import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    def payload = message.getBody(String)

    def errorMessage = ""

    def errorDetailMessage = ""

    def allMessages = (payload =~ /<message[^>]*>(.*?)<\/message>/)

    if (allMessages.size() > 0) {

        errorMessage = allMessages[0][1]

    }

    if (allMessages.size() > 1) {

        errorDetailMessage = allMessages[1][1]

    }

    message.setProperty("ErrorMessage", errorMessage)

    message.setProperty("ErrorDetailMessage", errorDetailMessage)

    // Constructing a new XML body with the extracted messages

    def outputBody = """

<ErrorMessage>${errorMessage}</ErrorMessage>
<ErrorDetailMessage>${errorDetailMessage}</ErrorDetailMessage>


"""

    message.setBody(outputBody.trim())

    return message

}
 