package eu.grigoriev.endpoint;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SOAPLoggingHandler implements SOAPHandler<SOAPMessageContext> {
    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        SOAPLoggingHelper.infoSOAPMessage(context);
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        SOAPLoggingHelper.errorSOAPMessage(context);
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }
}
