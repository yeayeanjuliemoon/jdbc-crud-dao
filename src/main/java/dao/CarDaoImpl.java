package dao;

import config.ConnectionFactory;
import model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao{

    Connection connection = ConnectionFactory.getConnection();

    public Car findById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Car WHERE id=" + id);
        return extractCarFromResultSet(resultSet);
    }

    public List<Car> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Car");
        List<Car> cars = new ArrayList<>();

        while(resultSet.next()) {
            Car car = extractCarFromResultSet(resultSet);
            cars.add(car);
        }
        return cars;

    }

    public Car update(Car dto) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Car SET color=? WHERE id=?");
        preparedStatement.setString(1, dto.getColor());
        preparedStatement.setInt(2, dto.getId());

        preparedStatement.executeUpdate();
        return dto;
    }

    public Car create(Car dto) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Car (id, make, model, yearOfCar, color, vin) VALUES (?, ?, ?, ?, ?, ?)");

        preparedStatement.setInt(1, dto.getId());
        preparedStatement.setString(2, dto.getMake());
        preparedStatement.setString(3, dto.getModel());
        preparedStatement.setInt(4, dto.getYearOfCar());
        preparedStatement.setString(5, dto.getColor());
        preparedStatement.setString(6, dto.getVin());

        preparedStatement.executeUpdate();
        return dto;
    }

    public void delete(int id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM Car WHERE id=" + id);
    }

    public Car extractCarFromResultSet(ResultSet resultSet) throws SQLException {
        if(resultSet.next()) {
            Car car = new Car();
            car.setId( resultSet.getInt("id") );
            car.setMake( resultSet.getString("make") );
            car.setModel( resultSet.getString("model") );
            car.setColor( resultSet.getString("color") );
            car.setYearOfCar(resultSet.getInt("yearOfCar"));
            car.setVin(resultSet.getString("vin"));
            return car;
        }
        return null;
    }
}
