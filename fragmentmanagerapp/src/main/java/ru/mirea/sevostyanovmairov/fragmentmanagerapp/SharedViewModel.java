package ru.mirea.sevostyanovmairov.fragmentmanagerapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<String> selectedCountry = new MutableLiveData<>();
    private final MutableLiveData<String> countryDetails = new MutableLiveData<>();

    public void selectCountry(String country) {
        selectedCountry.setValue(country);
        
        switch (country) {
            case "Russia":
                countryDetails.setValue(
                    "Capital: Moscow\n" +
                    "Population: 144.1 million\n" +
                    "Area: 17,098,246 km²\n" +
                    "Language: Russian\n" +
                    "Currency: Russian Ruble (RUB)\n" +
                    "Government: Federal semi-presidential republic"
                );
                break;
            case "USA":
                countryDetails.setValue(
                    "Capital: Washington, D.C.\n" +
                    "Population: 331.9 million\n" +
                    "Area: 9,833,517 km²\n" +
                    "Language: English\n" +
                    "Currency: United States Dollar (USD)\n" +
                    "Government: Federal presidential republic"
                );
                break;
            case "China":
                countryDetails.setValue(
                    "Capital: Beijing\n" +
                    "Population: 1.4 billion\n" +
                    "Area: 9,596,961 km²\n" +
                    "Language: Mandarin Chinese\n" +
                    "Currency: Renminbi (Yuan)\n" +
                    "Government: Unitary one-party socialist republic"
                );
                break;
            case "Japan":
                countryDetails.setValue(
                    "Capital: Tokyo\n" +
                    "Population: 125.7 million\n" +
                    "Area: 377,975 km²\n" +
                    "Language: Japanese\n" +
                    "Currency: Japanese Yen (JPY)\n" +
                    "Government: Unitary parliamentary constitutional monarchy"
                );
                break;
            case "Germany":
                countryDetails.setValue(
                    "Capital: Berlin\n" +
                    "Population: 83.2 million\n" +
                    "Area: 357,022 km²\n" +
                    "Language: German\n" +
                    "Currency: Euro (EUR)\n" +
                    "Government: Federal parliamentary republic"
                );
                break;
            case "France":
                countryDetails.setValue(
                    "Capital: Paris\n" +
                    "Population: 67.4 million\n" +
                    "Area: 551,695 km²\n" +
                    "Language: French\n" +
                    "Currency: Euro (EUR)\n" +
                    "Government: Unitary semi-presidential republic"
                );
                break;
            default:
                countryDetails.setValue("No details available for this country");
        }
    }

    public LiveData<String> getSelectedCountry() {
        return selectedCountry;
    }

    public LiveData<String> getCountryDetails() {
        return countryDetails;
    }
} 