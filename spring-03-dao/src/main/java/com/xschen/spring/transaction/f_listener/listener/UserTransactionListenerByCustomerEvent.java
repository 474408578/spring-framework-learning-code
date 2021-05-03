package com.xschen.spring.transaction.f_listener.listener;

import com.xschen.spring.transaction.f_listener.bean.User;
import com.xschen.spring.transaction.f_listener.event.UserSaveEvent;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * User 事务监听器 使用自定的 event
 * @author xschen
 */

@Component
public class UserTransactionListenerByCustomerEvent {

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void onSaveUserBeforeCommit(UserSaveEvent event) {
        System.out.println("监听到保存用户 事务准备提交……");
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onSaveUserAfterCommit(UserSaveEvent event) {
        System.out.println("监听到保存用户 事务提交成功……");
    }


    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void onSaveUserAfterRollBack(UserSaveEvent event) {
        System.out.println("监听到保存用户 事务回滚……");
    }


    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void onSaveUserAfterCompletion(UserSaveEvent event) {
        System.out.println("监听到保存用户 事务完成……");
    }
}
