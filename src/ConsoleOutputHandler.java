public class ConsoleOutputHandler implements OutputHandler{
    @Override
    public void displayMessage(String message){
        System.out.println(message);
    }
}
