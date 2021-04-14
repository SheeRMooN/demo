package ru.vlasov.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.vlasov.view.Views;

import javax.persistence.*;
import java.util.List;

@Entity
@EqualsAndHashCode(of = {"id"})
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @JsonView({Views.number.class})
    private String firstName;

    @JsonView({Views.number.class})
    private String lastName;

    @JsonView({Views.number.class})
    private int age;

    @JsonView({Views.number.class})
    private boolean gender;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<RecordEntity> records;


}