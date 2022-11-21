package com.senla.courses.atm.service.model;

public class Client {

    private Long id;

    private String name;

    private String surname;

    private String patronymic;

    public Client(Long id, String name, String surname, String patronymic) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Long getId() {
        return id;
    }

    public String getClientFullInfo() {
        return String.join(" ", name, surname, patronymic);
    }

}
