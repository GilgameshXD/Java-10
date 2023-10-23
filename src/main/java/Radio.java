import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Radio {
    private final int minChannel = 0;
    private final int maxVolume = 100;
    private final int minVolume = 0;
    private int maxChannel = 9;
    private int currentChannel = minChannel;
    private int currentVolume = minVolume;

    public Radio(int maxChannel) {
        this.maxChannel = maxChannel - 1;
    }
    public void setCurrentChannel(int newCurrentChannel) {
        if (newCurrentChannel < minChannel) {
            return;
        }
        if (newCurrentChannel > maxChannel) {
            return;
        }
        currentChannel = newCurrentChannel;
    }
    public void nextChannel() {
        if (currentChannel < maxChannel) {
            currentChannel = currentChannel + 1;
        } else {
            currentChannel = minChannel;
        }
    }

    public void prevChannel() {
        if (currentChannel > minChannel) {
            currentChannel = currentChannel - 1;
        } else {
            currentChannel = maxChannel;
        }
    }


    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume = currentVolume + 1;
        } else {
            currentVolume = maxVolume;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume = currentVolume - 1;
        } else {
            currentVolume = minVolume;
        }
    }
}
