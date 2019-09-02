package by.itstep.karnei.service;

import by.itstep.karnei.domain.Car;
import by.itstep.karnei.repositiry.CarRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {

    @Autowired
    CarService carService;

    @MockBean
    CarRepo carRepo;

    Car carOne;
    Car carTwo;
    Car carThree;

    @Before
    public void setUp() {
        carOne = new Car();
        carOne.setMark("VW");
        carOne.setModel("Polo");
        carOne.setColor("red");
        carOne.setVin("12543658452136529");
        carOne.setDeleted(false);
        carTwo = new Car();
        carTwo.setMark("Audi");
        carTwo.setModel("A8");
        carTwo.setColor("black");
        carTwo.setVin("1254dfgt12h58mj25");
        carOne.setDeleted(false);

        carThree = new Car();
        carThree.setMark("Opel");
        carThree.setModel("Vectra");
        carThree.setColor("blue");
        carThree.setVin("2554dfg672h58mj10");
        carThree.setDeleted(false);
    }

    @Test
    public void saveCarPositiveTest() {
        Mockito.when(carRepo.findByVin(carOne.getVin())).thenReturn(null);
        boolean isSave = carService.saveCar(carOne);
        Assert.assertTrue(isSave);
    }

    @Test(expected = AssertionError.class)
    public void saveCarNegativeTest() {
        Mockito.when(carRepo.findByVin(carOne.getVin())).thenReturn(null);
        boolean isSave = carService.saveCar(carOne);
        Assert.assertFalse(isSave);
    }

    @Test
    public void getAll() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void repareCar() {
    }
}