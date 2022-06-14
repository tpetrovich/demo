package com.example.demo.service.implementation;

import com.example.demo.dto.InvoiceDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Invoice;
import com.example.demo.model.InvoiceItem;
import com.example.demo.repo.InvoiceRepo;
import com.example.demo.service.InvoiceService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceRepo repo;

    private ModelMapper mapper = new ModelMapper();
    public InvoiceServiceImpl(InvoiceRepo repo) {
        this.repo = repo;
    }

    @Override
    public InvoiceDTO add(Invoice invoice) {
        Float total = 0f;
        for (InvoiceItem invoiceItem : invoice.getInvoiceItems()){
            invoiceItem.setInvoice(invoice);
            total = total + (invoiceItem.getQuantity() * invoiceItem.getProduct().getSalePrice());
        }
        invoice.setTotal(total);
        return mapper.map(repo.save(invoice), InvoiceDTO.class);
    }

    @Override
    public InvoiceDTO update(Invoice invoice) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public InvoiceDTO detail(Long id) {
        return null;
    }

    @Override
    public List<InvoiceDTO> list() {
        return mapper.map(repo.findAll(), new TypeToken<List<InvoiceDTO>>() {}.getType());
    }
}
