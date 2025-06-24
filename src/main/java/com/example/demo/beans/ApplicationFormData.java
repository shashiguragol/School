package com.example.demo.beans;



import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

@Entity
@Table(name = "application_form_data")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class ApplicationFormData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_form_data_seq")
    @SequenceGenerator(name = "application_form_data_seq", sequenceName = "application_form_data_application_id_seq", allocationSize = 1)
    @Column(name = "application_id", nullable = false)
    private Integer applicationId;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "second_name", length = 100)
    private String secondName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "addhar_id", nullable = false, length = 12)
    private String addharId;

    @Column(name = "blood_group", nullable = false, length = 4)
    private String bloodGroup;

    @Column(name = "nationality", nullable = false, length = 100)
    private String nationality;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "local_address", columnDefinition = "text")
    private String localAddress;

    @Column(name = "parmentant_address", columnDefinition = "text")
    private String permanentAddress;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "email", length = 100)
    private String email;

    // Constructors, getters, and setters



}
