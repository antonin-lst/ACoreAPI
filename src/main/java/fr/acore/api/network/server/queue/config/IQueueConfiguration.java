package fr.acore.api.network.server.queue.config;

import fr.acore.api.network.server.queue.utils.QueueType;

public interface IQueueConfiguration {

    public QueueType getQueueType();
    public void setQueueType(QueueType queueType);

    public long getQueueDelay();
    public void setQueueDelay(long delay);


}
