package badcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegisterBusinessTest {

    @Test
    @DisplayName("Throw exceptino with First name is requried.")
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
    @DisplayName("Throw exceptino with Last name is required.")
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
    @DisplayName("Throw exceptino with Email is required.")
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
    @DisplayName("Throw exceptino with Speaker doesn't meet our standard rules.")
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
}
