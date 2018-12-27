package com.oddlabs.tt.net;

import java.util.ArrayList;
import java.util.List;

public final strictfp class ChatHub implements ChatListener {
	private final List<ChatListener> listeners = new ArrayList<>();

	public void addListener(ChatListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	public void removeListener(ChatListener listener) {
		listeners.remove(listener);
	}

    @Override
	public void chat(ChatMessage message) {
		if (!ChatCommand.isIgnoring(message.nick)) {
			listeners.forEach(listener -> listener.chat(message));
		}
	}
}
