package com.uqai.capacitacion;

import java.io.File;
import java.util.List;
import java.util.Objects;

//@EnableAspectJAutoProxy // En nuevas versiones no es necesaria
//@SpringBootApplication
public class CapacitacionApplication {

    public static void main(String[] args) {
//		SpringApplication.run(CapacitacionApplication.class, args);
//        DecimalFormat decimalFormat = new DecimalFormat("#,00");
//
//        List<Double> numbers = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            numbers.add(Double.valueOf(decimalFormat.format(Math.random() * 10)));
//        }
//        System.out.println("Promedio final: " + average(numbers));

        System.out.println("Esperanding..... " + compressFilePath());
    }

    public static double average(List<Double> numbers) {
        double sum = 0;
        for (Double number : numbers) {
            System.out.println("- " + number);
            sum += number;
        }
        System.out.println("Suma total: " + sum);
        return sum / numbers.size();
    }

    public static String compressFilePath() {
        File temporalFolder = new File("/home/cris/Documentos/Projects/UQAI PRUEBAS/CAPACITACION/thymeleaf-spring/temp");
        String initialFileName = 1234 + "_";
        if (temporalFolder.isDirectory()) {
            for (File file : Objects.requireNonNull(temporalFolder.listFiles())) {
                if (file.getName().contains(initialFileName))
                    return file.getName();
            }
        }
        return "";
    }

}
