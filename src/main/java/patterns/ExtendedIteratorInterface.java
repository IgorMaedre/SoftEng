package patterns;

import java.util.Iterator;

public interface ExtendedIteratorInterface<Object> extends Iterator{
	
	public Object previous();
	
	public boolean hasPrevious();
	
	public void goFirst();
	
	public void goLast();
	
	public boolean isEmpty();
	
	public int size();

}
