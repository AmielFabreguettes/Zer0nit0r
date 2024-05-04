package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PictureInPictureParams;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {


    private GarpinatorRepo db;
    private SharedPreferences prefs;

    private boolean crew = false;
    private boolean known_bounty= false;
    private boolean bounty = false;
    private boolean nickname = false;
    private boolean status = false;
    private boolean age = false;
    private boolean height = false;
    private boolean devil_fruit = false;
    private boolean yonko_crew = false;
    private boolean yonko = false;
    private boolean scar = false;
    private boolean weapon = false;
    private boolean known_weapon = false;
    private boolean race = false;
    private boolean captain = false;
    private boolean vsLuffy = false;
    private boolean vsZoro = false;
    private boolean vsSanji = false;
    private boolean haki = false;
    Random rand;

    List<String> crews;
    List<String> races;
    List<String> weapons;
    List<Pirate> pirates;

    TextView question;
    Button yes;
    Button no;
    Button idk;
    TextView lmao;
    int question_time;

    int chosen_crew;

    int chosen_age = 0;
    int chosen_height = 0;
    long chosen_bounty = 0;

    int chosen_race;
    int chosen_weapon;


    private void gameOver(Pirate pirate){
        Button y = findViewById(R.id.yes);
        Button n = findViewById(R.id.no);
        Button idk = findViewById(R.id.idk);

        TextView question = findViewById(R.id.question);

        question.setText("Your character is "+ pirate.getName());
        y.setVisibility(View.INVISIBLE);
        n.setVisibility(View.INVISIBLE);
        idk.setVisibility(View.INVISIBLE);

        db.insertHistory(new History(db.getUserByName(prefs.getString("curUser","")),
                pirate));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
//        boolean character_found = false;
        // if first time
        // Ask if you know the rules
        // Then do stuff

        this.db = new GarpinatorRepo(getApplication());
        this.prefs = getSharedPreferences("LoginActivity", Context.MODE_PRIVATE);
        question = findViewById(R.id.question);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        idk = findViewById(R.id.idk);
        lmao = findViewById(R.id.lmao);

        rand = new Random();

        pirates = GarpinatorDatabase.retrieveAllPirates();

        weapons = new ArrayList<>();
        weapons.add("devil fruit");
        weapons.add("fist");
        weapons.add("weapon");
        weapons.add("legs");
        weapons.add("body");
        weapons.add("lion");
        weapons.add("minions");



        game();

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (question_time == 0 && !crew){ //Done
                    pirates.removeIf(pirate -> !pirate.getCrew().equals(crews.get(chosen_crew)));
                    crew = !crew;
                    game();
                }
                ////////////////////////////////////////////////////////////////////////////////////////
                else if (question_time == 1 && (!bounty || !known_bounty)){
                    if (!known_bounty){
                        pirates.removeIf(pirate -> pirate.getBounty() == -1);
                        known_bounty = !known_bounty;
                        game();
                    }
                    else if(!bounty){
                        pirates.removeIf(pirate -> pirate.getBounty() <= chosen_bounty);
                        game();
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////
                else if (question_time == 2 && !nickname){ //Done
                    pirates.removeIf(pirate -> !pirate.isNickname());
                    nickname = !nickname;
                    game();

                }
                else if (question_time == 3 && !status){ //Done
                    pirates.removeIf(pirate -> !pirate.isStatus());
                    status = !status;
                    game();

                }
                else if (question_time == 4 && !age){
                    pirates.removeIf(pirate -> pirate.getAge() <= chosen_age);
                    chosen_age = 0;
                    game();

                }
                else if (question_time == 5 && !height){
                    pirates.removeIf(pirate -> pirate.getHeight() <= chosen_height);
                    chosen_height = 0;
                    game();

                }
                else if (question_time == 6 && !devil_fruit){ //Done
                    pirates.removeIf(pirate -> !pirate.isDevil_fruit());
                    devil_fruit = !devil_fruit;
                    game();
                }
                else if (question_time == 7 && !yonko_crew){ //Done
                    pirates.removeIf(pirate -> !pirate.isYonko_crew());
                    yonko_crew = !yonko_crew;
                    game();
                }
                else if (question_time == 8 && !yonko){ //Done
                    pirates.removeIf(pirate -> !pirate.isYonko());
                    yonko = !yonko;
                    game();
                }
                else if (question_time == 9 && !scar){ //Done
                    pirates.removeIf(pirate -> !pirate.isScar());
                    scar = !scar;
                    game();
                }
                else if (question_time == 10 && (!weapon || !known_weapon)){
                    if (!known_weapon){
                        pirates.removeIf(pirate -> pirate.getWeapon().contains("-1"));
                        known_weapon = !known_weapon;
                        game();
                    }
                    else {
                        pirates.removeIf(pirate -> !pirate.getWeapon().contains(weapons.get(chosen_weapon)));
                        weapons.remove(chosen_weapon);
                        if (weapons.size() == 0){
                            weapon = !weapon;
                        }
                        game();
                    }
                }
                else if (question_time == 11 && !race){
                    pirates.removeIf(pirate -> !pirate.getRace().equals(races.get(chosen_race)));
                    race = !race;
                    game();

                }
                else if (question_time == 12 && !captain){ //Done
                    pirates.removeIf(pirate -> !pirate.isCaptain());
                    captain = !captain;
                    game();
                }
                else if (question_time == 13 && !vsLuffy){ //Done
                    pirates.removeIf(pirate -> !pirate.isVsLuffy());
                    vsLuffy = !vsLuffy;
                    game();
                }
                else if (question_time == 14 && !vsZoro){ //Done
                    pirates.removeIf(pirate -> !pirate.isVsZoro());
                    vsZoro = !vsZoro;
                    game();
                }
                else if (question_time == 15 && !vsSanji){ //Done
                    pirates.removeIf(pirate -> !pirate.isVsSanji());
                    vsSanji = !vsSanji;
                    game();
                }
                else if (question_time == 16 && !haki){ //Done
                    pirates.removeIf(pirate -> !pirate.isHaki());
                    haki = !haki;
                    game();
                }

            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (question_time == 0 && !crew){ //Done
                    pirates.removeIf(pirate -> pirate.getCrew().equals(crews.get(chosen_crew)));
                    crews.remove(chosen_crew);
                    game();
                }
                ////////////////////////////////////////////////////////////////////////////////////////
                else if (question_time == 1 && (!bounty || !known_bounty)){
                    if (!known_bounty){
                        pirates.removeIf(pirate -> pirate.getBounty() != -1 );
                        known_bounty = !known_bounty;
                        bounty = !bounty;
                        game();
                    }
                    else if(!bounty){
                        pirates.removeIf(pirate -> pirate.getBounty() > chosen_bounty);
                        game();
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////
                else if (question_time == 2 && !nickname){ //Done
                    pirates.removeIf(Pirate::isNickname);
                    nickname = !nickname;
                    game();
                }
                else if (question_time == 3 && !status){ //Done
                    pirates.removeIf(Pirate::isStatus);
                    status = !status;
                    game();
                }
                else if (question_time == 4 && !age){
                    pirates.removeIf(pirate -> pirate.getAge() > chosen_age);
                    chosen_age = 0;
                    game();
                }
                else if (question_time == 5 && !height){
                    pirates.removeIf(pirate -> pirate.getHeight() > chosen_height);
                    chosen_height = 0;
                    game();
                }
                else if (question_time == 6 && !devil_fruit){ //Done
                    pirates.removeIf(Pirate::isDevil_fruit);
                    devil_fruit = !devil_fruit;
                    weapons.remove("devil fruit");
                    game();
                }
                else if (question_time == 7 && !yonko_crew){ //Done
                    pirates.removeIf(Pirate::isYonko_crew);
                    yonko_crew = !yonko_crew;
                    game();
                }
                else if (question_time == 8 && !yonko){ //Done
                    pirates.removeIf(Pirate::isYonko);
                    yonko = !yonko;
                    game();
                }
                else if (question_time == 9 && !scar){ //Done
                    pirates.removeIf(Pirate::isScar);
                    scar = !scar;
                    game();
                }
                else if (question_time == 10 && (!weapon || !known_weapon)){
                    if (!known_weapon){
                        known_weapon = true;
                        weapon = !weapon;
                        game();
                    }else {
                        pirates.removeIf(pirate -> pirate.getWeapon().contains(weapons.get(chosen_weapon)));
                        weapons.remove(chosen_weapon);
                        if (weapons.size() == 0){
                            weapon = !weapon;
                        }
                        game();
                    }
                }
                else if (question_time == 11 && !race){
                    pirates.removeIf(pirate -> pirate.getRace().equals(races.get(chosen_race)));
                    races.remove(chosen_race);
                    game();
                }
                else if (question_time == 12 && !captain){ //Done
                    pirates.removeIf(Pirate::isCaptain);
                    captain = !captain;
                    game();
                }
                else if (question_time == 13 && !vsLuffy){ //Done
                    pirates.removeIf(Pirate::isVsLuffy);
                    vsLuffy = !vsLuffy;
                    game();
                }
                else if (question_time == 14 && !vsZoro){ //Done
                    pirates.removeIf(Pirate::isVsZoro);
                    vsZoro = !vsZoro;
                    game();
                }
                else if (question_time == 15 && !vsSanji){ //Done
                    pirates.removeIf(Pirate::isVsSanji);
                    vsSanji = !vsSanji;
                    game();
                }
                else if (question_time == 16 && !haki){ //Done
                    pirates.removeIf(Pirate::isHaki);
                    haki = !haki;
                    game();
                }

            }
        });

        idk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (question_time == 0 && !crew){ //Done
                    crew = true;
                    game();
                }
                else if (question_time == 1 && (!bounty || !known_bounty)){
                    bounty = true;
                    known_bounty = true;
                    game();
                }
                else if (question_time == 2 && !nickname){ //Done
                    nickname = true;
                    game();
                }
                else if (question_time == 3 && !status){ //Done
                    status = true;
                    game();
                }
                else if (question_time == 4 && !age){
                    age = true;
                    game();
                }
                else if (question_time == 5 && !height){
                    height = true;
                    game();
                }
                else if (question_time == 6 && !devil_fruit){ //Done
                    devil_fruit = true;
                    game();
                }
                else if (question_time == 7 && !yonko_crew){ //Done
                    yonko_crew = true;
                    game();
                }
                else if (question_time == 8 && !yonko){ //Done
                    yonko = true;
                    game();
                }
                else if (question_time == 9 && !scar){ //Done
                    scar = true;
                    game();
                }
                else if (question_time == 10 && (!weapon || !known_weapon)){
                    known_weapon = true;
                    weapon = true;
                    game();
                }
                else if (question_time == 11 && !race){
                    race = true;
                    game();
                }
                else if (question_time == 12 && !captain){ //Done
                    captain = true;
                    game();
                }
                else if (question_time == 13 && !vsLuffy){ //Done
                    vsLuffy = true;
                    game();
                }
                else if (question_time == 14 && !vsZoro){ //Done
                    vsZoro = true;
                    game();
                }
                else if (question_time == 15 && !vsSanji){ //Done
                    vsSanji = true;
                    game();
                }
                else if (question_time == 16 && !haki){ //Done
                    haki = true;
                    game();
                }

            }
        });

    }

    private void game(){
        lmao.setText("" + pirates.size());

        crews = new ArrayList<>();
        for (Pirate pirate : pirates){
            if (!crews.contains(pirate.getCrew()))
                crews.add(pirate.getCrew());
        }

        races = new ArrayList<>();
        for (Pirate pirate : pirates){
            if (!crews.contains(pirate.getRace()))
                crews.add(pirate.getRace());
        }


        if (pirates.size() == 1){
            question.setText("Is your character " + pirates.get(0).getName() + " ?");
            gameOver(pirates.get(0));
        }
        else {

            question_time = rand.nextInt(17);

            if (question_time == 0 && !crew) {
                chosen_crew = rand.nextInt(crews.size());
                question.setText("Is your character part of the " + crews.get(chosen_crew) + " ?");
            }
            ////////////////////////////////////////////////////////////////////////////////////////
            else if (question_time == 1 && (!bounty || !known_bounty)) {
                if (!known_bounty) {
                    question.setText("Does your character have a known bounty ?");
                } else if (!bounty) {
                    chosen_bounty = 0;
                    for (Pirate pirate : pirates){
                        chosen_bounty += pirate.getBounty();
                    }
                    chosen_bounty /= pirates.size();
                    question.setText("Does your character havc a bounty higher than " + chosen_bounty + " ?");

                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////
            else if (question_time == 2 && !nickname) {
                question.setText("Does your character have a nickname ?");
            } else if (question_time == 3 && !status) {
                question.setText("Is your character alive ?");
            } else if (question_time == 4 && !age) {
                for (Pirate pirate : pirates) {
                    chosen_age += pirate.getAge();
                }
                chosen_age /= pirates.size();
                question.setText("Is your pirate older than " + chosen_age + " ?");
            }
            else if (question_time == 5 && !height) {
                for (Pirate pirate : pirates) {
                    chosen_height += pirate.getHeight();
                }
                chosen_height /= pirates.size();
                question.setText("Is your pirate taller than " + chosen_height + "cm ?");
            } else if (question_time == 6 && !devil_fruit) {
                question.setText("Does your character have a devil fruit power ?");
            } else if (question_time == 7 && !yonko_crew) {
                question.setText("Is your character part of a Yonko crew ?");
            } else if (question_time == 8 && !yonko) {
                question.setText("Is your character a Yonko ?");
            } else if (question_time == 9 && !scar) {
                question.setText("Does your character have an apparant scar ?");
            } else if (question_time == 10 && (!weapon || !known_weapon)) {
                if (!known_weapon) {
                    question.setText("Do you know the way your character fights ?");
                }
                else {
                    if (weapons.size() != 0) {
                        chosen_weapon = rand.nextInt(weapons.size());
                        if (weapons.get(chosen_weapon).equals("weapon")) {
                            question.setText("Does your character fight with a weapon ?");
                        } else {
                            question.setText("Does you character fight using his " + weapons.get(chosen_weapon) + " ?");
                        }
                    }
                    else {
                        game();
                    }
                }
            } else if (question_time == 11 && !race) {
                if(races.size() != 0) {
                    chosen_race = rand.nextInt(races.size());
                    question.setText("Is your character a " + races.get(chosen_race) + " ?");
                }else {
                    game();
                }
            } else if (question_time == 12 && !captain) {
                question.setText("Is your character captain of a crew ?");
            } else if (question_time == 13 && !vsLuffy) {
                question.setText("Did your character fight against Luffy ?");
            } else if (question_time == 14 && !vsZoro) {
                question.setText("Did your character fight against Zoro ?");
            } else if (question_time == 15 && !vsSanji) {
                question.setText("Did your character fight against Sanji ?");
            } else if (question_time == 16 && !haki) {
                question.setText("Does your character know any type of haki ?");
            } else {
                game();
            }
        }
    }
}