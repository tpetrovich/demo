package com.example.demo.controller;

import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/demo/invoices")
public class InvoiceController {
    @Resource
    private InvoiceService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Invoice invoice){
        return ResponseEntity.ok().body(service.add(invoice));
    }

    @GetMapping("/list")
    private ResponseEntity<?> list(){
        return ResponseEntity.ok().body(service.list());
    }
}
