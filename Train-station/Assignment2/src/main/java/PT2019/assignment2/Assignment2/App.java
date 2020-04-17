package PT2019.assignment2.Assignment2;

import PT2019.assignment2.Assignment2.controller.Controller;
import PT2019.assignment2.Assignment2.view.View;

public class App 
{
    public static void main( String[] args )
    {
    	View view = new View();
    	//view.getNumberOfQueues(3);
    	//Manager model = new Manager(numberOfClients, 3, 300);
    	Controller controller = new Controller(view);
    	view.setVisible(true);
    }
}
