package repository;

import entiter.Subscriber;

public class SubscriberCRUD implements CrudOperations<Subscriber> {
    private final Connection connection;

    public SubscriberCRUD(Connection connection) {
        this.connection = connection;
}
    @Override
    public List<Subscriber> findAll() {
        List<Subscriber> subscribers = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Subscribers\";")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Subscriber subscriber = new Subscriber(id, name, sex);
                subscribers.add(subscriber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscribers;
    }
}