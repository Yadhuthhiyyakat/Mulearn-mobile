import 'dart:io';
void main(){
  print('Enter the first number:');
  var num1 = int.parse(stdin.readLineSync()!);
  print('Enter the second number:');
  var num2 = int.parse(stdin.readLineSync()!);
  var sum = num1 + num2;
  print('The sum of $num1 and $num2 is $sum');
}