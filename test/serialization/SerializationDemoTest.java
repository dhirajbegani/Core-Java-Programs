package serialization;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import serialization.DataModel;
import serialization.SerializationDemo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SerializationDemoTest {

	@Test
	public void test1WriteScenario() {
		SerializationDemo demo = new SerializationDemo();
		demo.setObj(new DataModel(100, 200, "Dhiraj"));
		demo.setFileName("DataModelSerializaitionFile.txt");
		assertTrue(demo.writeObject(demo.getObj(), demo.getFileName()));
	}
	
	@Test
	public void test2ReadScenario() {
		SerializationDemo demo = new SerializationDemo();
		demo.setFileName("DataModelSerializaitionFile.txt");
		assertTrue(demo.readObject(new DataModel(), demo.getFileName()));
	}
	
	@Test
	public void test3WriteScenarioForString() {
		SerializationDemo demo = new SerializationDemo();
		demo.setObj(new String("Dhiraj"));
		demo.setFileName("StringSerializaitionFile.txt");
		assertTrue(demo.writeObject(demo.getObj(), demo.getFileName()));
	}
	
	@Test
	public void test4ReadScenario() {
		SerializationDemo demo = new SerializationDemo();
		demo.setFileName("StringSerializaitionFile.txt");
		assertTrue(demo.readObject(new String(), demo.getFileName()));
	}
}
