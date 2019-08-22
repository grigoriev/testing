package eu.grigoriev.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import eu.grigoriev.webservice.NotificationService;
import lombok.extern.java.Log;

@Log
public class NotificationServiceClient {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:9999/ws/notification?wsdl");
        QName qname = new QName("http://webservice.grigoriev.eu/", "NotificationServiceImplService");

        Service service = Service.create(url, qname);

        NotificationService notificationService = service.getPort(NotificationService.class);

        String serviceVersion = notificationService.getServiceVersion();
        log.info("serviceVersion = " + serviceVersion);
        notificationService.notify("name", "parameter", "type");
    }
}
