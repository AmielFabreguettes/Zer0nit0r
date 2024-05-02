package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {



    private boolean crew = false;
    private boolean known_bounty= false;
    private boolean known_bounty_answer = false;
    private boolean bounty = false;
    private boolean nickname = false;
    private boolean status = false;
    private boolean age = false;
    private boolean birthday = false;
    private boolean height = false;
    private boolean devil_fruit = false;
    private boolean yonko_crew = false;
    private boolean yonko = false;
    private boolean scar = false;
    private boolean weapon = false;
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
    int question_time;

    int chosen_crew;

    int chosen_age = 0;
    int chosen_height = 0;
    int chosen_race;
    int chosen_weapon;

    private int min_age = 0;
    private int max_age = Integer.MAX_VALUE;

    private int min_height = 0;
    private int max_height =  Integer.MAX_VALUE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
//        boolean character_found = false;
        // if first time
        // Ask if you know the rules
        // Then do stuff

        question = findViewById(R.id.question);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        idk = findViewById(R.id.idk);

        rand = new Random();

        pirates = GarpinatorDatabase.retrieveAllPirates();

        crews = new ArrayList<>();
        for (Pirate pirate : pirates){
            if (!crews.contains(pirate.getCrew()))
                crews.add(pirate.getCrew());
        }

        races = new ArrayList<>();
        races.add("human");
        races.add("giant");
        races.add("fishMan");
        races.add("tontatta");

        weapons = new ArrayList<>();
        for (Pirate pirate : pirates){
            if (!weapons.contains(pirate.getWeapon()))
                weapons.add(pirate.getWeapon());
        }

        game();

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (question_time == 0 && !crew){ //Done
                    pirates.removeIf(pirate -> !pirate.getCrew().equals(crews.get(chosen_crew)));
                    crew = !crew;
                    System.out.println(pirates.size());
                    game();
                }
                ////////////////////////////////////////////////////////////////////////////////////////
                else if (question_time == 1 && (!bounty || !known_bounty)){
                    if (!known_bounty){
                        pirates.removeIf(pirate -> pirate.getBounty().equals("-1"));
                        known_bounty = !known_bounty;
                        System.out.println(pirates.size());
                        game();
                    }
                    else if(!bounty){
                        // calculate average;
                        game();
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////
                else if (question_time == 2 && !nickname){ //Done
                    pirates.removeIf(pirate -> !pirate.isNickname());
                    nickname = !nickname;
                    System.out.println(pirates.size());
                    game();

                }
                else if (question_time == 3 && !status){ //Done
                    pirates.removeIf(pirate -> !pirate.isStatus());
                    status = !status;
                    System.out.println(pirates.size());
                    game();

                }
                else if (question_time == 4 && !age){
                    pirates.removeIf(pirate -> pirate.getAge() <= chosen_age);
                    chosen_age = 0;
                    System.out.println(pirates.size());
                    game();

                }
                else if (question_time == 5 && !birthday){
                    game();
                }
                else if (question_time == 6 && !height){
                    pirates.removeIf(pirate -> pirate.getHeight() <= chosen_height);
                    chosen_height = 0;
                    System.out.println(pirates.size());
                    game();

                }
                else if (question_time == 7 && !devil_fruit){ //Done
                    pirates.removeIf(pirate -> !pirate.isDevil_fruit());
                    devil_fruit = !devil_fruit;
                    System.out.println(pirates.size());
                    game();
                }
                else if (question_time == 8 && !yonko_crew){ //Done
                    pirates.removeIf(pirate -> !pirate.isYonko_crew());
                    yonko_crew = !yonko_crew;
                    System.out.println(pirates.size());
                    game();
                }
                else if (question_time == 9 && !yonko){ //Done
                    pirates.removeIf(pirate -> !pirate.isYonko());
                    yonko = !yonko;
                    System.out.println(pirates.size());
                    game();
                }
                else if (question_time == 10 && !scar){ //Done
                    pirates.removeIf(pirate -> !pirate.isScar());
                    scar = !scar;
                    System.out.println(pirates.size());
                    game();
                }
                else if (question_time == 11 && !weapon){
                    game();
                }
                else if (question_time == 12 && !race){
                    pirates.removeIf(pirate -> !pirate.getRace().equals(races.get(chosen_race)));
                    race = !race;
                    System.out.println(pirates.size());
                    game();

                }
                else if (question_time == 13 && !captain){ //Done
                    pirates.removeIf(pirate -> !pirate.isCaptain());
                    captain = !captain;
                    System.out.println(pirates.size());
                    game();
                }
                else if (question_time == 14 && !vsLuffy){ //Done
                    pirates.removeIf(pirate -> !pirate.isVsLuffy());
                    vsLuffy = !vsLuffy;
                    System.out.println(pirates.size());
                    game();
                }
                else if (question_time == 15 && !vsZoro){ //Done
                    pirates.removeIf(pirate -> !pirate.isVsZoro());
                    vsZoro = !vsZoro;
                    System.out.println(pirates.size());
                    game();
                }
                else if (question_time == 16 && !vsSanji){ //Done
                    pirates.removeIf(pirate -> !pirate.isVsSanji());
                    vsSanji = !vsSanji;
                    System.out.println(pirates.size());
                    game();
                }
                else if (question_time == 17 && !haki){ //Done
                    pirates.removeIf(pirate -> !pirate.isHaki());
                    haki = !haki;
                    System.out.println(pirates.size());
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
                        pirates.removeIf(pirate -> !pirate.getBounty().equals("-1"));
                        known_bounty = !known_bounty;
                        game();
                    }
                    else if(!bounty){
                        // calculate average;
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
                else if (question_time == 5 && !birthday){
                    game();
                }
                else if (question_time == 6 && !height){
                    pirates.removeIf(pirate -> pirate.getHeight() > chosen_height);
                    chosen_height = 0;
                    game();
                }
                else if (question_time == 7 && !devil_fruit){ //Done
                    pirates.removeIf(Pirate::isDevil_fruit);
                    pirates.removeIf(Pirate::isYonko);
                    devil_fruit = !devil_fruit;
                    yonko = !yonko;
                    weapons.remove("devil fruit");
                    game();
                }
                else if (question_time == 8 && !yonko_crew){ //Done
                    pirates.removeIf(Pirate::isYonko_crew);
                    yonko_crew = !yonko_crew;
                    game();
                }
                else if (question_time == 9 && !yonko){ //Done
                    pirates.removeIf(Pirate::isYonko);
                    yonko = !yonko;
                    game();
                }
                else if (question_time == 10 && !scar){ //Done
                    pirates.removeIf(Pirate::isScar);
                    scar = !scar;
                    game();
                }
                else if (question_time == 11 && !weapon){
                    pirates.removeIf(pirate -> pirate.getWeapon().contains(weapons.get(chosen_weapon)));
                    weapons.remove(chosen_weapon);
                    game();
                }
                else if (question_time == 12 && !race){
                    pirates.removeIf(pirate -> !pirate.getRace().equals(races.get(chosen_race)));
                    races.remove(chosen_race);
                    game();
                }
                else if (question_time == 13 && !captain){ //Done
                    pirates.removeIf(Pirate::isCaptain);
                    captain = !captain;
                    game();
                }
                else if (question_time == 14 && !vsLuffy){ //Done
                    pirates.removeIf(Pirate::isVsLuffy);
                    vsLuffy = !vsLuffy;
                    game();
                }
                else if (question_time == 15 && !vsZoro){ //Done
                    pirates.removeIf(Pirate::isVsZoro);
                    vsZoro = !vsZoro;
                    game();
                }
                else if (question_time == 16 && !vsSanji){ //Done
                    pirates.removeIf(Pirate::isVsSanji);
                    vsSanji = !vsSanji;
                    game();
                }
                else if (question_time == 17 && !haki){ //Done
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
                else if (question_time == 5 && !birthday){
                    birthday = true;
                    game();
                }
                else if (question_time == 6 && !height){
                    height = true;
                    game();
                }
                else if (question_time == 7 && !devil_fruit){ //Done
                    devil_fruit = true;
                    game();
                }
                else if (question_time == 8 && !yonko_crew){ //Done
                    yonko_crew = true;
                    game();
                }
                else if (question_time == 9 && !yonko){ //Done
                    yonko = true;
                    game();
                }
                else if (question_time == 10 && !scar){ //Done
                    scar = true;
                    game();
                }
                else if (question_time == 11 && !weapon){
                    weapon = true;
                    game();
                }
                else if (question_time == 12 && !race){
                    race = true;
                    game();
                }
                else if (question_time == 13 && !captain){ //Done
                    captain = true;
                    game();
                }
                else if (question_time == 14 && !vsLuffy){ //Done
                    vsLuffy = true;
                    game();
                }
                else if (question_time == 15 && !vsZoro){ //Done
                    vsZoro = true;
                    game();
                }
                else if (question_time == 16 && !vsSanji){ //Done
                    vsSanji = true;
                    game();
                }
                else if (question_time == 17 && !haki){ //Done
                    haki = true;
                    game();
                }

            }
        });

    }

    private void game(){

        if (pirates.size() == 1){
            question.setText("Is your character " + pirates.get(0).getName() + " ?");
        }
        else {

            question_time = rand.nextInt(18);

            if (question_time == 0 && !crew) {
                chosen_crew = rand.nextInt(crews.size());
                question.setText("Is your character part of the " + crews.get(chosen_crew) + " ?");
            }
            ////////////////////////////////////////////////////////////////////////////////////////
            else if (question_time == 1 && (!bounty || !known_bounty)) {
                if (!known_bounty) {
                    question.setText("Does your character have a known bounty ?");
                } else if (!bounty) {
                    // calculate average;
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
            //else if (question_time == 5 && !birthday){

            //}
            else if (question_time == 6 && !height) {
                for (Pirate pirate : pirates) {
                    chosen_height += pirate.getHeight();
                }
                chosen_height /= pirates.size();
                question.setText("Is your pirate taller than " + chosen_height + " ?");
            } else if (question_time == 7 && !devil_fruit) {
                question.setText("Does your character have a devil fruit power ?");
            } else if (question_time == 8 && !yonko_crew) {
                question.setText("Is your character part of a Yonko crew ?");
            } else if (question_time == 9 && !yonko) {
                question.setText("Is your character a Yonko ?");
            } else if (question_time == 10 && !scar) {
                question.setText("Does your character have an apparant scar ?");
            } else if (question_time == 11 && !weapon) {
                chosen_weapon = rand.nextInt(weapons.size());
                if (weapons.get(chosen_weapon).equals("weapon")) {
                    question.setText("Does your character fight with a weapon ?");
                } else {
                    question.setText("Does you character fight using his " + weapons.get(chosen_weapon) + " ?");
                }
            } else if (question_time == 12 && !race) {
                chosen_race = rand.nextInt(races.size());
                question.setText("Is your character a " + races.get(chosen_race) + " ?");
            } else if (question_time == 13 && !captain) {
                question.setText("Is your character captain of a crew ?");
            } else if (question_time == 14 && !vsLuffy) {
                question.setText("Did your character fight angaints Luffy ?");
            } else if (question_time == 15 && !vsZoro) {
                question.setText("Did your character fight angaints Zoro ?");
            } else if (question_time == 16 && !vsSanji) {
                question.setText("Did your character fight angaints Sanji ?");
            } else if (question_time == 17 && !haki) {
                question.setText("Does your character know any type of haki ?");
            } else {
                game();
            }
        }
    }
}