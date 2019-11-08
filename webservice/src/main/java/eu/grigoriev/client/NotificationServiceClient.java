package eu.grigoriev.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import eu.grigoriev.common.Settings;
import eu.grigoriev.webservice.NotificationService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotificationServiceClient {

    public static void main(String[] args) {

        URL url = null;
        try {
            url = new URL("http://" + Settings.HOST + ":" + Settings.PORT + "/ws/notification?wsdl");
        } catch (MalformedURLException e) {
            log.error("", e);
        }
        QName qname = new QName("http://webservice.grigoriev.eu/", "NotificationServiceImplService");

        Service service = Service.create(url, qname);

        NotificationService notificationService = service.getPort(NotificationService.class);

        String serviceVersion = notificationService.getVersion();
        log.info("serviceVersion = " + serviceVersion);
        notificationService.notify("name", "parameter", "type");

        try {
            String result = notificationService.fault();
        } catch (Exception e) {
            log.error("", e);
        }
    }
}
