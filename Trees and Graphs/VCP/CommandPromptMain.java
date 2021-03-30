package VCP;


import java.util.List;
import java.util.Scanner;

/**
 * class containing main method
 * 
 */
public class CommandPromptMain {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		CommandExecutor commandExecutor = new CommandExecutor();
		boolean flag = true;
		while (flag) {
			// input command
			String input = scan.nextLine();
			String separatedString[] = input.split(" ");
			// first word is command
			String inputCommand = separatedString[0];
			// second word is argument or directiry name
			String argument=null;
			if (separatedString.length >1){
				argument = separatedString[1];
			}
			
			// check command exists or not
			Commands command= getCommandFromEnum(inputCommand);
			if(command == null) {
				System.out.println("Command does not exist !");
				commandExecutor.printDirectoryPath(commandExecutor.getCurrentDirectory());
			} 
			else {
				switch (command) {
				case mkdir:
					commandExecutor.makeNewDirectory(argument);
					break;
				case cd:
					commandExecutor.changeDirectory (argument);
					break;
				case bk:
					commandExecutor.getBackToParentDirectory();
					break;
				case ls:
					commandExecutor.listAllDirectories(commandExecutor.getCurrentDirectory());
					break;
				case find:
					List<Directory> list = commandExecutor.find(argument);
					if(list.size()==0) {
						System.out.println("No directory found !");
					} else {
						for(Directory value : list) {
							System.out.println(value.getDirectoryName()+"\t----"+value.getCreationTime()+"\nLocation: "+value.directoryPath+"\n");
						}
					}
					commandExecutor.printDirectoryPath(commandExecutor.getCurrentDirectory());
					break;
				case tree:
					commandExecutor.getTree(commandExecutor.getRootDirectory());
					System.out.println();
					commandExecutor.printDirectoryPath(commandExecutor.getCurrentDirectory());
					break;
				case exit:
					System.out.println("\nExiting from console.....");
					flag = false;
					break;
		
				default:
					System.out.println("Command does not exist!");
					break;
			  } 
			}
			
		}
	}
	
	
	/**
	 * method to return enum value of command entered
	 * @param commandEntered as String
	 * @return Commands Enum value
	 */
	private static Commands getCommandFromEnum(String commandEntered) {
		Commands commandObtained = null ;
		for(Commands command : Commands.values()) {
			if(command.toString().equals(commandEntered)) {
				commandObtained = command;
				break;
			}
		}
		return commandObtained;
	}
}