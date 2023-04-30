package org.adt.core.adt.implementation.dynamic;

import org.adt.core.adt.definition.IQueue;
import org.adt.core.adt.implementation.BaseQueueTest;

public class QueueTest extends BaseQueueTest {

    @Override
    public IQueue getQueue() {
        return new Queue();
    }
}
