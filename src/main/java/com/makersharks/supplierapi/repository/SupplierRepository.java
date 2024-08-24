package com.makersharks.supplierapi.repository;

import com.makersharks.supplierapi.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    List<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcessesIn(
            String location,
            Supplier.NatureOfBusiness natureOfBusiness,
            Set<Supplier.ManufacturingProcess> processes);
}
