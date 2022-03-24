package practice.hospital;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] temperatures = new float[patientsCount];
        float min = 32F;
        float max = 40F;
        for (int indexOfArray = 0; indexOfArray < temperatures.length; indexOfArray++) {
            Random temperature = new Random();
            temperatures[indexOfArray] = min + temperature.nextFloat() * (max - min);
        }
        return temperatures;
    }

    public static String getReport(float[] temperatureData) {
        float averageTemperature = 0;
        float minimalTemp = 36.2F;
        float maximalTemp = 36.9F;
        int healthy = 0;
        for (int indexOfArray = 0; indexOfArray < temperatureData.length; indexOfArray++) {
            averageTemperature = averageTemperature + temperatureData[indexOfArray];
            if (temperatureData[indexOfArray] >= minimalTemp && temperatureData[indexOfArray] <= maximalTemp) {
                healthy = healthy + 1;
            }
        }
        averageTemperature = averageTemperature / temperatureData.length;
        String formattedDouble = new DecimalFormat("#0.00").format(averageTemperature);
        String report =
                "Температуры пациентов: " + Arrays.toString(temperatureData).replaceAll("[\\[,\\]]", "") +
                        "\nСредняя температура: " + formattedDouble +
                        "\nКоличество здоровых: " + healthy;

        return report;
    }
}