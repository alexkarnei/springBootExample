package by.itstep.karnei.service;

import by.itstep.karnei.domain.UsingHistory;
import by.itstep.karnei.repository.UsingHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsingHistoryService {

    @Autowired
    UsingHistoryRepo usingHistoryRepo;

    public Page<UsingHistory> getAll(Pageable pageable) {
        return usingHistoryRepo.findAll(pageable);
    }

    public boolean saveUsingHistory(UsingHistory usingHistory) {

        usingHistoryRepo.save(usingHistory);
        return true;
    }
}


