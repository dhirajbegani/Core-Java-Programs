package serialization;

import java.io.Serializable;

public class DataModel implements Serializable{
	static final long serialVersionUID = -2564380081315815708L;
	private int id;
	private transient int transientId;
	private String name;
	private static int staticId = 300;

	public DataModel(int id, int transientId, String name) {
		super();
		this.setId(id);
		this.setTransientId(transientId);
		this.setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "DataModel [id=" + id + ", transientId=" + transientId + ", name=" + name + "]";
	}

	public DataModel() {
		super();
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

	public static int getStaticId() {
		return staticId;
	}

	public static void setStaticId(int staticId) {
		DataModel.staticId = staticId;
	}
}