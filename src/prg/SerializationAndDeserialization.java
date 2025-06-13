package prg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializationAndDeserialization {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//serialization
		Student s = new Student(10,"Dinesh");
		File f = new File("sd.text");
		ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(f));
		obj.writeObject(s);
		obj.close();
		
		//de-serialization
		ObjectInputStream oi = new ObjectInputStream(new FileInputStream(f));
		Student s_obj = (Student) oi.readObject();
		System.out.println(s_obj.getId() + " " + s.getName());
		
	}
	
}
