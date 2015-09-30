package cs.notify.storage;

import cs.notify.*;
import java.io.IOException;
import java.util.*;

public class DataHandler {
	private static int task_id;
	private static Stack<String> actions;
	//private static HashMap<Integer, Task> tasks; //KEY = task_id, VALUE = Task Name
	private static HashMap<String, ArrayList<Task>> categories; //KEY = Category, VALUE = List of Tasks that belong to that category.
	private static ArrayList<Task> cache; //Task cache
	private static HashMap<String, Constant.Command> commandVariations; //KEY = command variant, VALUE = default command
	
	public DataHandler() {
		task_id = 0;
		actions = new Stack<String>();
		categories = new HashMap<String, ArrayList<Task>>();
		cache = new ArrayList<Task>();
		commandVariations = new HashMap<String, Constant.Command>();
		populateCommandVariations();
		//loadTasks();
	}
	
	
	private void populateCommandVariations() {
		String currentLine;
		
		//Read each file
		for(Constant.Command command : Constant.Command.values()) {
			if(command.equals(Constant.Command.INVALID))
				break;
			commandVariations.put(command.toString(), command); //Add the default commands
			FileHandler fileHandler = new FileHandler("config/commands/"+command.toString()+".txt");
			fileHandler.createFileReader();
			try {
				//each line from the file, store it into the command variations.
				while((currentLine = fileHandler.getBufferedReader().readLine()) != null) {
					commandVariations.put(currentLine.toLowerCase() , command);
				}
			} catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	}
	
	public HashMap<String, Constant.Command> getCommandVariations(){
		return commandVariations;
	}
	
	public void addAction(String action) {
		actions.push(action);
	}
		
	//returns the most recent action
	public String getAction () {
		return actions.pop();
	}
	
	/**
	 * 
	 * @param task
	 * 			the new task which the user would like to add
	 * @param category
	 * 			the category type which the task falls under.
	 * @return True: if the task has been added successful
	 */
	public boolean addTask(Task task, String category) {
		task.setId(task_id);
		
		if(isNewCategory(category)) {
			ArrayList<Task> tasks = new ArrayList<Task>();
			tasks.add(task);
			categories.put(category, tasks);
			task_id++;
			return true;
		} else {
			if(categories.get(category).add(task)) {
				task_id++;
				return true;
			}
		}	
		
		return false;
	}
	
	private boolean isNewCategory(String categoryName) {
		return !categories.containsKey(categoryName);
	}
	
	//For the search function to iterate through the data I have so far by Tasks.
	public ArrayList<Task> getCache() {
		for(String key : categories.keySet()) {
			for(int i=0; i<categories.get(key).size(); i++) {
				cache.add(categories.get(key).get(i));
			}
		}
		
		return cache;
	}
	
	public ArrayList<Task> getCategory(String category) {
		return categories.get(category);
	}
	
	public boolean deleteTask(Task task) {
		for(String key : categories.keySet()) {
			for(int i=0; i<categories.get(key).size(); i++) {
				if(categories.get(key).get(i).getTaskId()==task.getTaskId()) {
					categories.get(key).remove(i);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean saveTasks() {
		FileHandler fileHandler = new FileHandler(".data/.tasks.txt");
		fileHandler.serializeData(categories);
		return true;
	}
	
	private void loadTasks() {
		FileHandler fileHandler = new FileHandler(".data/.tasks.txt");
		categories = (HashMap<String, ArrayList<Task>>)fileHandler.deserializeData();
	}
	
	
	public HashMap<String, ArrayList<Task>> getCategories() {
		return categories;
	}
	
}
