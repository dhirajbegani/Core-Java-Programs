package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDemo implements Serializable {

	/**
	 * 
	 */
	static final long serialVersionUID = -2564380081315815708L;
	private int id;
	private static int staticId = 300;
	private transient int transientId;
	private String name;

	public SerializationDemo(int id, int transientId, String name) {
		super();
		this.id = id;
		this.transientId = transientId;
		this.name = name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SerializationDemo obj = new SerializationDemo(100, 200, "Dhiraj");
		String fileName = "serializaitionFile.txt";
		try {
			
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(obj);
			out.close();
			file.close();
			
			System.out.println("Obj is serialized");
			System.out.println("Values when serializing Obj");
			System.out.println(obj.toString());
			
			FileInputStream fileInput = new FileInputStream(fileName);
			ObjectInputStream input = new ObjectInputStream(fileInput);
			
			SerializationDemo objNew = null;
			
			objNew = (SerializationDemo) input.readObject();
			input.close();
			fileInput.close();
			
			System.out.println("objNew is serialized");
			System.out.println("Values after deserializing Obj");
			System.out.println(objNew.toString());
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return "SerializationDemo [id=" + id + ", transientId=" + transientId + ", name=" + name + ", staticId="+ staticId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getStaticId() {
		return staticId;
	}

	public static void setStaticId(int staticId) {
		SerializationDemo.staticId = staticId;
	}

	public int getTransientId() {
		return transientId;
	}

	public void setTransientId(int transientId) {
		this.transientId = transientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
