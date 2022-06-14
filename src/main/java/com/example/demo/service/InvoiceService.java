package com.example.demo.service;

import com.example.demo.dto.InvoiceDTO;
import com.example.demo.model.Invoice;

import java.util.List;

public interface InvoiceService {
    InvoiceDTO add(Invoice invoice);

    InvoiceDTO update(Invoice invoice);

    void delete(Long id);

    InvoiceDTO detail(Long id);

    List<InvoiceDTO> list();
}
