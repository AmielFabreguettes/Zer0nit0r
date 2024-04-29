package com.example.garpinator;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = GarpinatorDatabase.PIRATE_TABLE)
public class Pirate {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String crew;
    private int bounty;
    private boolean nickname;
    private boolean status;
    private int age;
    private Date birthday;
    private int height;
    private boolean devil_fruit;
    private boolean yonko_crew;
    private boolean yonko;
    private boolean scar;
    private String weapon;
    private String race;
    private boolean captain;
    private boolean vsLuffy;
    private boolean vsZorp;
    private boolean vsSanji;
    private boolean haki;

    private int odds;

    public Pirate(String name) {
        this.name = name;
        this.odds = 2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOdds() {
        return odds;
    }

    public void setOdds(int odds) {
        this.odds = odds;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public int getBounty() {
        return bounty;
    }

    public void setBounty(int bounty) {
        this.bounty = bounty;
    }

    public boolean isNickname() {
        return nickname;
    }

    public void setNickname(boolean nickname) {
        this.nickname = nickname;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isDevil_fruit() {
        return devil_fruit;
    }

    public void setDevil_fruit(boolean devil_fruit) {
        this.devil_fruit = devil_fruit;
    }

    public boolean isYonko_crew() {
        return yonko_crew;
    }

    public void setYonko_crew(boolean yonko_crew) {
        this.yonko_crew = yonko_crew;
    }

    public boolean isYonko() {
        return yonko;
    }

    public void setYonko(boolean yonko) {
        this.yonko = yonko;
    }

    public boolean isScar() {
        return scar;
    }

    public void setScar(boolean scar) {
        this.scar = scar;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public boolean isCaptain() {
        return captain;
    }

    public void setCaptain(boolean captain) {
        this.captain = captain;
    }

    public boolean isVsLuffy() {
        return vsLuffy;
    }

    public void setVsLuffy(boolean vsLuffy) {
        this.vsLuffy = vsLuffy;
    }

    public boolean isVsZorp() {
        return vsZorp;
    }

    public void setVsZorp(boolean vsZorp) {
        this.vsZorp = vsZorp;
    }

    public boolean isVsSanji() {
        return vsSanji;
    }

    public void setVsSanji(boolean vsSanji) {
        this.vsSanji = vsSanji;
    }

    public boolean isHaki() {
        return haki;
    }

    public void setHaki(boolean haki) {
        this.haki = haki;
    }
}
