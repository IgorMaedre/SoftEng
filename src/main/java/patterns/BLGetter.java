package patterns;

import businessLogic.BLFacade;
import configuration.ConfigXML;

public interface BLGetter {
	
	public BLFacade getBusinessLogic(ConfigXML c);

}
