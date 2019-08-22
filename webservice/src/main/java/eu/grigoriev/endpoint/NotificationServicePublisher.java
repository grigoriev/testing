package eu.grigoriev.endpoint;

import javax.xml.ws.Endpoint;

import eu.grigoriev.webservice.NotificationServiceImpl;

public class NotificationServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/notification", new NotificationServiceImpl());
    }
}
