package org.fkjava.wexin.processors;

import org.fkjava.wexin.domain.event.EventInMessage;

public interface EventMessageProcessor {

	void onMessage(EventInMessage msg);
}
