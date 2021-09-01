package badcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegisterBusinessSuccessTest {

    @Test
    @DisplayName("return id when save success")
    public void case12() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();

        Speaker speaker = new Speaker();
        speaker.setFirstName("my-firstname");
        speaker.setLastName("my-lastname");
        speaker.setEmail("my-email@gmail.com");

        SpeakerRepository speakerRepository = new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 1;
            }
        };

        // Act
        Integer id = registerBusiness.register(speakerRepository, speaker);

        // Assert
        assertEquals(1, id);
    }
}
