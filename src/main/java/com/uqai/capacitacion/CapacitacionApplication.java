package com.uqai.capacitacion;

import java.util.Base64;

//@EnableAspectJAutoProxy // En nuevas versiones no es necesaria
//@SpringBootApplication
public class CapacitacionApplication {

    public static void main(String[] args) {
        // test code

        String obfuscated = "MTIzNEs1NkNrMDY=";
        String decoded = new String(Base64.getDecoder().decode(obfuscated));
        int otpLength = Integer.parseInt(decoded.substring(decoded.length() - 4, decoded.length() - 2));

        StringBuilder cleaned = new StringBuilder(decoded.substring(0, 1));
        for (int i = 1; i < decoded.length() - 4; i++) {
            if (i % 4 != 0) cleaned.append(decoded.charAt(i));
        }

        String cleanedString = cleaned.toString();
        String otp = cleanedString.substring(0, otpLength);

        System.out.println("Original: " + otp);



//        SpringApplication.run(CapacitacionApplication.class, args);
//        DecimalFormat decimalFormat = new DecimalFormat("#,00");
//
//        List<Double> numbers = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            numbers.add(Double.valueOf(decimalFormat.format(Math.random() * 10)));
//        }
//        System.out.println("Promedio final: " + average(numbers));

//        System.out.println("Esperanding..... " + compressFilePath());


//        System.out.println("--------------- " + FileUtils.getRepositoryFileName("/home/cristiancaceres/Documentos/Uqai Pruebas/thymeleaf-spring/temp", "ARCHIVITO.txt"));
    }

//    public static double average(List<Double> numbers) {
//        double sum = 0;
//        for (Double number : numbers) {
//            System.out.println("- " + number);
//            sum += number;
//        }
//        System.out.println("Suma total: " + sum);
//        return sum / numbers.size();
//    }

//    public static String compressFilePath() {
//        File temporalFolder = new File("/home/cris/Documentos/Projects/UQAI PRUEBAS/CAPACITACION/thymeleaf-spring/temp");
//        String initialFileName = 1234 + "_";
//        if (temporalFolder.isDirectory()) {
//            for (File file : Objects.requireNonNull(temporalFolder.listFiles())) {
//                if (file.getName().contains(initialFileName))
//                    return file.getName();
//            }
//        }
//        return "";
//    }

}
