package eu.grigoriev.webservice;

import javax.jws.WebService;

import lombok.extern.java.Log;

@WebService(endpointInterface = "eu.grigoriev.webservice.NotificationService")
@Log
public class NotificationServiceImpl implements NotificationService {
    @Override
    public String getServiceVersion() {
        return "v1.0";
    }

    @Override
    public void notify(String name, String parameter, String type) {
        log.info("name = " + name + ", parameter = " + parameter + ", type = " + type);
    }
}
