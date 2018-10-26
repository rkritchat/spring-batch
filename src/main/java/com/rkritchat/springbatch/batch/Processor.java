package com.rkritchat.springbatch.batch;


import com.rkritchat.springbatch.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Processor  implements ItemProcessor<User, User> {

    private static final Map<String, String> DEPT_NAME = new HashMap<>();

    public Processor() {
        DEPT_NAME.put("001", "Technology");
        DEPT_NAME.put("002", "Operation");
        DEPT_NAME.put("003", "Accounts");
    }

    @Override
    public User process(User user) throws Exception {
        String deptCode = user.getDept();
        user.setDept(DEPT_NAME.get(deptCode));
        return user;
    }
}
