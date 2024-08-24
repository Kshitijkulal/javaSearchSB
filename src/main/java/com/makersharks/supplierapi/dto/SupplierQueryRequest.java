package com.makersharks.supplierapi.dto;

import com.makersharks.supplierapi.entity.Supplier;
import lombok.Data;

import java.util.Set;

@Data
public class SupplierQueryRequest {
    private String location;
    private Supplier.NatureOfBusiness natureOfBusiness;
    private Set<Supplier.ManufacturingProcess> manufacturingProcesses;
    private int page = 0; // default page number
    private int size = 10; // default page size
}
