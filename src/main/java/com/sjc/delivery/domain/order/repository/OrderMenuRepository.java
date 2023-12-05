package com.sjc.delivery.domain.order.repository;

import com.sjc.delivery.domain.order.entity.OrderMenu;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMenuRepository extends JpaRepository<OrderMenu, Long> {

    Optional<OrderMenu> findFirstByUserIdAndIsDeleted(Long userId, Boolean isDeleted);

    @Query(value = "Update OrderMenu m set m.isDeleted = true WHERE m.user_id = :userId", nativeQuery = true)
    int updateByUserId(@Param("userId") Long userId);

    List<OrderMenu> findByUserIdAndIsDeleted(Long userId, Boolean isDeleted);

    @Query(value = "Update OrderMenu m set m.isDeleted = true, order_id = :orderId WHERE m.user_id = :userId", nativeQuery = true)
    int updateOrderByUserId(@Param("orderId") Long orderId, @Param("userId") Long userId);
}
