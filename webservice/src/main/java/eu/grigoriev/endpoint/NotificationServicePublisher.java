package eu.grigoriev.endpoint;

import java.util.List;

import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;

import eu.grigoriev.common.Settings;
import eu.grigoriev.webservice.NotificationServiceImpl;

public class NotificationServicePublisher {
    public static void main(String[] args) {
        Endpoint endpoint = Endpoint.create(new NotificationServiceImpl());

        List<Handler> handlerChain = endpoint.getBinding().getHandlerChain();
        handlerChain.add(new SOAPLoggingHandler());
        endpoint.getBinding().setHandlerChain(handlerChain);

        endpoint.publish("http://" + Settings.HOST + ":" + Settings.PORT + "/ws/notification");
    }
}
