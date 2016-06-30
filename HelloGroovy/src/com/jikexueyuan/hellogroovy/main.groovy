package com.jikexueyuan.hellogroovy

/**
 * Created by fangc on 2016/6/10.
 */
    println "groovy是弱化数据类型的语言，你需要变量的时候直接拿来用就行了，不用管类型；且同一个数组中可以存所有类型的数据。类似PHP"
    println ("hello world ")
println("类型定义-------------------------------------------分隔线")
def name="王五"
println name
println name.class

name=25
println name
println name.class

name=true
println name
println name.class

println("流程控制-------------------------------------------分隔线")
for(i in 0..5){
    println i
}
for(i in 0..<5){
    println i
}
println("集合-------------------------------------------分隔线")

name=0..10
println name
println name.class

name=["jikexueyuan","cc","ime"]
name.add("疯狂的石头")
name<<"中国" //<<表示在集合的最后添加元素

name[6]="北京"
name[5]= 3.14 as String
println name
println name.class

name=[1,2,3,4]
name=name+5
println name
println name.class

name=name-[2,4]
println name
println("映射（键值对），类似集合的数据管理方法-------------------------------------------分隔线")
def people=[name:"张三",age:34]
println people
people<<[isRunning:true]
println people
people=people+[sex:"girl"]
println people
println("join方法-------------------------------------------分隔线")
name=name.join(".;-")
println name
println("count方法-------------------------------------------分隔线")
def numbers=[1,2,3,4]
//println numbers.count(4)
//println numbers.count(numbers,4)
println("toUpperCase方法-------------------------------------------分隔线")
def lang=["java","groovy","c","c++"]
println lang*.toUpperCase() //注意lang*


