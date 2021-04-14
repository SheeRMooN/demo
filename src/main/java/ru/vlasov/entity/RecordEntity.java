package ru.vlasov.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.vlasov.view.Views;

import javax.persistence.*;

@Entity
@EqualsAndHashCode(of = {"id"})
@Data
@NoArgsConstructor
public class RecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView({Views.Name.class})
    private String firstName;

    @JsonView({Views.Name.class})
    private String lastName;

    @JsonView({Views.Name.class})
    private int age;

    @JsonView({Views.Name.class})
    private boolean gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}