package net.tlalka.github.search.platform

interface UseCase<IN : Any, OUT : Any> {

    suspend fun run(input: IN): OUT
}
