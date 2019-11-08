package eu.grigoriev.webservice;

import javax.jws.WebService;

import lombok.extern.slf4j.Slf4j;

@WebService(endpointInterface = "eu.grigoriev.webservice.NotificationService")
@Slf4j
public class NotificationServiceImpl implements NotificationService {
    @Override
    public String getVersion() {
        return "v1.0";
    }

    @Override
    public void notify(String name, String parameter, String type) {
        log.info("name = " + name + ", parameter = " + parameter + ", type = " + type);
    }

    @Override
    public String fault() {
        throw new NotificationServiceException("test exception");
    }
}
