package lib.edu.libraryapp.infrastructure.entity;

import jakarta.persistence.*;
import lib.edu.libraryapp.commonTypes.UserRole;

/**
 * The type Auth entity.
 */
@Entity
@Table(name = "auth", schema = "library")
public class AuthEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;

        @Basic
        @Column(name = "username", unique = true,nullable = false)
        private String username;

        @Basic
        @Column(name = "password",nullable = false)
        private String password;

        @Enumerated(EnumType.STRING)
        @Column(name = "role", nullable = false)
        private UserRole role;

        @OneToOne
        @JoinColumn(name = "user_id", nullable = false)
        private UserEntity user;

        /**
         * Gets id.
         *
         * @return the id
         */
        public long getId() {
                return id;
        }

        /**
         * Sets id.
         *
         * @param id the id
         */
        public void setId(long id) {
                this.id = id;
        }

        /**
         * Gets username.
         *
         * @return the username
         */
        public String getUsername() {
                return username;
        }

        /**
         * Sets username.
         *
         * @param username the username
         */
        public void setUsername(String username) {
                this.username = username;
        }

        /**
         * Gets password.
         *
         * @return the password
         */
        public String getPassword() {
                return password;
        }

        /**
         * Sets password.
         *
         * @param password the password
         */
        public void setPassword(String password) {
                this.password = password;
        }

        /**
         * Gets role.
         *
         * @return the role
         */
        public UserRole getRole() {
                return role;
        }

        /**
         * Sets role.
         *
         * @param role the role
         */
        public void setRole(UserRole role) {
                this.role = role;
        }

        /**
         * Gets user.
         *
         * @return the user
         */
        public UserEntity getUser() {
                return user;
        }

        /**
         * Sets user.
         *
         * @param user the user
         */
        public void setUser(UserEntity user) {
                this.user = user;
        }
}
