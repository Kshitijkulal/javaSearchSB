package com.makersharks.supplierapi.service;

import com.makersharks.supplierapi.entity.Supplier;
import com.makersharks.supplierapi.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> findSuppliers(String location, Supplier.NatureOfBusiness natureOfBusiness,
                                        Set<Supplier.ManufacturingProcess> processes, int page, int size) {
        return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesIn(
                location, natureOfBusiness, processes);
    }
}
