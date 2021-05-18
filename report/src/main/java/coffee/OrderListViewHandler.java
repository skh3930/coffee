package coffee;

import coffee.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderListViewHandler {


    @Autowired
    private OrderListRepository orderListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {

            if (ordered.isMe()) {
                // view 객체 생성
                OrderList orderList = new OrderList();
                // view 객체에 이벤트의 Value 를 set 함
                orderList.setOrderId(ordered.getId());
                orderList.setCustomerId(ordered.getCustomerId());
                orderList.setProductId(ordered.getProductId());
                // view 레파지 토리에 save
                orderListRepository.save(orderList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderWaited_then_UPDATE_1(@Payload OrderWaited orderWaited) {
        try {
            if (orderWaited.isMe()) {
                // view 객체 조회
                List<OrderList> orderListList = orderListRepository.findByOrderId(orderWaited.getOrderId());
                for(OrderList orderList : orderListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderList.setDeliveryId(orderWaited.getId());
                    orderList.setStatus(orderWaited.getStatus());
                    // view 레파지 토리에 save
                    orderListRepository.save(orderList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderReceived_then_UPDATE_2(@Payload OrderReceived orderReceived) {
        try {
            if (orderReceived.isMe()) {
                // view 객체 조회
                List<OrderList> orderListList = orderListRepository.findByOrderId(orderReceived.getOrderId());
                for(OrderList orderList : orderListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderList.setStatus(orderReceived.getStatus());
                    // view 레파지 토리에 save
                    orderListRepository.save(orderList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCompleted_then_UPDATE_3(@Payload DeliveryCompleted deliveryCompleted) {
        try {
            if (deliveryCompleted.isMe()) {
                // view 객체 조회
                List<OrderList> orderListList = orderListRepository.findByOrderId(deliveryCompleted.getOrderId());
                for(OrderList orderList : orderListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderList.setStatus(deliveryCompleted.getStatus());
                    // view 레파지 토리에 save
                    orderListRepository.save(orderList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenStatusUpdated_then_UPDATE_4(@Payload StatusUpdated statusUpdated) {
        try {
            if (statusUpdated.isMe()) {
                // view 객체 조회
                List<OrderList> orderListList = orderListRepository.findByOrderId(statusUpdated.getOrderId());
                for(OrderList orderList : orderListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderList.setDeliveryId(statusUpdated.getId());
                    orderList.setStatus(statusUpdated.getStatus());
                    // view 레파지 토리에 save
                    orderListRepository.save(orderList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}