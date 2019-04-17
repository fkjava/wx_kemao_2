package org.fkjava.wexin;

import java.util.Date;

import javax.transaction.Transactional;

import org.fkjava.wexin.domain.User;
import org.fkjava.wexin.domain.event.EventInMessage;
import org.fkjava.wexin.processors.EventMessageProcessor;
import org.fkjava.wexin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 把Bean加入容器管理，默认类名首字母小写作为ID
// 如果@Service注解有值则表示自定义ID
@Service("unsubscribeMessageProcessor")
public class UnsubscribeEventMessageProcessor implements EventMessageProcessor {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public void onMessage(EventInMessage msg) {
		System.out.println("取消关注消息处理器: " + msg);
		// 1.解除用户的关注状态
		User user = this.userRepository.findByOpenId(msg.getFromUserName());
		// 一般不删除数据，而是把数据标记为已经取消关注
		if (user != null) {
			user.setStatus(User.Status.IS_UNSUBSCRIBE);
			user.setUnsubTime(new Date());
		}
	}
}
