//Deep Programming (2021) Near Me | Firebase, Google Map, Place & Direction API's | Intro & Setup Project Android Java source code (Version 1.0) [Source code]. https://www.youtube.com/watch?v=dfTzz5AhBNQ&list=PLpQFhyCcxiCqDFYQabluYIYsNSsCFMNFk&index=1
package com.example.capeguide.Constant;

import com.example.capeguide.PlaceModel;
import com.example.capeguide.R;
import java.util.ArrayList;
import java.util.Arrays;

public interface AllConstant {

    int STORAGE_REQUEST_CODE = 1000;
    int LOCATION_REQUEST_CODE = 2000;
    String IMAGE_PATH = "/Profile/image_profile.jpg";

    ArrayList<PlaceModel> placesName = new ArrayList<>(
            Arrays.asList(
                    new PlaceModel(1, R.drawable.ic_restaurant,"Restaurant", "restaurant"),
                    new PlaceModel(2, R.drawable.ic_atm, "ATM", "atm"),
                    new PlaceModel(3, R.drawable.ic_gas_station, "Gas", "gas_station"),
                    new PlaceModel(4, R.drawable.ic_shopping_cart, "Groceries", "supermarket"),
                    new PlaceModel(5, R.drawable.ic_hotel, "Hotels", "hotel"),
                    new PlaceModel(6, R.drawable.ic_pharmacy, "Pharmacies", "pharmacy"),
                    new PlaceModel(7, R.drawable.ic_hospital, "Hospitals & Clinics", "hospital"),
                    new PlaceModel(8, R.drawable.ic_car_wash, "Car Wash", "car_wash"),
                    new PlaceModel(9, R.drawable.ic_saloon, "Beauty Salons", "beauty_salon")
            )
    );
}

