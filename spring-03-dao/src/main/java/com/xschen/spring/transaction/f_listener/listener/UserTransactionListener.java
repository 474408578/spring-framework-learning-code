package com.xschen.spring.transaction.f_listener.listener;

import com.xschen.spring.transaction.f_listener.bean.User;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * User 事务监听器，使用 Payload
 * @author xschen
 * 事务成功监听触发的顺序 BRFORE_COMMIT -> AFTER_COMPLETION -> AFTER_COMMIT
 * 事务回滚监听触发的顺序 AFTER_COMPLETION -> AFTER_COMMIT
 */

@Component
public class UserTransactionListener {

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void onSaveUserBeforeCommit(PayloadApplicationEvent<User> event) {
        System.out.println("监听到保存用户 事务准备提交……");
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onSaveUserAfterCommit(PayloadApplicationEvent<User> event) {
        System.out.println("监听到保存用户 事务提交成功……");
    }


    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void onSaveUserAfterRollBack(PayloadApplicationEvent<User> event) {
        System.out.println("监听到保存用户 事务回滚……");
    }


    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void onSaveUserAfterCompletion(PayloadApplicationEvent<User> event) {
        System.out.println("监听到保存用户 事务完成……");
    }
}
