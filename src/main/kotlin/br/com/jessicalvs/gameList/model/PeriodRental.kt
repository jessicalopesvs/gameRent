package br.com.jessicalvs.gameList.model

import java.time.LocalDate
import java.time.Period

data class PeriodRental(
    val date: LocalDate,
    val expireDate: LocalDate) {

    val inDays = Period.between(date, expireDate).days

}
