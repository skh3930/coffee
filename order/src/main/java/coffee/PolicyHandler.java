package coffee;

import coffee.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderWaited_UpdateStatus(@Payload OrderWaited orderWaited){

        if(orderWaited.isMe()){
            System.out.println("##### listener UpdateStatus : " + orderWaited.toJson());
            System.out.println();
            System.out.println();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCompleted_UpdateStatus(@Payload DeliveryCompleted deliveryCompleted){

        if(deliveryCompleted.isMe()){
            System.out.println("##### listener UpdateStatus : " + deliveryCompleted.toJson());
            System.out.println();
            System.out.println();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderReceived_UpdateStatus(@Payload OrderReceived orderReceived){

        if(orderReceived.isMe()){
            System.out.println("##### listener UpdateStatus : " + orderReceived.toJson());
            System.out.println();
            System.out.println();
        }
    }
}
