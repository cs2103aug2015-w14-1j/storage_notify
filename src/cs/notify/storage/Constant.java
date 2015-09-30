package cs.notify.storage;

public class Constant {
    private static String[] commandFile = new String[]{"CREATE.txt", "DONE.txt", "DELETE.txt", "EXIT.txt", "REDO.txt", "SEARCH.txt", "UPDATE.txt", "UNDO.txt", "BLOCK.txt"}; 
    public static enum Command { CREATE, UPDATE, DELETE, SEARCH, BLOCK, UNDO, REDO, DONE, EXIT, INVALID };
}