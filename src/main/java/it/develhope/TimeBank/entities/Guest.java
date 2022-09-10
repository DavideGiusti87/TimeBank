package it.develhope.TimeBank.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = false, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String nickname;
    @Column(unique = true, nullable = false)
    private int phoneNumber;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Guest() {
    }

    public Guest(Long id, String name, String nickname, int phoneNumber,Address address) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
