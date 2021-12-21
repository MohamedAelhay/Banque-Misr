package com.banquemisr.service.impl;

import com.banquemisr.job.RoundGeneratorThread;
import com.banquemisr.utils.DataMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class BaseService {
    @Autowired
    protected DataMapperUtil dataMapperUtil;

    @Autowired
    ApplicationContext applicationContext;

    public void startRoundGeneratorThread(){
        RoundGeneratorThread roundGeneratorThread = new RoundGeneratorThread();
        applicationContext.getAutowireCapableBeanFactory().autowireBean(roundGeneratorThread);
        roundGeneratorThread.start();
    }
}
