package com.poklad.androidtestprojectny.utils

interface Mapper<Source, Destination> {
    fun map(data: Source): Destination
}
