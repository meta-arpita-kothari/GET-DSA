package VCP;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * class containing attribute of a directory
 * 
 */
public class Directory {
	
	private String directoryName;
	private Date creationTime;
	private List<Directory> subFoldersList = new LinkedList<Directory>();
	Directory parentDirectory;
	String directoryPath="";
	
	public Directory (String directoryName, Date creationTime, Directory parentDirectory, String directoryPath) {
		this.directoryName = directoryName;
		this.creationTime = creationTime;
		this.parentDirectory = parentDirectory;
		this.directoryPath = directoryPath;
	}
	
	/**
	 * method to get name of directory
	 */
	public String getDirectoryName() {
		return directoryName;
	}

	/**
	 * method to get creation time of the directory
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * method to obtain list of sub-folders
	 */
	public List<Directory> getSubFolders() {
		return subFoldersList;
	}

	/**
	 * method to get parent node of the directory
	 */
	public Directory getParentDirectory() {
		return parentDirectory;
	}
	
	/**
	 * method to add a sub-folder in list of sub-folders of the current directory
	 */
	public void addSubfolder(Directory subfolder) {
		subFoldersList.add(subfolder);
	}

	/**
	 * @return directory path
	 */
	public String getDirectoryPath() {
		return directoryPath;
	}
	
}
