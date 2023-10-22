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
        channel.setCurrentChannel(channel.getMaxChannel());

        channel.nextChannel();

        int expected = channel.getMinChannel();
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
        channel.setCurrentChannel(channel.getMinChannel());

        channel.prevChannel();

        int expected = channel.getMaxChannel();
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
    public void shouldNotSetChannelAboveMax() {
        Radio channel = new Radio();
        channel.setCurrentChannel(50);


        int expected = channel.getMinChannel();
        int actual = channel.getCurrentChannel();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotSetChannelBelowMin() {
        Radio channel = new Radio();
        channel.setCurrentChannel(-1);


        int expected = channel.getMinChannel();
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
        volume.setCurrentVolume(volume.getMaxVolume());

        volume.increaseVolume();

        int expected = volume.getMaxVolume();
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
    public void shouldNotDecreaseVolumeBelowMin() {
        Radio volume = new Radio();
        volume.setCurrentVolume(-1);

        volume.decreaseVolume();

        int expected = volume.getMinVolume();
        int actual = volume.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldSetChannelsCount() {
        Radio radio = new Radio(25);

        Assertions.assertEquals(0, radio.getMinChannel());
        Assertions.assertEquals(24, radio.getMaxChannel());
    }

    @Test
    public void shouldSetChannel0AfterLastChannel() {
        Radio channel = new Radio(20);
        channel.setCurrentChannel(channel.getMaxChannel());

        channel.nextChannel();

        int expected = channel.getMinChannel();
        int actual = channel.getCurrentChannel();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetLastChannelBeforeChannel0() {
        Radio channel = new Radio(20);
        channel.setCurrentChannel(channel.getMinChannel());

        channel.prevChannel();

        int expected = channel.getMaxChannel();
        int actual = channel.getCurrentChannel();

        Assertions.assertEquals(expected, actual);

    }


}