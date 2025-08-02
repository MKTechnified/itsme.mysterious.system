package itsme.mysterious.system.models;

import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.PropertyName;

import java.util.Calendar;

public class PLAYER {

    @Exclude
    private String ID;

    @Exclude
    private double z;

    @Exclude
    private String PlayerAvatar;

    private String Name, Since, LastActive, PIN, Titles;

    private int Status, Penalties;

    private long Experience, MP, Extras;

    private double Intelligence, Agility, Strength, HP, Sense, Will, Vitality, Fatigue, Awareness,
            Stealth, Endurance, Aura, Mystique, Sincerity, Defiance;

    public PLAYER() {
        //Firestore
    }

    public PLAYER(String Name) {
        Status = 1;
        this.Name = Name;
        setSince();
    }

    @PropertyName("PlayerAvatar")
    public String getPlayerAvatar() {
        return PlayerAvatar;
    }

    @PropertyName("PlayerAvatar")
    public void setPlayerAvatar(String playerAvatar) {
        PlayerAvatar = playerAvatar;
    }

    @PropertyName("PIN")
    public String getPIN() {
        return PIN;
    }

    @PropertyName("PIN")
    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    @PropertyName("Extras")
    public long getExtras() {
        return Extras;
    }

    @PropertyName("Extras")
    public void setExtras(long Extras) {
        this.Extras = Extras;
    }

    @PropertyName("Since")
    public String getSince() {
        return Since;
    }

    @PropertyName("Since")
    public void setSince(String Since) {
        this.Since = Since;
    }

    @Exclude
    public double getZ() {

        if (getExperience() > 0) {

            if (getTheLevel() <= 20) {

                return 0.04;


            } else {

                return 0.04;

            }

        }else{
            return 0.0;
        }
    }

    @Exclude
    public void setZ(double z) {
        this.z = z;
    }

    @Exclude
    private void setSince() {
        Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        this.Since = date + "/" + (month + 1) + "/" + year;

    }

    @PropertyName("MP")
    public long getMP() {
        return MP;
    }

    @PropertyName("MP")
    public void setMP(long MP) {
        this.MP = MP;
    }

    @PropertyName("Intelligence")
    public double getIntelligence() {
        return Math.round(Intelligence * 1000) / 1000.00;
    }

    @PropertyName("Intelligence")
    public void setIntelligence(double Intelligence) {
        this.Intelligence = Intelligence;
    }

    @PropertyName("LastActive")
    public String getLastActive() {
        return LastActive;
    }

    @PropertyName("LastActive")
    public void setLastActive(String LastActive) {
        this.LastActive = LastActive;
    }

    @PropertyName("Agility")
    public double getAgility() {
        return Math.round(Agility * 1000) / 1000.00;
    }

    @PropertyName("Agility")
    public void setAgility(double Agility) {
        this.Agility = Agility;
    }

    @PropertyName("Strength")
    public double getStrength() {
        return Math.round(Strength * 1000) / 1000.00;
    }

    @PropertyName("Strength")
    public void setStrength(double Strength) {
        this.Strength = Strength;
    }

    @PropertyName("HP")
    public double getHP() {
        return Math.round(HP * 1000) / 1000.00;
    }

    @PropertyName("HP")
    public void setHP(double HP) {
        this.HP = HP;
    }

    @PropertyName("Sense")
    public double getSense() {
        return Math.round(Sense * 1000) / 1000.00;
    }

    @PropertyName("Sense")
    public void setSense(double Sense) {
        this.Sense = Sense;
    }

    @PropertyName("Will")
    public double getWill() {
        return Math.round(Will * 1000) / 1000.00;
    }

    @PropertyName("Will")
    public void setWill(double Will) {
        this.Will = Will;
    }

    @PropertyName("Vitality")
    public double getVitality() {
        return Math.round(Vitality * 1000) / 1000.00;
    }

    @PropertyName("Vitality")
    public void setVitality(double Vitality) {
        this.Vitality = Vitality;
    }

    @PropertyName("Fatigue")
    public double getFatigue() {
        return Math.round(Fatigue * 1000) / 1000.00;
    }

    @PropertyName("Fatigue")
    public void setFatigue(double Fatigue) {
        this.Fatigue = Fatigue;
    }

    @PropertyName("Awareness")
    public double getAwareness() {
        return Math.round(Awareness * 1000) / 1000.00;
    }

    @PropertyName("Awareness")
    public void setAwareness(double Awareness) {
        this.Awareness = Awareness;
    }

    @PropertyName("Stealth")
    public double getStealth() {
        return Math.round(Stealth * 1000) / 1000.00;
    }

    @PropertyName("Stealth")
    public void setStealth(double Stealth) {
        this.Stealth = Stealth;
    }

    @PropertyName("Endurance")
    public double getEndurance() {
        return Math.round(Endurance * 1000) / 1000.00;
    }

    @PropertyName("Endurance")
    public void setEndurance(double Endurance) {
        this.Endurance = Endurance;
    }

    @PropertyName("Aura")
    public double getAura() {
        return Math.round(Aura * 1000) / 1000.00;
    }

    @PropertyName("Aura")
    public void setAura(double Aura) {
        this.Aura = Aura;
    }

    @PropertyName("Mystique")
    public double getMystique() {
        return Math.round(Mystique * 1000) / 1000.00;
    }

    @PropertyName("Mystique")
    public void setMystique(double Mystique) {
        this.Mystique = Mystique;
    }

    @PropertyName("Sincerity")
    public double getSincerity() {
        return Math.round(Sincerity * 1000) / 1000.00;
    }

    @PropertyName("Sincerity")
    public void setSincerity(double Sincerity) {
        this.Sincerity = Sincerity;
    }

    @PropertyName("Defiance")
    public double getDefiance() {
        return Math.round(Defiance * 1000) / 1000.00;
    }

    @PropertyName("Defiance")
    public void setDefiance(double Defiance) {
        this.Defiance = Defiance;
    }

    @PropertyName("Experience")
    public long getExperience() {
        return Experience;
    }

    @PropertyName("Experience")
    public void setExperience(long Experience) {
        this.Experience = Experience;
    }

    @Exclude
    public String getID() {
        return ID;
    }

    @Exclude
    public void setID(String ID) {
        this.ID = ID;
    }

    @PropertyName("Name")
    public String getName() {
        return Name;
    }

    @PropertyName("Name")
    public void setName(String Name) {
        this.Name = Name;
    }

    @PropertyName("Title")
    public String getTitle() {
        return getTheTitle();
    }

    @Exclude
    private String getTheTitle() {

        String[] playerTitles = new String[]{

                "Initiated",
                "Heroic",
                "Incomparable",
                "Legendary",
                "Magnificent",
                "Outstanding",
                "Remarkable",
                "Terrific",
                "Ultimate",
                "Valiant",
                "Astonishing",
                "Impervious",
                "Nimble",
                "Overcharged",
                "Resistant",
                "Vengeful",
                "Unknowable",
                "Wise",
                "Venerable",
                "Eerie",
                "Incomprehensible",
                "Strange",
                "Insightful",
                "Captivating",
                "Death Defying",
                "Unfathomable",
                "Ascended",
                "Resolute",
                "Exceptional",
                "Adept",
                "Far Seeing",
                "Indescribable",
                "Majestic",
                "Otherworldly",
                "Phenomenal",
                "Unearthly",
                "Thoughtful",
                "Stupendous",
                "Watchful",
                "Excellent",
                "Indestructible",
                "Learned",
                "Resilient",
                "Splendid",
                "Wired",
                "Unbreakable",
                "Valorous",
                "Discerning",
                "Terrible",
                "Wrathful",
                "Unbounded",
                "Enigmatic",
                "Frightful",
                "Ferocious",
                "Monstrous",
                "Untamed",
                "Quintessence",
                "Larceny",
                "Unseen",
                "Unflinching",
                "Blessed",
                "Knowledgeable",
                "Observant",
                "Idealistic",
                "Sincere",
                "Unequalled",
                "Grounded",
                "Idiosyncratic",
                "Sentinel",
                "Improved",
                "Uncaring",
                "Ingenious",
                "L33T",
                "Uncontrollable",
                "Defiant",
                "Pathfinder",
                "Extraordinary",
                "Knight",
                "Man-At-Arms",
                "Solemnness",
                "Emperor",
                "Sage",
                "Beyond The Obvious",
                "The Dreaded",
                "The Forge",
                "Rising Star",
                "Reaper",
                "Superior",
                "Awoken",
                "Legendary",
                "Warlock",
                "Magician",
                "Sorcerer",
                "Necromancer",
                "Mythical",
                "Awoken",
                "Immeasurable",
                "Mysterious",
                "Master",
                "Master Of Everything"

        };

        if (getLevel() == 0) {
            setTheTitles(playerTitles, 0);
            return playerTitles[0];
        } else {

            int w = 0;

            for (int i = 0; i < getLevel(); i += 10) {
                setTheTitles(playerTitles, w);
                if (getLevel() <= i) {
                    return playerTitles[w];
                }
                w++;
            }

            return playerTitles[w - 1];
        }

    }

    @Exclude
    private void setTheTitles(String[] playerTitles, int max) {

        StringBuilder UpdatedTitles = new StringBuilder();

        for (int i = 0; i <= max; i++) {
            if (i == max) {
                UpdatedTitles.append(playerTitles[i]);
            } else {
                UpdatedTitles.append(playerTitles[i]).append(",\t\t");
            }
        }

        setTitles(UpdatedTitles.toString());

    }

    @PropertyName("Status")
    public int getStatus() {
        return Status;
    }

    @PropertyName("Status")
    public void setStatus(int Status) {
        this.Status = Status;
    }

    @PropertyName("Level")
    public int getLevel() {
        return getTheLevel();
    }

    @PropertyName("Penalties")
    public int getPenalties() {
        return Penalties;
    }

    @PropertyName("Penalties")
    public void setPenalties(int Penalties) {
        this.Penalties = Penalties;
    }

    @Exclude
    private int getTheLevel() {
        long previousExperience = 0;
        for (int level = 0; level <= 1000; level++) {
            if ((level * 100L) + previousExperience >= this.Experience) {
                return level;
            }
            previousExperience = (level * 100L) + previousExperience;
        }

        return 1000;
    }

    @PropertyName("MaxExperience")
    public long getMaxExperience() {
        return getTheExperienceMax();
    }

    @Exclude
    private long getTheExperienceMax() {
        long previousExperience = 0;

        if (getLevel() > 1000) {
            return 0;
        } else {
            for (int level = 0; level <= getLevel(); level++) {
                if (getLevel() == level) {
                    return (level * 100L) + previousExperience;
                }
                previousExperience = (level * 100L) + (previousExperience);
            }
        }
        return 0;
    }

    @PropertyName("MinExperience")
    public long getMinExperience() {
        return getTheExperienceMin();
    }

    @Exclude
    private long getTheExperienceMin() {
        long previousExperience = 0;

        for (int level = 0; level <= getLevel() - 1; level++) {
            if (getLevel() - 1 == level) {
                return (level * 100L) + previousExperience;
            }
            previousExperience = (level * 100L) + (previousExperience);
        }
        return 0;
    }

    @Exclude
    public void reduceStats() {
        reduceTheStats();
    }

    @Exclude
    private void reduceTheStats() {

        if (getExperience() > 0) {

            if (getTheLevel() <= 20) {

                setZ(0.04);

                setIntelligence(getIntelligence() - (getIntelligence() * getZ()));
                setAgility(getAgility() - (getAgility() * getZ()));
                setStrength(getStrength() - (getStrength() * getZ()));
                setHP(getHP() - (getHP() * getZ()));
                setSense(getSense() - (getSense() * getZ()));
                setWill(getWill() - (getWill() * getZ()));
                setVitality(getVitality() - (getVitality() * getZ()));
                setAwareness(getAwareness() - (getAwareness() * getZ()));
                setStealth(getStealth() - (getStealth() * getZ()));
                setEndurance(getEndurance() - (getEndurance() * getZ()));
                setAura(getAura() - (getAura() * getZ()));
                setMystique(getMystique() - (getMystique() * getZ()));
                setSincerity(getSincerity() - (getSincerity() * getZ()));
                setDefiance(getDefiance() - (getDefiance() * getZ()));

                long xp = getExperience();
                double total = xp * getZ();

                setExperience(getExperience() - (long) total);

            } else {

                setZ(0.02);

                setIntelligence(getIntelligence() - (getIntelligence() * getZ()));
                setAgility(getAgility() - (getAgility() * getZ()));
                setStrength(getStrength() - (getStrength() * getZ()));
                setHP(getHP() - (getHP() * getZ()));
                setSense(getSense() - (getSense() * getZ()));
                setWill(getWill() - (getWill() * getZ()));
                setVitality(getVitality() - (getVitality() * getZ()));
                setAwareness(getAwareness() - (getAwareness() * getZ()));
                setStealth(getStealth() - (getStealth() * getZ()));
                setEndurance(getEndurance() - (getEndurance() * getZ()));
                setAura(getAura() - (getAura() * getZ()));
                setMystique(getMystique() - (getMystique() * getZ()));
                setSincerity(getSincerity() - (getSincerity() * getZ()));
                setDefiance(getDefiance() - (getDefiance() * getZ()));

                long xp = getExperience();
                double total = xp * getZ();

                setExperience(getExperience() - (long) total);

            }

        }

    }

    @PropertyName("Titles")
    public String getTitles() {
        getTitle();
        return Titles;
    }

    @PropertyName("Titles")
    public void setTitles(String Titles) {
        this.Titles = Titles;
    }
}
