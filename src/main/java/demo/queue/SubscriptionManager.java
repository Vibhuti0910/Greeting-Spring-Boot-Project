package demo.queue;

import com.microsoft.azure.servicebus.MessageHandlerOptions;
import com.microsoft.azure.servicebus.SubscriptionClient;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import demo.model.GreetingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class SubscriptionManager {

    @Autowired
    GreetingData data;

    @Autowired
    SubscriptionClientFactory clientFactory;

    public void subscribeGreetingsEvent() throws ServiceBusException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        SubscriptionClient subscriptionClient = clientFactory.getSubscriptionClient();
        MessageHandler handler = new MessageHandler(subscriptionClient, data);
        MessageHandlerOptions options = new MessageHandlerOptions(3,false, Duration.ofMinutes(1L));

        subscriptionClient.registerMessageHandler(handler, options, executorService);
    }
}
