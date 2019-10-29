package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	Object obj;
	String fileName;

	public boolean writeObject(Object obj, String fileName) {
		boolean writtenSuccessful = false;
		if(obj!=null & fileName!=null) {
		try (FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);) {
			out.writeObject(obj);
			writtenSuccessful = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("Given object is serialized\nValues when serializing Obj\n" + obj);
		}
		return writtenSuccessful;
	}

	public boolean readObject(Object obj, String fileName) {
		boolean readSuccessful = false;
		if(obj!=null & fileName!=null) {
		try (FileInputStream fileInput = new FileInputStream(fileName);
			 ObjectInputStream input = new ObjectInputStream(fileInput);) {
			obj = input.readObject();
			readSuccessful=true;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("\nGiven object is deserialized\nValues after deserializing Obj\n" + obj);
		}
		return readSuccessful;
	}	
}