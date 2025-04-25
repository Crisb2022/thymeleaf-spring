package com.uqai.capacitacion.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalExampleUtils {

    // Proceso TakaTaka
//    public static String obtenerIpRemota(Map<String, String> httpHeaders, String remoteAddr) {
//        String ip = obtainXforwardedForHeaderIp(httpHeaders);
//        ip = obtainHeaderRemoteIp(httpHeaders, ip);
//
//        if (ip == null) {
//            ip = remoteAddr;
//        } else {
//            ip = ip.split(",")[0];
//        }
//
//        if (ip == null || ip.trim().isEmpty()) {
//            throw new RuntimeException("No se ha podido determinar la ip del terminal");
//        }
//
//        return ip;
//    }

//    private static String obtainXforwardedForHeaderIp(Map<String, String> httpHeaders) {
//        return httpHeaders.getOrDefault("X-Forwarded-For", null);
//    }
//
//    private static String obtainHeaderRemoteIp(Map<String, String> httpHeaders, String ip) {
//        if (ip == null) {
//            return httpHeaders.getOrDefault("X-Internal-Forwarded-For", null);
//        }
//        return ip;
//    }

    // Refactor Optional
    public static String obtenerIpRemota(Map<String, String> httpHeaders, String remoteAddr) {
        return obtainXforwardedForHeaderIp(httpHeaders)
                .map(ip -> ip.split(",")[0].trim())
                .filter(ip -> !ip.isEmpty())
                .orElse(remoteAddr);
    }

    private static Optional<String> obtainXforwardedForHeaderIp(Map<String, String> httpHeaders) {
        return Optional.ofNullable(httpHeaders.get("X-Forwarded-For")).or(() -> Optional.ofNullable(httpHeaders.get("X-Internal-Forwarded-For")));
    }

    // Clase principal para pruebas
    public static void main(String[] args) {
        Map<String, String> headers = new HashMap<>();

        headers.put("X-Forwarded-For", "192.168.1.100, proxy1, proxy2");

        String remoteAddr = "10.0.0.1";

        try {
            String ip = obtenerIpRemota(headers, remoteAddr);
            System.out.println("IP obtenida: " + ip);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        headers.clear();

        try {
            String ip = obtenerIpRemota(headers, remoteAddr);
            System.out.println("IP obtenida: " + ip);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
