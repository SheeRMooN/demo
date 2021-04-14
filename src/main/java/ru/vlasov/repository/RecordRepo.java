package ru.vlasov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vlasov.entity.RecordEntity;

import java.util.List;

public interface RecordRepo extends JpaRepository<RecordEntity, Long> {


    List<RecordEntity> findAllById(Long number);

    @Query("FROM RecordEntity r WHERE r.number = ?1")
        //jpql с обьектами
    List<RecordEntity> findAllByNumberjpql(Long number);
//
//    @Query(value = "SELECT * FROM recordEntity WHERE number = : number", nativeQuery = true)
//        //sql с таблицами
//    List<RecordEntity> findAllByNumbersql(@Param("number") Long number);
}
