package com.fortalsoft.grocery.service;

import com.fortalsoft.grocery.dto.DepartmentDTO;
import com.fortalsoft.grocery.dto.ProductDTO;
import com.fortalsoft.grocery.entity.Department;
import com.fortalsoft.grocery.entity.Product;
import com.fortalsoft.grocery.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentService extends GenericService<Department, DepartmentDTO> {

    private DepartmentRepository repository;

    @Autowired
    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public DepartmentDTO mapperEntityToDTO(Department department) {
        return new DepartmentDTO(department.getId(), department.getName());
    }

    @Override
    void mapperDTOToEntity(Department department, DepartmentDTO entityDTO) {
        department.setName(entityDTO.getName());
    }

    @Override
    Department createEntity() {
        return new Department();
    }

    @Override
    JpaRepository getRepository() {
        return this.repository;
    }
}
