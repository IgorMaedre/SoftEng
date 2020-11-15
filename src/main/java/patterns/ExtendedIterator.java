package patterns;

import java.util.Iterator;
import java.util.Vector;

import domain.Event;

public class ExtendedIterator<Event> implements ExtendedIteratorInterface {
	
	private Vector<Event> iter;
	private int size;
	private int position = 0;
	
	public ExtendedIterator(Vector<Event> v) {
		this.iter = v;
		this.size = v.size();
	}
	
	@Override
	public void goFirst() {
		this.position = 0;
	}
	
	@Override
	public void goLast() {
		this.position = this.size;
	}
	
	@Override
	public Event previous() {
		position--;
		return iter.get(position);
	}
	
	@Override
	public boolean hasPrevious() {
		return position > 0;
	}

	@Override
	public boolean hasNext() {
		return position < (size-1);
	}

	@Override
	public Event next() {
		position++;
		return iter.get(position-1);
	}
	
	@Override
	public boolean isEmpty() {
		return size!=0;
	}
	
	@Override
	public int size() {
		return this.size;
	}

}
