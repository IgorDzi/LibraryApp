package lib.edu.libraryapp.controller.dto.loan;

import lib.edu.libraryapp.infrastructure.entity.BookEntity;
import lib.edu.libraryapp.infrastructure.entity.UserEntity;

public class BeginLoanResponseDto {

    private long id;

    private BookEntity book;

    private UserEntity user;

    private String loanDate;
    private String returnDueDate;

    public BeginLoanResponseDto(long id, BookEntity book, UserEntity user, String loanDate, String returnDueDate) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
        this.returnDueDate = returnDueDate;
    }

    public BeginLoanResponseDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBook() {
        return book.getId();
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public long getUser() {
        return user.getId();
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getReturnDueDate() {
        return returnDueDate;
    }

    public void setReturnDueDate(String returnDueDate) {
        this.returnDueDate = returnDueDate;
    }
}
