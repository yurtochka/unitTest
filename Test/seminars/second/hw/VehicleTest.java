package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        car = new Car("Dodge", "Ram", 2010);
        motorcycle = new Motorcycle("Kawasaki", "Ninja", 2022);
    }


    /**
     * 1. Проверить, что экземпляр объекта Car также является экземпляром транспортного средства (используя оператор instanceof).
     */
    @Test
    public void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }


    /**
     * 2. Проверить, что объект Car создается с 4-мя колесами.
     */
    @Test
    public void testCarIsFourWheels(){
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    /**
     * 3. Проверить, что объект Motorcycle создается с 2-мя колесами.
     */
    @Test
    public void testMotorcycleIsSecondWheels(){
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }


    /**
     * 4. Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).
     */
    @Test
    public void testCarDrivSpeed(){
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    /**
     * 5. Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод testDrive()).
     */
    @Test
    public void testMotorcycleDriveSpeed(){
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    /**
     * 6. Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
     * машина останавливается (speed = 0).
    */
    @Test
    public void testCarParkIsStop(){
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    /**
     * 7. Проверить, что в режиме парковки (сначала testDrive, потом park,
     * т.е. эмуляция движения транспорта) мотоцикл останавливается (speed = 0).
     */
    @Test
    public void testMotorcycleParkIsStop(){
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}