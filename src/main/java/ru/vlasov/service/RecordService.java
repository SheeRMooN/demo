package ru.vlasov.service;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlasov.entity.RecordEntity;
import ru.vlasov.entity.UserEntity;
import ru.vlasov.exception.RecordNotFoundException;
import ru.vlasov.exception.UserNotFoundException;
import ru.vlasov.repository.RecordRepo;
import ru.vlasov.view.Views;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordRepo recordRepo;

    @Autowired
    private UserService userService;

    public RecordEntity getRecordById(Long id) throws RecordNotFoundException {
        return findRecordById(id);
    }

    public List<RecordEntity> findRecordByNumber(Long number) throws RecordNotFoundException {
        List<RecordEntity> records = new ArrayList<>(recordRepo.findAllById(number));
        if (records.isEmpty()) {
            throw new RecordNotFoundException();
        }
        return records;
    }

    public RecordEntity create(RecordEntity record, Long userId) throws UserNotFoundException {
        UserEntity user = userService.getUserById(userId);
        record.setUser(user);
        return recordRepo.save(record);
    }

    public RecordEntity update(RecordEntity record, Long id) throws RecordNotFoundException {
        RecordEntity recordFromDb = findRecordById(id);
        if (record != null) {
            recordFromDb.setFirstName(record.getFirstName());
            recordFromDb.setLastName(record.getLastName());
            recordFromDb.setAge(record.getAge());
            recordFromDb.setGender(record.isGender());
            recordRepo.save(recordFromDb);
        }
        return recordFromDb;
    }

    public RecordEntity delete(Long id) throws RecordNotFoundException {
        RecordEntity recordFromDb = findRecordById(id);
        recordRepo.delete(recordFromDb);
        return recordFromDb;
    }

    private RecordEntity findRecordById(Long id) throws RecordNotFoundException {
        return recordRepo.findById(id).orElseThrow(RecordNotFoundException::new);
    }
}
