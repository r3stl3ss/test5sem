package dtos;

import java.util.Objects;

public class ThreeElementalPollData {
    private String pollName;

    private String pollDescription;

    private String firstOption;

    private String secondOption;

    private String thirdOption;

    public ThreeElementalPollData(String pollName, String pollDescription, String firstOption, String secondOption, String thirdOption) {
        this.pollName = pollName;
        this.pollDescription = pollDescription;
        this.firstOption = firstOption;
        this.secondOption = secondOption;
        this.thirdOption = thirdOption;
    }

    public String getPollName() {
        return pollName;
    }

    public void setPollName(String pollName) {
        this.pollName = pollName;
    }

    public String getPollDescription() {
        return pollDescription;
    }

    public void setPollDescription(String pollDescription) {
        this.pollDescription = pollDescription;
    }

    public String getFirstOption() {
        return firstOption;
    }

    public void setFirstOption(String firstOption) {
        this.firstOption = firstOption;
    }

    public String getSecondOption() {
        return secondOption;
    }

    public void setSecondOption(String secondOption) {
        this.secondOption = secondOption;
    }

    public String getThirdOption() {
        return thirdOption;
    }

    public void setThirdOption(String thirdOption) {
        this.thirdOption = thirdOption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThreeElementalPollData that = (ThreeElementalPollData) o;
        return pollName.equals(that.pollName) &&
                pollDescription.equals(that.pollDescription) &&
                firstOption.equals(that.firstOption) &&
                secondOption.equals(that.secondOption) &&
                thirdOption.equals(that.thirdOption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pollName, pollDescription, firstOption, secondOption, thirdOption);
    }
}
