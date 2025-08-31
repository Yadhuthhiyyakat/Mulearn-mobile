import 'dart:io';
void main()
{
  print("Select the operation:\n 1.Addition\n 2.Substraction\n 3.Multiplication\n 4.Division\n 5.Exit");// Enter the number according to the opeartion you want to execute
   var commands = int.parse(stdin.readLineSync()!);
switch (commands) {
  case 1:
    print("Print the first number:");//Enter first number
    var num1 = int.parse(stdin.readLineSync()!);
    print("Print the second number:");//Enter second number
    var num2 = int.parse(stdin.readLineSync()!);
    var sum = num1 + num2;
    print(sum);
    break;
  case 2:
    print("Print the first number:");//Enter first number
    var num1 = int.parse(stdin.readLineSync()!);
    print("Print the second number:");
    var num2 = int.parse(stdin.readLineSync()!);
    var sub = num1 - num2;
    print(sub);
    break;
  case 3:
    print("Print the first number:");//Enter first number
    var num1 = int.parse(stdin.readLineSync()!);
    print("Print the second number:");
    var num2 = int.parse(stdin.readLineSync()!);
    var mul = num1 * num2;
    print(mul);
    break;
    case 4:
    print("Print the first number:");//Enter first number
    var num1 = int.parse(stdin.readLineSync()!);
    print("Print the second number:");//Enter second number
    var num2 = int.parse(stdin.readLineSync()!);
    var div = num1 / num2;
    print(div);
    case 5:
    exit(0);
    break;
  default:
    print("Unknown command.");
}

}  