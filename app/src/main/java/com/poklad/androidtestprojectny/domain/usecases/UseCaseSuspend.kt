package com.poklad.androidtestprojectny.domain.usecases

interface UseCaseSuspend<Parameter, Result> {
    suspend fun execute(params: Parameter): Result
}