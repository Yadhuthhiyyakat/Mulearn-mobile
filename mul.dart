import 'dart:io';

void main() {
  print(
    "Enter the number:",
  ); //Enter the number you want to generate the multiplication table
  var num = int.parse(stdin.readLineSync()!);
  for (var i = 1; i <= 10; i++) {
    var result = num * i;
    print("$num x $i = $result");
  }
  print("Multiplication table of $num completed.");
  print(
    "Total sum of the multiplication table is: ${num * (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10)}",
  );
}
