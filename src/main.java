import entiter.Author;
import entiter.book;
import entiter.subscriber;
import repository.authorCRUD;
import repository.bookCRUD;
import repository.SubscriberCRUD;


public class Main {
     DatabaseConnectionManager connectionManager = new DatabaseConnectionManager();
        try (Connection connection = connectionManager.getConnection()) {
            SubscriberCrudOperations subscriberCrudOperations = new SubscriberCrudOperations(connection);
            if (connection != null) {
                // Find all subscribers
                List<Subscriber> allSubscribers = subscriberCrudOperations.findAll();
                System.out.println("All Subscribers:");
                for (Subscriber subscriber : allSubscribers) {
                    System.out.println(subscriber.toString());
                }
             }
            else {
                System.out.println("connection failed.");
            }
        } catch (SQLException e) {
            System.err.println("An error : " + e.getMessage());
            System.out.println("try again .");
        }       
}

}