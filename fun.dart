import 'dart:io';

void main() {
  List<int> num1 = [1, 3, 5, 7];
  List<int> num2 = [10, 30, 50, 70];
  var square = (int num) => num * num;
  var cube = (int num) => num * num * num;
  print("Square=\n");
  processList(num1, square);
  print("Cube=\n");
  processList(num2, cube);
}

void processList(List<int> num, int Function(int) operation) {
  for (int number in num) {
    int result = operation(number);
    print("Original:$number \n Result:$result");
  }
}
