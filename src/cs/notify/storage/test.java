package cs.notify.storage;

import java.util.ArrayList;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		DataHandler dh = new DataHandler();
		/*
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			String cat = scan.next();
			Task task = new Task(scan.next());
			dh.addTask(task, cat);
		}
		
		scan.close();
		dh.saveTasks();
		*/
		
		System.out.println(dh.getCommandVariations().toString());
	}
}

