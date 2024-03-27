package lib.edu.libraryapp.infrastructure.entity;



import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "users", schema = "library")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "full_name")
    private String fullName;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private AuthEntity auth;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    @Column(name = "loans")
    private List<LoanEntity> loanList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

