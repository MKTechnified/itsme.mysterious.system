package itsme.mysterious.system.models;

import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.PropertyName;

import java.util.Date;

import system.mysteriouselevation.Utils.Constants;

public class GoalQuest {


    //Goal variable declarations
    private String Goal, LastUpdated, GoalID, GoalInformation, ScheduledTime, GoalDate;

    private int Score, MaxScore;
    private boolean MentalQuest, FinancialQuest, SpiritualQuest, PhysicalQuest;

    @Exclude
    private double MentalPoints, FinancialPoints, SpiritualPoints, PhysicalPoints, TotalPoints;

    public GoalQuest() {
        //For Firestore
    }

    //constructor with arguments
    public GoalQuest(String Goal, String LastUpdated, int MaxScore, String GoalInformation, String ScheduledTime, boolean MentalQuest,
                     boolean FinancialQuest, boolean SpiritualQuest, boolean PhysicalQuest) {
        this.Goal = Goal;
        this.LastUpdated = LastUpdated;
        this.MaxScore = MaxScore;
        this.MentalQuest = MentalQuest;
        this.FinancialQuest = FinancialQuest;
        this.SpiritualQuest = SpiritualQuest;
        this.PhysicalQuest = PhysicalQuest;
        this.GoalInformation = GoalInformation;
        this.ScheduledTime = ScheduledTime;
        this.GoalDate = Constants.getOnlyDate();
    }

    @PropertyName("GoalDate")
    public String getGoalDate() {
        return GoalDate;
    }

    @PropertyName("GoalDate")
    public void setGoalDate(String GoalDate) {
        this.GoalDate = GoalDate;
    }

    @PropertyName("GoalInformation")
    public String getGoalInformation() {
        return GoalInformation;
    }

    @PropertyName("GoalInformation")
    public void setGoalInformation(String GoalInformation) {
        this.GoalInformation = GoalInformation;
    }

    @PropertyName("ScheduledTime")
    public String getScheduledTime() {
        return ScheduledTime;
    }

    @PropertyName("ScheduledTime")
    public void setScheduledTime(String ScheduledTime) {
        this.ScheduledTime = ScheduledTime;
    }

    @Exclude
    public double getMentalPoints() {
        return Math.round(MentalPoints * 1000) / 1000.00;
    }

    @Exclude
    public void setMentalPoints(double MentalPoints) {
        this.MentalPoints = MentalPoints;
    }

    @Exclude
    public double getFinancialPoints() {
        return Math.round(FinancialPoints * 1000) / 1000.00;
    }

    @Exclude
    public void setFinancialPoints(double FinancialPoints) {
        this.FinancialPoints = FinancialPoints;
    }

    @Exclude
    public double getSpiritualPoints() {
        return Math.round(SpiritualPoints * 1000) / 1000.00;
    }

    @Exclude
    public void setSpiritualPoints(double SpiritualPoints) {
        this.SpiritualPoints = SpiritualPoints;
    }

    @Exclude
    public double getPhysicalPoints() {
        return Math.round(PhysicalPoints * 1000) / 1000.00;
    }

    @Exclude
    public void setPhysicalPoints(double PhysicalPoints) {
        this.PhysicalPoints = PhysicalPoints;
    }

    @Exclude
    public double getTotalPoints() {
        return Math.round(TotalPoints * 1000) / 1000.00;
    }

    @Exclude
    public void setTotalPoints(double TotalPoints) {
        this.TotalPoints = TotalPoints;
    }

    @PropertyName("Goal")
    public String getGoal() {
        return Goal;
    }

    @PropertyName("Goal")
    public void setGoal(String Goal) {
        this.Goal = Goal;
    }

    @PropertyName("MaxScore")
    public int getMaxScore() {
        return MaxScore;
    }

    @PropertyName("MaxScore")
    public void setMaxScore(int MaxScore) {
        this.MaxScore = MaxScore;
    }

    @PropertyName("MentalQuest")
    public boolean isMentalQuest() {
        return MentalQuest;
    }

    @PropertyName("MentalQuest")
    public void setMentalQuest(boolean MentalQuest) {
        this.MentalQuest = MentalQuest;
    }

    @PropertyName("FinancialQuest")
    public boolean isFinancialQuest() {
        return FinancialQuest;
    }

    @PropertyName("FinancialQuest")
    public void setFinancialQuest(boolean FinancialQuest) {
        this.FinancialQuest = FinancialQuest;
    }

    @PropertyName("SpiritualQuest")
    public boolean isSpiritualQuest() {
        return SpiritualQuest;
    }

    @PropertyName("SpiritualQuest")
    public void setSpiritualQuest(boolean SpiritualQuest) {
        this.SpiritualQuest = SpiritualQuest;
    }

    @PropertyName("PhysicalQuest")
    public boolean isPhysicalQuest() {
        return PhysicalQuest;
    }

    @PropertyName("PhysicalQuest")
    public void setPhysicalQuest(boolean PhysicalQuest) {
        this.PhysicalQuest = PhysicalQuest;
    }

    @PropertyName("Status")
    public String getStatus() {
        return getTheStatus();
    }

    @Exclude
    private String getTheStatus() {
        if (getScore() >= getMaxScore()) {
            return "COMPLETED";
        } else {
            return "INCOMPLETE";
        }
    }

    @PropertyName("Score")
    public int getScore() {
        return Score;
    }

    @PropertyName("Score")
    public void setScore(int Score) {
        this.Score = Score;
    }

    @PropertyName("LastUpdated")
    public String getLastUpdated() {
        return LastUpdated;
    }

    @PropertyName("LastUpdated")
    public void setLastUpdated(String LastUpdated) {
        this.LastUpdated = LastUpdated;
    }

    @Exclude
    public String getGoalID() {
        return GoalID;
    }

    @Exclude
    public void setGoalID(String GoalID) {
        this.GoalID = GoalID;
    }

    @Exclude
    public PLAYER QuestCompleted(PLAYER player) {
        return QuestHasCompleted(player);
    }

    @Exclude
    private PLAYER QuestHasCompleted(PLAYER player) {

        double total = 0;

        if (player.getExperience() < 0) {
            player.setExperience(0);
        } else {
            if (getScore() >= getMaxScore()) {

                if (isMentalQuest()) {

                    player.setIntelligence(player.getIntelligence() + 0.099);
                    player.setAwareness(player.getAwareness() + 0.043);
                    player.setWill(player.getWill() + 0.054);
                    player.setEndurance(player.getEndurance() + 0.069);
                    player.setDefiance(player.getDefiance() + 0.071);
                    player.setAura(player.getAura() + 0.062);
                    player.setSincerity(player.getSincerity() + 0.043);
                    player.setStealth(player.getStealth() + 0.067);
                    player.setMystique(player.getMystique() + 0.095);
                    player.setSense(player.getSense() + 0.068);

                    MentalPoints = 0.099 + 0.043 + 0.054 + 0.069 + 0.071 + 0.062 + 0.043 + 0.067 + 0.095 + 0.068;
                    total = total + MentalPoints;

                }
                if (isFinancialQuest()) {

                    player.setMP(player.getMP() + getMaxScore());

                    player.setIntelligence(player.getIntelligence() + 0.064);
                    player.setAwareness(player.getAwareness() + 0.067);
                    player.setWill(player.getWill() + 0.054);
                    player.setAura(player.getAura() + 0.062);
                    player.setSincerity(player.getSincerity() + 0.029);
                    player.setStealth(player.getStealth() + 0.055);
                    player.setMystique(player.getMystique() + 0.099);
                    player.setSense(player.getSense() + 0.071);

                    FinancialPoints = 0.064 + 0.067 + 0.054 + 0.062 + 0.029 + 0.055 + 0.099 + 0.071;
                    total = total + (getMaxScore() / 10.0) + FinancialPoints;

                }
                if (isSpiritualQuest()) {

                    player.setIntelligence(player.getIntelligence() + 0.095);
                    player.setAwareness(player.getAwareness() + 0.045);
                    player.setWill(player.getWill() + 0.059);
                    player.setEndurance(player.getEndurance() + 0.063);
                    player.setDefiance(player.getDefiance() + 0.083);
                    player.setAura(player.getAura() + 0.052);
                    player.setSincerity(player.getSincerity() + 0.054);
                    player.setMystique(player.getMystique() + 0.037);
                    player.setStrength(player.getStrength() + 0.099);
                    player.setAgility(player.getAgility() + 0.094);
                    player.setVitality(player.getVitality() + 0.076);
                    player.setHP(player.getHP() + 0.059);
                    player.setSense(player.getSense() + 0.039);

                    if (player.getFatigue() > 0) {
                        player.setFatigue(player.getFatigue() - 1);
                    }

                    SpiritualPoints = 0.095 + 0.045 + 0.059 + 0.063 + 0.083 + 0.052 +
                            0.054 + 0.037 + 0.099 + 0.094 + 0.076 + 0.059 + 0.039;
                    total = total + SpiritualPoints;

                }
                if (isPhysicalQuest()) {

                    player.setAwareness(player.getAwareness() + 0.056);
                    player.setWill(player.getWill() + 0.053);
                    player.setEndurance(player.getEndurance() + 0.055);
                    player.setDefiance(player.getDefiance() + 0.032);
                    player.setAura(player.getAura() + 0.035);
                    player.setMystique(player.getMystique() + 0.093);
                    player.setStrength(player.getStrength() + 0.099);
                    player.setAgility(player.getAgility() + 0.071);
                    player.setVitality(player.getVitality() + 0.043);
                    player.setHP(player.getHP() + 0.095);
                    player.setSense(player.getSense() + 0.059);

                    PhysicalPoints = 0.056 + 0.053 + 0.055 + 0.032 + 0.035 + 0.093 + 0.099 + 0.071 + 0.043 + 0.095 + 0.059;
                    total = total + PhysicalPoints;

                }

                TotalPoints = MentalPoints + FinancialPoints + SpiritualPoints + PhysicalPoints;

                player.setExperience(player.getExperience() + (long) (total * 10));

            } else {

                if (player.getExperience() > 0) {
                    if (isMentalQuest()) {

                        player.setIntelligence(player.getIntelligence() - 0.099);
                        player.setAwareness(player.getAwareness() - 0.043);
                        player.setWill(player.getWill() - 0.054);
                        player.setEndurance(player.getEndurance() - 0.069);
                        player.setDefiance(player.getDefiance() - 0.071);
                        player.setAura(player.getAura() - 0.062);
                        player.setSincerity(player.getSincerity() - 0.043);
                        player.setStealth(player.getStealth() - 0.067);
                        player.setMystique(player.getMystique() - 0.095);
                        player.setSense(player.getSense() - 0.068);

                        total = total + 0.099 + 0.043 + 0.054 + 0.069 + 0.071 + 0.062 + 0.043 + 0.067 + 0.095 + 0.068;

                    }
                    if (isFinancialQuest()) {

                        player.setMP(player.getMP() - getMaxScore());

                        player.setIntelligence(player.getIntelligence() - 0.064);
                        player.setAwareness(player.getAwareness() - 0.067);
                        player.setWill(player.getWill() - 0.054);
                        player.setAura(player.getAura() - 0.062);
                        player.setSincerity(player.getSincerity() - 0.029);
                        player.setStealth(player.getStealth() - 0.055);
                        player.setMystique(player.getMystique() - 0.099);
                        player.setSense(player.getSense() - 0.071);

                        total = total + (getMaxScore() / 10.0) + 0.064 + 0.067 + 0.054 + 0.062 + 0.029 + 0.055 + 0.099 + 0.071;

                    }
                    if (isSpiritualQuest()) {

                        player.setIntelligence(player.getIntelligence() - 0.095);
                        player.setAwareness(player.getAwareness() - 0.045);
                        player.setWill(player.getWill() - 0.059);
                        player.setEndurance(player.getEndurance() - 0.063);
                        player.setDefiance(player.getDefiance() - 0.083);
                        player.setAura(player.getAura() - 0.052);
                        player.setSincerity(player.getSincerity() - 0.054);
                        player.setMystique(player.getMystique() - 0.037);
                        player.setStrength(player.getStrength() - 0.099);
                        player.setAgility(player.getAgility() - 0.094);
                        player.setVitality(player.getVitality() - 0.076);
                        player.setHP(player.getHP() - 0.059);
                        player.setSense(player.getSense() - 0.039);

                        if (player.getFatigue() > 0) {
                            player.setFatigue(player.getFatigue() - 1);
                        }

                        total = total + 0.095 + 0.045 + 0.059 + 0.063 + 0.083 + 0.052 +
                                0.054 + 0.037 + 0.099 + 0.094 + 0.076 + 0.059 + 0.039;

                    }
                    if (isPhysicalQuest()) {

                        player.setAwareness(player.getAwareness() - 0.056);
                        player.setWill(player.getWill() - 0.053);
                        player.setEndurance(player.getEndurance() - 0.055);
                        player.setDefiance(player.getDefiance() - 0.032);
                        player.setAura(player.getAura() - 0.035);
                        player.setMystique(player.getMystique() - 0.093);
                        player.setStrength(player.getStrength() - 0.099);
                        player.setAgility(player.getAgility() - 0.071);
                        player.setVitality(player.getVitality() - 0.043);
                        player.setHP(player.getHP() - 0.095);
                        player.setSense(player.getSense() - 0.059);

                        total = total + 0.056 + 0.053 + 0.055 + 0.032 + 0.035 + 0.093 + 0.099 + 0.071 + 0.043 + 0.095 + 0.059;

                    }

                    player.setExperience(player.getExperience() - (long) (total * 10));
                }
            }
        }

        return player;
    }

}