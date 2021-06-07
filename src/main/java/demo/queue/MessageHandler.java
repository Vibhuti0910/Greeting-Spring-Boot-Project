package demo.queue;

import com.microsoft.azure.servicebus.ExceptionPhase;
import com.microsoft.azure.servicebus.IMessage;
import com.microsoft.azure.servicebus.IMessageHandler;
import com.microsoft.azure.servicebus.SubscriptionClient;
import demo.model.GreetingData;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

public class MessageHandler implements IMessageHandler {

    SubscriptionClient receiveClient;

    GreetingData data;

    MessageHandler(SubscriptionClient client, GreetingData data) {
        this.receiveClient = client;
        this.data = data;
    }

    @Override
    public CompletableFuture<Void> onMessageAsync(IMessage message) {
        byte[] body = message.getBody();
        String messageBody = new String(body, StandardCharsets.UTF_8);
        System.out.println("Received from sb: " + messageBody);
        data.setName(messageBody);
        return receiveClient.completeAsync(message.getLockToken());
    }

    @Override
    public void notifyException(Throwable throwable, ExceptionPhase exceptionPhase) {
        System.out.println("Exception occurred while receiving message from service bus");
    }
}
