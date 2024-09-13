package com.uqai.capacitacion.controller;

import com.uqai.capacitacion.exceptions.CustomException;
import com.uqai.capacitacion.models.Invoice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping
    public int getInvoice() {
        var num = 0;
        try {
            num = 10;
            return num;
        } catch (Exception e) {
            log.error("", e);
            throw new CustomException("fallo con exito", HttpStatus.BAD_REQUEST, 400);
        }
    }
}
