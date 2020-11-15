package patterns;

import java.awt.Color;
import java.awt.Event;
import java.util.Date;
import java.util.Locale;

import javax.swing.UIManager;

import businessLogic.BLFacade;
import configuration.ConfigXML;
import gui.MainGUI;

public class ProgramIterator {

	public static void main(String[] args) {
		boolean isLocal = true;
		Date d = null;
		
		ConfigXML c = ConfigXML.getInstance();
		System.out.println(c.getLocale());
		Locale.setDefault(new Locale(c.getLocale()));
		System.out.println("Locale: "+Locale.getDefault());
		
		BLGetter blGet = new GetBusinessLogic();

		try {
			
			BLFacade appFacadeInterface;
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			
			appFacadeInterface = blGet.getBusinessLogic(c);
			
			ExtendedIterator<domain.Event> iter = appFacadeInterface.getEvents(d);
			domain.Event ev = null;
			iter.goLast();
			
			while (iter.hasPrevious()) {
				ev = iter.previous();
				System.out.print(ev);
			}
			
			iter.goFirst();
			
			while(iter.hasNext()) {
				ev = iter.next();
				System.out.print(ev);
			}
			
		}catch (Exception e) {
			System.err.println("Error in ApplicationLauncher: "+e.toString());
		}
	}

}
