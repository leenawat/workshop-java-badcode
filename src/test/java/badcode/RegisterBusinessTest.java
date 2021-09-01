package badcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegisterBusinessTest {

    @Test
    @DisplayName("Throw exception with First name is requried.")
    public void case01() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();

        // Act
        Exception exception = assertThrows(ArgumentNullException.class,
                () -> registerBusiness.register(null, new Speaker()));

        // Assert
        assertEquals("First name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Throw exception with Last name is required.")
    public void case02() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("my-firstname");

        // Act
        Exception exception = assertThrows(ArgumentNullException.class,
                () -> {
                    registerBusiness.register(null, speaker);
                });

        // Assert
        assertEquals("Last name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Throw exception with Email is required.")
    public void case03() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("my-firstname");
        speaker.setLastName("my-lastname");

        // Act
        Exception exception = assertThrows(ArgumentNullException.class,
                () -> {
                    registerBusiness.register(null, speaker);
                });

        // Assert
        assertEquals("Email is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Throw exception with Speaker doesn't meet our standard rules.")
    public void case04() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("my-firstname");
        speaker.setLastName("my-lastname");
        speaker.setEmail("my-email@local.com");

        // Act
        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class,
                () -> {
                    registerBusiness.register(null, speaker);
                });

        // Assert
        assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
    }

    @Test
    @DisplayName("Throw exception with Can't save a speaker.")
    public void case05() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("my-firstname");
        speaker.setLastName("my-lastname");
        speaker.setEmail("my-email@gmail.com");

        // Act
        Exception exception = assertThrows(SaveSpeakerException.class,
                () -> {
                    registerBusiness.register(null, speaker);
                });

        // Assert
        assertEquals("Can't save a speaker.", exception.getMessage());
    }

    @Test
    @DisplayName("get email domain gmail success")
    public void case06() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act
        String domain = registerBusiness.getEmailDomain("my-email@gmail.com");

        // Assert
        assertEquals("gmail.com", domain);
    }

}
