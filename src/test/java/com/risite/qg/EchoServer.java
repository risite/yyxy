package com.risite.qg;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/echo")
public class EchoServer {
	private static final String GUEST_PREFIX = "�ÿ�";
	private static final AtomicInteger connectionIds = new AtomicInteger(0);
	// ����һ�����ϣ����ڱ������н����WebSocket�ͻ���
	private static final Set<EchoServer> clientSet = new CopyOnWriteArraySet<>();
	// ����һ����Ա��������¼WebSocket�ͻ��˵������ǳ�
	private final String nickname;
	// ����һ����Ա��������¼��WebSocket֮��ĻỰ
	private Session session;

	public EchoServer() {
		nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
	}

	// ���ͻ������ӽ���ʱ�Զ������÷���
	@OnOpen
	public void start(Session session) {
		this.session = session;
		// ��WebSocket�ͻ��˻Ự��ӵ�������
		clientSet.add(this);
		String message = String.format("��%s %s��", nickname, "���뷿��");
		// ������Ϣ
		broadcast(message);
		System.out.println(message);
	}

	// ���ͻ��˶Ͽ�����ʱ�Զ������÷���
	@OnClose
	public void end() {
		clientSet.remove(this);
		String message = String.format("��%s %s��", nickname, "�뿪����");
		// ������Ϣ
		broadcast(message);
		System.out.println(message);
	}

	// ÿ���յ��ͻ�����Ϣʱ�Զ������÷���
	@OnMessage
	public void incoming(String message) {
		String filteredMessage = String.format("%s: %s", nickname,
				filter(message));
		// ������Ϣ
		broadcast(filteredMessage);
		System.out.println(filteredMessage);
	}

	// ���ͻ���ͨ�ų��ִ���ʱ�������÷���
	@OnError
	public void onError(Throwable t) throws Throwable {
		System.out.println("WebSocket����˴��� " + t);
	}

	// ʵ�ֹ㲥��Ϣ�Ĺ��߷���
	private static void broadcast(String msg) {
		// �������������������пͻ���
		for (EchoServer client : clientSet) {
			try {
				synchronized (client) {
					// ������Ϣ
					client.session.getBasicRemote().sendText(msg);
				}
			} catch (IOException e) {
				System.out.println("���������ͻ��� " + client + " ������Ϣ���ִ���");
				clientSet.remove(client);
				try {
					client.session.close();
				} catch (IOException e1) {
				}
				String message = String.format("��%s %s��", client.nickname,
						"�Ѿ����Ͽ������ӡ�");
				broadcast(message);
			}
		}
	}

	// ����һ�����߷��������ڶ��ַ����е�HTML�ַ���ǩ����ת��
	private static String filter(String message) {
		if (message == null)
			return null;
		char content[] = new char[message.length()];
		message.getChars(0, message.length(), content, 0);
		StringBuilder result = new StringBuilder(content.length + 50);
		for (int i = 0; i < content.length; i++) {
			// ���ƶԼ����ŵ������ַ�����ת��
			switch (content[i]) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '"':
				result.append("&quot;");
				break;
			default:
				result.append(content[i]);
			}
		}
		return (result.toString());
	}
}