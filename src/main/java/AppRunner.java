import config.ConnectionFactory;
import dao.CarDaoImpl;
import model.Car;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AppRunner {
    public static void main(String[] args) throws SQLException {
        CarDaoImpl carDao = new CarDaoImpl();
        Car car = carDao.findById(5902);
        System.out.println(car);

        List<Car> cars = carDao.findAll();
        for(int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }

        Car car1 = new Car();
        car1.setId(5902);
        car1.setColor("Pink");
        carDao.update(car1);

        Car car2 = new Car();
        car2.setId(9801);
        car2.setMake("Toyota");
        car2.setModel("Prius");
        car2.setYearOfCar(1990);
        car2.setColor("blue");
        car2.setVin("PO1234N");
        carDao.create(car2);

        carDao.delete(3679);
    }
}
