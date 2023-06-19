package com.cerberobeta.StoreWize.repository;

import com.cerberobeta.StoreWize.entities.carts.CartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartsRepository extends JpaRepository<CartsEntity, Long> {

}
