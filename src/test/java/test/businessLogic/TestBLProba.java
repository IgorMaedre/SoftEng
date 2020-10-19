package test.businessLogic;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import exceptions.QuestionAlreadyExist;

@RunWith(MockitoJUnitRunner.class)
public class TestBLProba {
	
	DataAccess dataAccess = Mockito.mock(DataAccess.class);
    Event mockedEvent1 = Mockito.mock(Event.class);
        
    @InjectMocks
	 BLFacade sut = new BLFacadeImplementation(dataAccess);

	@Test
	public void test0() {
		try {
			Mockito.doReturn(mockedEvent1).when(dataAccess).getEvents(Mockito.any(Date.class));
			
			ArgumentCaptor<Date> dateCaptor = ArgumentCaptor.forClass(Date.class);
			
			Mockito.verify(dataAccess,Mockito.times(1)).getEvents(dateCaptor.capture());
			
			assertEquals(mockedEvent1, dateCaptor.getValue());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	public void test1() {
		try {
			Mockito.doReturn(null).when(dataAccess).getEvents(Mockito.any(Date.class));
			
			ArgumentCaptor<Date> dateCaptor = ArgumentCaptor.forClass(Date.class);
			
			Mockito.verify(dataAccess,Mockito.times(1)).getEvents(dateCaptor.capture());
			
			assertEquals(null, dateCaptor.getValue());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	public void test2() {
		try {
			Mockito.doReturn(new Exception()).when(dataAccess).getEvents(null);
			
			ArgumentCaptor<Date> dateCaptor = ArgumentCaptor.forClass(Date.class);
			
			Mockito.verify(dataAccess,Mockito.times(1)).getEvents(dateCaptor.capture());
			
			assertEquals(mockedEvent1, dateCaptor.getValue());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}

}
