package by.itstep.karnei.service;

import by.itstep.karnei.domain.Car;
import by.itstep.karnei.domain.Owner;
import by.itstep.karnei.repository.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class OwnerService {
    @Autowired
    OwnerRepo ownerRepo;

    public boolean saveOwner(Owner owner) {

        ownerRepo.save(owner);
        return true;
    }

    @GetMapping
    public Iterable<Owner> ownerList() {
        return ownerRepo.findAll();
    }

    public Page<Owner> getAll(Pageable pageable) {

        return ownerRepo.findAll(pageable);
    }
}
