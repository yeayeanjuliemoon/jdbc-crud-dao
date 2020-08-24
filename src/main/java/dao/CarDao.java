package dao;

import model.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarDao {
    public Car findById(int id) throws SQLException;
    public List<Car> findAll() throws SQLException;
    public Car update(Car dto) throws SQLException;
    public Car create(Car dto) throws SQLException;
    public void delete(int id) throws SQLException;
}
