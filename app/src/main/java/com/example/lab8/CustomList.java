package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    public void addCity(City city){
    cities.add(city);
    }

    /**
     *
     * @return
     */
    public List getCities() {
        List list  = cities;
        Collections.sort(list);
        return list;
    }

    /**
     *
     * @param city
     * @return
     */
    public boolean hasCity(City city){
        if (cities.contains(city)){
            return true;

        } else {
            return false;
        }
    }

    /**
     *
     * @param city
     * @throws IllegalAccessException
     */
    public void deleteCity(City city) throws IllegalAccessException {
        if (cities.contains(city)){
            cities.remove(city);
        } else {
            throw new IllegalAccessException();
        }
    }
    /**
     *
     * @return
     */
    public int countCities() {
        return cities.size();
    }



}
