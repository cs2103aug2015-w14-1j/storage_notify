package cs.notify;

import cs.notify.parser.*;
import cs.notify.storage.*;

public class Notify {
	
	public static void main(String[] args) {
		
		Storage str = new Storage();
		
		System.out.println(str.getCommands().toString());
	}

}
