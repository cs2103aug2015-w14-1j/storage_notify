package cs.notify.parser;

import java.util.Date;

import cs.notify.Constant;
import cs.notify.Constant.Command;

public class Formatter {
	
	/**
	 * This operation converts and unchecked input to a system recognized command
	 * Variant of the command will be converted to the system recognized command
	 * 
	 * @return the valid system recognized command if found, otherwise INVALID_COMMAND
	 * 
	 */
	public static Command getCommand(String command) {
		Command results = Constant.Command.INVALID;

		/*command = command.trim().toLowerCase();
		HashMap<String, Command> variants = getCommandVariations();
		if(variants.containsKey(command) == true) { 
			results = variants.get(command);
		}*/

		return results;
	}
	
	/**
	 * This operation verifies the user passed date and time 
	 * 
	 * @param date
	 *            unformatted date eg. 140615, 14/06/15, 14-06-15
	 *            accepts [ddmmyy], [dd/mm/yy], [dd-mm-yy]
	 *            if year is omitted, current year will be defaulted 
	 *            
	 * @param time
	 * 			  unformatted time eg. 02:30pm, 0230hrs
	 * 			  accepts [hh:mm:am/pm], [hhmm]
	 * 			  if am/pm is omitted, value will be treated with 24hrs formatting
	 * 
	 * @return returns the formatted date and time passed.
	 * 		   if either field is absent, default minimum value is return
	 */
	public static Date getDateTime(String datetime) {
		return null;
	}
	
	/**
	 * This operation formulates given array into string
	 * Must be called after all the variables have been extracted (eg. from, to.. )
	 */
	public static String getName(String[] array) {
		String value = "";
		for(int i = 0; i < array.length; i++) {
			if(array[i].equalsIgnoreCase(Constant.STRING_EMPTY) == false) {
				value += array[i] + Constant.STRING_SPACE;
			}
		}
		
		return value.trim();
	}
}