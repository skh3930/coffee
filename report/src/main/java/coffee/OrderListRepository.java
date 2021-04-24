package coffee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderListRepository extends CrudRepository<OrderList, Long> {

    List<OrderList> findByOrderId(Long orderId);

}