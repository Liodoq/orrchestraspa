package com.gabriel.emplms.repository;
import com.gabriel.emplms.entity.BookingData;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookingDataRepository extends JpaRepository<BookingData,Integer>{
    
}
