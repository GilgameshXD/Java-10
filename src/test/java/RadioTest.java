import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void shouldSetNextChannel() {
        Radio channel = new Radio();
        channel.setCurrentChannel(5);

        channel.nextChannel();

        int expected = 6;
        int actual = channel.getCurrentChannel();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldSetChannel0AfterChannel9() {
        Radio channel = new Radio();
        channel.setCurrentChannel(9);

        channel.nextChannel();

        int expected = 0;
        int actual = channel.getCurrentChannel();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPrevChannel() {
        Radio channel = new Radio();
        channel.setCurrentChannel(5);

        channel.prevChannel();

        int expected = 4;
        int actual = channel.getCurrentChannel();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldSetChannel9BeforeChannel0() {
        Radio channel = new Radio();
        channel.setCurrentChannel(0);

        channel.prevChannel();

        int expected = 9;
        int actual = channel.getCurrentChannel();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldSetChannel() {
        Radio channel = new Radio();
        channel.setCurrentChannel(7);

        int expected = 7;
        int actual = channel.getCurrentChannel();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldSetChannelAboveMax() {
        Radio channel = new Radio();
        channel.setCurrentChannel(50);


        int expected = 0;
        int actual = channel.getCurrentChannel();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldSetChannelBelowMin() {
        Radio channel = new Radio();
        channel.setCurrentChannel(-5);


        int expected = 0;
        int actual = channel.getCurrentChannel();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldIncreaseVolume() {
        Radio volume = new Radio();
        volume.setCurrentVolume(50);

        volume.increaseVolume();

        int expected = 51;
        int actual = volume.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotIncreaseVolumeAboveMax() {
        Radio volume = new Radio();
        volume.setCurrentVolume(100);

        volume.increaseVolume();

        int expected = 100;
        int actual = volume.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldDecreaseVolume() {
        Radio volume = new Radio();
        volume.setCurrentVolume(50);

        volume.decreaseVolume();

        int expected = 49;
        int actual = volume.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldDecreaseVolumeBelowMin() {
        Radio volume = new Radio();
        volume.setCurrentVolume(-1);

        volume.decreaseVolume();

        int expected = 0;
        int actual = volume.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }


}