package com.fortalsoft.grocery.controller;

import com.fortalsoft.grocery.dto.DepartmentDTO;
import com.fortalsoft.grocery.dto.ProductDTO;
import com.fortalsoft.grocery.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentService service;

    @Autowired
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Collection<DepartmentDTO>> list() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> get(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> update(@PathVariable UUID id, @RequestBody DepartmentDTO departmentDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, departmentDTO));
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> save(@RequestBody DepartmentDTO departmentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(departmentDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
