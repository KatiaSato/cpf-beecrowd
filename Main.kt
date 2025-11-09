package org.example
import java.util.Scanner

fun main(){

    var b1valido: Boolean
    var b2valido: Boolean
    println("Digite o CPF: ")
    val reader = Scanner(System.`in`)

    val cpf = reader.nextLine()
    if(cpf.length!=11){
        return print("Tamanho do CPF invalido. Digite um CPF válido ")
    }
    if(cpf.matches(Regex("(\\d)\\1{10}"))){
        return println("Formato invalido!")
    }

    var b1 = 0
    for (i in 0..8){
        val digito = cpf[i].digitToInt()
        val peso = i + 1
        b1 += digito * peso
    }
    var restoB1 = b1 %11
    println(restoB1)
    if (restoB1 == 10){
        restoB1 = 0
    }
    println(restoB1)

    if(restoB1 == cpf[9].digitToInt()){
        b1valido = true
    }else{
        b1valido = false
    }

    var b2 = 0
    for (i in 0..8){
        val digito = cpf[i].digitToInt()
        val peso = 9 - i
        b2 += digito * peso
    }
    var restoB2 = b2 %11
    println(restoB2)
    if (restoB2 == 10)
         restoB2 = 0

    println(restoB2)

    if(restoB2 == cpf[10].digitToInt()){
        b2valido = true
    }else{
        b2valido = false
    }
    if(b1valido && b2valido){
        println("CPF valido\n")
    }else{
        println("CPF invalido\n")
    }
}