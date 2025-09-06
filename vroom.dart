class Car {
  //create class for the car
  String name;
  double price;
  Car(this.name, this.price);
  void changePrice(double newPrice) {
    price = newPrice;
    print('The price of $name is cahnged to $price');
  }
}

class Person {
  //create class for the person
  String name;
  double moneyLeft;
  List<Car> ownedCars = [];
  Person(this.name, this.moneyLeft);
  void buyCar(Car car) {
    //Method for buying a car
    if (moneyLeft >= car.price) {
      ownedCars.add(car);
      moneyLeft -= car.price;
      print('$name bought ${car.name} for ${car.price}');
    } else {
      print('Not enough money to buy ${car.name}');
    }
  }

  void sellCar(Car car) {
    //Method for selling a car
    if (ownedCars.contains(car)) {
      ownedCars.remove(car);
      moneyLeft += car.price;
      print('The ${car.name} is sold for ${car.price}');
    } else {
      print("The $name doesn't own a car");
    }
  }
}

void main() {
  Car car1 = Car("BMW M3", 1500000);
  Car car2 = Car("Range Rover Defender", 17000000);
  Car car3 = Car("Innova", 2500000);
  // Create a person
  Person person = Person("Yadhu", 10000000);
  // Buying cars
  person.buyCar(car1);
  person.buyCar(car2);
  person.buyCar(car3);
  // Changing a car price
  car1.changePrice(1600000);
  // Selling a car
  person.sellCar(car1);
}
