package com.makersharks.supplierapi;

import com.makersharks.supplierapi.entity.Supplier;
import com.makersharks.supplierapi.repository.SupplierRepository;
import com.makersharks.supplierapi.service.SupplierService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SupplierServiceTests {

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierService supplierService;

    @Test
    public void testFindSuppliers() {
        Supplier supplier = new Supplier();
        supplier.setCompanyName("ABC Manufacturing");
        supplier.setLocation("India");
        supplier.setNatureOfBusiness(Supplier.NatureOfBusiness.SMALL_SCALE);
        supplier.setManufacturingProcesses(Collections.singleton(Supplier.ManufacturingProcess._3D_PRINTING));

        when(supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesIn(
                "India", Supplier.NatureOfBusiness.SMALL_SCALE, Collections.singleton(Supplier.ManufacturingProcess._3D_PRINTING)
        )).thenReturn(List.of(supplier));

        List<Supplier> result = supplierService.findSuppliers("India", Supplier.NatureOfBusiness.SMALL_SCALE, 
                Collections.singleton(Supplier.ManufacturingProcess._3D_PRINTING), 0, 10);

        assertEquals(1, result.size());
        assertEquals("ABC Manufacturing", result.get(0).getCompany
