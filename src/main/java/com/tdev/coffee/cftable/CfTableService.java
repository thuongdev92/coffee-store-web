package com.tdev.coffee.cftable;

import org.springframework.stereotype.Service;

@Service
public class CfTableService {
    private final CfTableRepository cfTableRepository;
    public CfTableService(CfTableRepository cfTableRepository) {
        this.cfTableRepository = cfTableRepository;
    }

}
