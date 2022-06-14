package com.example.demo.service.implementation;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo repo;

    private ModelMapper mapper = new ModelMapper();

    public ProductServiceImpl(ProductRepo repo) {
        this.repo = repo;
    }

    @Override
    public ProductDTO add(Product product) {
        return mapper.map(repo.save(product), ProductDTO.class);
    }

    @Override
    public ProductDTO update(Product product) {
        return mapper.map(repo.save(product), ProductDTO.class);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public ProductDTO detail(Long id) {
        return mapper.map(repo.findById(id).get(), ProductDTO.class);
    }

    @Override
    public List<ProductDTO> list() {
        return mapper.map(repo.findAll(), new TypeToken<List<ProductDTO>>() {}.getType());
    }
}
