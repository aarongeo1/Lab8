package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() throws IllegalAccessException {
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertEquals(true,list.hasCity(city));
        City city1 = new City("toronto", "Ontario");
        assertEquals(false,list.hasCity(city1));
    }

    @Test
    void testDeleteCity() throws IllegalAccessException {
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertEquals(1, list.getCities().size());
        list.deleteCity(city);
        assertEquals(0, list.getCities().size());
    }

    @Test
    void testCountCities() throws IllegalAccessException {
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        list.add(city);
        assertEquals(1, list.countCities());
    }

}
