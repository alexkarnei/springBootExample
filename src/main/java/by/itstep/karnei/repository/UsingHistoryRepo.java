package by.itstep.karnei.repository;

import by.itstep.karnei.domain.UsingHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface UsingHistoryRepo extends CrudRepository <UsingHistory,Long> {

    Page <UsingHistory> findAll (Pageable pageable);
}
