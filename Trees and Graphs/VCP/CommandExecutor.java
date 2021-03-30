package VCP;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * class containing methods to execute commands of the command prompt
 * 
 */
public class CommandExecutor {
	// attributes required for virtual command prompt
	private Directory rootDirectory = null;
	private Directory currentDirectory = null;
	private Directory foundDirectory = null;
	private String pathOfDirectories = "R:\\";  // given "R" as Root directory
	private List<Directory> listOfFoundDirectories = new ArrayList<Directory>();
	int horizontalSpace=0;
	
	
	/**
	 * creation of root directory at initialization
	 */
	public CommandExecutor () {
		rootDirectory = new Directory("R", new Date(), null,"R:\\");
		currentDirectory = rootDirectory;
		printDirectoryPath(rootDirectory);
		}
	
	/**
	 * method to create a new directory
	 */
	public void makeNewDirectory (String directoryName) {
		if(directoryName==null) {
			System.out.println("Incorrect syntax for mkdir !");
			printDirectoryPath(currentDirectory);
			return;
		}
		if(isDirectoryPresent(directoryName,currentDirectory)) {
			System.out.println("Directory already exist !");
		} else {
			Directory newDirectory = new Directory(directoryName, new Date(),currentDirectory, (currentDirectory.getDirectoryPath()+directoryName)+"\\");
			currentDirectory.addSubfolder(newDirectory);
			System.out.println("Command successfully executed at "+newDirectory.getCreationTime()+" .\n"+newDirectory.getDirectoryName()+" directory created in "+currentDirectory.getDirectoryName()+" !");
		}
		printDirectoryPath(currentDirectory);
	}

	/**
	 * method to change the current working directory
	 */
	public void changeDirectory(String directoryName) {
		if(directoryName==null) {
			System.out.println("Incorrect syntax for cd !");
			printDirectoryPath(currentDirectory);
			return;
		}
		if(isDirectoryPresent(directoryName,currentDirectory)) {
			currentDirectory = foundDirectory;
		} else {
			System.out.println("File not found in specified path !");
		}
		printDirectoryPath(currentDirectory);
	}
	
	/**
	 * method to set current working directory one step back
	 */
	public void getBackToParentDirectory () {
		if(currentDirectory.equals(rootDirectory)) {
			System.out.println("Already in root directory !");
		} else {
			currentDirectory = currentDirectory.getParentDirectory();
		}
		printDirectoryPath(currentDirectory);
	}
	
	public void listAllDirectories(Directory directory) {
		if(directory.getSubFolders().size()==0) {
			System.out.println("No directories in "+directory.getDirectoryName()+" !");
			return;
		} 
		for(Directory subDirectories : directory.getSubFolders()) {
			System.out.println(directory.getCreationTime()+"\t"+subDirectories.getDirectoryName());
		}
		System.out.println("\tTotal folders: "+directory.getSubFolders().size());
		printDirectoryPath(currentDirectory);
	}
	
	/**
	 * method to print the tree of the structure
	 */
	public void getTree(Directory directory) {
		if(directory.getSubFolders().size()==0) {
			System.out.println("No tree structure is there !");
			return;
		} else {
			printDirectoryTree(directory,"\u2500","\u251C");
		}
	}
	
	/*
	 * print tree structure of directory
	 */
	private void printDirectoryTree(Directory directory,String hiphen, String slash) {
		System.out.print(slash);
		for(int i=0; i<horizontalSpace;i++) 
			System.out.print("  ");
		horizontalSpace += directory.getSubFolders().size();
		
		if(directory.getSubFolders().size()==0) {
			horizontalSpace=0;
			return;
		} else {
			for(Directory val : directory.getSubFolders()) {
				System.out.println(slash+hiphen+val.getDirectoryName());
				printDirectoryTree(val,"\u2500","\u251C");
			}
		}
	}
	
	/**
	 * method to find a directory in list of directories
	 * @param string input as directory to be find
	 * @return directory found 
	 */
	public List<Directory> find(String directoryToBeFound) {
		if(directoryToBeFound==null) {
			System.out.println("Incorrect syntax for find !");
			return null;
		}
		List<Directory> listOfFoundDirectory = new ArrayList<Directory>();
		updateListOfDirectoriesFound(directoryToBeFound,rootDirectory);
		listOfFoundDirectory = listOfFoundDirectories;
		return listOfFoundDirectory;
	}
	/* 
	 * utility function to find directory in list
	 */
	private void updateListOfDirectoriesFound(String directoryName,Directory directory) {
		if((directoryName.equals(directory.getDirectoryName()))) {
			listOfFoundDirectories.add(directory);
		} else {
			for (Directory val : directory.getSubFolders()) {
				updateListOfDirectoriesFound(directoryName,val);
			}
		}
	}
	
	/**
	 * method finds if the particular directory is present or not
	 * @param String directory name to be searched
	 * @param Directory object from where searching is to be start
	 * @return true if directory is present otherwise return false
	 */
	private boolean isDirectoryPresent(String directoryName, Directory directoryToBeChecked) {
		for (Directory directory : directoryToBeChecked.getSubFolders()) {
			if(directoryName.equals(directory.getDirectoryName())){
				foundDirectory = directory;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return root directory
	 */
	public Directory getRootDirectory() {
		return rootDirectory;
	}
	
	/**
	 * @return current working directory
	 */
	public Directory getCurrentDirectory() {
		return currentDirectory;
	}

	/*
	 * print directory path
	 */
	public void printDirectoryPath (Directory directory) {
		if(directory.equals(rootDirectory)) {
			System.out.print(pathOfDirectories+">");
		} else {
			System.out.print(directory.getDirectoryPath()+">" );
		}
	}
	

}