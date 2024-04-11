package lib.edu.libraryapp.controller.dto.auth;

public class UpdatePasswordResponseDto {
    private String username;

    private boolean success;

    public UpdatePasswordResponseDto(String username, boolean success) {
        this.username = username;
        this.success = success;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
