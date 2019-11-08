package eu.grigoriev.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface NotificationService {

    @WebMethod
    String getVersion();

    @WebMethod
    void notify(String name, String parameter, String type);

    @WebMethod
    String fault();
}
