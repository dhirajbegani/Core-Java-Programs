package core;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SerializationDemoTest {

	@Test
	public void test1WriteScenario() {
		SerializationDemo demo = new SerializationDemo();
		demo.obj = new DataModel(100, 200, "Dhiraj");
		demo.fileName = "serializaitionFile.txt";
		assertTrue(demo.writeObject(demo.obj, demo.fileName));
	}
	
	@Test
	public void test2ReadScenario() {
		SerializationDemo demo = new SerializationDemo();
		demo.fileName = "serializaitionFile.txt";
		assertTrue(demo.readObject(new DataModel(), demo.fileName));
	}
	
	@Test
	public void test3WriteScenarioForString() {
		SerializationDemo demo = new SerializationDemo();
		demo.obj = new String("Dhiraj");
		demo.fileName = "serializaitionFile.txt";
		assertTrue(demo.writeObject(demo.obj, demo.fileName));
	}
	
	@Test
	public void test4ReadScenario() {
		SerializationDemo demo = new SerializationDemo();
		demo.fileName = "serializaitionFile.txt";
		assertTrue(demo.readObject(new String(), demo.fileName));
	}
}
