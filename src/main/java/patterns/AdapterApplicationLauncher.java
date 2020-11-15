package patterns;

import java.awt.Color;
import java.net.URL;
import java.util.Locale;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import patterns.BLGetter;
import patterns.GetBusinessLogic;
import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;

public class AdapterApplicationLauncher { 
	
	public static void main(String[] args) {

		ConfigXML c=ConfigXML.getInstance();
	
		System.out.println(c.getLocale());
		
		Locale.setDefault(new Locale(c.getLocale()));
		
		System.out.println("Locale: "+Locale.getDefault());
		
		AdapterMainGUI a=new AdapterMainGUI();
		a.setVisible(true);
		
		BLGetter blGet = new GetBusinessLogic();

		try {
			
			BLFacade appFacadeInterface;
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			
			appFacadeInterface = blGet.getBusinessLogic(c);
			
			AdapterMainGUI.setBussinessLogic(appFacadeInterface);
			
		}catch (Exception e) {
			
			a.jLabelSelectOption.setText("Error: "+e.toString());
			a.jLabelSelectOption.setForeground(Color.RED);	
			
			System.out.println("Error in AdapterApplicationLauncher: "+e.toString());
		}

	}

}
