package com.ereyes.imc

/****
 * Project: IMC
 * From: com.ereyes.imc
 * Created by Edgar Reyes Gonzalez on 2/4/2023 at 2:29 PM
 * All rights reserved 2023.
 ****/
enum class eTypeGenre(val num: Int) {
    MALE(1),
    FEMALE(2),
    NOT_ASSIGNED(0)
}

fun getTypeGenre(type: Int): eTypeGenre{
    return when(type){
        1 -> eTypeGenre.MALE
        2 -> eTypeGenre.FEMALE
        else -> eTypeGenre.NOT_ASSIGNED
    }
}