package eu.grigoriev.endpoint;

import java.io.ByteArrayOutputStream;

import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SOAPLoggingHelper {

    public static void logSOAPMessage(SOAPMessageContext context, boolean error) {
        boolean outboundProperty = (boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        SOAPMessage soapMessage = context.getMessage();
        String soapMessageAsString = getSOAPMessageAsString(soapMessage);
        if (error) {
            log.error(System.lineSeparator() + (outboundProperty ? "outbound message:" : "inbound message:") + System.lineSeparator() + soapMessageAsString);
        } else {
            log.info(System.lineSeparator() + (outboundProperty ? "outbound message:" : "inbound message:") + System.lineSeparator() + soapMessageAsString);
        }
    }

    public static String getSOAPMessageAsString(SOAPMessage soapMessage) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            Source source = soapMessage.getSOAPPart().getContent();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            StreamResult streamResult = new StreamResult(byteArrayOutputStream);
            transformer.transform(source, streamResult);

            return byteArrayOutputStream.toString();
        } catch (Exception e) {
            log.error("Exception in getSOAPMessageAsString ", e);
            return null;
        }
    }

    public static void infoSOAPMessage(SOAPMessageContext context) {
        logSOAPMessage(context, false);
    }

    public static void errorSOAPMessage(SOAPMessageContext context) {
        logSOAPMessage(context, true);
    }
}
