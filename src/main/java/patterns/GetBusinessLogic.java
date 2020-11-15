package patterns;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;

public class GetBusinessLogic implements BLGetter{
	
	private BLFacade bl;
	
	public BLFacade getBusinessLogic(ConfigXML c) {
		
		try {
			
			if (c.isBusinessLogicLocal()) {	//If local
				
				DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
				bl=new BLFacadeImplementation(da);
				
			} else { //If remote
				
				String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";
				URL url = new URL(serviceName);
		        QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
		        Service service = Service.create(url, qname);
		        bl = service.getPort(BLFacade.class);
		        
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  bl;
	}

}
