function myFunction() {
    document.getElementById("demo").innerHTML="段落被更改";
}

var person={
    firstName:"Bill",
    lastName:"Gates",
    age:50,
    eyeColor:"blue",
    fullName:function (){
        return this.firstName+" "+this.lastName;
    }
};

person.firstName;
person["firstName"];
name = person.fullName();

var cars = ["Saab","Volvo","BMW"];
var animals = new Array("panda","elephant","cat","dog");
var name = cars[0];
cars[0]="Opel";
document.getElementById("demo1").innerHTML=cars[0]
document.getElementById("demo").innerHTML=cars

document.getElementById("demo").innerHTML=cars.join("*");
cars.pop()
cars.push("Bence")
var fruits = ["Banana","Orange","Apple","Mango"];
fruits[0]="Kiwi";
fruits[fruits.length]="Kiwi";

var myGirls = ["Celilie","Lone"];
var myBoys = ["Emil","Tobias","Linux"];
var myChildren = myGirls.concat(myBoys)

var arr1 = ["Celilie","Lone"];
var arr2 = ["Emil"];
var arr3 = ["Robin"];
var myChildren1 = arr1.concat(arr2,arr3);

var myChildren2 = arr1.concat(["lili","lucy"]);

fruits.sort()
fruits.reverse()





