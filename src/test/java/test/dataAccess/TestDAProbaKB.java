package test.dataAccess;

import static org.junit.Assert.*;

import java.util.Date;

import dataAccess.*;
import domain.Event;
import domain.Question;
import exceptions.QuestionAlreadyExist;
import test.businessLogic.TestFacadeImplementation;

import org.junit.Test;

import configuration.ConfigXML;

public class TestDAProbaKB {

	static DataAccess sut = new DataAccess(ConfigXML.getInstance().getDataBaseOpenMode().equals("initialize"));
	static TestFacadeImplementation testBL = new TestFacadeImplementation();
	
	private Event ev;

	@Test
	public void test0() {
		System.out.println("test0");
		 //params
		String quest1 = "Zenbat gol?";
		String quest2 = "Zenbat txartel hori";
		float bet = (float) 5.50;
		Date date = new Date(10, 10, 2020);
		
		try {
			ev = testBL.addEvent(quest1, date);
			Question q = sut.createQuestion(ev, quest2, bet);
			
			assertTrue(q != null);
			assertEquals(q.getQuestion(), quest2);
			assertEquals(q.getBetMinimum(), bet, 0);
			
		} catch (QuestionAlreadyExist e) {
			e.printStackTrace();
			fail("????�?��??�?�?��?�");
		} finally {
			testBL.removeEvent(ev);
		}
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
		 //params
		String quest = "Zenbat gol?";
		float bet = (float) 5.50;
		Date date = new Date(10, 10, 2020);
		
		try {
			ev = testBL.addEvent(quest, date);
			Question q = sut.createQuestion(ev, quest, bet);
			
			assertTrue(q != null);
			assertEquals(q.getQuestion(), quest);
			assertEquals(q.getBetMinimum(), bet, 0);
			
		} catch (QuestionAlreadyExist e) {
			e.printStackTrace();
			fail("Galdera dagoeneko existitzen da");
		} finally {
			testBL.removeEvent(ev);
		}
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
		 //params
		String quest = "Zenbat txartel hori?";
		float bet = (float) 5.50;
		Date date = new Date(10, 10, 2020);
		
		try {
			ev = null;
			Question q = sut.createQuestion(ev, quest, bet);
			
			assertTrue(q != null);
			assertEquals(q.getQuestion(), quest);
			assertEquals(q.getBetMinimum(), bet, 0);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Event == null");
		} finally {
			testBL.removeEvent(ev);
		}
	}
	
	@Test
	public void test3() {
		System.out.println("test3");
		 //params
		String quest = "Zenbat txartel hori?";
		float bet = (float) 5.50;
		Date date = new Date(10, 10, 2020);
		
		try {
			ev = testBL.addEvent(quest, date);
			Question q = sut.createQuestion(ev, null, bet);
			
			assertTrue(q != null);
			assertEquals(q.getQuestion(), quest);
			assertEquals(q.getBetMinimum(), bet, 0);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("quest == null");
		} finally {
			testBL.removeEvent(ev);
		}
	}

}
