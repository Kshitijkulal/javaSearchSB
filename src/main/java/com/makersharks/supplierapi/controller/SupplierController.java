package com.makersharks.supplierapi.controller;

import com.makersharks.supplierapi.dto.SupplierQueryRequest;
import com.makersharks.supplierapi.entity.Supplier;
import com.makersharks.supplierapi.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<List<Supplier>> querySuppliers(@RequestBody SupplierQueryRequest request) {
        List<Supplier> suppliers = supplierService.findSuppliers(
                request.getLocation(),
                request.getNatureOfBusiness(),
                request.getManufacturingProcesses(),
                request.getPage(),
                request.getSize());

        return ResponseEntity.ok(suppliers);
    }
}

