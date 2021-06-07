package demo.queue;

import com.microsoft.azure.servicebus.ReceiveMode;
import com.microsoft.azure.servicebus.SubscriptionClient;
import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionClientFactory {

    @Value("${TOPIC_NAME}")
    String topicName;

    @Value("${SUBSCRIPTION_NAME}")
    String subscriptionName;

    @Value("${CONNECTION_STRING}")
    String connectionString;

    public SubscriptionClient getSubscriptionClient() throws ServiceBusException, InterruptedException {
        String entityPath = String.format("%s/subscriptions/%s", topicName, subscriptionName);

        ConnectionStringBuilder stringBuilder = new ConnectionStringBuilder(connectionString, entityPath);
        return new SubscriptionClient(stringBuilder, ReceiveMode.PEEKLOCK);
    }
}
