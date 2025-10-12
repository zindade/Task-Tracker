package main.java.com.taskcli.command;

public class Command {

    private boolean useCommand;

    private void command(boolean useCommand){
        if(useCommand == true) {
            System.out.println("command activate");
        }else {
            System.out.println("command inactive");
        }
    }
}
