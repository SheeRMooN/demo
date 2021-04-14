package ru.vlasov.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vlasov.entity.RecordEntity;
import ru.vlasov.exception.RecordNotFoundException;
import ru.vlasov.exception.UserNotFoundException;
import ru.vlasov.service.RecordService;
import ru.vlasov.view.Views;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    RecordService recordService;

    @GetMapping({"{id}"})
    @JsonView({Views.number.class})
    public ResponseEntity getRecordById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(recordService.getRecordById(id));
        } catch (RecordNotFoundException e) {
            return ResponseEntity.badRequest().body(NOT_FOUND);
        }
    }

    @GetMapping(path = "/find")
    @JsonView({Views.number.class})
    public ResponseEntity findRecord(@RequestParam Long number) {
        try {
            return ResponseEntity.ok(recordService.findRecordByNumber(number));
        } catch (RecordNotFoundException e) {
            return ResponseEntity.badRequest().body(NOT_FOUND);
        }
    }

    @PostMapping
    @JsonView({Views.number.class})
    public ResponseEntity create(@RequestBody RecordEntity record,
                                 @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(recordService.create(record, userId));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(NOT_FOUND);
        }
    }

    @PutMapping
    @JsonView({Views.number.class})
    public ResponseEntity update(@RequestBody RecordEntity record,
                                 @RequestParam Long id) {
        try {
            return ResponseEntity.ok(recordService.update(record, id));
        } catch (RecordNotFoundException e) {
            return ResponseEntity.badRequest().body(NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    @JsonView({Views.number.class})
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(recordService.delete(id));
        } catch (RecordNotFoundException e) {
            return ResponseEntity.badRequest().body(NOT_FOUND);
        }
    }
}
